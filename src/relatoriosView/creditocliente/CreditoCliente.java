/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.creditocliente;

/**
 *
 * @author daniel
 */
public class CreditoCliente {
    
    private String qtd;
    private String und;
    private String produto;
    private String vlUnit;
    private String vlTotal;
    private String status;

    public CreditoCliente() {
    }

    public CreditoCliente(String qtd, String und, String produto, String vlUnit, String vlTotal, String status) {
        this.qtd = qtd;
        this.und = und;
        this.produto = produto;
        this.vlUnit = vlUnit;
        this.vlTotal = vlTotal;
        this.status = status;
    }

    
    
    
    
    
    
    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getUnd() {
        return und;
    }

    public void setUnd(String und) {
        this.und = und;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getVlUnit() {
        return vlUnit;
    }

    public void setVlUnit(String vlUnit) {
        this.vlUnit = vlUnit;
    }

    public String getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(String vlTotal) {
        this.vlTotal = vlTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    
    
}
