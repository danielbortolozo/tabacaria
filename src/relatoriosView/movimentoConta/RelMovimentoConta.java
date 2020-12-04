/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.movimentoConta;

import java.util.Date;

/**
 *
 * @author daniel
 */
public class RelMovimentoConta {
    
    private String conta;
    private float saldo;
    private Date dt_mov;
    private String obs;
    private float entrada;
    private float saida;

    public RelMovimentoConta() {
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getDt_mov() {
        return dt_mov;
    }

    public void setDt_mov(Date dt_mov) {
        this.dt_mov = dt_mov;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public float getEntrada() {
        return entrada;
    }

    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }

    public float getSaida() {
        return saida;
    }

    public void setSaida(float saida) {
        this.saida = saida;
    }
    
    
    
    
}
