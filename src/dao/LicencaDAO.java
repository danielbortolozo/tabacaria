/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Licenca;

/**
 *
 * @author del
 */
public class LicencaDAO {
    
    
    
    public void salvar(Licenca l){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.merge(l);
        
        tx.commit();
        
        manager.close();
    }
    
    public Licenca licenca(){
        EntityManager manager = JPAUtil.getEntityManager();
        
        Licenca l = manager.find(Licenca.class, 1L);
        
        return l;
    }
    
}
