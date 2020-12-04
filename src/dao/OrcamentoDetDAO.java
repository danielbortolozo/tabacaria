/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.OrcamentoDet;


/**
 *
 * @author del
 */
public class OrcamentoDetDAO {
    
    
    public void excluir(Long idOrcamento, int idProduto){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Query query = manager.createQuery("from OrcamentoDet where id_orcamento_cab = :idOrcamento and id_produto = :idProduto");
        query.setParameter("idOrcamento", idOrcamento);
        query.setParameter("idProduto", idProduto);
        Object orcDet = query.getSingleResult();
        
        manager.remove(orcDet);
        
        tx.commit();
        manager.close();       
        
    }
    
    public Long ID_ItemOrcamenot(int idOrcamento, int idProduto){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
      //  tx.begin();
        try{
           Query query = manager.createQuery("from OrcamentoDet where id_orcamento_cab = :idOrcamento and id_produto = :idProduto");
           query.setParameter("idOrcamento", idOrcamento);
           query.setParameter("idProduto", idProduto);
           OrcamentoDet orcDet = (OrcamentoDet) query.getSingleResult();
           Long id = orcDet.getId();           
           return id;
        }catch (Exception e){
           return  0L;
        }   
        
    }
    
    
}
