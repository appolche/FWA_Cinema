package edu.school21.cinema.services;

import edu.school21.cinema.models.User;

public interface UsersService {
    void save(User user);
    User findByEmail(String email, String password);
}