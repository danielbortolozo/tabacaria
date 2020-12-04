/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

import java.util.Objects;
import javax.persistence.CascadeType;

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
 * @author del
 */
@Entity
@Table(name = "venda_det")
public class VendaDet implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_venda_cab")
    private VendaCab venda;
    
    @ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    private float vl_unitario;
    
    private float vl_total;

    private float quantidade;
    private float desconto;

    public VendaDet() {
    }

    public VendaDet(VendaCab venda, Produto produto, float vl_unitario, float vl_total, float quantidade) {
        
        this.venda = venda;
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
    }

    public VendaDet(Long id, VendaCab venda, Produto produto, float vl_unitario, float vl_total, float quantidade) {
        this.id = id;
        this.venda = venda;
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
    }
   
    public VendaDet(VendaCab venda, Produto produto, float vl_unitario, float vl_total, float quantidade, float desconto) {
        
        this.venda = venda;
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public VendaDet(Produto produto, float quantidade, float vl_total) {
        this.produto = produto;
        
        this.quantidade = quantidade;
        this.vl_total = vl_total;
    }
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VendaCab getVenda() {
        return venda;
    }

    public void setVenda(VendaCab venda) {
        this.venda = venda;
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

    
    
    
    @Override
    public String toString() {
        return "VendaDet{" + "id=" + id + ", venda=" + venda + ", produto=" + produto + ", vl_unitario=" + vl_unitario + ", vl_total=" + vl_total + ", quantidade=" + quantidade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.venda);
        hash = 37 * hash + Objects.hashCode(this.produto);
        hash = 37 * hash + Float.floatToIntBits(this.vl_unitario);
        hash = 37 * hash + Float.floatToIntBits(this.vl_total);
        hash = 37 * hash + Float.floatToIntBits(this.quantidade);
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
        final VendaDet other = (VendaDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
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
        return true;
    }
    
    
    
    
    
    
    
    
}
