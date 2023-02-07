package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class ImageRepositoryJdbcTemplateImpl implements ImageRepositoryJdbcTemplate {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void save(Image image) {
        jdbcTemplate.update("insert into images(uuid, original_name, size, mime, user_id, date) values (?, ?, ?, ?, ?, ?)",
                image.getUuid(),
                image.getOriginal_name(),
                image.getSize(),
                image.getMime(),
                image.getUserId(),
                image.getDate());
    }

    @Override
    public List<Image> findByUserId(Long userId) {
        try {
            return jdbcTemplate.query("select * from images where user_id = ? order by date desc", new ImageMapper(), userId);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
