/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Conexao.ConexaoPostgres;
import Modelo.Cidade;
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
public class CidadeDB {

    private static String sqlLista = "select * from cidade";
    private static String sqlInsere = "insert into cidade (cep, nome, estado) values (?, ?, ?)";
    private static String sqlExclui = "delete from cidade where cep = ?";
    private static String sqlAltera = "update cidade set cep = ?, nome = ?, estado = ? where cep = ?";

    public static boolean insereCidade(Cidade cidade) {
        boolean inseriu = false;
        try {
            //Connection conexao = ConexaoPostgres.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            System.out.println("Cheguei!!3");
            pstmt.setInt(1, cidade.getCep());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getEstado());
            pstmt.execute();
            ConexaoElep.fechaConexao(conexao);

            /*int valor = pstmt.executeUpdate();
             if (valor == 1) {
             inseriu = true;/*
             System.out.println("Cheguei!!3");
             }
             */
            inseriu = true;

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }

    public static ArrayList listaCidade() {
        ArrayList lista = new ArrayList();

        try {
            Connection conexao = ConexaoElep.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int cep = rs.getInt("cep");
                String nome = rs.getString("nome");
                String estado = rs.getString("estado");

                Cidade cidade = new Cidade(cep, nome, estado);

                lista.add(cidade);
            }
            ConexaoElep.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return lista;
        }

    }

    public static boolean excluiCidade(Cidade cidade) {
        boolean excluiu = false;

        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlExclui);
            pstmt.setInt(1, cidade.getCep());
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

    public static boolean alteraCidade(Cidade cidade) {
        boolean alterou = false;

        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);

            pstmt.setInt(1, cidade.getCep());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getEstado());
            pstmt.setInt(4, cidade.getCep());

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
