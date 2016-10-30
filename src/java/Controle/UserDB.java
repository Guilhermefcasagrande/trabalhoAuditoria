/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guilherme
 */
public class UserDB {
    private static String sqlUsuario = "select * from usuario where login = ? and senha = ?";
    
    public static User getUsuario(String login, String senha){
        User usuario = null;
        try{
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlUsuario);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("usr_codigo");
                String nome = rs.getString("nome");
                String log = rs.getString("login");
                String pass = rs.getString("senha");
                String email = rs.getString("email");
                
                usuario = new User();
                
                usuario.setUsrCodigo(codigo);
                usuario.setNome(nome);
                usuario.setLogin(log);
                usuario.setSenha(pass);
                usuario.setEmail(email);
                
            }
        }catch(SQLException erro){
            System.out.println("Erro SQL: " + erro.getMessage());
        }finally{
            return usuario;
        }
    }
    
}
