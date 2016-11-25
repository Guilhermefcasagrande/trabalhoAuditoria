/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoPostgres;
import Modelo.Acao;
import Modelo.Log;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class AcaoDB {

    private static String sqlLista = "select * from acao order by ac_codigo";

    public static ArrayList listaAcao() {
        ArrayList lista = new ArrayList();

        try {
            Connection conexao = ConexaoPostgres.getConnection();
            //Connection conexao = ConexaoElep.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int acCodigo = rs.getInt("ac_codigo");
                String descricao = rs.getString("descricao");

                Acao acao = new Acao();
                acao.setAcCodigo(acCodigo);
                acao.setDescricao(descricao);

                lista.add(acao);
            }
            //ConexaoElep.fechaConexao(conexao);
            ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL: " + erro.getMessage());
        } finally {
            return lista;
        }
    }
}
