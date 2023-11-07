package br.com.socialpet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection conectar(){
        Connection conn = null;

        try {
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/cadastro?user="+user+"&password="+password;
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado.");


        }catch (SQLException erro){
            System.out.printf("O erro está na classe de conexão "+erro.getMessage());
        }

        return conn;

    }
}