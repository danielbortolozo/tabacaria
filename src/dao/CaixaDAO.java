/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import graficosView.venda.GraficoVendasMes;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import model.Caixa;
import model.CaixaItens;
import model.Pessoa;

/**
 *
 * @author del
 */
public class CaixaDAO {
    EntityManager manager;
    
    public Caixa salvar(Caixa caixa) {
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(caixa);
//            for (CaixaItens itens : caixa.getCaixaItensList()) {
//                itens.setIdCaixa(caixa);
//                manager.persist(itens);
//            }
            tx.commit();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Gravar Caixa. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
        return caixa;
    }
    
    public void alterarCaixa(Caixa caixa){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();            
            manager.merge(caixa); 
            if (!caixa.getCaixaItensList().isEmpty()){
                for (CaixaItens itens : caixa.getCaixaItensList()){
                    manager.merge(itens);
                }
            }
            
            tx.commit();            
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Problemas ao Alterar Caixa. Error: "+ ex.getMessage());
        }finally{
            manager.close();
        }
    }
    
    
    
    public Caixa caixaId(Long id){        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Caixa caixa = manager.find(Caixa.class, id);
        
        manager.close();
        return caixa;            
    }
    
    public List<Caixa> caixaAbertoUsuario(Pessoa p){
        manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery(
                        "from Caixa where status = 'ABERTO' AND idUsuario = :Usuario");
          query.setParameter("Usuario", p);
          
          //List veiculos = query.getResultList();
         return query.getResultList();
        
    }
    public Caixa carregaCaixa(Pessoa p){
        manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery(
                        "from Caixa where status = 'ABERTO' AND idUsuario = :Usuario");
          query.setParameter("Usuario", p);
           
        return (Caixa) query.getSingleResult();
        
    }
    
    public List<Caixa> listaCaixaPorUsuario(Pessoa usuario) {
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM Caixa c WHERE c.idUsuario = :usuario order by dtAbertura desc";
        return this.manager.createQuery(jpql, Caixa.class)
        .setParameter("usuario", usuario)        
        .getResultList();
    }
    
    public List<Caixa> listaCaixaTodosUsuario() {
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM Caixa c ";
        return this.manager.createQuery(jpql, Caixa.class)            
        .getResultList();
    }
    
    
    public List<Object[]> listaPeriodoCaixaTotalEntrada(Date ini, Date fim){
        EntityManager manager = JPAUtil.getEntityManager();
        String jpql = "SELECT c.dt_cad, sum(i.vlEntrada) FROM Caixa c, CaixaItens i "
                + "WHERE i.idCaixa = c.id and c.dt_cad between :ini and :fim and i.tipo <> 'INICIAL' "
                + "group by dt_cad order by dt_cad" ;
        
         Query query = null;
        try{
           query = manager.createQuery(jpql, Object[].class);
           query.setParameter("ini", ini);
           query.setParameter("fim", fim); 
           return query.getResultList();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Problemas Pesquisa Grafico. Error: "+ ex.getMessage());
        }finally{
            manager.close();
        }
        return null;       
    }
    
    
//    public List<Object[]> listaPeriodoCaixaTotalEntrada(Date ini, Date fim){
//        EntityManager manager = JPAUtil.getEntityManager();
//        String jpql = "SELECT c.dt_cad, sum(c.totalEntrada) FROM Caixa c "
//                + "WHERE dt_cad between :ini and :fim group by dt_cad order by dt_cad" ;
//        Query query = manager.createQuery(jpql, Object[].class);
//        query.setParameter("ini", ini);
//        query.setParameter("fim", fim);
//        
//        return query.getResultList();       
//    } 
    
    
    
    
    
//    public void teste (Date ini, Date fim){
//      TypedQuery<Object[]> query = manager.createQuery(
//      "select p.dt_cad, sum(p.totalEntrada) from Caixa p "
//      + "where p.dt_cad between :ini and :fim group by p.dt_cad", Object[].class);
//       query.setParameter("ini", ini);
//        query.setParameter("fim", fim);
//       List<Object[]> resultado = query.getResultList();
//       
//       for (Object[] valores : resultado) {
//        System.out.println(valores[0] + " - " + valores[1]);
//        
//       }
//    }  
    
//    TypedQuery<Object[]> query = manager.createQuery(
//"select p.nome, count(v) from Proprietario p "
//+ "inner join p.veiculos v group by p.nome", Object[].class);
//List<Object[]> resultado = query.getResultList();
//for (Object[] valores : resultado) {
//System.out.println(valores[0] + " - " + valores[1]);
//}
    
    
//    public List<Caixa> listaCaixa(){
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        List<Caixa> p = manager.createQuery("from Caixa order by id", Pessoa.class).getResultList();
//        
//        return p;
//        
//    }
    
//    public Caixa caixaAbertoUsuario() {
//        manager = JPAUtil.getEntityManager();
//        String jpql = "SELECT c FROM Caixa c ";
//        return this.manager.createQuery(jpql, Caixa.class)
//       // .setParameter("idUsuario", pessoa)        
//        .getSingleResult();
//    }
    
    
    
    
    
    
    
}
