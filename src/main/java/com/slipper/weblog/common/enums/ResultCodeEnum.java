package com.slipper.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gumingchen
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(0, "成功！"),
    ERROR(500, "系统异常，请联系管理员！"),
    VERIFICATION_ERROR(400, "参数校验异常！"),
    NOT_ALLOWED(401, "没有权限访问！"),
    NOT_FOUND(404, "路径不存在！"),
    METHOD_ERROR(405, "不支持该请求方法！"),
    DUPLICATE_KEY(4000, "数据库中已存在该记录！"),
    BAD_SQL(4001, "SQL异常！"),
    MAIL_SEND_ERROR(4002, "发送邮件失败！"),
    FILE_SAVE_ERROR(4003, "保存文件失败！"),

    NOT_LOGIN(5000, "还未登录，请先登录！"),
    TOKEN_EXPIRE(5001, "凭证已过期，请重新登录！");
    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 状态信息
     */
    private final String message;
}
