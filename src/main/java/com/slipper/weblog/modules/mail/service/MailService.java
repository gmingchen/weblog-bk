package com.slipper.weblog.modules.mail.service;

import com.slipper.weblog.modules.setting.model.dto.EmailSetting;

/**
 * @author gumingchen
 */
public interface MailService {
    /**
     * 发送邮件
     * @param email 邮箱
     * @param title 标题
     * @param content 内容
     */
    void send(String email, String title, String content);

    /**
     * 发送验证码
     * @param email 邮箱
     * @param captcha 验证码
     */
    void sendCaptcha(String email, String captcha);

    /**
     * 获取配置
     * @return
     */
    EmailSetting getSetting();
}
