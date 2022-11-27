package edu.school21.cinema.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/users", name = "UsersServlet")
public class UsersServlet extends HttpServlet {

    //doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter printWriter = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Connection connection = DriverManager.getConnection(url, "postgres", "1");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT first_name from users");

            while (resultSet.next()) {
                printWriter.println(resultSet.getString("first_name"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
