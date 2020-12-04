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

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@Table(name = "banco_movimento")
public class BancoMovimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_entrada")
    private BigDecimal vlEntrada;
    @Column(name = "vl_saida")
    private BigDecimal vlSaida;
    @Column(name = "saldo")
    private BigDecimal saldo;
    
    @Column(name = "obs")
    private String obs;
    
    @JoinColumn(name = "id_banco", referencedColumnName = "id")
    @ManyToOne
    private Banco idBanco;

    
    @Column(name = "dt_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dtLancamento;
    
    public BancoMovimento() {
    }

    public BancoMovimento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
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
        if (!(object instanceof BancoMovimento)) {
            return false;
        }
        BancoMovimento other = (BancoMovimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BancoMovimento[ id=" + id + " ]";
    }
    
}
