import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {

    private int ID;
    private String nome;
    private String email;
    private String mae;
    private String pai;
    private String senha;
    private String repSenha;

    public Cadastro(){}

    public Cadastro(int ID, String nome, String email, String mae, String pai, String senha, String repSenha) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.mae = mae;
        this.pai = pai;
        this.senha = senha;
        this.repSenha = repSenha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String nomeMae = request.getParameter("nomeMae");
        String nomePai = request.getParameter("nomePai");
        String senha = request.getParameter("senha");
        String repetirSenha = request.getParameter("repetirSenha");

        //System.out.println(carName);

        request.getRequestDispatcher("/pages/cadastro.html").forward(request, response);

    }
}
