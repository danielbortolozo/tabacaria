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
import model.Fornecedor;
import model.Pessoa;

/**
 *
 * @author daniel
 */
public class PessoaDAO {
    
    
    
    public List<Pessoa> listaFornecedorALL(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Pessoa> p = manager.createQuery("from Pessoa p where p.fornecedor='S' order by p.nome", Pessoa.class).getResultList();
        
        return p;
        
    }
     public List<Pessoa> listaColaboradorALL(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Pessoa> p = null;
        try{
        p = manager.createQuery("from Pessoa p where p.colaborador='S' order by p.nome", Pessoa.class).getResultList();
        //return p;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema Listar Colaborador DAO. "+e.getMessage());
        }
        
        return p;
    }
    
    public Pessoa pessoa(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Pessoa p = manager.find(Pessoa.class, id);
        
        manager.close();
        
        return p;      
    }
    
    
    
    public List<Pessoa> listaClienteALL(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Pessoa> p = null;
        try{
           p = manager.createQuery("from Pessoa p where p.cliente='S' order by p.nome", Pessoa.class).getResultList();
           //return p;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema Listar Cliente DAO. "+e.getMessage());
        }
        
        return p;
    }
    
    
}
