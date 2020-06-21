package com.fruitshop.api.fruitshopapi.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;

public class DateValidatorLogic implements ConstraintValidator<DateValidator,String> {

    private String pattern;

    @Override
    public void initialize(DateValidator constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        if(date == null){
            return true;
        }else {
            try{
                DateTimeFormatter.ofPattern(pattern).parse(date);
                return true;
            }catch (Exception e){
                return false;
            }
        }
    }
}
