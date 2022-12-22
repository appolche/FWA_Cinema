package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.SignInRequestEntity;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
import edu.school21.cinema.services.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepositoryJdbcTemplate usersRepository;

    public UsersServiceImpl(UsersRepositoryJdbcTemplate usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public SignInRequestEntity findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
