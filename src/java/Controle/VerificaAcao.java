/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Conexao.ConexaoPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class VerificaAcao {

    private int acCodigo;
    private String sqlBusca = "select ac_codigo from acao where descricao = ?";

    public int buscaAcao(String acao) {
        try {
            //Connection conexao = ConexaoElep.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlBusca);
            pstmt.setString(1, acao);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                acCodigo = rs.getInt("ac_codigo");
            }
            //ConexaoPostgres.fechaConexao(conexao);
            ConexaoElep.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de sql " + erro);
        } finally {
            return acCodigo;
        }
    }
}
