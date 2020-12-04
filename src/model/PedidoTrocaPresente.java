/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
public class PedidoTrocaPresente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="nome_consumidor")
    private String nomeConsumidor;
    @Column(name="cpf_consumidor")
    private String cpf;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Pessoa cliente;
    
    private BigDecimal vl_devolucao;
    
    private BigDecimal vl_troca;
    
    private BigDecimal credito;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_cad;
    
    
    @OneToMany(mappedBy = "pedidoTrocaPresente", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<PedidoTrocaPresenteItens> listaTrocaPresenteItens;
      
    
    private String status;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeConsumidor() {
        return nomeConsumidor;
    }

    public void setNomeConsumidor(String nomeConsumidor) {
        this.nomeConsumidor = nomeConsumidor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getVl_devolucao() {
        return vl_devolucao;
    }

    public void setVl_devolucao(BigDecimal vl_devolucao) {
        this.vl_devolucao = vl_devolucao;
    }

    public BigDecimal getVl_troca() {
        return vl_troca;
    }

    public void setVl_troca(BigDecimal vl_troca) {
        this.vl_troca = vl_troca;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public Date getDt_cad() {
        return dt_cad;
    }

    public void setDt_cad(Date dt_cad) {
        this.dt_cad = dt_cad;
    }

    public List<PedidoTrocaPresenteItens> getListaTrocaPresenteItens() {
        return listaTrocaPresenteItens;
    }

    public void setListaTrocaPresenteItens(List<PedidoTrocaPresenteItens> listaTrocaPresenteItens) {
        this.listaTrocaPresenteItens = listaTrocaPresenteItens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof PedidoTrocaPresente)) {
            return false;
        }
        PedidoTrocaPresente other = (PedidoTrocaPresente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PedidoTrocaPresente[ id=" + id + " ]";
    }
    
}
