/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView;

import java.io.Serializable;


/**
 *
 * @author daniel
 */

public class PedidoVenda implements Serializable {

   
    
    private String descricaoProduto;
    private String vlUnit;
    private String subtotal;
   // private String total;
    private String qtdProduto;
    private String idProduto;

    public PedidoVenda() {
    }

    public PedidoVenda(String descricaoProduto, String vlUnit, String subtotal, String qtdProduto, String idProduto) {
        this.descricaoProduto = descricaoProduto;
        this.vlUnit = vlUnit;
        this.subtotal = subtotal;
        this.qtdProduto = qtdProduto;
        this.idProduto = idProduto;
    }

   
    
   
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getVlUnit() {
        return vlUnit;
    }

    public void setVlUnit(String vlUnit) {
        this.vlUnit = vlUnit;
    }


    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(String qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    

    /**
     * @return the idProduto
     */
    public String getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
    
    
    
    
    
    
}
