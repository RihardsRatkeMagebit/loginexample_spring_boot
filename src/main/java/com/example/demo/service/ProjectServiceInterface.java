package com.example.demo.service;

import com.example.demo.model.Project;
import com.example.demo.model.Release;
import com.example.demo.model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ProjectServiceInterface {
    public List<Project> getAllProjects();

    public Project getProjectBySlug(String slug) throws NoSuchElementException;

    public List<Release> getProjectReleases(String slug);

    public List<User> getProjectUsers(String slug);
}
