/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Empresa;

/**
 *
 * @author daniel
 */
public class EmpresaDAO {
    
    public void salvar(Empresa empresa){        
       EntityManager manager = JPAUtil.getEntityManager();       
       EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        manager.merge(empresa);        
        tx.commit();
        manager.close();
    }
    
    public Empresa getEmpresa(){
        EntityManager manager = JPAUtil.getEntityManager();
       // EntityTransaction tx = manager.getTransaction();
      //  tx.begin();
        
        Empresa b = manager.find(Empresa.class, 1);
        
        return b;
        
    } 
    
    
    
}
