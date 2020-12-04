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
import javax.swing.JOptionPane;
import model.Pessoa;
import model.PessoaContato;
import model.PessoaEndereco;
import model.PessoaFisica;

/**
 *
 * @author daniel
 */
public class PessoaFisicaDAO {
    
    
    public PessoaFisica pessoaFisica(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        PessoaFisica pf = manager.find(PessoaFisica.class, id);
//        
//        PessoaFisica pessoaFisica = new PessoaFisica();
//        
//        pessoaFisica.setId(id);
//        pessoaFisica.setNome(pf.getNome());
//        pessoaFisica.setEmail(pf.getEmail());
//        pessoaFisica.setSite(pf.getSite());
//        pessoaFisica.setTipo(pf.getTipo());
//        pessoaFisica.setCpf(pf.getCpf());
//        pessoaFisica.setEstado_civil(pf.getEstado_civil());
//        pessoaFisica.setSexo(pf.getSexo());
//        pessoaFisica.setRg(pf.getRg());
//        pessoaFisica.setOrgao_rg(pf.getOrgao_rg());
//        pessoaFisica.setData_emissao(pf.getData_emissao());
//                 
        manager.close();
        
        return  pf;   //pessoaFisica;//pessoaFisica;      
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
    
   public void excluir(Long id){
       
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        PessoaFisica pessoa = manager.find(PessoaFisica.class, id);
        
        manager.remove(pessoa);
         
       tx.commit();
       manager.close();
        
       
       
   }
    
    public PessoaFisica verificaSeExisteCPF(String cpf){
        EntityManager manager = JPAUtil.getEntityManager();        
        String jpql = "select p from PessoaFisica p where p.cpf = :cpf";
        try{
          
           PessoaFisica p = manager.createQuery(jpql, PessoaFisica.class)
                            .setParameter("cpf", cpf).getSingleResult();
            
           return p;
        }catch (Exception e){
           //JOptionPane.showMessageDialog(null, "CPF não encontrado!!!: ");
           return null;
        }finally{
            manager.close();
        }
      //  return null;
    }
    
    
}
