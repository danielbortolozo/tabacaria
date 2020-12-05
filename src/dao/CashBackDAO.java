/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.CashBack;

/**
 *
 * @author daniel
 */
public class CashBackDAO {
    
    
     public void salvar(CashBack cash){
         EntityManager manager = JPAUtil.getEntityManager();
         EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(cash);
        
        tx.commit();
        manager.close();
               
    }
    
    public void excluir(CashBack cash){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        CashBack b = manager.find(CashBack.class, cash.getId());
        
        manager.remove(b);
        
        tx.commit();
        manager.close();
    }
    public void alterar(CashBack cash){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
      //  System.out.println("Codigo cep ="+cep.getId());
        CashBack b = manager.find(CashBack.class, cash.getId());
        
        b.setAtivo(cash.isAtivo());
        b.setValorCompra(cash.getValorCompra());
        b.setPontos(cash.getPontos());
        
        tx.commit();
        manager.close();
    }
    
    public CashBack cashBack(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
       //   EntityTransaction tx = manager.getTransaction();
      //  tx.begin();
        
        CashBack cb = manager.find(CashBack.class, id);
        
        manager.close();
        return cb;            
    }
    
    
    
}
