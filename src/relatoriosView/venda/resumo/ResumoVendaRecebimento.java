/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.resumo;

/**
 *
 * @author daniel
 */
public class ResumoVendaRecebimento {
    
    
    private String totalAVista;
    private String totalAPrazo;
    private String totalDinheiro;
    private String totalCartaoDeb;
    private String totalCartaoCred;
    private String totalCheque;
    private String totalValeAli;
    private String totalVenda;
    private String totalRecebimento;

    public ResumoVendaRecebimento() {
    }

    public ResumoVendaRecebimento(String totalVendaAvista, String totalVendaAprazo, String totalDinheiro, String totalCartaoDeb, String totalCartaoCred, String totalCheque, String totalValeAli, String totalVenda, String totalRecebimento) {
        this.totalAVista = totalVendaAvista;
        this.totalAPrazo = totalVendaAprazo;
        this.totalDinheiro = totalDinheiro;
        this.totalCartaoDeb = totalCartaoDeb;
        this.totalCartaoCred = totalCartaoCred;
        this.totalCheque = totalCheque;
        this.totalValeAli = totalValeAli;
        this.totalVenda = totalVenda;
        this.totalRecebimento = totalRecebimento;
    }

    
    
    

    public String getTotalAVista() {
        return totalAVista;
    }

    public void setTotalAVista(String totalVendaAvista) {
        this.totalAVista = totalVendaAvista;
    }

    public String getTotalAPrazo() {
        return totalAPrazo;
    }

    public void setTotalAPrazo(String totalVendaAprozo) {
        this.totalAPrazo = totalVendaAprozo;
    }

    public String getTotalDinheiro() {
        return totalDinheiro;
    }

    public void setTotalDinheiro(String totalDinheiro) {
        this.totalDinheiro = totalDinheiro;
    }

    public String getTotalCartaoDeb() {
        return totalCartaoDeb;
    }

    public void setTotalCartaoDeb(String totalCartaoDeb) {
        this.totalCartaoDeb = totalCartaoDeb;
    }

    public String getTotalCartaoCred() {
        return totalCartaoCred;
    }

    public void setTotalCartaoCred(String totalCartaoCred) {
        this.totalCartaoCred = totalCartaoCred;
    }

    public String getTotalCheque() {
        return totalCheque;
    }

    public void setTotalCheque(String totalCheque) {
        this.totalCheque = totalCheque;
    }

    public String getTotalValeAli() {
        return totalValeAli;
    }

    public void setTotalValeAli(String totalValeAli) {
        this.totalValeAli = totalValeAli;
    }

    public String getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(String totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getTotalRecebimento() {
        return totalRecebimento;
    }

    public void setTotalRecebimento(String totalRecebimento) {
        this.totalRecebimento = totalRecebimento;
    }
    
    
    
    
    
    
    
    
}
