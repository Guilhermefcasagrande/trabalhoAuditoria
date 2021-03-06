/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Conexao.ConexaoPostgres;
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
    private static String sqlLista = "select * from venda";
    private static String sqlExclui = "delete from venda where cli_codigo = ? and pro_codigo = ? and cep = ?";
    private static String sqlAltera = "update venda set cli_codigo = ?, cep = ?, pro_codigo = ?, data = ?, qtd_venda = ?, data_pagto = ?, valor_pagto = ? where cli_codigo = ? and cep = ? and pro_codigo = ?";

    public static boolean insereVenda(Venda venda) {
        boolean inseriu = false;
        try {
            //Connection conexao = ConexaoElep.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
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
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }

    public static ArrayList listaVenda() {
        ArrayList lista = new ArrayList();

        try {
            //Connection conexao = ConexaoElep.getConnection();
            Connection conexao = ConexaoPostgres.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int cliente = rs.getInt("cli_codigo");
                int cep = rs.getInt("cep");
                int produto = rs.getInt("pro_codigo");
                String data = rs.getString("data");
                int qtd = rs.getInt("qtd_venda");
                String dataPagto = rs.getString("data_pagto");
                double valor = rs.getDouble("valor_pagto");

                Venda auxVenda = new Venda();

                auxVenda.setCliCodigo(cliente);
                auxVenda.setCep(cep);
                auxVenda.setProCodigo(produto);
                auxVenda.setData(data);
                auxVenda.setDataPagto(dataPagto);
                auxVenda.setQtdVenda(qtd);
                auxVenda.setValorPagto(valor);

                lista.add(auxVenda);
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL: " + erro.getMessage());
        } finally {
            return lista;
        }

    }

    public static boolean excluiVenda(Venda venda) {
        boolean excluiu = false;

        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlExclui);
            pstmt.setInt(1, venda.getCliCodigo());
            pstmt.setInt(2, venda.getProCodigo());
            pstmt.setInt(3, venda.getCep());
            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                excluiu = true;
            }
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return excluiu;
        }

    }

    public static boolean alteraVenda(Venda venda) {
        boolean alterou = false;

        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);

            pstmt.setInt(1, venda.getCliCodigo());
            pstmt.setInt(2, venda.getCep());
            pstmt.setInt(3, venda.getProCodigo());
            pstmt.setString(4, venda.getData());
            pstmt.setInt(5, venda.getQtdVenda());
            pstmt.setString(6, venda.getDataPagto());
            pstmt.setDouble(7, venda.getValorPagto());
            pstmt.setInt(8, venda.getCliCodigo());
            pstmt.setInt(9, venda.getCep());
            pstmt.setInt(10, venda.getProCodigo());

            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                alterou = true;
            }

        } catch (SQLException erro) {
            System.out.println("Erro de SQl " + erro.getMessage());
        } finally {
            return alterou;
        }

    }
}
