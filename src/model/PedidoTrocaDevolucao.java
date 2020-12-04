/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
public class PedidoTrocaDevolucao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    private BigDecimal vldevolucao;
    private BigDecimal vltroca;    
    private BigDecimal vlcredito;
    
    private String utilizouCredito;  
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCad;
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getVldevolucao() {
        return vldevolucao;
    }

    public void setVldevolucao(BigDecimal vldevolucao) {
        this.vldevolucao = vldevolucao;
    }

    public BigDecimal getVltroca() {
        return vltroca;
    }

    public void setVltroca(BigDecimal vltroca) {
        this.vltroca = vltroca;
    }

    public BigDecimal getVlcredito() {
        return vlcredito;
    }

    public void setVlcredito(BigDecimal vlcredito) {
        this.vlcredito = vlcredito;
    }

    public String getUtilizouCredito() {
        return utilizouCredito;
    }

    public void setUtilizouCredito(String utilizouCredito) {
        this.utilizouCredito = utilizouCredito;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
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
        if (!(object instanceof PedidoTrocaDevolucao)) {
            return false;
        }
        PedidoTrocaDevolucao other = (PedidoTrocaDevolucao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PedidoTrocaDevolucao[ id=" + id + " ]";
    }
    
}
