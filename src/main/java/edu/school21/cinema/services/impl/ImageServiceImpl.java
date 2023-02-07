package edu.school21.cinema.services.impl;

import edu.school21.cinema.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final String storagePath;

    @Override
    public List<String> getImages(long userId, HttpServletResponse response) {
        try (Stream<Path> paths = Files.walk(Paths.get(storagePath + "/" + userId));
             OutputStream outputStream = response.getOutputStream()) {
            URL imagesUrl = paths.findFirst().map(Path::toUri).get();
            BufferedImage bufferedImage = ImageIO.read(imagesUrl);
            ImageIO.setUseCache(false);
            ImageIO.write(bufferedImage, "png", outputStream);
//            return paths
//                    .filter(Files::isRegularFile)
//                    .map(Object::toString)
//                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return null;
    }

//    public static void main(String[] args) {
//        try (Stream<Path> paths = Files.walk(Paths.get("/Users/e.goryaev/IdeaProjects/apache-tomcat-9.0.69/FWA/images/4/Screenshot 2022-07-26 at 17.57.20.png"));
//             ) {
//            URI imagesUrl = paths.findFirst().map(Path::toUri).get();
//            System.out.println(imagesUrl);
//            System.out.println(imagesUrl.toURL());
////            BufferedImage bufferedImage = ImageIO.read(imagesUrl);
////            ImageIO.setUseCache(false);
////            return paths
////                    .filter(Files::isRegularFile)
////                    .map(Object::toString)
////                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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

            String pathToFile = uploadPath + "/" + createFileName(fileName, uploadPath, 1);
            filePart.write(pathToFile);

            request.getSession().setAttribute("avatar", pathToFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String createFileName(String fullFileName, String uploadPath, int num) {
        String fileName = num == 1 ? fullFileName : appendNumToFileName(fullFileName, num);
        File file = new File(uploadPath + File.pathSeparator + fileName);
        if (file.exists()) {
            return createFileName(fullFileName, uploadPath, num + 1);
        }
        return fileName;
    }

    private String appendNumToFileName(String fileName, int num) {
        StringBuilder res = new StringBuilder();
        int dotIdx = fileName.lastIndexOf(".");
        res
                .append(fileName, 0, dotIdx)
                .append("_").append(num)
                .append(fileName, dotIdx, fileName.length());
        return res.toString();
    }
}
