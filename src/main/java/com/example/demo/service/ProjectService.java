package com.example.demo.service;

import com.example.demo.model.Project;
import com.example.demo.model.Release;
import com.example.demo.model.User;
import com.example.demo.model.repository.ProjectRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService implements ProjectServiceInterface {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectBySlug(String slug) throws NoSuchElementException {
        Optional<Project> project = projectRepository.findBySlug(slug);

        if (project.isEmpty()) {
            throw new NoSuchElementException("Project not found");
        }

        return project.get();
    }

    @Override
    public List<Release> getProjectReleases(String slug) {
        return getProjectBySlug(slug).getReleases();
    }

    @Override
    public List<User> getProjectUsers(String slug) {
        return getProjectBySlug(slug).getUsers();
    }
}
