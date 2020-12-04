/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "orcamento_det")
public class OrcamentoDet implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_orcamento_cab")
    private OrcamentoCab orcamentoCab;
    
    @ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    private float vl_unitario;
    
    private float vl_total;

    private float quantidade;
    private float desconto;
    
    @Column(name = "tipo_venda")
    private String tipoVenda;
    
    
    public OrcamentoDet() {
    }

   

   public OrcamentoDet(OrcamentoCab orcamentoCab, Produto produto, float vl_unitario, float vl_total, float quantidade, float desconto, String tipoVenda) {
        this.orcamentoCab = orcamentoCab;
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.tipoVenda = tipoVenda;
    }

    public OrcamentoDet(Long id, OrcamentoCab orcamentoCab, Produto produto, float vl_unitario, float vl_total, float quantidade, float desconto, String tipoVenda) {
        this.id = id;
        this.orcamentoCab = orcamentoCab;
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.tipoVenda = tipoVenda;
    }


   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrcamentoCab getOrcamentoCab() {
        return orcamentoCab;
    }

    public void setOrcamentoCab(OrcamentoCab orcamentoCab) {
        this.orcamentoCab = orcamentoCab;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getVl_unitario() {
        return vl_unitario;
    }

    public void setVl_unitario(float vl_unitario) {
        this.vl_unitario = vl_unitario;
    }

    public float getVl_total() {
        return vl_total;
    }

    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    
    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    
    
    
    
    @Override
    public String toString() {
        return "OrcamentoDet{" + "id=" + id + ", orcamentoCab=" + orcamentoCab + ", produto=" + produto + ", vl_unitario=" + vl_unitario + ", vl_total=" + vl_total + ", quantidade=" + quantidade + ", desconto=" + desconto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.orcamentoCab);
        hash = 53 * hash + Objects.hashCode(this.produto);
        hash = 53 * hash + Float.floatToIntBits(this.vl_unitario);
        hash = 53 * hash + Float.floatToIntBits(this.vl_total);
        hash = 53 * hash + Float.floatToIntBits(this.quantidade);
        hash = 53 * hash + Float.floatToIntBits(this.desconto);
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
        final OrcamentoDet other = (OrcamentoDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.orcamentoCab, other.orcamentoCab)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_unitario) != Float.floatToIntBits(other.vl_unitario)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_total) != Float.floatToIntBits(other.vl_total)) {
            return false;
        }
        if (Float.floatToIntBits(this.quantidade) != Float.floatToIntBits(other.quantidade)) {
            return false;
        }
        if (Float.floatToIntBits(this.desconto) != Float.floatToIntBits(other.desconto)) {
            return false;
        }
        return true;
    }
    
   

    
    
    
    
    
    
    
    
    
    
    
}
