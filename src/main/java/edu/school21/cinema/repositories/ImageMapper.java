package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ImageMapper implements RowMapper<Image> {

    @Override
    public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
        Image image = new Image();
        image.setId(rs.getLong("id"));
        image.setUuid(UUID.fromString(rs.getString("uuid")));
        image.setOriginal_name(rs.getString("original_name"));
        image.setSize(rs.getLong("size"));
        image.setMime(rs.getString("mime"));
        image.setUserId(rs.getLong("user_id"));
        image.setDate(rs.getTimestamp("date").toLocalDateTime());
        return image;
    }
}
