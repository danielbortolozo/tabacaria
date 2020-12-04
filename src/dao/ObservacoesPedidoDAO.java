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
import model.ObservacoesPedido;


/**
 *
 * @author daniel
 */
public class ObservacoesPedidoDAO {
    
    public void salvar(ObservacoesPedido obs){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.merge(obs);
        
        tx.commit();
        manager.close();
               
    }
    
    public void excluir(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        ObservacoesPedido b = manager.find(ObservacoesPedido.class, id);
        
        manager.remove(b);
        
        tx.commit();
        manager.close();
    }
    
    
    public List<ObservacoesPedido> listObs(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<ObservacoesPedido> listaObs = manager.createQuery("from ObservacoesPedido order by descricao", ObservacoesPedido.class).getResultList();
        manager.close();
        return listaObs;
    }
    
    
     public ObservacoesPedido observacaoID(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        ObservacoesPedido obs = manager.find(ObservacoesPedido.class, id);
        manager.close();
        return obs;        
    }  
    
    
}
