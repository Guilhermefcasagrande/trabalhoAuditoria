/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Modelo.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class GravaLog {
    private static String sqlGravaLog = "insert into log (usr_codigo,ac_codigo,dt_execucao,tabela) values (?,?,current_timestamp,?)";
    
    public static boolean log(Log log){
        boolean inseriu = false;
        
        try {

            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlGravaLog);
            pstmt.setInt(1, log.getUsrCodigo());
            pstmt.setInt(2, log.getAcCodigo());
            pstmt.setString(3, log.getTabela());
            
            pstmt.execute();
            pstmt.close();

            inseriu = true;
            System.out.println("Log Gravado");

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }
}
