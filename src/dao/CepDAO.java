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

import model.Cep;

/**
 *
 * @author daniel
 */
public class CepDAO implements Serializable{
    
    
    public void salvar(Cep cep){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
              
        manager.persist(cep);
        
        tx.commit();
        
        manager.close();
       // JPAUtil.close();
    }
    
    
    public List<Cep>  getCep(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Cep> cep = manager.createQuery("from Cep", Cep.class).getResultList();
        manager.close();
        return cep;
        
    }
    
    
    public void alterarCep(Cep cep){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
      //  System.out.println("Codigo cep ="+cep.getId());
        Cep cep1 = manager.find(Cep.class, cep.getId());
        
        cep1.setLogadouro(cep.getLogadouro());
        cep1.setBairro(cep.getBairro());
        cep1.setCidade(cep.getCidade());
        cep1.setCep(cep.getCep());
        cep1.setUf(cep.getUf());
        
        tx.commit();
        manager.close();
        System.out.println("Cep alterado");
    }
    
   
    
    
    
}
