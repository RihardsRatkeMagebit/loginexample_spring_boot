package com.example.demo.controller;


import com.example.demo.model.Project;
import com.example.demo.model.Release;
import com.example.demo.model.User;
import com.example.demo.response.GenericResponse;
import com.example.demo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    ProjectService projectService;
    Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Object> list() {
        List<Project> projects = projectService.getAllProjects();

        return GenericResponse.generateResponse("Successfully got list of all projects", HttpStatus.OK, projects);
    }

    @RequestMapping(value = "/{slug}/release", method = GET)
    @ResponseBody
    public ResponseEntity<Object> getProjectRelease(@PathVariable("slug") String slug) {
        try {
            List<Release> releases = projectService.getProjectReleases(slug);

            return GenericResponse.generateResponse("Successfully got all releases", HttpStatus.OK, releases);
        } catch (NoSuchElementException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value = "/{slug}/users", method = GET)
    @ResponseBody
    public ResponseEntity<Object> getProjectUsers(@PathVariable("slug") String slug) {
        try {
            List<User> users = projectService.getProjectUsers(slug);

            return GenericResponse.generateResponse("Successfully got all users", HttpStatus.OK, users);
        } catch (NoSuchElementException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value = "/{slug}/edit", method = GET)
    @ResponseBody
    public ResponseEntity<Object> getProject(@PathVariable("slug") String slug) {
        try {
            Project project = projectService.getProjectBySlug(slug);

            return GenericResponse.generateResponse("Successfully got project", HttpStatus.OK, project);
        } catch (NoSuchElementException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
