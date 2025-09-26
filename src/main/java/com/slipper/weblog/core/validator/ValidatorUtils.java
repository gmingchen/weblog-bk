package com.slipper.weblog.core.validator;

import com.slipper.weblog.common.enums.ResultCodeEnum;
import com.slipper.weblog.core.validator.config.ValidatorConfig;
import com.slipper.weblog.exception.RunException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 * @author gumingchen
 */
public class ValidatorUtils {

    private static Validator validator;

    static {
        validator = ValidatorConfig.getValidator();
    }

    /**
     * 功能描述:校验注解参数
     */
    public static <T> void validate(T object, Class<?>... groups) throws RunException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder message = new StringBuilder();
            message.append(ResultCodeEnum.VERIFICATION_ERROR.getMessage());
            String comma = "";
            for (ConstraintViolation<Object> constraint : constraintViolations) {
                message.append(comma).append(constraint.getPropertyPath()+ "-" + constraint.getMessage());
                comma = ",";
            }
            throw new RunException(ResultCodeEnum.VERIFICATION_ERROR.getCode(), message.toString());
        }
    }
}
