/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class ConexaoPostgres {
    
    private static String driver = "org.postgresql.Driver";
    private static String servidor = "localhost";
    private static String banco = "trabAud";
    private static String usuario = "postgres";
    private static String senha = "1";
    private static String url = "jdbc:postgresql://" + servidor + ":5432/" + banco;

    public static Connection getConnection() {
        Connection conexao = null;

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com sucesso");

        } catch (ClassNotFoundException erro) {
            System.out.println("Erro de driver " + erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return conexao;
        }
    }
}
