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
import model.Pessoa;
import model.PessoaEndereco;

/**
 *
 * @author daniel
 */
public class EnderecoDAO {
    
    
    
    public List<PessoaEndereco> enderecos(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        Pessoa pessoa =  manager.find(Pessoa.class, id);               
        List<PessoaEndereco> enderecos = new ArrayList<PessoaEndereco>();
        enderecos = pessoa.getListaEndereco();  
        manager.close();
        return enderecos;       
    }
    
    public void salvar(PessoaEndereco endereco){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
      //  PessoaEndereco pEnd = manager.find(PessoaEndereco.class, endereco.getPessoa().getId());
        
        manager.persist(endereco);
        
        tx.commit();
        manager.close();
    }
    
    
    
    
}
