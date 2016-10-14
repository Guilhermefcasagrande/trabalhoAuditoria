/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoPostgres;
import Modelo.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class CidadeDB {

    //private static String sqlTodos = "select * from cidade";
    private static String sqlInsere = "insert into cidade (cep, nome, estado) values (?, ?, ?)";
    //private static String sqlExclui = "delete from apartamento where apt_numero = ?";
    //private static String sqlAltera = "update apartamento set qtd_quartos = ?, area = ?, pro_codigo = ?, tipo_codigo =?  where apt_numero = ?";


    public static boolean insereCidade(Cidade cidade) {
        boolean inseriu = false;
        try {
            Connection conexao = ConexaoPostgres.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            System.out.println("Cheguei!!3");
            pstmt.setInt(1, cidade.getCep());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getEstado());
            pstmt.execute();
            pstmt.close();

            /*int valor = pstmt.executeUpdate();
             if (valor == 1) {
             inseriu = true;
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
}
