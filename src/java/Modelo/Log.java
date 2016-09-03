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
    private Calendar dtExecucao;

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

    public Calendar getDtExecucao() {
        return dtExecucao;
    }

    public void setDtExecucao(Calendar dtExecucao) {
        this.dtExecucao = dtExecucao;
    }
    
    
}
