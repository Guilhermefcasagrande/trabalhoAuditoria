/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi;

/**
 *
 * @author Guilherme
 */
public class Usuario {

    private int usrCodigo;
    private String nome;
    private String login;
    private String senha;
    private String email;

    public int getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(int usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
