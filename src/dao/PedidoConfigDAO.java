/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.PedidoConfig;

/**
 *
 * @author daniel
 */
public class PedidoConfigDAO {
    
    
     public void salvar(PedidoConfig p){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();          
        manager.merge(p);           
        tx.commit();
        manager.close();
    }  
    
    public PedidoConfig configuracao(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        PedidoConfig p = manager.find(PedidoConfig.class, id);
        manager.close();
        return p;        
    }   
    
}
