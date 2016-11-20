/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Conexao.ConexaoElep;
import Conexao.ConexaoPostgres;
import Modelo.User;
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
public class UserDB {

    private static String sqlUsuario = "select * from usuario where login = ? and senha = ?";
    private static String sqlTentativas = "update usuario set tentativas_login = ? where login = ?";
    private static String sqlUpdateSituacao = "update usuario set tentativas_login = ?, st_ativo = ? where login = ?";
    private static String sqlInsere = "insert into usuario (nome,login,senha,email,tentativas_login,st_ativo) values (?,?,?,?,?,?)";
    private static String sqlLista = "select * from usuario order by usr_codigo";
    private static String sqlAltera = "update usuario set nome = ?, login = ?, email = ?, st_ativo = ? where usr_codigo = ?";

    public static User getUsuario(String login, String senha) {
        User usuario = null;
        try {
            //Connection conexao = ConexaoPostgres.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlUsuario);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("usr_codigo");
                String nome = rs.getString("nome");
                String log = rs.getString("login");
                String pass = rs.getString("senha");
                String email = rs.getString("email");
                String ativo = rs.getString("st_ativo");

                usuario = new User();

                usuario.setUsrCodigo(codigo);
                usuario.setNome(nome);
                usuario.setLogin(log);
                usuario.setSenha(pass);
                usuario.setEmail(email);
                usuario.setStAtivo(ativo);

            }
            ConexaoElep.fechaConexao(conexao);
            //ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro SQL: " + erro.getMessage());
        } finally {
            return usuario;
        }
    }

    /*
     método que atualiza a quantidade de tentativas de login para o usuario
     que tiver o login igual ao que foi passado no parametro, dependendo da 
     quantidade que retornar do método 'retornaQtdLogin'.
     */
    public static boolean updateTentativasLoginErro(String login) {
        boolean alterou = false;
        int qtd = retornaQtdLogin(login);
        System.out.println(qtd);

        if (qtd < 2) {
            int aux = qtd;
            try {
                //Connection conexao = ConexaoPostgres.getConnection();
                Connection conexao = ConexaoElep.getConnection();
                PreparedStatement pstmt = conexao.prepareStatement(sqlTentativas);
                pstmt.setInt(1, aux + 1);
                pstmt.setString(2, login);

                int valor = pstmt.executeUpdate();
                if (valor == 1) {
                    alterou = true;
                }
                ConexaoElep.fechaConexao(conexao);
                //ConexaoPostgres.fechaConexao(conexao);
            } catch (SQLException erro) {
                System.out.println("Erro de sql aqui: " + erro);
            }

        } else if (qtd >= 2) {
            int aux = qtd;
            try {
                //Connection conexao = ConexaoPostgres.getConnection();
                Connection conexao = ConexaoElep.getConnection();
                PreparedStatement pstmt = conexao.prepareStatement(sqlUpdateSituacao);
                pstmt.setInt(1, aux + 1);
                pstmt.setString(2, "N");
                pstmt.setString(3, login);

                pstmt.executeUpdate();
                ConexaoElep.fechaConexao(conexao);
                //ConexaoPostgres.fechaConexao(conexao);

            } catch (SQLException erro) {
                System.out.println("Erro de sql: " + erro);
            }
        }
        return alterou;
    }

    /*
     método que retorna a quantidade de tentativas de login do usuário que 
     tiver o login igual ao que foi passado no parametro, na coluna 'tentativas_login' 
     da tabela 'usuario'
     */
    public static int retornaQtdLogin(String login) {
        String sqlBuscaQtd = "select tentativas_login from usuario where login = ?";
        int qtd = 0;
        try {
            //Connection conexao = ConexaoPostgres.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlBuscaQtd);
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                qtd = rs.getInt("tentativas_login");
            }
            ConexaoElep.fechaConexao(conexao);
            //ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de sql: " + erro);
        } finally {
            return qtd;
        }

    }

    public static boolean updateTentativasLogin(String login) {
        boolean alterou = false;
        try {
            //Connection conexao = ConexaoPostgres.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlUpdateSituacao);
            pstmt.setInt(1, 0);
            pstmt.setString(2, "S");
            pstmt.setString(3, login);

            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                alterou = true;
            }
            ConexaoElep.fechaConexao(conexao);
            //ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de sql: " + erro);
        } finally {
            return alterou;
        }
    }
    
    public static boolean insereUser(User usuario) throws ParseException {
        boolean inseriu = false;

        try {
            //Connection conexao = ConexaoPostgres.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlInsere);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setInt(5, usuario.getTentativasLogin());
            pstmt.setString(6, usuario.getStAtivo());
            
            pstmt.execute();
            ConexaoElep.fechaConexao(conexao);
            //ConexaoPostgres.fechaConexao(conexao);

            inseriu = true;

        } catch (SQLException erro) {
            System.out.println("Erro de SQL " + erro.getMessage());
        } finally {
            return inseriu;
        }
    }
    
    public static ArrayList listaUsuario() {
        ArrayList lista = new ArrayList();

        try {
            //Connection conexao = ConexaoPostgres.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                int codigo = rs.getInt("usr_codigo");
                String nome = rs.getString("nome");
                String login = rs.getString("login");
                String email = rs.getString("email");
                String ativo = rs.getString("st_ativo");

               User usuario = new User();
               usuario.setNome(nome);
               usuario.setUsrCodigo(codigo);
               usuario.setLogin(login);
               usuario.setEmail(email);
               usuario.setStAtivo(ativo);

                lista.add(usuario);
            }
            ConexaoElep.fechaConexao(conexao);
            //ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQL: " + erro.getMessage());
        } finally {
            return lista;
        }

    }
    
    public static boolean alteraUsuario(User usuario) {
        boolean alterou = false;

        try {
            //Connection conexao = ConexaoPostgres.getConnection();
            Connection conexao = ConexaoElep.getConnection();
            PreparedStatement pstmt = conexao.prepareStatement(sqlAltera);

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getStAtivo());
            pstmt.setInt(5, usuario.getUsrCodigo());

            int valor = pstmt.executeUpdate();
            if (valor == 1) {
                alterou = true;
            }
            ConexaoElep.fechaConexao(conexao);
            //ConexaoPostgres.fechaConexao(conexao);
        } catch (SQLException erro) {
            System.out.println("Erro de SQl " + erro.getMessage());
        } finally {
            return alterou;
        }

    }

}
