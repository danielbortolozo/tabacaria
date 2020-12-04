/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author daniel
 */
@Entity
@Table(name="pessoa_contato")
public class PessoaContato {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    
    @Column(length = 100)
    private String descricao;
    
    private String ddd;
    private String numero;

     public PessoaContato(String descricao, String ddd, String numero) {        
        this.descricao = descricao;
        this.ddd = ddd;
        this.numero = numero;        
    }

    public PessoaContato(Long id, String descricao, String ddd, String numero) {
        this.id = id;       
        this.descricao = descricao;
        this.ddd = ddd;
        this.numero = numero;
        
    }
    

    public PessoaContato() {
       
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.pessoa != null ? this.pessoa.hashCode() : 0);
        hash = 67 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 67 * hash + (this.ddd != null ? this.ddd.hashCode() : 0);
        hash = 67 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaContato other = (PessoaContato) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.pessoa != other.pessoa && (this.pessoa == null || !this.pessoa.equals(other.pessoa))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if ((this.ddd == null) ? (other.ddd != null) : !this.ddd.equals(other.ddd)) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
