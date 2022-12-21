package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplateImpl;
import edu.school21.cinema.services.UsersService;
import edu.school21.cinema.services.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:../application.properties")
public class DataSourceConfig {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.driver}")
    private String driver;
    @Value("${db.password}")
    private String password;

    @Bean
    DataSource dataSourceBean() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HikariDataSource source = new HikariDataSource();
        source.setJdbcUrl(url);
        source.setUsername(user);
        source.setPassword(password);
        return source;
    }
    @Bean
    JdbcTemplate jdbcTemplateBean() {
        return new JdbcTemplate((dataSourceBean()));
    }

    @Bean
    UsersRepositoryJdbcTemplate usersRepositoryJdbcTemplateBean() {
        return new UsersRepositoryJdbcTemplateImpl(jdbcTemplateBean());
    }

    @Bean
    public UsersService usersServiceBean() {
        return new UsersServiceImpl(usersRepositoryJdbcTemplateBean());
    }
}
