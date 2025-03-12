package com.example.webbe.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {

//    private static final String IMAGE_DIRECTORY = "F:/File_web/ShopQuanAo/src/main/resources/static/images/";

    public String saveImage(MultipartFile image, String directory) {
        try {
            String fileName = UUID.randomUUID().toString() + "-" + image.getOriginalFilename();
            Path path = Paths.get(directory + fileName);
            image.transferTo(path);

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public void deleteImage(String imagePath, String directory) {
        if (imagePath != null && !imagePath.isEmpty()) {
            File file = new File(directory + imagePath);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted) {
                    throw new RuntimeException("Failed to delete the file: " + imagePath);
                }
            }
        }
    }
}
