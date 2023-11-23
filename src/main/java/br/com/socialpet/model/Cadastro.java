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
    private String logradouro;
    private String cidade;
    private String cep;
    private String estado;

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
        logradouro = request.getParameter("logradouro");
        cidade = request.getParameter("cidade");
        cep = request.getParameter("cep");
        estado = request.getParameter("estado");


        /*
        System.out.println("Nome recebido: " + nome);
        System.out.println("Email recebido: " + email);
        System.out.println("Data recebida: " + data);
        System.out.println("Nome do Pai recebido: " + nomePai);
        System.out.println("Nome da Mãe recebido: " + nomeMae);
        System.out.println("Senha recebida: " + senha);
        System.out.println("Senha Repetida: " + repSenha);
        */
        Connection conn = new Conexao().conectar();

        if (conn != null) {
            try {
                String insert = "INSERT INTO cadastrar (nome,data,email, nomePai, nomeMae, senha, repSenha, logradouro, cidade, cep, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement preparedStatementNome = conn.prepareStatement(insert);


                preparedStatementNome.setString(1, nome);
                preparedStatementNome.setString(2, String.valueOf(data));
                preparedStatementNome.setString(3, email);
                preparedStatementNome.setString(4, nomePai);
                preparedStatementNome.setString(5, nomeMae);
                preparedStatementNome.setString(6, senha);
                preparedStatementNome.setString(7, repSenha);
                preparedStatementNome.setString(8, logradouro);
                preparedStatementNome.setString(9, cidade);
                preparedStatementNome.setString(10, cep);
                preparedStatementNome.setString(11, estado);

                int executar = preparedStatementNome.executeUpdate();

                if (executar > 0) {
                    System.out.println("Inserção bem-sucedida.");
                    request.getRequestDispatcher("index.html").forward(request, response);
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
