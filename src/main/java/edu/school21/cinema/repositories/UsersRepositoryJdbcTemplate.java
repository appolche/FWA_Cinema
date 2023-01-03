package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;

public interface UsersRepositoryJdbcTemplate {
    void save(User user);

    User findByEmail(String email);
}
