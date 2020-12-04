/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.movimentoConta;

/**
 *
 * @author daniel
 */
public class SaldoContasSelecionadas {
    
    private String conta;
    private float saldo;

    public SaldoContasSelecionadas(String conta, float saldo) {
        this.conta = conta;
        this.saldo = saldo;
    }

    public SaldoContasSelecionadas() {
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
    
    
    
    
    
    
}
