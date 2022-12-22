package edu.school21.cinema.repositories;

import edu.school21.cinema.models.SignInRequestEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInRequestMapper implements RowMapper<SignInRequestEntity> {
    @Override
    public SignInRequestEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        SignInRequestEntity signInRequestEntity = new SignInRequestEntity();
        signInRequestEntity.setEmail(rs.getString("email"));
        signInRequestEntity.setPassword(rs.getString("password"));
        return signInRequestEntity;
    }
}
