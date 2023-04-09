package com.example.demo.service;

import com.example.demo.model.OSType;
import com.example.demo.model.Release;
import com.example.demo.model.ReleaseFile;
import com.example.demo.model.repository.FileRepository;
import com.example.demo.model.repository.ReleaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileService implements FileServiceInterface {

    private final ReleaseRepository releaseRepository;
    private final FileRepository fileRepository;
    private final Environment environment;

    private Path foundFile;

    @Override
    public boolean upload(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileDir = environment.getProperty("release.upload.dir");
        String finalLocation = fileDir + filename;
        Enum<OSType> osType = OSType.valueOf("ANDROID");

        file.transferTo(new File(finalLocation));

        ReleaseFile releaseFile = ReleaseFile.builder().filename(finalLocation).osType(osType).build();

        fileRepository.save(releaseFile);

        return true;
    }

    @Override
    public Resource download(String filename) throws IOException {
        foundFile = null;

        String defaultUploadDir = environment.getProperty("release.upload.dir");
        Path uploadDir = Paths.get(Objects.requireNonNull(defaultUploadDir));

        Files.list(uploadDir).forEach(file -> {
            if (file.getFileName().toString().startsWith(filename)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}
