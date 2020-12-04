/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import model.MarcaProduto;
import org.postgresql.util.PSQLException;


/**
 *
 * @author daniel
 */
public class MarcaProdutoDAO implements Serializable{
    
    public void salvar(MarcaProduto marca){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
              
        manager.persist(marca);
        
        tx.commit();
        
        manager.close();
       // JPAUtil.close();
    }
    
    public List<MarcaProduto>  getMarca(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<MarcaProduto> marca = manager.createQuery("from MarcaProduto", MarcaProduto.class).getResultList();
        manager.close();
        return marca;
        
    }
    
    
    public void alterarMarca(MarcaProduto marcaProduto){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
      //  System.out.println("Codigo cep ="+cep.getId());
        MarcaProduto marca = manager.find(MarcaProduto.class, marcaProduto.getId());
        
        marca.setDescricao(marcaProduto.getDescricao());
        
        tx.commit();
        manager.close();
        System.out.println("Marca do Produto alterado com Sucesso!!!");
    }
    
     
    public void excluir(MarcaProduto marca){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        MarcaProduto marcaP = manager.find(MarcaProduto.class, marca.getId());
        try {
            manager.remove(marcaP);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Excluir Marca de Produto"+e.getMessage());
            e.printStackTrace();
        }finally{
                 manager.close();
        }           
    }
     
     
    
}
