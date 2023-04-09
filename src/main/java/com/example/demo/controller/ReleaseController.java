package com.example.demo.controller;


import com.example.demo.model.Release;
import com.example.demo.response.GenericResponse;
import com.example.demo.service.ReleaseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/release")
public class ReleaseController {
    ReleaseService releaseService;
    Logger logger = LoggerFactory.getLogger(ReleaseController.class);

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        List<Release> releases = releaseService.getAllReleases();

        return GenericResponse.generateResponse("Successfully got all releases", HttpStatus.OK, releases);
    }

    @RequestMapping(value = "/{slug}", method = GET)
    @ResponseBody
    public ResponseEntity<Object> getRelease(@PathVariable("slug") String slug) {
        try {
            Release release = releaseService.getReleaseBySlug(slug);

            return GenericResponse.generateResponse("Successfully got release", HttpStatus.OK, release);
        } catch (NoSuchElementException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value = "/{slug}/edit", method = GET)
    @ResponseBody
    public ResponseEntity<Object> editRelease(@PathVariable("slug") String slug) {
        try {
            Release release = releaseService.getReleaseBySlug(slug);

            return GenericResponse.generateResponse("Successfully got release", HttpStatus.OK, release);
        } catch (NoSuchElementException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
