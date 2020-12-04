/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Caixa;
import model.CaixaItens;

/**
 *
 * @author del
 */
public class CaixaItensDAO {
    
    EntityManager manager;
    public CaixaItens salvar(CaixaItens cxItens) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {           
            manager.persist(cxItens);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Salvar Itens do Caixa: " + e.getMessage());
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return cxItens;

    }
    
   
    public List<CaixaItens> listaCaixaItens(Caixa caixa){
        manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery(
                        "from CaixaItens where idCaixa = :caixa");
          query.setParameter("caixa", caixa);
          
          //List veiculos = query.getResultList();
         return query.getResultList();
        
    }
    
    public CaixaItens caixaId(int id){        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        CaixaItens itens = manager.find(CaixaItens.class, id);
        
        manager.close();
        return itens;            
    }
    
     public void excluir(int id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        CaixaItens b = manager.find(CaixaItens.class, id);
        
        manager.remove(b);
        
        tx.commit();
        manager.close();
    }
    
    
    public List<CaixaItens> listaCaixaItensPorPeriodo(Date dtIni, Date dtFim) {
        EntityManager manager = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM CaixaItens c WHERE c.dtHora BETWEEN :dtIni AND :dtFim AND c.tipo = 'VENDA'";
        return manager.createQuery(jpql, CaixaItens.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
    }
     
    
}
