package edu.school21.cinema.services.impl;

import edu.school21.cinema.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final String storagePath;

    @Override
    public List<String> getImages() {
        return null;
    }

    @Override
    public boolean uploadImage(InputStream reqInputStream, long userId, HttpServletRequest request) {
        try {
            DiskFileItemFactory fileFactory = new DiskFileItemFactory();
            fileFactory.setRepository(new File(storagePath));
            ServletFileUpload uploader = new ServletFileUpload(fileFactory);
            List<FileItem> fileItemsList = uploader.parseRequest(request);
            for (FileItem fileItem : fileItemsList) {
                File file = createFile(storagePath + "/" + userId + "/" + fileItem.getName(), 1);
                fileItem.write(file);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private File createFile(String fullFileName, int num) throws IOException {
        File file = new File(fullFileName + ((num == 1) ? "" : "_" + num));
        if (!file.createNewFile()) {
            return createFile(fullFileName, num + 1);
        } else {
            return file;
        }
    }
}
