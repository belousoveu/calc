package org.skypro.be.calc.controller;


import org.skypro.be.calc.exception.DivideByZeroException;
import org.skypro.be.calc.exception.InvalidOperatorException;
import org.skypro.be.calc.utils.ResponseFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalAdvancedController {


    @ExceptionHandler(
            {MissingServletRequestParameterException.class,
                    MissingPathVariableException.class,
                    MethodArgumentTypeMismatchException.class,
                    InvalidOperatorException.class,
                    DivideByZeroException.class,
                    NullPointerException.class
            }
    )
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ResponseFormatter.getErrorMessage(ex.getMessage()));
    }

}
