package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
}
