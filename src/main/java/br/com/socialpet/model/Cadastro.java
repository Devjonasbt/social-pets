package br.com.socialpet.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.socialpet.dao.Conexao;

@WebServlet("/create-cadastro")
public class Cadastro extends HttpServlet {

    private String name;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        name = request.getParameter("nome");
        System.out.println("Nome recebido: " + name);

        // Estabeleça a conexão com o banco de dados
        Connection conn = new Conexao().conectar();

        if (conn != null) {
            try {
                String sql = "INSERT INTO cadastrar (nome) VALUES (?)";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, name);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Inserção bem-sucedida.");
                } else {
                    System.out.println("Nenhuma linha foi afetada pela inserção.");
                }

            } catch (Exception e) {
                System.out.println("Erro durante a inserção no banco de dados: " + e.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }

        request.getRequestDispatcher("index.html").forward(request, response);
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }
}
