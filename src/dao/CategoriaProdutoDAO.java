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
import model.CategoriaProduto;

/**
 *
 * @author daniel
 */
public class CategoriaProdutoDAO {
    
    
    
    public void salvar(CategoriaProduto categoria) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.persist(categoria);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Salvar Categoria: " + e.getMessage());
            e.printStackTrace();
        } finally {
            manager.close();
        }

    }
    public void alterar(CategoriaProduto categoriaProduto) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            CategoriaProduto categoria = manager.find(CategoriaProduto.class, categoriaProduto.getId());
            categoria.setDescricao(categoriaProduto.getDescricao());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Alterar Categoria: " + e.getMessage());
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
    
    public List<CategoriaProduto> listCategoriaProduto() {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<CategoriaProduto> listCategoria;
        try {
            listCategoria = manager.createQuery("from CategoriaProduto order by id", CategoriaProduto.class).getResultList();
        } finally {
            manager.close();
        }
        return listCategoria;
    }
    
    public void excluir(CategoriaProduto categoria) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CategoriaProduto categoriaP = manager.find(CategoriaProduto.class, categoria.getId());
        try {
            manager.remove(categoriaP);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Excluir Categoria de Produto" + e.getMessage());
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
     
    
    public List<CategoriaProduto> listCategoriaPorOrderDescricao() {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<CategoriaProduto> listCategoria;
        try {
            listCategoria = manager.createQuery("from CategoriaProduto order by descricao", CategoriaProduto.class).getResultList();
        } finally {
            manager.close();
        }
        return listCategoria;
    }
    
    
}
