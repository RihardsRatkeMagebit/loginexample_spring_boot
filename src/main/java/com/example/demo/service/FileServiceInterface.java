package com.example.demo.service;

import com.example.demo.model.OSType;
import com.example.demo.model.Release;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileServiceInterface {
    public boolean upload(MultipartFile file) throws IOException;

    public Resource download(String filename) throws IOException;
}
