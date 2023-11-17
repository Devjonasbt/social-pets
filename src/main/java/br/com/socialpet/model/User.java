package br.com.socialpet.model;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/user")
public class User extends HttpServlet {

    private String email;
    private String password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("login");
        password = request.getParameter("password");

        boolean credentialsValid = checkCredentials(email, password);

        if (credentialsValid) {
            System.out.println("Credenciais válidas para Email: " + email + " e Senha: " + password);
            request.getRequestDispatcher("index.html").forward(request, response);
        } else {
            System.out.println("Credenciais inválidas para Email: " + email + " e Senha: " + password);
        }
    }

    private boolean checkCredentials(String email, String password) {
        String query = "SELECT senha FROM cadastrar WHERE email = ? AND senha = ?";
        boolean credentialsValid = false;

        String url = "jdbc:mysql://bk1jwhvz2w0bcspk7qld-mysql.services.clever-cloud.com:3306/bk1jwhvz2w0bcspk7qld";
        String usuario = "uvmexunuh952emqc";
        String senha = "ahTkmHGBRFHkidXgPXz3";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                credentialsValid = resultSet.next(); // Verifica se há pelo menos uma linha correspondente
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return credentialsValid;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
