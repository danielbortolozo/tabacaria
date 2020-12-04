/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name="pessoa_endereco")
public class PessoaEndereco {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    
    @Column(length=150)
    private String logradouro;
    @Column(length=20)
    private String numero;
    @Column(length=50)
    private String complemento;
    @Column(length=100)
    private String bairro;
    @Column(length=100)
    private String cidade;
    @Column(length=20)
    private String cep;
    @Column(length=2)
    private String uf;
    
    private Boolean entrega;
    
    private Boolean cobranca;
    
    private Boolean principal;
    
    private Boolean correspondencia;

    public PessoaEndereco() {
    }

    public PessoaEndereco(String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String uf, Boolean entrega, Boolean cobranca, Boolean principal, Boolean correspondencia, Long id) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.entrega = entrega;
        this.cobranca = cobranca;
        this.principal = principal;
        this.correspondencia = correspondencia;
        this.id = id;
    }
   

    public PessoaEndereco(Long id, String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String uf, Boolean entrega, Boolean cobranca, Boolean principal, Boolean correspondencia) {
        this.id = id;        
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.entrega = entrega;
        this.cobranca = cobranca;
        this.principal = principal;
        this.correspondencia = correspondencia;
    }


    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
  
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Boolean getEntrega() {
        return entrega;
    }

    public void setEntrega(Boolean entrega) {
        this.entrega = entrega;
    }

    public Boolean getCobranca() {
        return cobranca;
    }

    public void setCobranca(Boolean cobranca) {
        this.cobranca = cobranca;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Boolean getCorrespondencia() {
        return correspondencia;
    }

    public void setCorrespondencia(Boolean correspondencia) {
        this.correspondencia = correspondencia;
    }

   
    
    
    
    
    
    
    
    
}
