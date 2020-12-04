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
import model.SubCategoriaConta;



/**
 *
 * @author del
 */
public class SubCategoriaContaDAO {
    
    public void salvar(SubCategoriaConta categoria) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.merge(categoria);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Salvar Sub-Categoria Conta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            manager.close();
        }

    }
    
    public List<SubCategoriaConta> getLista() {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<SubCategoriaConta> listCategoria;
        try {
            listCategoria = manager.createQuery("from SubCategoriaConta order by descricao", SubCategoriaConta.class).getResultList();
        } finally {
            manager.close();
        }
        return listCategoria;
    }
    
    
    public void excluir(int conta){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        SubCategoriaConta b = manager.find(SubCategoriaConta.class, conta);
        
        manager.remove(b);
        
        tx.commit();
        manager.close();
    }
    
    
}
