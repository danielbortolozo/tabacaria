/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "pedido_itens")

public class PedidoItens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
   
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_unit")
    private BigDecimal vlUnit;
    @Column(name = "vl_subtotal")
    private BigDecimal vlSubtotal;
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    
    @Column(name = "vl_custo")
    private BigDecimal vl_custo;
    
    @Column(name = "vl_lucro")
    private BigDecimal vlLucro;
    
    @ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "tipo_venda")
    private String tipoVenda;
    
    private String status;

    public PedidoItens() {
    }

    public PedidoItens(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    } 

    public BigDecimal getVlUnit() {
        return vlUnit;
    }

    public void setVlUnit(BigDecimal vlUnit) {
        this.vlUnit = vlUnit;
    }

    public BigDecimal getVlSubtotal() {
        return vlSubtotal;
    }

    public void setVlSubtotal(BigDecimal vlSubtotal) {
        this.vlSubtotal = vlSubtotal;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }  

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getVl_custo() {
        return vl_custo;
    }

    public void setVl_custo(BigDecimal vl_custo) {
        this.vl_custo = vl_custo;
    }

    public BigDecimal getVlLucro() {
        return vlLucro;
    }

    public void setVlLucro(BigDecimal vlLucro) {
        this.vlLucro = vlLucro;
    }
    
        
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.pedido);
        hash = 71 * hash + Objects.hashCode(this.vlUnit);
        hash = 71 * hash + Objects.hashCode(this.vlSubtotal);
        hash = 71 * hash + Objects.hashCode(this.quantidade);
        hash = 71 * hash + Objects.hashCode(this.produto);
        hash = 71 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoItens other = (PedidoItens) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.vlUnit, other.vlUnit)) {
            return false;
        }
        if (!Objects.equals(this.vlSubtotal, other.vlSubtotal)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidoItens{" + "id=" + id + ", pedido=" + pedido + ", vlUnit=" + vlUnit + ", vlSubtotal=" + vlSubtotal + ", quantidade=" + quantidade + ", produto=" + produto + ", descricao=" + descricao + '}';
    }

   

   
   
    
}
