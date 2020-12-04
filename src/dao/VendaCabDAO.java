/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.VendaCab;
import model.VendaDet;

/**
 *
 * @author del
 */
public class VendaCabDAO {
    
    
    public VendaCab salvar(VendaCab venda) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(venda);
            for (VendaDet itens : venda.getListaItens()) {
                itens.setVenda(venda);
                manager.persist(itens);
            }
            tx.commit();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Gravar Venda. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
        return venda;
    }
//    public VendaCab retornaVendaSalva(VendaCab venda){
//        VendaCab v = new VendaCab();
//        v = venda;
//        return v;        
//    }
    
    public void alterar(VendaCab venda){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.merge(venda);            
            tx.commit();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Gravar Venda. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
    }
  
    public Collection<VendaCab> listVendaReceberDia(Date vencimento){  
        EntityManager manager = JPAUtil.getEntityManager();        
        Query query = null;
        try{
           query = manager.createQuery("Select v FROM VendaCab v where v.vencimento = :vencimento and v.status='ABERTO' ");  
	   query.setParameter("vencimento", vencimento);     
	   
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao executar o sql! Error:"+ex.getMessage());
        }   
	return query.getResultList();  
    }
    
    public VendaCab vendaCab(Long id){        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        VendaCab vendaCab = manager.find(VendaCab.class, id);
        
        manager.close();
        return vendaCab;            
    }
    
    
    
}
