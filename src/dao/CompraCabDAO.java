/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.CompraCab;
import model.CompraDet;

/**
 *
 * @author daniel
 */
public class CompraCabDAO implements Serializable {
    EntityManager manager;
    
    
    public void salvar(CompraCab compra){
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();             
        manager.persist(compra);       
        
        if (compra.getListaCompraDet() != null){
           for (CompraDet compraDet: compra.getListaCompraDet()){
               compraDet.setCompra_cab(compra);
               manager.persist(compraDet);
           }
        }       
        tx.commit();
        manager.close();
    }
     public void alterar(CompraCab compra){
        EntityManager m = JPAUtil.getEntityManager();
        //manager = JPAUtil.getEntityManager();
        EntityTransaction tx = m.getTransaction();
        tx.begin();    
        
        m.merge(compra);       
//        int i =0;
       // tx.commit();
        if (compra.getListaCompraDet() != null){
           for (CompraDet compraDet: compra.getListaCompraDet()){              
               //compraDet.setCompra_cab(compra);  
               
               m.merge(compraDet);
             
           }
        }       
        
        tx.commit();
        
        m.close();
    } 
    public List<CompraCab> listaCompraCab(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<CompraCab> compracab = manager.createQuery("from CompraCab", CompraCab.class).getResultList();
        manager.close();
        return compracab;
    }   
    public CompraCab compraCab(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        CompraCab compraCab = manager.find(CompraCab.class, id);
        
        manager.close();
        return compraCab;            
    }
    
    public void excluirPagamento(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        CompraCab compraCab = manager.find(CompraCab.class, id);        
        manager.remove(compraCab);       
        tx.commit();
        manager.close();
    }
    public List<CompraCab> listaPorPeriodoDataEmissao(Date dtIni, Date dtFim) {
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM CompraCab c WHERE c.emissao BETWEEN :dtIni AND :dtFim";
        return this.manager.createQuery(jpql, CompraCab.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
    }
    
    
     
//     public List<Events> findAllEvents(Date startDate, Date endDate) {    
//  List<Events> allEvents = entityManager.createQuery(
//    "SELECT e FROM Events e WHERE e.eventsDate BETWEEN :startDate AND :endDate")  
//  .setParameter("startDate", startDate, TemporalType.DATE)  
//  .setParameter("endDate", endDate, TemporalType.DATE)  
//  .getResultList();
//  return allEvents ;  
//}
     
     
     
     
}
