package org.example.config;

/**
 * @author ruo
 * @version 1.0
 * @date 2023/1/29
 */

import org.example.util.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result validateException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> list = new ArrayList<>();
        for (FieldError error : fieldErrors) {
            list.add(error.getField() + error.getDefaultMessage());
        }
        System.out.println(list.get(0).toString());
        return new Result("500", "参数有误！", list.get(0));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public Result validateException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        List<String> list = new ArrayList<>();
        for (ConstraintViolation<?> item : violations) {
            list.add(item.getMessage());
        }
        System.out.println(list.get(0).toString());
        return new Result("500", "参数有误！", list.get(0));
    }

}