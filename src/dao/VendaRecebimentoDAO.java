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
import javax.swing.JOptionPane;
import model.VendaRecebimento;

/**
 *
 * @author del
 */
public class VendaRecebimentoDAO {
    
    
    public void salvar(List<VendaRecebimento> vRecebimento){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
           tx.begin();
           
           for (VendaRecebimento v : vRecebimento){
               manager.persist(v);
           }
           tx.commit();
        }catch (Exception ex){
           JOptionPane.showMessageDialog(null, "Erro ao Receber Venda!!! Error: "+ex.getMessage());            
        }finally{
            manager.close();
        }       
    }
    
  
    
}
