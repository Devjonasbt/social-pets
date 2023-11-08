package br.com.socialpet.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import br.com.socialpet.dao.Conexao;

@WebServlet("/create-cadastro")
public class Cadastro extends HttpServlet {

    private String nome;
    private Date data;
    private String email;
    private String nomePai;
    private String nomeMae;
    private String senha;
    private String repSenha;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        nome = request.getParameter("nome");
        email = request.getParameter("email");
        data = Date.valueOf(request.getParameter("data"));
        nomePai = request.getParameter("nomePai");
        nomeMae = request.getParameter("nomeMae");
        senha = request.getParameter("senha");
        repSenha = request.getParameter("repSenha");

        System.out.println("Nome recebido: " + nome);
        System.out.println("Email recebido: " + email);
        System.out.println("Data recebida: " + data);
        System.out.println("Nome do Pai recebido: " + nomePai);
        System.out.println("Nome da Mãe recebido: " + nomeMae);
        System.out.println("Senha recebida: " + senha);
        System.out.println("Senha Repetida: " + repSenha);

        Connection conn = new Conexao().conectar();

        if (conn != null) {
            try {
                String insertNome = "INSERT INTO cadastrar (nome,data,email, nomePai, nomeMae, senha, repSenha) VALUES (?,?,?,?,?,?,?)";

                PreparedStatement preparedStatementNome = conn.prepareStatement(insertNome);


                preparedStatementNome.setString(1, nome);
                preparedStatementNome.setString(2, String.valueOf(data));
                preparedStatementNome.setString(3, email);
                preparedStatementNome.setString(4, nomePai);
                preparedStatementNome.setString(5, nomeMae);
                preparedStatementNome.setString(6, senha);
                preparedStatementNome.setString(7, repSenha);

                int executar = preparedStatementNome.executeUpdate();

                if (executar > 0) {
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
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepSenha() {
        return repSenha;
    }

    public void setRepSenha(String repSenha) {
        this.repSenha = repSenha;
    }
}
