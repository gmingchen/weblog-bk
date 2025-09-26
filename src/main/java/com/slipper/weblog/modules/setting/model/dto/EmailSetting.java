package com.slipper.weblog.modules.setting.model.dto;

import com.slipper.weblog.modules.setting.model.SettingValue;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class EmailSetting implements SettingValue {
    /**
     * 邮箱地址
     */
    @NotBlank(message = "邮箱地址不能为空")
    private String email;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 协议
     */
    @NotBlank(message = "协议不能为空")
    private String protocol;
    /**
     * 主机
     */
    @NotBlank(message = "主机不能为空")
    private String host;
    /**
     * 端口
     */
    @NotNull(message = "端口不能为空")
    private Integer port;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;
}
