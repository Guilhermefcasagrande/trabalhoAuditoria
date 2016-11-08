/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Conexao.ConexaoPostgres;
import Modelo.Cidade;
import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class ProdutoDB {

    private static String sqlInsere = "insert into produto (descricao, preco, qtd_estoque) values (?, ?, ?)";
    private static String sqlLista = "select * from produto order by pro_codigo";
    private static String sqlExclui = "delete from produto where pro_codigo = ?";
    private static String sqlAltera = "update produto set pro_codigo = ?, descricao = ?, preco = ?, qtd_estoque = ? where pro_codigo = ?";

    public static boolean insereProduto(Produto produto) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setInt(3, produto.getQtdEstoque());
            pstmt.execute();
            ConexaoElep.fechaConexao(conexao);

            inseriu = true;

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }

    public static ArrayList listaProduto() {
        ArrayList lista = new ArrayList();

        try {
            Connection conexao = ConexaoElep.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int codigo = rs.getInt("pro_codigo");
                String descricao = rs.getString("descricao");
                int preco = rs.getInt("preco");
                int qtd = rs.getInt("qtd_estoque");

                Produto produto = new Produto();

                produto.setProCodigo(codigo);
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                produto.setQtdEstoque(qtd);

                lista.add(produto);
            }
            ConexaoElep.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL: " + erro.getMessage());
        } finally {
            return lista;
        }

    }

    public static boolean excluiProduto(Produto produto) {
        boolean excluiu = false;

        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlExclui);
            pstmt.setInt(1, produto.getProCodigo());
            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                excluiu = true;
            }
            ConexaoElep.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return excluiu;
        }

    }

    public static boolean alteraProduto(Produto produto) {
        boolean alterou = false;

        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);

            pstmt.setInt(1, produto.getProCodigo());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQtdEstoque());
            pstmt.setInt(5, produto.getProCodigo());

            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                alterou = true;
            }
            ConexaoElep.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQl " + erro.getMessage());
        } finally {
            return alterou;
        }

    }

}
