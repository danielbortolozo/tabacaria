/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.CompraDet;

/**
 *
 * @author daniel
 */
public class CompraDetDAO {
    
    
    public void salvar(CompraDet compraDet){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
                
        manager.persist(compraDet);
        
        tx.commit();
        
        manager.close();      
    }
    
    
//    public List<CompraDet>  listCompraDet(){
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        List<> cli = manager.createQuery("from Cliente", Cliente.class).getResultList();
//        manager.close();
//        return cli;
//        
//    }
    
    
    
}
