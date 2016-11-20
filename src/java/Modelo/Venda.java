/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Guilherme
 */
public class Venda {

    private int vCodigo;
    private int cliCodigo;
    private int cep;
    private int proCodigo;
    private String data;
    private int qtdVenda;
    private String dataPagto;
    private double valorPagto;

    public int getvCodigo() {
        return vCodigo;
    }

    public void setvCodigo(int vCodigo) {
        this.vCodigo = vCodigo;
    }

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public double getValorPagto() {
        return valorPagto;
    }

    public void setValorPagto(double valorPagto) {
        this.valorPagto = valorPagto;
    }

}
