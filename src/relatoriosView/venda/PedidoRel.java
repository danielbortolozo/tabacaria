/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author daniel
 */
public class PedidoRel {
    
    
    private String idVenda;
    private String cliente;
    private String total;
    private String custo;
    private String dtVenda;

    public PedidoRel() {
    }

    public PedidoRel(String idVenda, String cliente, String total, String dtVenda) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.total = total;
        this.dtVenda = dtVenda;
        
    }

    

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }  
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    

    
   
}
