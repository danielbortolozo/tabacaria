/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
@Table(name="pedido_crediario")
public class PedidoCrediario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido idPedido;
    
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    
    private String numParcela;
    
    private BigDecimal vlParcela;
    
   
    
    @ManyToOne
    @JoinColumn(name = "id_pedido_pagamento")
    private PedidoPagamento idPedidoPagamento;
    
    
    private String status;
    

    public PedidoCrediario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(String numParcela) {
        this.numParcela = numParcela;
    }

    public BigDecimal getVlParcela() {
        return vlParcela;
    }

    public void setVlParcela(BigDecimal vlParcela) {
        this.vlParcela = vlParcela;
    }

    public PedidoPagamento getIdPedidoPagamento() {
        return idPedidoPagamento;
    }

    public void setIdPedidoPagamento(PedidoPagamento idPedidoPagamento) {
        this.idPedidoPagamento = idPedidoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  

    
    
    
    
    @Override
    public String toString() {
        return "PedidoCrediario{" + "id=" + id + ", idPedido=" + idPedido + ", dtVencimento=" + dtVencimento + ", numParcela=" + numParcela + ", vlParcela=" + vlParcela + ", idPedidoPagamento=" + idPedidoPagamento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.idPedido);
        hash = 53 * hash + Objects.hashCode(this.dtVencimento);
        hash = 53 * hash + Objects.hashCode(this.numParcela);
        hash = 53 * hash + Objects.hashCode(this.vlParcela);
        hash = 53 * hash + Objects.hashCode(this.idPedidoPagamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoCrediario other = (PedidoCrediario) obj;
        if (!Objects.equals(this.numParcela, other.numParcela)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idPedido, other.idPedido)) {
            return false;
        }
        if (!Objects.equals(this.dtVencimento, other.dtVencimento)) {
            return false;
        }
        if (!Objects.equals(this.vlParcela, other.vlParcela)) {
            return false;
        }
        if (!Objects.equals(this.idPedidoPagamento, other.idPedidoPagamento)) {
            return false;
        }
        return true;
    }
       
}
