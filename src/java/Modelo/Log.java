/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;

/**
 *
 * @author Guilherme
 */
public class Log {

    private int usrCodigo;
    private int acCodigo;
    private String dtExecucao;
    private int cdLog;
    private String tabela;

    public int getCdLog() {
        return cdLog;
    }

    public void setCdLog(int cdLog) {
        this.cdLog = cdLog;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public int getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(int usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public int getAcCodigo() {
        return acCodigo;
    }

    public void setAcCodigo(int acCodigo) {
        this.acCodigo = acCodigo;
    }

    public String getDtExecucao() {
        return dtExecucao;
    }

    public void setDtExecucao(String dtExecucao) {
        this.dtExecucao = dtExecucao;
    }
    
    
}
