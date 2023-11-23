package br.com.socialpet.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    private String email;
    private String password;

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
                credentialsValid = resultSet.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return credentialsValid;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("login");
        password = request.getParameter("password");

        if (checkCredentials(email, password)) {
            System.out.println("Credenciais válidas para Email: " + email + " e Senha: " + password);

            DadosUsuario userData = getDadosUsuario(email, password);

            request.setAttribute("userData", userData);

            request.getRequestDispatcher("pages/user.jsp").forward(request, response);
        } else {
            System.out.println("Credenciais inválidas para Email: " + email + " e Senha: " + password);

            request.setAttribute("error", "Credenciais inválidas. Tente novamente.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private DadosUsuario getDadosUsuario(String email, String password) {
        String query = "SELECT id, nome, data, email, logradouro, cidade, cep, estado FROM cadastrar WHERE email = ? AND senha = ?";
        DadosUsuario userData = new DadosUsuario();

        String url = "jdbc:mysql://bk1jwhvz2w0bcspk7qld-mysql.services.clever-cloud.com:3306/bk1jwhvz2w0bcspk7qld";
        String usuario = "uvmexunuh952emqc";
        String senha = "ahTkmHGBRFHkidXgPXz3";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    userData.setId(resultSet.getString("id"));
                    userData.setNome(resultSet.getString("nome"));
                    userData.setDataNascimento(resultSet.getString("data"));
                    userData.setEmail(resultSet.getString("email"));
                    userData.setLogradouro(resultSet.getString("logradouro"));
                    userData.setCidade(resultSet.getString("cidade"));
                    userData.setCep(resultSet.getString("cep"));
                    userData.setEstado(resultSet.getString("estado"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userData;
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
