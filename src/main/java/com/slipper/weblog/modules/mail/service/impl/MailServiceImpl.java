package com.slipper.weblog.modules.mail.service.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.slipper.weblog.common.enums.SettingEnum;
import com.slipper.weblog.modules.mail.config.MailConfig;
import com.slipper.weblog.modules.mail.service.MailService;
import com.slipper.weblog.modules.setting.entity.SettingEntity;
import com.slipper.weblog.modules.setting.model.dto.EmailCaptchaSetting;
import com.slipper.weblog.modules.setting.model.dto.EmailSetting;
import com.slipper.weblog.modules.setting.service.SettingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;

/**
 * @author gumingchen
 */
@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private SettingService settingService;

    @Override
    public void send(String email, String title, String content) {
        EmailSetting setting = this.getSetting();

        MailAccount mailAccount = new MailAccount()
                .setFrom(setting.getEmail())
                .setAuth(true)
                .setUser(setting.getUsername())
                .setPass(setting.getPassword())
                .setHost(setting.getHost())
                .setPort(setting.getPort())
                .setSslEnable(true)
                .setStarttlsEnable(true);
        MailUtil.send(mailAccount, email, title, content, true);
    }

    @Override
    public void sendCaptcha(String email, String captcha) {
        EmailCaptchaSetting emailCaptchaSetting = settingService.queryByCode(SettingEnum.EMAIL_CAPTCHA.getCode(), EmailCaptchaSetting.class);

        String reg = "\\$\\{captcha\\}";
        String content = emailCaptchaSetting.getContent().replaceFirst(reg, Matcher.quoteReplacement(captcha));

        this.send(email, emailCaptchaSetting.getTitle(), content);
    }

    @Override
    public EmailSetting getSetting() {
        EmailSetting emailSetting = settingService.queryByCode(SettingEnum.EMAIL.getCode(), EmailSetting.class);
        if (emailSetting == null) {
            emailSetting = new EmailSetting();
        }

        emailSetting.setEmail(StringUtils.isNotBlank(emailSetting.getEmail()) ? emailSetting.getEmail() : mailConfig.getEmail())
                .setUsername(StringUtils.isNotBlank(emailSetting.getUsername()) ? emailSetting.getUsername() : mailConfig.getUsername())
                .setPassword(StringUtils.isNotBlank(emailSetting.getPassword()) ? emailSetting.getPassword() : mailConfig.getPassword())
                .setProtocol(StringUtils.isNotBlank(emailSetting.getProtocol()) ? emailSetting.getProtocol() : mailConfig.getProtocol())
                .setHost(StringUtils.isNotBlank(emailSetting.getHost()) ? emailSetting.getHost() : mailConfig.getHost())
                .setPort(emailSetting.getPort() != null ? emailSetting.getPort() : mailConfig.getPort());

        return emailSetting;
    }
}
