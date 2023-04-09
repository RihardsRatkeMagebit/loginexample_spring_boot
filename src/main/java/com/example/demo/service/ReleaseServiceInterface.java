package com.example.demo.service;

import com.example.demo.model.Release;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface ReleaseServiceInterface {

    public List<Release> getAllReleases();

    public Release getReleaseBySlug(String slug) throws NoSuchElementException;
}
