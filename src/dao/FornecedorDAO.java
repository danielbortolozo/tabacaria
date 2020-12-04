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


import model.Fornecedor;
import model.Pessoa;
import model.PessoaContato;
import model.PessoaEndereco;
import model.PessoaFisica;
import model.PessoaJuridica;

/**
 *
 * @author daniel
 */
public class FornecedorDAO {
    
     public void salvarPessoaFisica(PessoaFisica pf, Fornecedor forn, List<PessoaEndereco> enderecos, List<PessoaContato> contatos){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
                   
        manager.persist(pf);
        manager.persist(forn);
        //Salvando os Endereços do Cliente.
        if (enderecos != null){
           for (PessoaEndereco endereco: enderecos){
               endereco.setPessoa(pf);
               manager.persist(endereco);
           }
        }
        //Salvando os Contatos do Cliente.
        if (contatos != null){
            
           // System.out.println("Oi entrei no for do contato add");
            for(PessoaContato contato:contatos){
               // System.out.println("Contatos ="+ contato.getDescricao());
                contato.setPessoa(pf);
                manager.persist(contato);
            }
            
//            for (int i=0; i<contatos.size(); i++){
//                System.out.println("Lista de contato exibida: "+contatos.get(i));
//            }
        }
        tx.commit();
        System.out.println("Fornecedor Salvo com Sucesso !!!");
        manager.close();
    }
    
    
     
     public void alterarPessoaFisica(PessoaFisica pf, Fornecedor forn, List<PessoaEndereco> enderecos, List<PessoaContato> contatos ){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        PessoaFisica pessoaFisica = manager.find(PessoaFisica.class, pf.getId());
    //     System.out.println("CPF alterar PF ="+);
       // System.out.println("Email: "+pf.getEmail()+" Site: "+pf.getSite()+" CPF: "+pf.getCpf());
        //pessoaFisica = pf;
        pessoaFisica.setTipo(pf.getTipo());
        pessoaFisica.setNome(pf.getNome());
        pessoaFisica.setEmail(pf.getEmail());
        pessoaFisica.setSite(pf.getSite());
         System.out.println("CPF dentro do alterar DAO ="+pf.getCpf());
        pessoaFisica.setCpf(pf.getCpf());
        pessoaFisica.setEstado_civil(pf.getEstado_civil());
        pessoaFisica.setSexo(pf.getSexo());
        pessoaFisica.setRg(pf.getRg());
        pessoaFisica.setOrgao_rg(pf.getOrgao_rg());
        pessoaFisica.setData_emissao(pf.getData_emissao());
        
       
        
        //Alterando Fornecedor
        Fornecedor fn = new Fornecedor();
        fn = fornecedor(pf.getId());
        fn = manager.find(Fornecedor.class, fn.getId());
        
       // cl.setLimite(cli.getLimite());
        fn.setStatus(forn.getStatus());
        
        //Alterar Endereços Cliente
        PessoaEnderecoDAO daoEnd = new PessoaEnderecoDAO();
        List<PessoaEndereco> listaEndereco = new ArrayList<PessoaEndereco>();
        listaEndereco = daoEnd.enderecos(pf.getId());
        int i = 0;
        
        for (PessoaEndereco pEnd : listaEndereco){
           
            pEnd.setLogradouro(enderecos.get(i).getLogradouro());
            pEnd.setNumero(enderecos.get(i).getNumero());
            pEnd.setBairro(enderecos.get(i).getBairro());
            pEnd.setCidade(enderecos.get(i).getCidade());
            pEnd.setCep(enderecos.get(i).getCep());
            pEnd.setPrincipal(enderecos.get(i).getPrincipal());
            pEnd.setCobranca(enderecos.get(i).getCobranca());
            pEnd.setCorrespondencia(enderecos.get(i).getCorrespondencia());
            pEnd.setEntrega(enderecos.get(i).getEntrega());
            pEnd.setUf(enderecos.get(i).getUf());
              
            daoEnd.alterarEndereco(pEnd);
            ++i;
        }
        //Alterar lista de Contato.
        PessoaContatoDAO daoContato = new PessoaContatoDAO();
        List<PessoaContato> listaContato = new ArrayList<PessoaContato>();
        listaContato = daoContato.contatos(pf.getId());
        i = 0;
        
        for (PessoaContato pCont : listaContato){
            pCont.setDescricao(contatos.get(i).getDescricao());
            pCont.setDdd(contatos.get(i).getDdd());
            pCont.setNumero(contatos.get(i).getNumero());
            
            daoContato.alterarContato(pCont);
            ++i;
        }
                              
        tx.commit();
        manager.close();
        System.out.println("Fornecedor Alterado com Sucesso !!!");
    }  
    
    
     
     public Fornecedor fornecedor(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Pessoa pessoa = manager.find(Pessoa.class, id);
        
        Fornecedor forn = new Fornecedor();
        forn.setStatus(pessoa.getForn().getStatus());
        forn.setDataCadastro(pessoa.getForn().getDataCadastro());
        forn.setId(pessoa.getForn().getId());
       
        return forn;
    }
     
    public List<PessoaFisica> getPessoaFisica(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<PessoaFisica> pf = manager.createQuery("from PessoaFisica pf where pf.fornecedor='S'", PessoaFisica.class).getResultList();
        manager.close();
        
        return pf;
        
        
    } 
     public List<PessoaJuridica> getPessoaJuridica(){
        EntityManager manager = JPAUtil.getEntityManager();       
        List<PessoaJuridica> pj = null;
        try{
            pj = manager.createQuery("from PessoaJuridica pj where pj.fornecedor='S'", PessoaJuridica.class).getResultList();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao executar getPessoaJuridica"+e.getMessage());
        }finally{
            manager.close();
        }
        
        return pj;       
        
    } 
    
    
     

    
    public List<Pessoa> listaFornecedor(){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Pessoa> forn = null;
        try{
           forn = manager.createQuery("from Pessoa p where p.fornecedor = 'S' order by p.nome", Pessoa.class).getResultList();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro listaFornecedor (dao). Error:"+e.getMessage());
        }finally{
            manager.close();
        }         
        return forn;       
    }
    
    
    public void alterarPessoaFisica(PessoaFisica pf, Fornecedor forn){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
        tx.begin();  
            
        manager.merge(pf);
            

        manager.merge(forn);        
        if (pf.getListaEndereco() != null){
           for (PessoaEndereco endereco: pf.getListaEndereco()){
               endereco.setPessoa(pf);
               manager.merge(endereco);
           }
        }
        //Salvando os Contatos do Cliente.
        if (pf.getListaContato() != null){                    
            for(PessoaContato contato:pf.getListaContato()){               
                contato.setPessoa(pf);
                manager.merge(contato);
            }
        }
        tx.commit();
        System.out.println("Fornecedor Aterado com Sucesso !!!");
        }catch (Exception ex){
               System.out.println("Erro ao Alterar Fornecedor, Error:"+ex.getMessage());
        }finally {
               manager.close();
        }
    }
    
    
    
     public void alterarPessoaJuridica(PessoaJuridica pj, Fornecedor forn){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
        tx.begin(); 
            System.out.println("cheguei no alterar juridico");
        manager.merge(pj);
            System.out.println("id forn ="+forn.getId());

        manager.merge(forn);        
        if (pj.getListaEndereco() != null){
           for (PessoaEndereco endereco: pj.getListaEndereco()){
               endereco.setPessoa(pj);
               manager.merge(endereco);
           }
        }
        //Salvando os Contatos do Cliente.
        if (pj.getListaContato() != null){                    
            for(PessoaContato contato:pj.getListaContato()){               
                contato.setPessoa(pj);
                System.out.println("id contato ="+contato.getId());
                manager.merge(contato);
            }
        }
        tx.commit();
        System.out.println("Fornecedor Aterado com Sucesso !!!");
        }catch (Exception ex){
               System.out.println("Erro ao Alterar Fornecedor, Error:"+ex.getMessage());
        }finally {
               manager.close();
        }
    }
    
     public void salvarPessoaJuridica(PessoaJuridica pj, Fornecedor forn){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
                   
        manager.persist(pj);
        manager.persist(forn);
        //Salvando os Endereços do Cliente.
        if (pj.getListaEndereco() != null){
           for (PessoaEndereco endereco: pj.getListaEndereco()){
               endereco.setPessoa(pj);
               manager.persist(endereco);
           }
        }
        //Salvando os Contatos do Cliente.
        if (pj.getListaContato() != null){          
            for(PessoaContato contato: pj.getListaContato()){             
                contato.setPessoa(pj);
                manager.persist(contato);
            }            
        }
        tx.commit();
        System.out.println("Fornecedor Salvo com Sucesso !!!");
        manager.close();
    }
    
     public void salvarPessoaFisica(PessoaFisica pf, Fornecedor forn){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
        tx.begin();             
        manager.persist(pf);
        manager.persist(forn);        
        if (pf.getListaEndereco() != null){
           for (PessoaEndereco endereco: pf.getListaEndereco()){
               endereco.setPessoa(pf);
               manager.persist(endereco);
           }
        }
        //Salvando os Contatos do Cliente.
        if (pf.getListaContato() != null){                    
            for(PessoaContato contato:pf.getListaContato()){               
                contato.setPessoa(pf);
                manager.persist(contato);
            }
        }
        tx.commit();
        System.out.println("Fornecedor Salvo com Sucesso !!!");
        }catch (Exception ex){
               System.out.println("Erro ao Salvar Fornecedor, Error:"+ex.getMessage());
        }finally {
               manager.close();
        }
    }
    
    
    
}
