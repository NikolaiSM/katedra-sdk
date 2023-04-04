package com.katedraclases.sdk.util;

import com.katedraclases.sdk.model.ConstraintsKatedra;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static <T> List<ConstraintsKatedra> validate(T t) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        List<ConstraintsKatedra> constraintsList = new ArrayList<>();

        validator.validate(t).forEach(violation -> {
            constraintsList.add(new ConstraintsKatedra(violation.getMessage(), violation.getPropertyPath().toString()));
        });

        return constraintsList;
    }
}
