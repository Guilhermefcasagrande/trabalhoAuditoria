/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Conexao.ConexaoPostgres;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class Teste {
    public static void main(String[] args) throws SQLException {
        Connection c = new ConexaoPostgres().getConnection();
        c.close();
    }
}
