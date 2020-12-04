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
import model.PedidoTrocaDevolucao;

/**
 *
 * @author daniel
 */
public class PedidoTrocaDevolucaoDAO {
    
    private EntityManager manager;
     EntityTransaction tx;
    
    public void salvar(PedidoTrocaDevolucao pedidoTroca){
        manager = JPAUtil.getEntityManager();
        tx = manager.getTransaction();
        tx.begin();          
        manager.merge(pedidoTroca);           
        tx.commit();
        manager.close();
    }  
    
    public List<PedidoTrocaDevolucao> listaPedidoTrocaDevol(){
        EntityManager manager = JPAUtil.getEntityManager();
        //EntityTransaction tx = manager.getTransaction();
       // tx.begin();
        List<PedidoTrocaDevolucao> pedidos = manager.createQuery("from PedidoTrocaDevolucao", PedidoTrocaDevolucao.class).getResultList();
        manager.close();
        return pedidos;
    }
    public PedidoTrocaDevolucao pesquisaCPFCliente(String cpf){
        manager = JPAUtil.getEntityManager();
        String jpql = "select p from PedidoTrocaDevolucao p where p.codBarras = :codBarras";
        return this.manager
        .createQuery(jpql, PedidoTrocaDevolucao.class)
        .setParameter("codBarras", cpf)
        .getSingleResult();
    }
    
    
}
