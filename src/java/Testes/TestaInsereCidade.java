/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Modelo.Cidade;
import View.CidadeDao;

/**
 *
 * @author Guilherme
 */
public class TestaInsereCidade {
    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        
        cidade.setCep(89160000);
        cidade.setNome("Rio do Oeste");
        cidade.setEstado("Santa Catarina");
        
        CidadeDao dao = new CidadeDao();
        dao.adiciona(cidade);
        
        System.out.println("Show");
    }
}
