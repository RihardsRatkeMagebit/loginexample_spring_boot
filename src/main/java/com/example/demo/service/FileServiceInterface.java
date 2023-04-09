package com.example.demo.service;

import com.example.demo.model.OSType;
import com.example.demo.model.Release;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileServiceInterface {
    public boolean upload(MultipartFile file, Release release, Enum<OSType> osType) throws IOException;

    public boolean download(String filename);
}
