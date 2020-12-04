/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.categoria;

import java.math.BigDecimal;




/**
 *
 * @author daniel
 */

public class VendaItensProdutoCategoria {

   
    
   
    private String produto;
    private String quantidade;
    private String total;

    public VendaItensProdutoCategoria() {
    }

    public VendaItensProdutoCategoria(String produto, String quantidade, String total) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
    }
    

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   
    
    
    
    
    
}
