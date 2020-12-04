/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda;

import java.util.Date;
import java.util.List;

/**
 *
 * @author daniel
 */
public class VendaMaster {
    
    
    private int idVenda;
    private String nome;
    private String data;
    private String valor;
    private String desconto;
    private String acrescimo;
    private List itens;

    public VendaMaster() {
    }

    public VendaMaster(int idVenda, String nome, String data, String valor) {
        this.idVenda = idVenda;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

    public VendaMaster(int idVenda, String nome, String data, String valor, List itens) {
        this.idVenda = idVenda;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.itens = itens;
    }

    public VendaMaster(int idVenda, String nome, String data, String valor, String desconto, String acrescimo, List itens) {
        this.idVenda = idVenda;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.itens = itens;
    }
    
     
    
    
    
       
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List getItens() {
        return itens;
    }

    public void setItens(List itens) {
        this.itens = itens;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(String acrescimo) {
        this.acrescimo = acrescimo;
    }
    
    
    
    
    
    
    
}
