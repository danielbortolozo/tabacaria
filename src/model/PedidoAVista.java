/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name="pedido_crediario")
public class PedidoAVista implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido idPedido;    
    
    @ManyToOne
    @JoinColumn(name = "id_pedido_pagamento")
    private PedidoPagamento idPedidoPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public PedidoPagamento getIdPedidoPagamento() {
        return idPedidoPagamento;
    }

    public void setIdPedidoPagamento(PedidoPagamento idPedidoPagamento) {
        this.idPedidoPagamento = idPedidoPagamento;
    }
    
    
    
    
    
}
