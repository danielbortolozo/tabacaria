/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
 * @author del
 */
@Entity
@Table(name = "venda_recebimento")
public class VendaRecebimento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_venda_cab")
    private VendaCab venda;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_tipo_pagamento")
    private TipoPagamento tipoPagamento;
    
    private float juro;
    private float desconto;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_pagto")
    private Date dtPagamento;
    @Temporal(TemporalType.DATE)
    @Column(name = "vencimento")
    private Date dtVencimento;
    
    private float vl_recebido;
    private float vl_total;
    private float vl_subtotal;
    private float vl_troco;
    
    private int parcela;
    private float multa;
    

    public VendaRecebimento() {
    }

    public VendaRecebimento(VendaCab venda, TipoPagamento tipoPagamento, float desconto, Date dtPagamento, Date dtVencimento, float vl_recebido, float vl_total, float vl_subtotal, float vl_troco, int parcela) {
        this.venda = venda;
        this.tipoPagamento = tipoPagamento;
        this.desconto = desconto;
        this.dtPagamento = dtPagamento;
        this.dtVencimento = dtVencimento;
        this.vl_recebido = vl_recebido;
        this.vl_total = vl_total;
        this.vl_subtotal = vl_subtotal;
        this.vl_troco = vl_troco;
        this.parcela = parcela;
    }

    
    
    
    public int getParcela() {
        return parcela;
    }
    public void setParcela(int parcela) {
        this.parcela = parcela;
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

    public float getJuro() {
        return juro;
    }

    public void setJuro(float juro) {
        this.juro = juro;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public float getVl_recebido() {
        return vl_recebido;
    }

    public void setVl_recebido(float vl_recebido) {
        this.vl_recebido = vl_recebido;
    }

    public float getVl_total() {
        return vl_total;
    }

    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
    }

    public float getVl_subtotal() {
        return vl_subtotal;
    }

    public void setVl_subtotal(float vl_subtotal) {
        this.vl_subtotal = vl_subtotal;
    }

    public float getVl_troco() {
        return vl_troco;
    }

    public void setVl_troco(float vl_troco) {
        this.vl_troco = vl_troco;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    
    
    

    @Override
    public String toString() {
        return "VendaRecebimento{" + "id=" + id + ", venda=" + venda + ", tipoPagamento=" + tipoPagamento + ", juro=" + juro + ", desconto=" + desconto + ", dtPagamento=" + dtPagamento + ", dtVencimento=" + dtVencimento + ", vl_recebido=" + vl_recebido + ", vl_total=" + vl_total + ", vl_subtotal=" + vl_subtotal + ", vl_troco=" + vl_troco + ", parcela=" + parcela + ", multa=" + multa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.venda);
        hash = 79 * hash + Objects.hashCode(this.tipoPagamento);
        hash = 79 * hash + Float.floatToIntBits(this.juro);
        hash = 79 * hash + Float.floatToIntBits(this.desconto);
        hash = 79 * hash + Objects.hashCode(this.dtPagamento);
        hash = 79 * hash + Objects.hashCode(this.dtVencimento);
        hash = 79 * hash + Float.floatToIntBits(this.vl_recebido);
        hash = 79 * hash + Float.floatToIntBits(this.vl_total);
        hash = 79 * hash + Float.floatToIntBits(this.vl_subtotal);
        hash = 79 * hash + Float.floatToIntBits(this.vl_troco);
        hash = 79 * hash + this.parcela;
        hash = 79 * hash + Float.floatToIntBits(this.multa);
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
        final VendaRecebimento other = (VendaRecebimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.tipoPagamento, other.tipoPagamento)) {
            return false;
        }
        if (Float.floatToIntBits(this.juro) != Float.floatToIntBits(other.juro)) {
            return false;
        }
        if (Float.floatToIntBits(this.desconto) != Float.floatToIntBits(other.desconto)) {
            return false;
        }
        if (!Objects.equals(this.dtPagamento, other.dtPagamento)) {
            return false;
        }
        if (!Objects.equals(this.dtVencimento, other.dtVencimento)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_recebido) != Float.floatToIntBits(other.vl_recebido)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_total) != Float.floatToIntBits(other.vl_total)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_subtotal) != Float.floatToIntBits(other.vl_subtotal)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_troco) != Float.floatToIntBits(other.vl_troco)) {
            return false;
        }
        if (this.parcela != other.parcela) {
            return false;
        }
        if (Float.floatToIntBits(this.multa) != Float.floatToIntBits(other.multa)) {
            return false;
        }
        return true;
    }
    
    
    

   
    
    
    
}
