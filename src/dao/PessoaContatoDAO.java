/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.PessoaContato;

/**
 *
 * @author daniel
 */
public class PessoaContatoDAO {
    
    public void alterarContato(PessoaContato pContato){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        PessoaContato pContat = manager.find(PessoaContato.class, pContato.getId());
        
        pContat.setDescricao(pContato.getDescricao().toUpperCase());
        pContat.setDdd(pContato.getDdd());
        pContat.setNumero(pContato.getNumero());
        
        tx.commit();
        manager.close();
        
        
    }
    
    public void salvar(PessoaContato pContato){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(pContato);
        
        tx.commit();
        manager.close();
         
    }
    
    public void remover(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        PessoaContato pContato = manager.find(PessoaContato.class, id);
        manager.remove(pContato);
        tx.commit();
        manager.close();      
        
    }
    
    public List<PessoaContato> contatos(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        Pessoa pessoa = manager.find(Pessoa.class, id);
        List<PessoaContato> contatos = new ArrayList<PessoaContato>();
        contatos = pessoa.getListaContato();
        manager.close();
        return contatos;
    }
    
     public List<PessoaContato> getContatos(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        List<PessoaContato> contatos = null;
        try{
           Query query = manager.createQuery("SELECT pc FROM PessoaContato pc  where pc.pessoa.id = :id", PessoaContato.class);
           query.setParameter("id", id);        
           contatos = query.getResultList();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro metodo getEnderecos classe:PessoaEnderecoDAO. Error:"+e.getMessage());
        }
        return contatos;        
    }
    
    
}
