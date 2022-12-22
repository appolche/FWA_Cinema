package edu.school21.cinema.repositories;

import edu.school21.cinema.models.SignInRequestEntity;
import edu.school21.cinema.models.User;

public interface UsersRepositoryJdbcTemplate {
    void save(User user);
    SignInRequestEntity findByEmail(String email);
}
