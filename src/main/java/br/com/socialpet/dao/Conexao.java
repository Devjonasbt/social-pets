package br.com.socialpet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection conectar(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://bk1jwhvz2w0bcspk7qld-mysql.services.clever-cloud.com:3306/bk1jwhvz2w0bcspk7qld";
            String usuario = "uvmexunuh952emqc";
            String senha = "ahTkmHGBRFHkidXgPXz3";

            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado.");

        } catch (SQLException erro) {
            System.out.printf("O erro está na classe de conexão "+erro.getMessage());
        }


        return conn;

    }
}