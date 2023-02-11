package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositories.ImageRepositoryJdbcTemplate;
import edu.school21.cinema.repositories.ImageRepositoryJdbcTemplateImpl;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplateImpl;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.UsersService;
import edu.school21.cinema.services.impl.ImageServiceImpl;
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
    @Value("${storage.path}")
    private String storagePath;

    @Bean
    public DataSource dataSourceBean() {
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
    public JdbcTemplate jdbcTemplateBean() {
        return new JdbcTemplate((dataSourceBean()));
    }

    @Bean
    public UsersRepositoryJdbcTemplate usersRepositoryJdbcTemplateBean() {
        return new UsersRepositoryJdbcTemplateImpl(jdbcTemplateBean());
    }

    @Bean
    public UsersService usersServiceBean() {
        return new UsersServiceImpl(usersRepositoryJdbcTemplateBean());
    }

    @Bean
    public ImageRepositoryJdbcTemplate imageRepositoryJdbcTemplateBean() {
        return new ImageRepositoryJdbcTemplateImpl(jdbcTemplateBean());
    }

    @Bean
    public ImageService imageServiceBean() {
        return new ImageServiceImpl(System.getProperty("catalina.home") + this.storagePath, imageRepositoryJdbcTemplateBean());
    }
}
