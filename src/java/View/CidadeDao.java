/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Conexao.ConexaoPostgres;
import Modelo.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class CidadeDao {
    private Connection connection;
    
    public CidadeDao(){
        this.connection = new ConexaoPostgres().getConnection();
    }
    
    public void adiciona(Cidade cidade){
        String sql = "insert into cidade values (?,?,?);";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cidade.getCep());
            stmt.setString(2, cidade.getNome());
            stmt.setString(3, cidade.getEstado());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }
    }
}
