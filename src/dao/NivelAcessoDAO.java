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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Colaborador;
import model.NivelAcesso;
import model.Produto;

/**
 *
 * @author daniel
 */
public class NivelAcessoDAO {
    private EntityManager manager;
    
    
    
    public NivelAcesso salvar(NivelAcesso nivel){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();       
        manager.persist(nivel);       
        
        tx.commit();
        
        manager.close();                       
        return nivel;
    } 
    
     public List<NivelAcesso> listaNivelAcesso(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<NivelAcesso> lista = manager.createQuery("from NivelAcesso", NivelAcesso.class).getResultList();     
        manager.close();
        return lista;
    }
    
    public NivelAcesso nivelAcessoID(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        NivelAcesso na = manager.find(NivelAcesso.class, id);
        manager.close();
        return na;        
    }   
     
     public void excluir(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
          
        NivelAcesso n = manager.find(NivelAcesso.class, id);
        
        manager.remove(n);
        
        tx.commit();
        manager.close();
    } 
     
     
//    public boolean verificaAcesso(String nomeMenu, String codFuncionario) {
//       Query query =  manager.createQuery("SELECT n FROM NivelAcesso n WHERE n.idColaborador = :idColaborador AND n.nomeModulo = :nomeModulo");
//        System.out.println("id colaborador ="+codFuncionario);
//       query.setParameter("idColaborador", Integer.parseInt(codFuncionario));
//       query.setParameter("nomeModulo", nomeMenu);
//       List<NivelAcesso> data = query.getResultList();
//       if (data.size() > 0) {
//          return true;
//       } else {
//          return false;
//       }
//    }
     
 public boolean verificaAcesso(String modulo, Colaborador idColaborador){
        EntityManager manager = JPAUtil.getEntityManager();        
        Query query = manager.createQuery(
                        "select n from NivelAcesso n where n.nomeModulo = :modulo and n.idColaborador = :idColaborador");
          query.setParameter("modulo", modulo);
          query.setParameter("idColaborador", idColaborador);
          
          List lista = query.getResultList();
          
          System.out.println("Tamanho da lista ="+lista.size());
          if (lista.size() > 0)
              return true;
          else            
             return false;
        
    }
     
     
     
//    public Produto produtoCodInterno(Long idColaborador){
//        manager = JPAUtil.getEntityManager();        
//        String jpql = "select n from NivelAcesso n where n.idColaborador = :idColaborador";
//        return this.manager
//        .createQuery(jpql, Produto.class)
//        .setParameter("idColaborador", idColaborador)
//        .getSingleResult();
//    } 
    
    
    
}
