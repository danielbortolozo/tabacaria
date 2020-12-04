/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.itens;

/**
 *
 * @author Daniel Rocca Bortolozo | www.sisdb.com.br
 */
public class RelVendaPorItens {
    
    private String codproduto;
    private String descricao;
    private String quantidade;
    private String vl_venda;
    private String vl_custo;
    private String vl_lucro;
    private String vl_total;

    public RelVendaPorItens() {
    }

    public RelVendaPorItens(String codproduto, String descricao, String quantidade, String vl_venda, String vl_custo, String vl_lucro, String vl_total) {
        this.codproduto = codproduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.vl_venda = vl_venda;
        this.vl_custo = vl_custo;
        this.vl_lucro = vl_lucro;
        this.vl_total = vl_total;
    }
    

    public String getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(String codproduto) {
        this.codproduto = codproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getVl_venda() {
        return vl_venda;
    }

    public void setVl_venda(String vl_venda) {
        this.vl_venda = vl_venda;
    }

    public String getVl_custo() {
        return vl_custo;
    }

    public void setVl_custo(String vl_custo) {
        this.vl_custo = vl_custo;
    }

    public String getVl_lucro() {
        return vl_lucro;
    }

    public void setVl_lucro(String vl_lucro) {
        this.vl_lucro = vl_lucro;
    }

    public String getVl_total() {
        return vl_total;
    }

    public void setVl_total(String vl_total) {
        this.vl_total = vl_total;
    }

    
    
    
    
    
    
    
}
