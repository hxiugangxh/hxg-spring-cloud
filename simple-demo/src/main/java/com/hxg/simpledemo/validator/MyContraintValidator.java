package com.hxg.simpledemo.validator;

import com.hxg.simpledemo.service.UserService;
import com.hxg.simpledemo.service.impl.UserServiceImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyContraintValidator implements ConstraintValidator<MyContraint, Object> {

    @Override
    public void initialize(MyContraint myContraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        UserService userService = new UserServiceImpl();
        String msg = userService.greet("tom");
        System.out.println(msg);

        return true;
    }
}
