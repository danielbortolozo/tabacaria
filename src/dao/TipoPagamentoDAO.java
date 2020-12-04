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
import javax.persistence.Query;
import model.TipoPagamento;

/**
 *
 * @author daniel
 */
public class TipoPagamentoDAO {
    
    
    public void salvar(TipoPagamento tipopag){
        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(tipopag);
        
        tx.commit();
        manager.close();
                
    }
    
     public void excluir(TipoPagamento tipopag){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        TipoPagamento tippg = manager.find(TipoPagamento.class, tipopag.getId());
        
        manager.remove(tippg);
        
        tx.commit();
        manager.close();
    }
    
     
    public List<TipoPagamento> listTipoPag(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<TipoPagamento> listTipoPag = manager.createQuery("from TipoPagamento order by descricao", TipoPagamento.class).getResultList();
        manager.close();
        return listTipoPag;
    }
 
    
    public void alterar(TipoPagamento tipopag){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
      //  System.out.println("Codigo cep ="+cep.getId());
        TipoPagamento tppg = manager.find(TipoPagamento.class, tipopag.getId());
        
        tppg.setDescricao(tipopag.getDescricao());
        
        tx.commit();
        manager.close();
    }
    
     public TipoPagamento tipoPagamento(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
       //   EntityTransaction tx = manager.getTransaction();
      //  tx.begin();
        
        TipoPagamento tp = manager.find(TipoPagamento.class, id);
        
        manager.close();
        return tp;            
    }
    
     
    public TipoPagamento getPagamentoDescricaoNenhum(){
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery(
                        "from TipoPagamento where descricao = 'NENHUM' ");
          //query.setParameter("Usuario", descricao);
           
        return (TipoPagamento) query.getSingleResult();
        
    } 
     
     
    
}
