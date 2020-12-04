/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda;



/**
 *
 * @author daniel
 */
public class VendaDetail {
    
    private String qtd;
    private String produto;
    private String vlunit;
    private String total;

    public VendaDetail() {
    }

    public VendaDetail(String qtd, String produto, String vlunit, String total) {
        this.qtd = qtd;
        this.produto = produto;
        this.vlunit = vlunit;
        this.total = total;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getVlunit() {
        return vlunit;
    }

    public void setVlunit(String vlunit) {
        this.vlunit = vlunit;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
     
    
    
    
    
}
