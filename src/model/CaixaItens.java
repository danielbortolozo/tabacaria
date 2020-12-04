/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author del
 */
@Entity
@Table(name = "caixa_itens")
public class CaixaItens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dt_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtHora;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_entrada")
    private BigDecimal vlEntrada;
    @Column(name = "vl_saida")
    private BigDecimal vlSaida;
    @Column(name = "forma_pagto")
    private String formaPagto;
    @Column(name = "obs")
    private String obs;
    
        
    private String tipo;
    
    @JoinColumn(name = "id_caixa", referencedColumnName = "id")
    @ManyToOne
    private Caixa idCaixa;

    public CaixaItens() {
    }

    public CaixaItens(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtHora() {
        return dtHora;
    }

    public void setDtHora(Date dtHora) {
        this.dtHora = dtHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getVlEntrada() {
        return vlEntrada;
    }

    public void setVlEntrada(BigDecimal vlEntrada) {
        this.vlEntrada = vlEntrada;
    }

    public BigDecimal getVlSaida() {
        return vlSaida;
    }

    public void setVlSaida(BigDecimal vlSaida) {
        this.vlSaida = vlSaida;
    }

    public String getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(String formaPagto) {
        this.formaPagto = formaPagto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

   
    

    public Caixa getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(Caixa idCaixa) {
        this.idCaixa = idCaixa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaixaItens)) {
            return false;
        }
        CaixaItens other = (CaixaItens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CaixaItens[ id=" + id + " ]";
    }
    
}
