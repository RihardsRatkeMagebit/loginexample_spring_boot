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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileService implements FileServiceInterface {

    ReleaseRepository releaseRepository;

    @Override
    public boolean upload(MultipartFile file, Release release, Enum<OSType> osType) throws IOException {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        List<String> files = new ArrayList<>();
        files.add(filename);

        ReleaseFiles releaseFile = ReleaseFiles.builder().files(files).osType(osType).build();
        List<ReleaseFiles> releaseList = release.getReleaseFilesList();
        releaseList.add(releaseFile);
        release.setReleaseFilesList(releaseList);

        releaseRepository.save(release);

        return true;
    }

    @Override
    public boolean download(String filename) {
        return false;
    }
}
