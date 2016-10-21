/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class ClienteDB {

    private static String sqlInsere = "insert into cliente (cep,nome,endereco,sexo,dt_nascto,saldo_devedor,ativo) values (?,?,?,?,?,?,?)";
    //private static String sqlLista = "select * from produto order by pro_codigo";
    //private static String sqlExclui = "delete from produto where pro_codigo = ?";
    //private static String sqlAltera = "update produto set pro_codigo = ?, descricao = ?, preco = ?, qtd_estoque = ? where pro_codigo = ?";

    public static boolean insereCliente(Cliente cliente) throws ParseException {
        boolean inseriu = false;
       
        String dataFormatada = cliente.getDtNascto();
        SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
        Date data = (Date) formato.parse(dataFormatada);
        
        try {
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            System.out.println(formato.format(data));
            pstmt.setInt(1, cliente.getCep());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getEndereco());
            pstmt.setString(4, cliente.getSexo());
            pstmt.setDate(5, formato.format(data));
            pstmt.setDouble(6, cliente.getSaldoDevedor());
            pstmt.setString(7, cliente.getAtivo());
            pstmt.execute();
            pstmt.close();

            inseriu = true;

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }
    /*
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

    }
     */
}
