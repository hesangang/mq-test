package com.sg.mq.domain.validation.validator;

import com.sg.mq.domain.validation.annotaion.NotNull;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sangang
 * @create 2019-01-26
 */
public class NotNullValidator implements ConstraintValidator<NotNull, Object> {


    @Override
    public void initialize(NotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext context) {
        if (s != null) {
            if (s instanceof String) {
                return !StringUtils.isBlank(s.toString());
            }
            return true;
        }
        return false;
    }
}
