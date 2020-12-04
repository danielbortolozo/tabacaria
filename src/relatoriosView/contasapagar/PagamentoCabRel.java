/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.contasapagar;

/**
 *
 * @author del
 */
public class PagamentoCabRel {
    
    private String num_doc;
    private String descricao;
    private String fornecedor;
    private String vencimento;
    private String total;
    private String parcelas;
    private String parcelasPagas;
    private String vlParcela;
    private String numParcela;

    public PagamentoCabRel() {
    }

    public PagamentoCabRel(String num_doc, String descricao, String fornecedor, String vencimento, String numParcela, String parcelas, 
            String vlParcela, String total) {
        this.num_doc = num_doc;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.vencimento = vencimento;
        this.numParcela = numParcela;
        this.parcelas = parcelas;       
        this.vlParcela = vlParcela;
        this.total = total;
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

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getParcelasPagas() {
        return parcelasPagas;
    }

    public void setParcelasPagas(String parcelasPagas) {
        this.parcelasPagas = parcelasPagas;
    }

    public String getVlParcela() {
        return vlParcela;
    }

    public void setVlParcela(String vlParcela) {
        this.vlParcela = vlParcela;
    }

    public String getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(String numParcela) {
        this.numParcela = numParcela;
    }
    
       
}
