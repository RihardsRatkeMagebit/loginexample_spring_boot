package com.example.demo.controller.advice;

import com.example.demo.response.GenericResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
@Slf4j
public class RestErrorHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(RestErrorHandler.class);

    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(
            AccessDeniedException exception,
            WebRequest request
    ) {
        logger.warn("Access denied required:" + request.getContextPath());
        logger.error(exception.getMessage());

        return GenericResponse.generateResponse("Access denied your action has been logged", HttpStatus.OK, null);
    }

    @ResponseBody
    @ExceptionHandler({ExpiredJwtException.class, SignatureException.class})
    public ResponseEntity<Object> handleOldToken(
            ExpiredJwtException exception,
            WebRequest request
    ) {
        logger.warn("Expired token occurred " + request.getContextPath());
        logger.error(exception.getMessage());

        return GenericResponse.generateResponse("Token is invalid or experienced, re-auth required", HttpStatus.OK, null);
    }
}