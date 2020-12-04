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

/**
 *
 * @author del
 */
@Entity
@Table(name = "venda_cab")
public class VendaCab implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@Column(name = "id_colaborador")
    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Pessoa colaborador;
    
    //@Column(name = "id_cliente")
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Pessoa cliente;
    
    @Column(name = "tipo_venda")
    private String tipoVenda;
    
    private Date vencimento;
    
    private float subtotal;
    private float total;
    private float desconto;
    private String status;
    private int parcelas;
    
    @OneToMany(mappedBy = "venda")
    private List<VendaDet> listaItens;
    
    @OneToMany(mappedBy = "venda", cascade = {CascadeType.REMOVE})
    private List<VendaRecebimento> listaRecebimento;
    

    private Date dt_cad;
    
    
    
    
    public VendaCab() {
    }

       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getColaborador() {
        return colaborador;
    }

    public void setColaborador(Pessoa colaborador) {
        this.colaborador = colaborador;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

   

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<VendaDet> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<VendaDet> listaItens) {
        this.listaItens = listaItens;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public List<VendaRecebimento> getListaRecebimento() {
        return listaRecebimento;
    }

    public void setListaRecebimento(List<VendaRecebimento> listaRecebimento) {
        this.listaRecebimento = listaRecebimento;
    }

    public Date getDt_cad() {
        return dt_cad;
    }

    public void setDt_cad(Date dt_cad) {
        this.dt_cad = dt_cad;
    }

    
    
    
    
    @Override
    public String toString() {
        return "VendaCab{" + "id=" + id + ", colaborador=" + colaborador + ", cliente=" + cliente + ", tipoVenda=" + tipoVenda + ", vencimento=" + vencimento + ", subtotal=" + subtotal + ", total=" + total + ", desconto=" + desconto + ", status=" + status + ", parcelas=" + parcelas + ", listaItens=" + listaItens + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.colaborador);
        hash = 59 * hash + Objects.hashCode(this.cliente);
        hash = 59 * hash + Objects.hashCode(this.tipoVenda);
        hash = 59 * hash + Objects.hashCode(this.vencimento);
        hash = 59 * hash + Float.floatToIntBits(this.subtotal);
        hash = 59 * hash + Float.floatToIntBits(this.total);
        hash = 59 * hash + Float.floatToIntBits(this.desconto);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + this.parcelas;
        hash = 59 * hash + Objects.hashCode(this.listaItens);
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
        final VendaCab other = (VendaCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.colaborador, other.colaborador)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.tipoVenda, other.tipoVenda)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (Float.floatToIntBits(this.subtotal) != Float.floatToIntBits(other.subtotal)) {
            return false;
        }
        if (Float.floatToIntBits(this.total) != Float.floatToIntBits(other.total)) {
            return false;
        }
        if (Float.floatToIntBits(this.desconto) != Float.floatToIntBits(other.desconto)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (this.parcelas != other.parcelas) {
            return false;
        }
        if (!Objects.equals(this.listaItens, other.listaItens)) {
            return false;
        }
        return true;
    }
    
    
    
    
    

   

   
    
    
}
