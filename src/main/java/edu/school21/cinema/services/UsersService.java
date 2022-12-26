package edu.school21.cinema.services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.school21.cinema.models.SignInRequestEntity;
import edu.school21.cinema.models.User;

public interface UsersService {
    void save(User user);
    User findByEmail(String email, String password);
}
