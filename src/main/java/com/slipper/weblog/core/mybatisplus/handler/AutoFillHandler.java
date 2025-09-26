package com.slipper.weblog.core.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.slipper.weblog.common.entity.BaseEntity;
import com.slipper.weblog.core.security.utils.SecurityUtils;
import com.slipper.weblog.modules.user.entity.UserEntity;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 自动填充
 * @author gumingchen
 */
public class AutoFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject)) {
            UserEntity userEntity = SecurityUtils.getLoginUser();
            // 基础字段自动填充
            if (metaObject.getOriginalObject() instanceof BaseEntity) {
                BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
                // 如果时间为空 则 自动填充当前时间
                LocalDateTime now = LocalDateTime.now();
                if (Objects.isNull(baseEntity.getCreatedAt())) {
                    baseEntity.setCreatedAt(now);
                }
                if (Objects.isNull(baseEntity.getUpdatedAt())) {
                    baseEntity.setUpdatedAt(now);
                }
                // 如果创建者和更新者为空 且 当前登录人ID不为空 则 自动填充当前登录人ID
                if (Objects.nonNull(userEntity) && Objects.isNull(baseEntity.getCreator())) {
                    baseEntity.setCreator(userEntity.getId());
                }
                if (Objects.nonNull(userEntity) && Objects.isNull(baseEntity.getUpdater())) {
                    baseEntity.setUpdater(baseEntity.getId());
                }
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 如果时间为空 则 自动填充当前时间
        Object updateAt = getFieldValByName("updatedAt", metaObject);
        if (Objects.isNull(updateAt)) {
            setFieldValByName("updatedAt", LocalDateTime.now(), metaObject);
        }
        // 如果更新者为空 且 当前登录人ID不为空 则 自动填充当前登录人ID
        Object updater = getFieldValByName("updater", metaObject);
        Long id = SecurityUtils.getLoginUserId();
        if (Objects.nonNull(id) && Objects.isNull(updater)) {
            setFieldValByName("updater", id.toString(), metaObject);
        }
    }
}
