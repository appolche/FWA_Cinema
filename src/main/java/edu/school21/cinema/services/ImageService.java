package edu.school21.cinema.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ImageService {
    List<String> getImages(long userId, HttpServletResponse response);
    boolean uploadImage(HttpServletRequest request, long userId);
}
