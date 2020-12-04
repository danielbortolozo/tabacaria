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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author del
 */
@Entity
@Table (name = "pagamento_cab")
public class PagamentoCab implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id")
    private Pessoa fornecedor; 
    
    private String descricao;
    private String numdoc;
    private int qtd_parcela;
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Temporal(TemporalType.DATE)
    private Date emissao;
    private float vl_total;
    private float subtotal;
    private float desconto;
    private float juro;
    private String status;
    private float saldo_devedor;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private CategoriaConta id_categoria;
    
     
    @OneToMany(mappedBy = "pagamentoCab", cascade = {CascadeType.REMOVE})
    @OrderBy(value="num_parcela")
    private List<PagamentoDet> listaPagamentoDet;
    

    public PagamentoCab() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Pessoa id_fornecedor) {
        this.fornecedor = id_fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public int getQtd_parcela() {
        return qtd_parcela;
    }

    public void setQtd_parcela(int qtd_parcela) {
        this.qtd_parcela = qtd_parcela;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public float getVl_total() {
        return vl_total;
    }

    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
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

    public float getJuro() {
        return juro;
    }

    public void setJuro(float juro) {
        this.juro = juro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PagamentoDet> getListaPagamentoDet() {
        return listaPagamentoDet;
    }

    public void setListaPagamentoDet(List<PagamentoDet> listaPagamentoDet) {
        this.listaPagamentoDet = listaPagamentoDet;
    }

    public float getSaldo_devedor() {
        return saldo_devedor;
    }

    public void setSaldo_devedor(float saldo_devedor) {
        this.saldo_devedor = saldo_devedor;
    }

    public CategoriaConta getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriaConta id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.fornecedor);
        hash = 61 * hash + Objects.hashCode(this.descricao);
        hash = 61 * hash + Objects.hashCode(this.numdoc);
        hash = 61 * hash + this.qtd_parcela;
        hash = 61 * hash + Objects.hashCode(this.vencimento);
        hash = 61 * hash + Objects.hashCode(this.emissao);
        hash = 61 * hash + Float.floatToIntBits(this.vl_total);
        hash = 61 * hash + Float.floatToIntBits(this.subtotal);
        hash = 61 * hash + Float.floatToIntBits(this.desconto);
        hash = 61 * hash + Float.floatToIntBits(this.juro);
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + Float.floatToIntBits(this.saldo_devedor);
        hash = 61 * hash + Objects.hashCode(this.listaPagamentoDet);
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
        final PagamentoCab other = (PagamentoCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.numdoc, other.numdoc)) {
            return false;
        }
        if (this.qtd_parcela != other.qtd_parcela) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.emissao, other.emissao)) {
            return false;
        }
        if (Float.floatToIntBits(this.vl_total) != Float.floatToIntBits(other.vl_total)) {
            return false;
        }
        if (Float.floatToIntBits(this.subtotal) != Float.floatToIntBits(other.subtotal)) {
            return false;
        }
        if (Float.floatToIntBits(this.desconto) != Float.floatToIntBits(other.desconto)) {
            return false;
        }
        if (Float.floatToIntBits(this.juro) != Float.floatToIntBits(other.juro)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo_devedor) != Float.floatToIntBits(other.saldo_devedor)) {
            return false;
        }
        if (!Objects.equals(this.listaPagamentoDet, other.listaPagamentoDet)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PagamentoCab{" + "id=" + id + ", id_fornecedor=" + fornecedor + ", descricao=" + descricao + ", numdoc=" + numdoc + ", qtd_parcela=" + qtd_parcela + ", vencimento=" + vencimento + ", emissao=" + emissao + ", vl_total=" + vl_total + ", subtotal=" + subtotal + ", desconto=" + desconto + ", juro=" + juro + ", status=" + status + ", saldo_devedor=" + saldo_devedor + ", listaPagamentoDet=" + listaPagamentoDet + '}';
    }

    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
}
