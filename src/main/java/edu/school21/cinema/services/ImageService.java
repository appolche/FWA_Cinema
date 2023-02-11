package edu.school21.cinema.services;

import edu.school21.cinema.models.Image;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ImageService {
    List<Image> getImages(Long userId);

    boolean uploadImage(HttpServletRequest request, long userId);
}
