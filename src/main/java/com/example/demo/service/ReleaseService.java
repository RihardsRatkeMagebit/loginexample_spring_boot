package com.example.demo.service;

import com.example.demo.model.OSType;
import com.example.demo.model.Release;
import com.example.demo.model.ReleaseFiles;
import com.example.demo.model.repository.ReleaseRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReleaseService implements ReleaseServiceInterface {

    ReleaseRepository repository;

    @Override
    public List<Release> getAllReleases() {
        return repository.findAll();
    }

    @Override
    public Release getReleaseBySlug(String slug) throws NoSuchElementException {
        Optional<Release> release = repository.findBySlug(slug);

        if (release.isEmpty()) {
            throw new NoSuchElementException("Release doesn't exist");
        }

        return release.get();
    }

}
