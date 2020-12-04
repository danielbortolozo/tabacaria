
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author daniel
 */
@Entity
public class PedidoTrocaPresenteItens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @ManyToOne
    @JoinColumn(name = "id_pedido_troca_presente")
    private PedidoTrocaPresente pedidoTrocaPresente;
        
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    private String status;
    
    private BigDecimal qtd;
    
    private BigDecimal vlUnit;
    
    private BigDecimal vltotal;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoTrocaPresente getPedidoTrocaPresente() {
        return pedidoTrocaPresente;
    }

    public void setPedidoTrocaPresente(PedidoTrocaPresente pedidoTrocaPresente) {
        this.pedidoTrocaPresente = pedidoTrocaPresente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getVlUnit() {
        return vlUnit;
    }

    public void setVlUnit(BigDecimal vlUnit) {
        this.vlUnit = vlUnit;
    }

    public BigDecimal getVltotal() {
        return vltotal;
    }

    public void setVltotal(BigDecimal vltotal) {
        this.vltotal = vltotal;
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
        if (!(object instanceof PedidoTrocaPresenteItens)) {
            return false;
        }
        PedidoTrocaPresenteItens other = (PedidoTrocaPresenteItens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PedidoTrocaPresenteItens[ id=" + id + " ]";
    }
    
}
