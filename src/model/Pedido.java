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
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id")
    private Integer id;
    
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")    
    private Pessoa cliente;
   
    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Pessoa colaborador;
    
    @ManyToOne
    @JoinColumn(name = "id_entregador")
    private Pessoa entregador;
    
    @Column(name = "dt_cad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCad;
    //Se é do tipo Balcao, Delivery ou Mesa
    @Column(name = "tipo_pedido")
    private String tipoPedido;
    
    @Column(name = "status")
    private String status;
    private String observacao;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_pedido_entrega")
    private PedidoEntrega pedidoEntrega;

    
    //Se a venda é do tipo, A vista, Crediario ou Fiado.
    @Column(name = "tipo_venda")
    private String tipoVenda;
    
    
    
    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<PedidoItens> listaItens;
    
    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<PedidoPagamento> listaPagamento;
    
    @OneToMany(mappedBy = "idPedido", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<PedidoCrediario> listaCrediario;
    
    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    } 

    public Date getDtCad() {
        return dtCad;
    }

    public void setDtCad(Date dtCad) {
        this.dtCad = dtCad;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public List<PedidoItens> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<PedidoItens> listaItens) {
        this.listaItens = listaItens;
    }

//    public PedidoPagamento getPedidoPagamento() {
//        return pedidoPagamento;
//    }

    public Pessoa getEntregador() {
        return entregador;
    }

    public void setEntregador(Pessoa entregador) {
        this.entregador = entregador;
    }

    public PedidoEntrega getPedidoEntrega() {
        return pedidoEntrega;
    }

    public void setPedidoEntrega(PedidoEntrega pedidoEntrega) {
        this.pedidoEntrega = pedidoEntrega;
    }

    public List<PedidoCrediario> getListaCrediario() {
        return listaCrediario;
    }

    public void setListaCrediario(List<PedidoCrediario> listaCrediario) {
        this.listaCrediario = listaCrediario;
    }

    public List<PedidoPagamento> getListaPagamento() {
        return listaPagamento;
    }

    public void setListaPagamento(List<PedidoPagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

   

      
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.cliente);
        hash = 53 * hash + Objects.hashCode(this.colaborador);
        hash = 53 * hash + Objects.hashCode(this.dtCad);
        hash = 53 * hash + Objects.hashCode(this.tipoPedido);
        hash = 53 * hash + Objects.hashCode(this.status);
        hash = 53 * hash + Objects.hashCode(this.observacao);
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.tipoPedido, other.tipoPedido)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.colaborador, other.colaborador)) {
            return false;
        }
        if (!Objects.equals(this.dtCad, other.dtCad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", colaborador=" + colaborador + ", dtCad=" + dtCad + ", tipoPedido=" + tipoPedido + ", status=" + status + ", observacao=" + observacao + '}';
    }

    
   

   
    
  

   
}
