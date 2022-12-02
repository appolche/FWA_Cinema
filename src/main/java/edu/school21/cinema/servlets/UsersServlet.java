package edu.school21.cinema.servlets;

import edu.school21.cinema.config.DataSourceConfig;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/sign_in", name = "UsersServlet")
public class UsersServlet extends HttpServlet {

    //doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT first_name FROM users")) {

            while (resultSet.next()) {
                printWriter.println(resultSet.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("jdbc driver not founded", e);
        }
        try {
            return DriverManager.getConnection(url, "postgres", "1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
