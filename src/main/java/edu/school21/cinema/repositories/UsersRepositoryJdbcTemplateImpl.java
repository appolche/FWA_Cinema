package edu.school21.cinema.repositories;

import edu.school21.cinema.models.SignInRequestEntity;
import edu.school21.cinema.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepositoryJdbcTemplate {
    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users(email, first_name, last_name, phone_number, password) values (?, ?, ?, ?, ?)",
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getPassword());
    }

    @Override
    public User findByEmail(String email) {
        return jdbcTemplate.query("select * from users where email = ?", new UserMapper(), email)
                        .stream().findAny().orElse(null);
    }

}
