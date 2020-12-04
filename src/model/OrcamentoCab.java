/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
 * @author daniel
 */
@Entity
@Table(name = "orcamento_cab")
public class OrcamentoCab implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Pessoa cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Pessoa colaborador;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_orc;
    
    private float vl_total;
    private String status;
    private float subtotal;
    private float desconto;
    @OneToMany(mappedBy = "orcamentoCab", cascade = {CascadeType.REMOVE})
    private List<OrcamentoDet> listOrcamentoDet;
    
    
    
    
    
    private String obs;
    
    
    
    
    

    public OrcamentoCab() {
    }

    
    
    
   

    public OrcamentoCab(Pessoa cliente, Pessoa colaborador, Date data_orc, float vl_total, String status, float subtotal, float desconto, List<OrcamentoDet> listOrcamentoDet) {
        this.cliente = cliente;
        this.colaborador = colaborador;
        this.data_orc = data_orc;
        this.vl_total = vl_total;
        this.status = status;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.listOrcamentoDet = listOrcamentoDet;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Pessoa getColaborador() {
        return colaborador;
    }

    public void setColaborador(Pessoa colaborador) {
        this.colaborador = colaborador;
    }

    public Date getData_orc() {
        return data_orc;
    }

    public void setData_orc(Date data_orc) {
        this.data_orc = data_orc;
    }

    public float getVl_total() {
        return vl_total;
    }

    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
    }

    public String getStatus() {
        return status;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public List<OrcamentoDet> getListOrcamentoDet() {
        return listOrcamentoDet;
    }

    public void setListOrcamentoDet(List<OrcamentoDet> listOrcamentoDet) {
        this.listOrcamentoDet = listOrcamentoDet;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    
    
    
    
    
    
    @Override
    public String toString() {
        return "OrcamentoCab{" + "id=" + id + ", cliente=" + cliente + ", colaborador=" + colaborador + ", data_orc=" + data_orc + ", vl_orc=" + vl_total + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.cliente);
        hash = 43 * hash + Objects.hashCode(this.colaborador);
        hash = 43 * hash + Objects.hashCode(this.data_orc);
        hash = 43 * hash + Float.floatToIntBits(this.vl_total);
        hash = 43 * hash + Objects.hashCode(this.status);
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
        final OrcamentoCab other = (OrcamentoCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.colaborador, other.colaborador)) {
            return false;
        }
        if (!Objects.equals(this.data_orc, other.data_orc)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_total) != Float.floatToIntBits(other.vl_total)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
    
    
}
