package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;

import java.util.List;

public interface ImageRepositoryJdbcTemplate {
    void save(Image image);

    List<Image> findByUserId(Long userId);
//    Image findByUuid(UUID id);
}
