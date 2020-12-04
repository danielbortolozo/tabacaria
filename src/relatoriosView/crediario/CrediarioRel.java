/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.crediario;

/**
 *
 * @author daniel
 */
public class CrediarioRel {
    
    private String documento;
    private String vencimento;
    private String parcela;
    private String valor;
    private String cliente;
    private String cpf;
    private String endereco;
    private String vencimentoExtenso;
    private String valorExtenso;

    public CrediarioRel() {
    }

    public CrediarioRel(String documento, String vencimento, String parcela, String valor, String cliente, String cfp_cnpj, String endereco,
            String vencimentnoExtenso, String valorExtenso) {
        this.documento = documento;
        this.vencimento = vencimento;
        this.parcela = parcela;
        this.valor = valor;
        this.cliente = cliente;
        this.cpf = cfp_cnpj;
        this.endereco = endereco;
        this.vencimentoExtenso = vencimentnoExtenso;
        this.valorExtenso = valorExtenso;
    }
    
    
    

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cfp_cnpj) {
        this.cpf = cfp_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getVencimentoExtenso() {
        return vencimentoExtenso;
    }

    public void setVencimentoExtenso(String vencimentoExtenso) {
        this.vencimentoExtenso = vencimentoExtenso;
    }

    public String getValorExtenso() {
        return valorExtenso;
    }

    public void setValorExtenso(String valorExtenso) {
        this.valorExtenso = valorExtenso;
    }
    
    
    
    
    
    
    
    
}
