package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
import edu.school21.cinema.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepositoryJdbcTemplate usersRepository;

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public User findByEmail(String email, String password) {
        User user = usersRepository.findByEmail(email);
        if (user == null || !(BCrypt.checkpw(password, user.getPassword()))) {
            return null;
        }
        return user;
    }
}
