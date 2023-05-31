package com.sg.mq.domain.validation.validator;

import com.sg.mq.domain.validation.enums.IEnum;
import com.sg.mq.domain.validation.annotaion.EnumValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 枚举校验.
 *
 * @author sangang
 */
public class EnumValidator implements ConstraintValidator<EnumValue, Object> {

    private Class<? extends IEnum<Object>> enumClass;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (null != value) {
            return null != IEnum.parseByCode(value, enumClass);
        }
        return true;
    }
}
