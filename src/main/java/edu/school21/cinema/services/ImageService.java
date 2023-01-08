package edu.school21.cinema.services;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

public interface ImageService {
    List<String> getImages();
    boolean uploadImage(InputStream reqInputStream, long userId, HttpServletRequest request);
}
