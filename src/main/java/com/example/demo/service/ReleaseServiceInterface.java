package com.example.demo.service;

import com.example.demo.model.OSType;
import com.example.demo.model.Release;
import com.example.demo.model.ReleaseFiles;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface ReleaseServiceInterface {

    public List<Release> getAllReleases();

    public Release getReleaseBySlug(String slug) throws NoSuchElementException;
}
