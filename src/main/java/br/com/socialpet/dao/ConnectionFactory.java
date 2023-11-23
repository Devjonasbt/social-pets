
package br.com.socialpet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://bk1jwhvz2w0bcspk7qld-mysql.services.clever-cloud.com:3306/bk1jwhvz2w0bcspk7qld";
    private static final String USER = "uvmexunuh952emqc";
    private static final String PASSWORD = "ahTkmHGBRFHkidXgPXz3";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}