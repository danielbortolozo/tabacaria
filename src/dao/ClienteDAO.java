/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Pessoa;
import model.PessoaContato;
import model.PessoaEndereco;
import model.PessoaFisica;
import model.PessoaJuridica;

/**
 *
 * @author root
 */
public class ClienteDAO {
    
    
      
     public void salvarPessoaFisica(PessoaFisica pf){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();              
        manager.persist(pf);
        
        manager.persist(pf.getCli());
        //Salvando os Endereços do Cliente.
        if (pf.getListaEndereco() != null){
           for (PessoaEndereco endereco: pf.getListaEndereco()){
               endereco.setPessoa(pf);
               manager.persist(endereco);
           }
        }
       // Salvando os Contatos do Cliente.
        if (pf.getListaContato() != null){            
          
            for(PessoaContato contato: pf.getListaContato()){               
                contato.setPessoa(pf);
                manager.persist(contato);
            }
        }
        tx.commit();       
        manager.close();        
    }
     public void alterarPessoaFisica(PessoaFisica pf, Cliente cli){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
       
        manager.merge(pf);
        manager.merge(cli);
        ///manager.merge(cli);
      //  manager.merge(pf.getCli());
        //Salvando os Endereços do Cliente.
        if (pf.getListaEndereco() != null){
           for (PessoaEndereco endereco: pf.getListaEndereco()){
               endereco.setPessoa(pf);
               manager.merge(endereco);
           }
        }
//       // Salvando os Contatos do Cliente.
        if (pf.getListaContato() != null){     
          
            for(PessoaContato contato: pf.getListaContato()){               
                contato.setPessoa(pf);
                manager.merge(contato);
            }
        }
        tx.commit();
        System.out.println("cliente salvo na dao");
        
        manager.close();        
    } 
     
   public void salvarPessoaJuridica(PessoaJuridica pj){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();                   
        manager.persist(pj);
        manager.persist(pj.getCli());
        //Salvando os Endereços do Cliente.
        if (pj.getListaEndereco() != null){
           for (PessoaEndereco endereco: pj.getListaEndereco()){
               endereco.setPessoa(pj);
               manager.persist(endereco);
           }
        }
        //Salvando os Contatos do Cliente.
        if (pj.getListaContato() != null){
            
           // System.out.println("Oi entrei no for do contato add");
            for(PessoaContato contato:pj.getListaContato()){                
                contato.setPessoa(pj);
                manager.persist(contato);
            }
        }
        tx.commit();        
        manager.close();       
    }  
   
    public void alterarPessoaJuridica(PessoaJuridica pj, Cliente cli){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();                   
        manager.merge(pj);
        manager.merge(cli);
        //Salvando os Endereços do Cliente.
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
                manager.merge(contato);
            }
        }
        tx.commit();        
        manager.close();       
    }
     
   
    public void alterarCreditoCliente(Cliente cli){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();                   
        manager.merge(cli);       
        tx.commit();        
        manager.close();   
    }
    
    
    
    public List<Pessoa>  getCliente(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Pessoa> p = manager.createQuery("from Pessoa where cliente = 'S' order by nome", Pessoa.class).getResultList();
        manager.close();
        return p;
        
    }
    
    public List<PessoaFisica> getClienteFisico(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<PessoaFisica> pf = manager.createQuery("from PessoaFisica pf where pf.cliente='S'", PessoaFisica.class).getResultList();
        manager.close();
        
        return pf;
        
        
    }
    public List<PessoaJuridica> getClienteJuridica(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<PessoaJuridica> pj = manager.createQuery("from PessoaJuridica pj where pj.cliente='S'", PessoaJuridica.class).getResultList();
        manager.close();
        
        return pj;    
    }
    public Pessoa cliente(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Pessoa pessoa = manager.find(Pessoa.class, id);
        
        
        return pessoa;
    }
    
    
    public PessoaFisica pessoaFisica(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        PessoaFisica pf = manager.find(PessoaFisica.class, id);
        PessoaFisica pessoaFisica = new PessoaFisica();
        
        pessoaFisica.setId(id);
        pessoaFisica.setNome(pf.getNome());
        pessoaFisica.setEmail(pf.getEmail());
        pessoaFisica.setSite(pf.getSite());
        pessoaFisica.setTipo(pf.getTipo());
        pessoaFisica.setCpf(pf.getCpf());
        pessoaFisica.setEstado_civil(pf.getEstado_civil());
        pessoaFisica.setSexo(pf.getSexo());
        pessoaFisica.setRg(pf.getRg());
        pessoaFisica.setOrgao_rg(pf.getOrgao_rg());
        pessoaFisica.setData_emissao(pf.getData_emissao());
                 
        manager.close();
        
        return pessoaFisica;      
    }
    public PessoaJuridica pessoaJuridica(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        PessoaJuridica pj = manager.find(PessoaJuridica.class, id);
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setId(id);
        pessoaJuridica.setNome(pj.getNome());
        pessoaJuridica.setEmail(pj.getEmail());
        pessoaJuridica.setSite(pj.getSite());
        pessoaJuridica.setTipo(pj.getTipo());
        pessoaJuridica.setRazao_social(pj.getRazao_social());
        pessoaJuridica.setCnpj(pj.getCnpj());
        pessoaJuridica.setInscrecao_estadual(pj.getInscrecao_estadual());
        pessoaJuridica.setInscrecao_municipal(pj.getInscrecao_municipal());
        manager.close();
        return pessoaJuridica;
    }
    
//    public Cliente cliente(Long id){
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        Pessoa pessoa = manager.find(Pessoa.class, id);
//        
//        Cliente cli = new Cliente();
//        cli.setLimite(pessoa.getCli().getLimite());
//        cli.setSituacao(pessoa.getCli().getSituacao());
//        cli.setDataCadastro(pessoa.getCli().getDataCadastro());
//        cli.setId(pessoa.getCli().getId());
//        
//        return cli;
//    }
    
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
    
    public List<PessoaContato> contatosClientes(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
          
        
        List<PessoaContato> pc = manager.createQuery("from PessoaContato pc where pc.pessoa.cliente='S'", PessoaContato.class).getResultList();
        manager.close();
        
        return pc; 
        //return contatos;
    }
    
    
    
    
//    public void alterarPessoaFisica(PessoaFisica pf, Cliente cli, List<PessoaEndereco> enderecos, List<PessoaContato> contatos ){
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        manager.merge(pf);
//        
//       
//       manager.merge(cli);
//        
//          System.out.println("Id cliente ="+cli.getId());
//        
//        
//        //Alterar Endereços Cliente
//        List<PessoaEndereco> listaEndereco = new ArrayList<PessoaEndereco>();
//        listaEndereco = enderecos(pf.getId());
//        int i = 0;
//        PessoaEnderecoDAO daoEnd = new PessoaEnderecoDAO();
//        for (PessoaEndereco pEnd : listaEndereco){
//           
//            pEnd.setLogradouro(enderecos.get(i).getLogradouro());
//            pEnd.setNumero(enderecos.get(i).getNumero());
//            pEnd.setBairro(enderecos.get(i).getBairro());
//            pEnd.setCidade(enderecos.get(i).getCidade());
//            pEnd.setCep(enderecos.get(i).getCep());
//            pEnd.setPrincipal(enderecos.get(i).getPrincipal());
//            pEnd.setCobranca(enderecos.get(i).getCobranca());
//            pEnd.setCorrespondencia(enderecos.get(i).getCorrespondencia());
//            pEnd.setEntrega(enderecos.get(i).getEntrega());
//            pEnd.setUf(enderecos.get(i).getUf());
//              
//            daoEnd.alterarEndereco(pEnd);
//            ++i;
//        }
//        //Alterar lista de Contato do Cliente.
//        List<PessoaContato> listaContato = new ArrayList<PessoaContato>();
//        listaContato = contatos(pf.getId());
//        i = 0;
//        PessoaContatoDAO daoContato = new PessoaContatoDAO();
//        for (PessoaContato pCont : listaContato){
//            pCont.setDescricao(contatos.get(i).getDescricao());
//            pCont.setDdd(contatos.get(i).getDdd());
//            pCont.setNumero(contatos.get(i).getNumero());
//            
//            daoContato.alterarContato(pCont);
//            ++i;
//        }
//                              
//        tx.commit();
//        manager.close();
//        System.out.println("Cliente Alterado com Sucesso !!!");
//    }
    
//    public void alterarPessoaJuridica(PessoaJuridica pj, Cliente cli, List<PessoaEndereco> enderecos, List<PessoaContato> contatos ){
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        PessoaJuridica pessoaJuridica = manager.find(PessoaJuridica.class, pj.getId());
//        
//       // System.out.println("Email: "+pf.getEmail()+" Site: "+pf.getSite()+" CPF: "+pf.getCpf());
//        //pessoaFisica = pf;
//        pessoaJuridica.setTipo(pj.getTipo());
//        pessoaJuridica.setNome(pj.getNome());
//        pessoaJuridica.setEmail(pj.getEmail());
//        pessoaJuridica.setSite(pj.getSite());
//        pessoaJuridica.setRazao_social(pj.getRazao_social());
//        pessoaJuridica.setCnpj(pj.getCnpj());
//        pessoaJuridica.setInscrecao_estadual(pj.getInscrecao_estadual());
//        pessoaJuridica.setInscrecao_municipal(pj.getInscrecao_municipal());
//       
//        
//        //Alterando Cliente
//        Cliente cl = new Cliente();
//        cl = cliente(pj.getId());
//        cl = manager.find(Cliente.class, cl.getId());
//        
//        cl.setLimite(cli.getLimite());
//        cl.setSituacao(cli.getSituacao());
//        
//        //Alterar Endereços Cliente
//        List<PessoaEndereco> listaEndereco = new ArrayList<PessoaEndereco>();
//        listaEndereco = enderecos(pj.getId());
//        int i = 0;
//        PessoaEnderecoDAO daoEnd = new PessoaEnderecoDAO();
//        for (PessoaEndereco pEnd : listaEndereco){
//           
//            pEnd.setLogradouro(enderecos.get(i).getLogradouro());
//            pEnd.setNumero(enderecos.get(i).getNumero());
//            pEnd.setBairro(enderecos.get(i).getBairro());
//            pEnd.setCidade(enderecos.get(i).getCidade());
//            pEnd.setCep(enderecos.get(i).getCep());
//            pEnd.setPrincipal(enderecos.get(i).getPrincipal());
//            pEnd.setCobranca(enderecos.get(i).getCobranca());
//            pEnd.setCorrespondencia(enderecos.get(i).getCorrespondencia());
//            pEnd.setEntrega(enderecos.get(i).getEntrega());
//            pEnd.setUf(enderecos.get(i).getUf());
//              
//            daoEnd.alterarEndereco(pEnd);
//            ++i;
//        }
//        //Alterar lista de Contato do Cliente.
//        List<PessoaContato> listaContato = new ArrayList<PessoaContato>();
//        listaContato = contatos(pj.getId());
//        i = 0;
//        PessoaContatoDAO daoContato = new PessoaContatoDAO();
//        for (PessoaContato pCont : listaContato){
//            pCont.setDescricao(contatos.get(i).getDescricao());
//            pCont.setDdd(contatos.get(i).getDdd());
//            pCont.setNumero(contatos.get(i).getNumero());
//            
//            daoContato.alterarContato(pCont);
//            ++i;
//        }
//                              
//        tx.commit();
//        manager.close();
//        System.out.println("Cliente Alterado com Sucesso !!!");
//    }
    public List<Pessoa>  listaCliente(){
        EntityManager manager = JPAUtil.getEntityManager();
      //  EntityTransaction tx = manager.getTransaction();
       // tx.begin();
         List<Pessoa> p = null;
        try{
            p = manager.createQuery("from Pessoa where cliente = 'S' order by nome", Pessoa.class).getResultList();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro metodo listaCliente. Error:"+e.getMessage());
        }finally{
            manager.close();
        }    
        return p;
        
    }
    
    
    
    
    
    
}
