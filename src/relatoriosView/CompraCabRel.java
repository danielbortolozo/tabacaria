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
public class CompraCabRel {
    
    private String num_doc;
    private String descricao;
    private String fornecedor;
    private String emissao;
    private String subtotal;
    private String desconto;
    private String total;

    public CompraCabRel() {
    }

    public CompraCabRel(String num_doc, String descricao, String fornecedor, String emissao, String subtotal, String desconto, String total) {
        this.num_doc = num_doc;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.emissao = emissao;
        this.subtotal = subtotal;
        this.desconto = desconto;
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

    public String getEmissao() {
        return emissao;
    }

    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
    
    
    
}
