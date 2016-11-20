/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Conexao.ConexaoPostgres;
import Modelo.Cliente;
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
public class LogDB {

    private static String sqlLista = "select * from log order by cd_log";

    public static ArrayList listaLog() {
        ArrayList lista = new ArrayList();

        try {
            Connection conexao = ConexaoPostgres.getConnection();
            //Connection conexao = ConexaoElep.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int usrCodigo = rs.getInt("usr_codigo");
                int acCodigo = rs.getInt("ac_codigo");
                int cdLog = rs.getInt("cd_log");
                String dtExecucao = rs.getString("dt_execucao");
                String tabela = rs.getString("tabela");

                Log log = new Log();
                log.setCdLog(cdLog);
                log.setAcCodigo(acCodigo);
                log.setDtExecucao(dtExecucao);
                log.setTabela(tabela);
                log.setUsrCodigo(usrCodigo);
                
                lista.add(log);
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
