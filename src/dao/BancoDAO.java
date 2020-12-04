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
import model.Banco;

/**
 *
 * @author daniel
 */
public class BancoDAO {
    
    public void salvar(Banco banco){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(banco);
        
        tx.commit();
        manager.close();
               
    }
    
    public void excluir(Banco banco){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        Banco b = manager.find(Banco.class, banco.getId());
        
        manager.remove(b);
        
        tx.commit();
        manager.close();
    }
    
    
    public List<Banco> listBanco(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Banco> listBanco = manager.createQuery("from Banco order by descricao", Banco.class).getResultList();
        manager.close();
        return listBanco;
    }
    
    public void alterar(Banco banco){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
      //  System.out.println("Codigo cep ="+cep.getId());
        Banco b = manager.find(Banco.class, banco.getId());
        
        b.setDescricao(banco.getDescricao());
        
        tx.commit();
        manager.close();
    }
    
     public Banco banco(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
       //   EntityTransaction tx = manager.getTransaction();
      //  tx.begin();
        
        Banco bc = manager.find(Banco.class, id);
        
        manager.close();
        return bc;            
    }
    
    
}
