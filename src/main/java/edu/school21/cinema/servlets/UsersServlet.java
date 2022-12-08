package edu.school21.cinema.servlets;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.config.DataSourceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(value = "/sign_in", name = "UsersServlet")
public class UsersServlet extends HttpServlet {

    //doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);

        PrintWriter printWriter = response.getWriter();

        try (Connection connection = context.getBean(HikariDataSource.class).getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT first_name FROM users")) {

            while (resultSet.next()) {
                printWriter.println(resultSet.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
