package com.slipper.weblog.modules.auth.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class QqUserDTO {
    /**
     * 用户在QQ空间的昵称。
     */
    private String nickname;
    /**
     * 大大小为30×30像素的QQ空间头像URL。
     */
    private String figureurl;
    /**
     * 大小为50×50像素的QQ空间头像URL。
     */
    private String figureurl_1;
    /**
     * 大小为100×100像素的QQ空间头像URL。
     */
    private String figureurl_2;
    /**
     * 大小为40×40像素的QQ头像URL。
     */
    private String figureurl_qq_1;
    /**
     * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
     */
    private String figureurl_qq_2;
    /**
     * 性别。 如果获取不到则默认返回"男"
     */
    private String gender;
    /**
     * 性别类型。默认返回2
     */
    private Integer gender_type;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 年
     */
    private Integer year;
    /**
     * 星座
     */
    private String constellation;
}
