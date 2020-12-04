/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.contasapagar;

/**
 *
 * @author danel
 */
public class ContasPagaRel {
    
    private String num_doc;
    private String descricao;
    private String fornecedor;
    private String dtVencimento;
    private String dtPagamento;
    private String juro;
    private String desconto;
    private String multa;
    private String subtotal;
    private String total;
    private String qtdParcela;
    private String parcela;
  
    

    public ContasPagaRel() {
    }

    public ContasPagaRel(String num_doc, String descricao, String fornecedor, String dtVencimento, String dtPagamento, String juro, String desconto, String multa, String subtotal, String total, String qtdParcela, String parcela) {
        this.num_doc = num_doc;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.dtVencimento = dtVencimento;
        this.dtPagamento = dtPagamento;
        this.juro = juro;
        this.desconto = desconto;
        this.multa = multa;
        this.subtotal = subtotal;
        this.total = total;
        this.qtdParcela = qtdParcela;
        this.parcela = parcela;
    }

    
    
    

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(String dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public String getJuro() {
        return juro;
    }

    public void setJuro(String juro) {
        this.juro = juro;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(String qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }
    
    
    
    
    
    
}
