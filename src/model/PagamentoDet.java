/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table (name = "pagamento_det")
public class PagamentoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pagamento_cab")
    private PagamentoCab pagamentoCab;
    
 
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_pagamento")
    private TipoPagamento tipo_pagamento;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_banco")
    private Banco banco;
    
    private float desconto;
    private float juro;
    private float multa;
    private float vl_parcela;
    private float vl_pago;
    private int num_parcela;
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Temporal(TemporalType.DATE)
    private Date dt_pagamento;

    public PagamentoDet() {
    }  

    public PagamentoDet(TipoPagamento tipo_pagamento, Banco banco, float desconto, float juro, float multa, float vl_parcela, float vl_pago, int num_parcela, Date vencimento, Date dt_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
        this.banco = banco;
        this.desconto = desconto;
        this.juro = juro;
        this.multa = multa;
        this.vl_parcela = vl_parcela;
        this.vl_pago = vl_pago;
        this.num_parcela = num_parcela;
        this.vencimento = vencimento;
        this.dt_pagamento = dt_pagamento;
    }

   
    
    
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public PagamentoCab getPagamentoCab() {
        return pagamentoCab;
    }

    public void setPagamentoCab(PagamentoCab pagamentoCab) {
        this.pagamentoCab = pagamentoCab;
    }

    public TipoPagamento getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(TipoPagamento tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

   



    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getJuro() {
        return juro;
    }

    public void setJuro(float juro) {
        this.juro = juro;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public float getVl_parcela() {
        return vl_parcela;
    }

    public void setVl_parcela(float vl_parcela) {
        this.vl_parcela = vl_parcela;
    }

    public float getVl_pago() {
        return vl_pago;
    }

    public void setVl_pago(float vl_pago) {
        this.vl_pago = vl_pago;
    }

    public int getNum_parcela() {
        return num_parcela;
    }

    public void setNum_parcela(int num_parcela) {
        this.num_parcela = num_parcela;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getDt_pagamento() {
        return dt_pagamento;
    }

    public void setDt_pagamento(Date dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.pagamentoCab);
        hash = 29 * hash + Objects.hashCode(this.tipo_pagamento);
        hash = 29 * hash + Objects.hashCode(this.banco);
        hash = 29 * hash + Float.floatToIntBits(this.desconto);
        hash = 29 * hash + Float.floatToIntBits(this.juro);
        hash = 29 * hash + Float.floatToIntBits(this.multa);
        hash = 29 * hash + Float.floatToIntBits(this.vl_parcela);
        hash = 29 * hash + Float.floatToIntBits(this.vl_pago);
        hash = 29 * hash + this.num_parcela;
        hash = 29 * hash + Objects.hashCode(this.vencimento);
        hash = 29 * hash + Objects.hashCode(this.dt_pagamento);
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
        final PagamentoDet other = (PagamentoDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pagamentoCab, other.pagamentoCab)) {
            return false;
        }
        if (!Objects.equals(this.tipo_pagamento, other.tipo_pagamento)) {
            return false;
        }
        if (!Objects.equals(this.banco, other.banco)) {
            return false;
        }
        if (Float.floatToIntBits(this.desconto) != Float.floatToIntBits(other.desconto)) {
            return false;
        }
        if (Float.floatToIntBits(this.juro) != Float.floatToIntBits(other.juro)) {
            return false;
        }
        if (Float.floatToIntBits(this.multa) != Float.floatToIntBits(other.multa)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_parcela) != Float.floatToIntBits(other.vl_parcela)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_pago) != Float.floatToIntBits(other.vl_pago)) {
            return false;
        }
        if (this.num_parcela != other.num_parcela) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.dt_pagamento, other.dt_pagamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PagamentoDet{" + "id=" + id + ", pagamentoCab=" + pagamentoCab + ", tipo_pagamento=" + tipo_pagamento + ", banco=" + banco + ", desconto=" + desconto + ", juro=" + juro + ", multa=" + multa + ", vl_parcela=" + vl_parcela + ", vl_pago=" + vl_pago + ", num_parcela=" + num_parcela + ", vencimento=" + vencimento + ", dt_pagamento=" + dt_pagamento + '}';
    }

  
    
    
    
  
}
