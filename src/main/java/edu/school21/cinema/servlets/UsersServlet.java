package edu.school21.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
//    private UsersService usersService;
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        ServletContext context = config.getServletContext();
//        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
//        this.usersService = springContext.getBean(UsersService.class);
//    }
    //doPost

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //нужен чтоб написать что-то на странице в аутпуте
        PrintWriter printWriter = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "postgres", "1");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT first_name from users");

            while(resultSet.next()) {
                printWriter.println(resultSet.getString("first_name"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
