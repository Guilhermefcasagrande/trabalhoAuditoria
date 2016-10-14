/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoPostgres;
import Modelo.Cidade;
import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class ProdutoDB {

    private static String sqlInsere = "insert into produto (descricao, preco, qtd_estoque) values (?, ?, ?)";
    
    public static boolean insereProduto(Produto produto) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setInt(1, produto.getQtdEstoque());
            pstmt.execute();
            pstmt.close();
            
            inseriu = true;

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }

}
