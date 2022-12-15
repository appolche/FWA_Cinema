package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepositoryJdbcTemplate {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users values (?, ?, ?, ?)", user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getPassword());
    }
}
