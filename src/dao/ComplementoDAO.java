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
import model.Complemento;

/**
 *
 * @author del
 */
public class ComplementoDAO {
    
    public void salvar(Complemento b){        
       EntityManager manager = JPAUtil.getEntityManager();       
       EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.merge(b);
        
        tx.commit();
        manager.close();
    }
    
    
    
    public Complemento complementoID(int id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        Complemento complemento = manager.find(Complemento.class, id);
        manager.close();
        return complemento;        
    }  
    
//    public void salvar(Complemento b){        
//       EntityManager manager = JPAUtil.getEntityManager();       
//       EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        manager.persist(b);
//        
//        tx.commit();
//        manager.close();
//    }
//    
    
    
    public List<Complemento>  getLista(){
        EntityManager manager = JPAUtil.getEntityManager();
      //  EntityTransaction tx = manager.getTransaction();
       // tx.begin();
        List<Complemento> b;
        try{
            b = manager.createQuery("from Complemento b order by b.descricao", Complemento.class).getResultList();
        }finally{   
                manager.close();
        }
        return b;        
    }
    
    public void excluir(int id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        Complemento b = manager.find(Complemento.class, id);
        
        manager.remove(b);
        
        tx.commit();
        manager.close();
    } 
    
    
    
    
    
}
