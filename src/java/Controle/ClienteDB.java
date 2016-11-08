/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class ClienteDB {

    private static String sqlInsere = "insert into cliente (cep,nome,endereco,sexo,dt_nascto,saldo_devedor,ativo) values (?,?,?,?,?,?,?)";
    private static String sqlLista = "select * from cliente order by cli_codigo";
    private static String sqlExclui = "delete from cliente where cli_codigo = ?";
    private static String sqlAltera = "update cliente set cli_codigo = ?, cep = ?, nome = ?, endereco = ?, sexo = ?, dt_nascto = ?, saldo_devedor = ?, ativo = ? where cli_codigo = ?";

    public static boolean insereCliente(Cliente cliente) throws ParseException {
        boolean inseriu = false;

        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            pstmt.setInt(1, cliente.getCep());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getEndereco());
            pstmt.setString(4, cliente.getSexo());
            pstmt.setString(5, cliente.getDtNascto());
            pstmt.setDouble(6, cliente.getSaldoDevedor());
            pstmt.setString(7, cliente.getAtivo());
            pstmt.execute();
            ConexaoElep.fechaConexao(conexao);

            inseriu = true;

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }

    public static ArrayList listaCliente() {
        ArrayList lista = new ArrayList();

        try {
            Connection conexao = ConexaoElep.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int codigo = rs.getInt("cli_codigo");
                int cep = rs.getInt("cep");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                String dt_nascto = rs.getString("dt_nascto");
                double saldo = rs.getDouble("saldo_devedor");
                String ativo = rs.getString("ativo");

                Cliente cliente = new Cliente();

                cliente.setCliCodigo(codigo);
                cliente.setCep(cep);
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setSexo(sexo);
                cliente.setDtNascto(dt_nascto);
                cliente.setSaldoDevedor(saldo);
                cliente.setAtivo(ativo);

                lista.add(cliente);
            }
            ConexaoElep.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL: " + erro.getMessage());
        } finally {
            return lista;
        }

    }

    public static boolean excluiCliente(Cliente cliente) {
        boolean excluiu = false;

        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlExclui);
            pstmt.setInt(1, cliente.getCliCodigo());
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

    public static boolean alteraCliente(Cliente cliente) {
        boolean alterou = false;

        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);

            pstmt.setInt(1, cliente.getCliCodigo());
            pstmt.setInt(2, cliente.getCep());
            pstmt.setString(3, cliente.getNome());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getSexo());
            pstmt.setString(6, cliente.getDtNascto());
            pstmt.setDouble(7, cliente.getSaldoDevedor());
            pstmt.setString(8, cliente.getAtivo());
            pstmt.setInt(9, cliente.getCliCodigo());

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
