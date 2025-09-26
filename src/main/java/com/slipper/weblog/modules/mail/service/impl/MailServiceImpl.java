package com.slipper.weblog.modules.mail.service.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.slipper.weblog.common.enums.SettingEnum;
import com.slipper.weblog.modules.mail.config.MailConfig;
import com.slipper.weblog.modules.mail.service.MailService;
import com.slipper.weblog.modules.setting.entity.SettingEntity;
import com.slipper.weblog.modules.setting.model.dto.EmailSetting;
import com.slipper.weblog.modules.setting.service.SettingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public EmailSetting getSetting() {
        SettingEntity settingEntity = settingService.queryByCode(SettingEnum.EMAIL.getCode());
        EmailSetting setting = (EmailSetting) settingEntity.getValue();
        if (setting == null) {
            setting = new EmailSetting();
        }

        setting.setEmail(StringUtils.isNotBlank(setting.getEmail()) ? setting.getEmail() : mailConfig.getEmail())
                .setUsername(StringUtils.isNotBlank(setting.getUsername()) ? setting.getUsername() : mailConfig.getUsername())
                .setPassword(StringUtils.isNotBlank(setting.getPassword()) ? setting.getPassword() : mailConfig.getPassword())
                .setProtocol(StringUtils.isNotBlank(setting.getProtocol()) ? setting.getProtocol() : mailConfig.getProtocol())
                .setHost(StringUtils.isNotBlank(setting.getHost()) ? setting.getHost() : mailConfig.getHost())
                .setPort(setting.getPort() != null ? setting.getPort() : mailConfig.getPort());

        return setting;
    }
}
