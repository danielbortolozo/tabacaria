/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Colaborador;
import model.Pessoa;
import model.PessoaContato;
import model.PessoaEndereco;
import model.PessoaFisica;

/**
 *
 * @author daniel
 */
public class ColaboradorDAO {
    
    private String login;
    private Long id;
    private String nome;
    
    
    public void salvar(PessoaFisica pf, List<PessoaEndereco> enderecos, List<PessoaContato> contatos){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();  
        manager.persist(pf);
        pf.getColaborad().setPessoa(pf);
        manager.persist(pf.getColaborad());
        if (enderecos != null){
           for (PessoaEndereco endereco: enderecos){
               endereco.setPessoa(pf);
               manager.persist(endereco);
           }
        }
        if (contatos != null){            
           for(PessoaContato contato:contatos){
                contato.setPessoa(pf);
                manager.persist(contato);
            }       
        }
        
        
        tx.commit();        
        manager.close();       
    }
    
    public void alterar(PessoaFisica pf, Colaborador colaborador, List<PessoaEndereco> enderecos, List<PessoaContato> contatos){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();  
        manager.merge(pf);
        colaborador.setPessoa(pf);
        manager.merge(colaborador);
        if (enderecos != null){
           for (PessoaEndereco endereco: enderecos){
               endereco.setPessoa(pf);
               manager.merge(endereco);
           }
        }
        if (contatos != null){            
           for(PessoaContato contato:contatos){
                contato.setPessoa(pf);
                manager.merge(contato);
            }       
        }
        
        
        tx.commit();        
        manager.close();       
    }
    
    
    
    public Pessoa colaboradorIDPessoa(Long id){
        EntityManager manager =  JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
        tx.begin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Falha de Conexão com Banco de Dados :"+e.getMessage());
            e.printStackTrace();           
        }
        Pessoa colaborador = null;
        try{ 
           colaborador = manager.find(Pessoa.class, id);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Pesquisar Colaborador :"+e.getMessage());
            e.printStackTrace();           
        }finally{
            manager.close();
        }
        return colaborador;       
    }
    public Colaborador colaboradorID(Long id){
        EntityManager manager =  JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
        tx.begin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Falha de Conexão com Banco de Dados :"+e.getMessage());
            e.printStackTrace();           
        }
        Colaborador colaborador = null;
        try{ 
           colaborador = manager.find(Colaborador.class, id);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Pesquisar Colaborador :"+e.getMessage());
            e.printStackTrace();           
        }finally{
            manager.close();
        }
        return colaborador;       
    }
    
    
    
    
    
    
    public boolean autenticaColaborador(String login, String senha){
        EntityManager manager =  JPAUtil.getEntityManager();
       
       
        try{
           Query query = manager.createQuery("SELECT c FROM  Colaborador c where c.login = :login and senha = :senha", Colaborador.class);
           query.setParameter("login", login);
           query.setParameter("senha", senha);
           
           Colaborador co = (Colaborador) query.getSingleResult();
            setLogin(co.getLogin());
            setId(co.getPessoa().getId());
            setNome(co.getPessoa().getNome());
            return true;
        }catch(Exception e){
            return false;
        }
        
        
    }
    public String getColaboradorLogin(String login){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Query query = manager.createQuery("select c from Coloborador c where c.login = :login");
        query.setParameter("login", login);
        Colaborador co = (Colaborador) query.getSingleResult();
        setLogin(co.getLogin());
        return co.getLogin();
        
    }
    
    public List<Colaborador>  getListColaborador(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Colaborador> colab;
        try{
            colab = manager.createQuery("from Colaborador ", Colaborador.class).getResultList();
        }finally{   
                manager.close();
        }
        return colab;
        
    }
     public List<Pessoa> listColab(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Pessoa> list = manager.createQuery("from Pessoa", Pessoa.class).getResultList();
        
        manager.close();
        return list;
    }
     
     
     public List<Colaborador>  getListColab(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Colaborador> colab;
        try{
            colab = manager.createQuery("from Colaborador", Colaborador.class).getResultList();
        }finally{   
                manager.close();
        }
        return colab;
        
    } 
    
    
    
    
    
    public void registroDataHoraAcesso(Colaborador colaborador){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin(); 
        
        
        manager.merge(colaborador);
        tx.commit();
        
        manager.close();
        
    }
    
    
    
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    
    
}
