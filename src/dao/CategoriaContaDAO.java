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
import model.CategoriaConta;

/**
 *
 * @author del
 */
public class CategoriaContaDAO {
    
    public void salvar(CategoriaConta categoria) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.merge(categoria);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Salvar Categoria Conta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            manager.close();
        }

    }
    
    
    
     public void excluir(int id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        CategoriaConta b = manager.find(CategoriaConta.class, id);
        
        manager.remove(b);
        
        tx.commit();
        manager.close();
    }
    
    
    public List<CategoriaConta> lista(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<CategoriaConta> list = manager.createQuery("from CategoriaConta order by descricao", CategoriaConta.class).getResultList();
        manager.close();
        return list;
    }
    
    public List<CategoriaConta> listaContas(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        //List<CategoriaConta> list = manager.createQuery("from CategoriaConta where idSubCategoriaConta = 1 order by descricao", CategoriaConta.class).getResultList();
        List<CategoriaConta> list = manager.createQuery("from CategoriaConta order by descricao", CategoriaConta.class).getResultList();
        manager.close();
        return list;
    }
     
     
}
