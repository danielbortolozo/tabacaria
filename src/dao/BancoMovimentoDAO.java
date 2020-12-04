/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import model.BancoMovimento;

/**
 *
 * @author root
 */
public class BancoMovimentoDAO {
    
    public void salvar(BancoMovimento bancoMov){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        manager.merge(bancoMov);        
        tx.commit();
        manager.close();
               
    }
    
    public void excluir(BancoMovimento bancoMov){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        BancoMovimento b = manager.find(BancoMovimento.class, bancoMov.getId());
        
        manager.remove(b);
        
        tx.commit();
        manager.close();        
    }
//    public BancoMovimento bancoMovimento(int idBanco){
//        EntityManager manager = JPAUtil.getEntityManager();        
//        Query query = null;
//        float saldo = 0;
//         try{
//           query = manager.createQuery("Select bm.saldo FROM BancoMovimento bm where bm.idBanco = :idBanco");  
//	   query.setParameter("idBanco", idBanco);     
//	   
//           BancoMovimento b = new BancoMovimento();
//           b = (BancoMovimento) query.getSingleResult();
//        }catch (Exception ex){
//            JOptionPane.showMessageDialog(null, "Erro ao executar o sql! Error:"+ex.getMessage());
//        }   
//	return b;        
//        
//    }
    
//     public Collection<VendaCab> listVendaReceberDia(Date vencimento){  
//        EntityManager manager = JPAUtil.getEntityManager();        
//        Query query = null;
//        try{
//           query = manager.createQuery("Select v FROM VendaCab v where v.vencimento = :vencimento and v.status='ABERTO' ");  
//	   query.setParameter("vencimento", vencimento);     
//	   
//        }catch (Exception ex){
//            JOptionPane.showMessageDialog(null, "Erro ao executar o sql! Error:"+ex.getMessage());
//        }   
//	return query.getResultList();  
//    }
    
    
    
}
