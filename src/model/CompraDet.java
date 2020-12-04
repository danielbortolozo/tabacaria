/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "compra_det")
public class CompraDet {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_compra_cab", referencedColumnName = "id")
    private CompraCab compra_cab;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;
    
    @Column(name = "vl_unit")
    private float vl_unitario;
    private float vl_total;
    private float quantidade;
    private float desconto;

    public CompraDet() {
    }

    public CompraDet(Produto produto, float vl_unitario, float vl_total, float quantidade, float desconto) {
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public CompraDet(Long id, Produto produto, float vl_unitario, float vl_total, float quantidade, float desconto) {
        this.id = id;
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    
    
    
    public CompraDet(Long id, CompraCab compra_cab, Produto produto, float vl_unitario, float vl_total, float quantidade, float desconto) {
        this.id = id;
        this.compra_cab = compra_cab;
        this.produto = produto;
        this.vl_unitario = vl_unitario;
        this.vl_total = vl_total;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompraCab getCompra_cab() {
        return compra_cab;
    }

    public void setCompra_cab(CompraCab compra_cab) {
        this.compra_cab = compra_cab;
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
        return "CompraDet{" + "id=" + id + ", compra_cab=" + compra_cab + ", produto=" + produto + ", vl_unitario=" + vl_unitario + ", vl_total=" + vl_total + ", quantidade=" + quantidade + ", desconto=" + desconto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.compra_cab);
        hash = 17 * hash + Objects.hashCode(this.produto);
        hash = 17 * hash + Float.floatToIntBits(this.vl_unitario);
        hash = 17 * hash + Float.floatToIntBits(this.vl_total);
        hash = 17 * hash + Float.floatToIntBits(this.quantidade);
        hash = 17 * hash + Float.floatToIntBits(this.desconto);
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
        final CompraDet other = (CompraDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.compra_cab, other.compra_cab)) {
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
