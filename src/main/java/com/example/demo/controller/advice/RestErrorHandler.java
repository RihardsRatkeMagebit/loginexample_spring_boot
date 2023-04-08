package com.example.demo.controller.advice;

import com.example.demo.response.GenericResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String, List<String>> body = new HashMap<>();

        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);

        logger.error("Bad request " + ((ServletWebRequest) request).getHttpMethod().name());

        return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
    }
}
