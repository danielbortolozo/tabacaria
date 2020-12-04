/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name="unidade_produto")
public class UnidadeProduto implements Serializable{
    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 10)
    private String sigla;

    @Column(length = 60)
    private String descricao;

    public UnidadeProduto() {
    }

    public UnidadeProduto(Long id, String sigla, String descricao) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
    
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        String oldSigla = this.sigla;
        this.sigla = sigla;
    
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
       
    }

    @Override
    public String toString() {
        return "UnidadeProduto{" + "changeSupport=" + changeSupport + ", id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.sigla != null ? this.sigla.hashCode() : 0);
        hash = 59 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
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
        final UnidadeProduto other = (UnidadeProduto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.sigla == null) ? (other.sigla != null) : !this.sigla.equals(other.sigla)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
    
}
