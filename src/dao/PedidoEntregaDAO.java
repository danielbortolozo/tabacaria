/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import model.PedidoEntrega;


/**
 *
 * @author daniel
 */
public class PedidoEntregaDAO {
    
    public void salvar(PedidoEntrega pe){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(pe);            
            tx.commit();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Gravar Endereço de Entrega. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
    }
    
    public void alterar(PedidoEntrega pe){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.merge(pe);            
            tx.commit();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Alterar Endereço de Entrega. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
    }
    
    
    
    
}
