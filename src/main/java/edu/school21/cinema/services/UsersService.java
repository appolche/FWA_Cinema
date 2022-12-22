package edu.school21.cinema.services;

import edu.school21.cinema.models.SignInRequestEntity;
import edu.school21.cinema.models.User;

public interface UsersService {
    void save(User user);
    SignInRequestEntity findByEmail(String email);
}
