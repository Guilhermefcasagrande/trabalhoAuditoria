/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class VendaDB {

    private static String sqlInsere = "insert into venda (cli_codigo,cep,pro_codigo,data,qtd_venda,data_pagto,valor_pagto) values (?,?,?,?,?,?,?)";
    private static String sqlLista = "select * from venda order by v_codigo";
    //private static String sqlExclui = "delete from produto where pro_codigo = ?";
    //private static String sqlAltera = "update produto set pro_codigo = ?, descricao = ?, preco = ?, qtd_estoque = ? where pro_codigo = ?";

    public static boolean insereVenda(Venda venda) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            pstmt.setInt(1, venda.getCliCodigo());
            pstmt.setInt(2, venda.getCep());
            pstmt.setInt(3, venda.getProCodigo());
            pstmt.setString(4, venda.getData());
            pstmt.setInt(5, venda.getQtdVenda());
            pstmt.setString(6, venda.getDataPagto());
            pstmt.setDouble(7, venda.getValorPagto());            
            
            pstmt.execute();
            pstmt.close();

            inseriu = true;

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }

    public static ArrayList listaVenda() {
        ArrayList lista = new ArrayList();

        try {
            Connection conexao = ConexaoElep.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int cliente = rs.getInt("cli_codigo ");
                int cep = rs.getInt("cep");
                int produto = rs.getInt("pro_codigo");
                int venda = rs.getInt("v_codigo");
                String data = rs.getString("data");
                int qtd = rs.getInt("qtd_venda");
                String dataPagto = rs.getString("data_pagto");
                double valor = rs.getDouble("valor_pagto");

                Venda auxVenda = new Venda();
                
                auxVenda.setCliCodigo(cliente);
                auxVenda.setCep(cep);
                auxVenda.setProCodigo(produto);
                auxVenda.setvCodigo(venda);
                auxVenda.setData(data);
                auxVenda.setDataPagto(dataPagto);
                auxVenda.setQtdVenda(qtd);
                auxVenda.setValorPagto(valor);
                
                lista.add(produto);
            }

        } catch (SQLException erro) {
            System.out.println("Erro de SQL: " + erro.getMessage());
        } finally {
            return lista;
        }

    }
/*
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

        } catch (SQLException erro) {
            System.out.println("Erro de SQl " + erro.getMessage());
        } finally {
            return alterou;
        }

    }*/
}
