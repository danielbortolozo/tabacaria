/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView;

import java.util.List;

/**
 *
 * @author del
 */
public class ReciboVenda {
    
    private String codigoProduto;
    private String descricaoProduto;
    private String qtdProduto;
    private String undProduto;
    private String vlUnit;
    private String vlTotal;
    private String id_venda;
    private String operador;
    private String cliente;
    private String desconto;
    private List lista;
    public ReciboVenda() {
    }

    public ReciboVenda(String codigoProduto, String descricaoProduto) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
    }

    public ReciboVenda(String codigoProduto, String descricaoProduto, String qtdProduto, String undProduto, String vlUnit, String vlTotal) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.qtdProduto = qtdProduto;
        this.undProduto = undProduto;
        this.vlUnit = vlUnit;
        this.vlTotal = vlTotal;
    }
    public ReciboVenda(String codigoProduto, String descricaoProduto, String qtdProduto, String undProduto, String vlUnit, String vlTotal, String desconto) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.qtdProduto = qtdProduto;
        this.undProduto = undProduto;
        this.vlUnit = vlUnit;
        this.vlTotal = vlTotal;
        this.desconto = desconto;
    }

      
    
    
    public ReciboVenda(String codigoProduto, String descricaoProduto, String operador, String cliente, List lista) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.operador = operador;
        this.cliente = cliente;
        this.lista = lista;
    }

    
       
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(String qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getUndProduto() {
        return undProduto;
    }

    public void setUndProduto(String undProduto) {
        this.undProduto = undProduto;
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

    public String getId_venda() {
        return id_venda;
    }

    public void setId_venda(String id_venda) {
        this.id_venda = id_venda;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }
    
    
    
    
    
    
    
    
    
}
