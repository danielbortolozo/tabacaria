/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import model.PedidoPagamento;
import model.PedidoPagamentoItens;

/**
 *
 * @author daniel
 */
public class PedidoPagamentoDAO {
    
    
    public PedidoPagamento salvar(PedidoPagamento p){
        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(p);
            
            for (PedidoPagamentoItens itens : p.getListaPagamentoItens()) {
                System.out.println("data itens pagamento ="+itens.getDtPagamento());
                itens.setPedidoPagamento(p);
                manager.persist(itens);
            }
            tx.commit();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Gravar Pedido. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
        return p;
        
    }
    
     public PedidoPagamento alterar(PedidoPagamento p){
        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.merge(p);
            
            for (PedidoPagamentoItens itens : p.getListaPagamentoItens()) {
                itens.setPedidoPagamento(p);
                manager.merge(itens);
            }
            tx.commit();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Alterar Pedido. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
        return p;
        
    }
    
    
    
     public List<PedidoPagamento> listaPedidoPagamentoAberto(){
        EntityManager manager = JPAUtil.getEntityManager();        
        List<PedidoPagamento> pedidos = manager.createQuery("from PedidoPagamento where status = 'ABERTO' order by dtCad", PedidoPagamento.class).getResultList();
        manager.close();
        return pedidos;
    }
    
    public PedidoPagamento pedidoPagamentoID(int id){        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        PedidoPagamento pedido = manager.find(PedidoPagamento.class, id);
        
        manager.close();
        if (pedido == null)
            return null;
        else
            return pedido;            
    }
       
    
    
    
    
    
}
