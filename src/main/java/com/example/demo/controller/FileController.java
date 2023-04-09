package com.example.demo.controller;

import com.example.demo.model.Release;
import com.example.demo.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("api/v1/file")
public class FileController {
    @RequestMapping(value = "/{filename}", method = GET)
    @ResponseBody
    public ResponseEntity<Object> download(@PathVariable("filename") String filename) {
        try {

            return GenericResponse.generateResponse("Successfully got release", HttpStatus.OK, null);
        } catch (NoSuchElementException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @RequestMapping(value = "/{filename}", method = POST)
    @ResponseBody
    public ResponseEntity<Object> upload(@PathVariable("filename") String filename) {
        try {

            return GenericResponse.generateResponse("Successfully got release", HttpStatus.OK, null);
        } catch (NoSuchElementException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
