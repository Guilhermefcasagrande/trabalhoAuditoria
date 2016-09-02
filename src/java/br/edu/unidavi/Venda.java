/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi;

import java.util.Calendar;

/**
 *
 * @author Guilherme
 */
public class Venda {

    private int cliCodigo;
    private int cep;
    private int proCodigo;
    private Calendar data;
    private int qtdVenda;
    private Calendar dataPagto;
    private float valorPagto;

    public int getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(int cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(int proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public Calendar getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(Calendar dataPagto) {
        this.dataPagto = dataPagto;
    }

    public float getValorPagto() {
        return valorPagto;
    }

    public void setValorPagto(float valorPagto) {
        this.valorPagto = valorPagto;
    }
    
    
}
