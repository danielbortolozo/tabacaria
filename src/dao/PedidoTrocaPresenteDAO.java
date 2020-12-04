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
import model.PedidoTrocaPresente;
import model.PedidoTrocaPresenteItens;

/**
 *
 * @author daniel
 */
public class PedidoTrocaPresenteDAO {
    private EntityManager manager;
     EntityTransaction tx;
    
    public void salvar(PedidoTrocaPresente pedidoTroca){
        manager = JPAUtil.getEntityManager();
        tx = manager.getTransaction();
        tx.begin();          
        manager.persist(pedidoTroca);           
        for (PedidoTrocaPresenteItens itens : pedidoTroca.getListaTrocaPresenteItens()){
            itens.setPedidoTrocaPresente(pedidoTroca);
            manager.merge(itens);
        }
        tx.commit();
        manager.close();
    } 
    
    public void alterar(PedidoTrocaPresente pedidoTroca){
        manager = JPAUtil.getEntityManager();
        tx = manager.getTransaction();
        tx.begin();          
        manager.merge(pedidoTroca);           
        for (PedidoTrocaPresenteItens itens : pedidoTroca.getListaTrocaPresenteItens()){
            itens.setPedidoTrocaPresente(pedidoTroca);
            manager.merge(itens);
        }
        manager.flush();
        tx.commit();
        manager.close();

    }
    
    public List<PedidoTrocaPresente> listaPedidoTrocaPresente(){
        EntityManager manager = JPAUtil.getEntityManager();
        List<PedidoTrocaPresente> pedidos = manager.createQuery("from PedidoTrocaPresente where status = 'ABERTO'", PedidoTrocaPresente.class).getResultList();
        manager.close();
        return pedidos;
    }
    
    
    
    
    
    public void excluir(PedidoTrocaPresente ptp){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        PedidoTrocaPresente p = manager.find(PedidoTrocaPresente.class, ptp.getId());
        
        manager.remove(p);
        
        tx.commit();
        manager.close();
    }
    
}
