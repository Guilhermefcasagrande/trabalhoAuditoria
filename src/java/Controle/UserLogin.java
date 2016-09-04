/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoPostgres;
import Modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class UserLogin {
    
    private static String sqlLoginUser = "select * from usuario where login = ? and senha = ?";
    
    public static User getUser(String login, String senha){
        User usuario = null;
        try {
            Connection con = ConexaoPostgres.getConnection();
            PreparedStatement stmt = con.prepareStatement(sqlLoginUser);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                int auxCodigo = res.getInt("usr_codigo");
                String auxNome = res.getString("nome");
                String auxLogin = res.getString("login");
                String auxSenha = res.getString("senha");
                String auxEmail = res.getString("email");
                usuario = new User(auxCodigo, auxNome, auxLogin, auxSenha, auxEmail);
            }
        } catch (SQLException er) {
            System.out.println("Não foi possível autenticar: " + er.getMessage());
        }finally{
            return usuario;
        }
    }
}
