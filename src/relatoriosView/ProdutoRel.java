/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView;

/**
 *
 * @author del
 */
public class ProdutoRel {
    
    
    private String id;
    private String cod_interno;
    private String codigo_original;
    private String descricao;
    private String unidade;
    private String marca;
    private String modelo;
    private String peso;
    private String estoque;
    private String preco;
    private String vl_venda;
    private String status;
    

    public ProdutoRel() {
    }

    public ProdutoRel(String id, String cod_interno, String descricao, String unidade, String marca, String peso, String estoque, String preco) {
        this.id = id;
        this.cod_interno = cod_interno;
        this.descricao = descricao;
        this.unidade = unidade;
        this.marca = marca;
      //  this.modelo = modelo;
        this.peso = peso;
        this.estoque = estoque;
        this.preco = preco;
    }

    public ProdutoRel(String cod_interno, String descricao, String marca, String estoque, String vl_venda, String status) {
        this.cod_interno = cod_interno;
        
        this.descricao = descricao;
        this.marca = marca;
        
        this.estoque = estoque;
        this.vl_venda = vl_venda;
        this.status = status;
        
    }

    
    
    
    
    
    public String getCodigo_original() {
        return codigo_original;
    }

    public void setCodigo_original(String codigo_original) {
        this.codigo_original = codigo_original;
    }   
    
    
    

    public String getVl_venda() {
        return vl_venda;
    }

    public void setVl_venda(String vl_venda) {
        this.vl_venda = vl_venda;
    }   
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCod_interno() {
        return cod_interno;
    }

    public void setCod_interno(String cod_interno) {
        this.cod_interno = cod_interno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    
}
