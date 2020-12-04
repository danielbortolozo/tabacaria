/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(length=20)
    private String situacao;
    private BigDecimal limite;
    private BigDecimal credito;
   
    @OneToOne(optional = false)
    private Pessoa pessoa;

 
    //Construtores

    public Cliente() {
    }

    public Cliente(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
  
    
    //Gets e Sets
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
      
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    
    
    
    
    
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        Date oldDataCadastro = this.dataCadastro;
        this.dataCadastro = dataCadastro;
        changeSupport.firePropertyChange("dataCadastro", oldDataCadastro, dataCadastro);
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        String oldSituacao = this.situacao;
        this.situacao = situacao;
        changeSupport.firePropertyChange("situacao", oldSituacao, situacao);
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        BigDecimal oldLimite = this.limite;
        this.limite = limite;
        changeSupport.firePropertyChange("limite", oldLimite, limite);
    }

    
    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 19 * hash + (this.dataCadastro != null ? this.dataCadastro.hashCode() : 0);
        hash = 19 * hash + (this.situacao != null ? this.situacao.hashCode() : 0);
        hash = 19 * hash + (this.limite != null ? this.limite.hashCode() : 0);
        hash = 19 * hash + (this.pessoa != null ? this.pessoa.hashCode() : 0);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.dataCadastro != other.dataCadastro && (this.dataCadastro == null || !this.dataCadastro.equals(other.dataCadastro))) {
            return false;
        }
        if ((this.situacao == null) ? (other.situacao != null) : !this.situacao.equals(other.situacao)) {
            return false;
        }
        if (this.limite != other.limite && (this.limite == null || !this.limite.equals(other.limite))) {
            return false;
        }
        if (this.pessoa != other.pessoa && (this.pessoa == null || !this.pessoa.equals(other.pessoa))) {
            return false;
        }
        return true;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    
    
    
    
    
    
}
