package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.repositories.ImageRepositoryJdbcTemplate;
import edu.school21.cinema.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final String storagePath;
    private final ImageRepositoryJdbcTemplate imageRepository;

    @Override
    public List<Image> getImages(Long userId) {
        return imageRepository.findByUserId(userId);
    }

    @Override
    public boolean uploadImage(HttpServletRequest request, long userId) {
        String uploadPath = storagePath + "/" + userId;
        File createDir = new File(uploadPath);
        if (!createDir.exists()) {
            createDir.mkdirs();
        }
        try {
            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            UUID uniqueName = UUID.randomUUID();

            String pathToFile = uploadPath + "/" + uniqueName;
            filePart.write(pathToFile);

            Image uploadedImage = createEntity(fileName, uniqueName, userId, filePart.getSize(), filePart.getContentType(), LocalDateTime.now());

            imageRepository.save(uploadedImage);

            request.getSession().setAttribute("avatar", pathToFile); //???
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Image createEntity(String fileName, UUID uniqueName, Long userId, long size, String mime, LocalDateTime date) {
        Image uploadedImage = new Image();
        uploadedImage.setOriginal_name(fileName);
        uploadedImage.setUuid(uniqueName);
        uploadedImage.setUserId(userId);
        uploadedImage.setSize(size);
        uploadedImage.setMime(mime);
        uploadedImage.setDate(date);
        return uploadedImage;
    }

}
