/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView;

import model.Produto;

/**
 *
 * @author del
 */
public class ProdutosMaisVendidos {
    
    
    
    private String descricao;
    private Double quantidade;
    private Double total;
    private Produto produto;
    private Long id;

    public ProdutosMaisVendidos() {
    }
    
    

    public ProdutosMaisVendidos(String descricao, Double quantidade, Double total) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.total = total;
    }

    
    
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade; 
    
    }
}