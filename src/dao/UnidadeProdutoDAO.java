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
import model.UnidadeProduto;

/**
 *
 * @author daniel
 */
public class UnidadeProdutoDAO {
    
    
    public void salvar(UnidadeProduto unidade){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.merge(unidade);
        
        tx.commit();
        System.out.println("Unidade Salvada com Sucesso !!!");
        manager.close();
    }
    
//    public List<Cliente>  getCliente(){
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        List<Cliente> cli = manager.createQuery("from Cliente", Cliente.class).getResultList();
//        manager.close();
//        return cli;
//        
//    }
    public List<UnidadeProduto> listUnidadeProduto(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<UnidadeProduto> listUnidade = manager.createQuery("from UnidadeProduto", UnidadeProduto.class).getResultList();
        manager.close();
        return listUnidade;
    }
    
    
    public void excluir(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        UnidadeProduto unidadeP = manager.find(UnidadeProduto.class, id);
        
        manager.remove(unidadeP);
        
        tx.commit();
        manager.close();
    }
    
    
    
    
    
    
    
}
