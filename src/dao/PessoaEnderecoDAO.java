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
import model.PessoaEndereco;

/**
 *
 * @author daniel
 */
public class PessoaEnderecoDAO {
    
    
    
    public void alterarEndereco(PessoaEndereco pEnd){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
       
        PessoaEndereco pEndereco = manager.find(PessoaEndereco.class, pEnd.getId());
        
        
        
        pEndereco.setLogradouro(pEnd.getLogradouro().toUpperCase());
        pEndereco.setNumero(pEnd.getNumero().toUpperCase());
        pEndereco.setBairro(pEnd.getBairro().toUpperCase());
        pEndereco.setCidade(pEnd.getCidade().toUpperCase());
        pEndereco.setUf(pEnd.getUf().toUpperCase());
        pEndereco.setCep(pEnd.getCep());
        pEndereco.setPrincipal(pEnd.getPrincipal());
        pEndereco.setCobranca(pEnd.getCobranca());
        pEndereco.setEntrega(pEnd.getEntrega());
        pEndereco.setCorrespondencia(pEnd.getCorrespondencia());
    //    pEndereco.setId(pEnd.getId());
   //     pEndereco.setPessoa(pEnd.getPessoa());
        
        
        tx.commit();
        
        manager.close();
        System.out.println("Endereço Alterado com Sucesso!!!");
        
    }
    public void salvar (PessoaEndereco pEndereco){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(pEndereco);
        
        tx.commit();
        manager.close();
        System.out.println("Endereço Salvo com Sucesso!!!");
    }
    
    public void remover(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        PessoaEndereco pEndereco = manager.find(PessoaEndereco.class, id);
        
        manager.remove(pEndereco);
        
        tx.commit();
        manager.close();
    }
    
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
    
    public List<PessoaEndereco> getEnderecos(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        List<PessoaEndereco> enderecos = null;
        try{
        Query query = manager.createQuery("SELECT pe FROM PessoaEndereco pe  where pe.pessoa.id = :id", PessoaEndereco.class);
        query.setParameter("id", id);        
        enderecos = query.getResultList();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro metodo getEnderecos classe:PessoaEnderecoDAO. Error:"+e.getMessage());
        }finally{
            manager.close();
        }
        return enderecos;
        
    }
    
}
