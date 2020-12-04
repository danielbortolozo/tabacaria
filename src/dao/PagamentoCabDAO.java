/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import model.PagamentoCab;
import model.PagamentoDet;

/**
 *
 * @author del
 */
public class PagamentoCabDAO {
    
    EntityManager manager;
    public void salvar(PagamentoCab pagtoCab ){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        
        try{
           tx.begin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com Banco de Dados :"+e.getMessage());
        }   
        try{  
           manager.persist(pagtoCab);
           if (pagtoCab.getListaPagamentoDet() != null){
              for (PagamentoDet pgtDet: pagtoCab.getListaPagamentoDet()){
                  pgtDet.setPagamentoCab(pagtoCab);
                  manager.persist(pgtDet);
              }
           }
           tx.commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Salvar Pagamento (DAO):"+e.getMessage());
        }finally{
            manager.close();    
        }            
    }
    
    public List<PagamentoCab> listaPgtCab(){
        EntityManager manager = JPAUtil.getEntityManager();
        //EntityTransaction tx = manager.getTransaction();
       // tx.begin();
        List<PagamentoCab> pgtcab = manager.createQuery("from PagamentoCab where status = 'ABERTO'", PagamentoCab.class).getResultList();
        manager.close();
        return pgtcab;
    }
    
    public PagamentoCab pagamentoCab(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
           tx.begin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com Banco de Dados :"+e.getMessage());
        }  
        PagamentoCab pgt = null;
        try{
            pgt = manager.find(PagamentoCab.class, id);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Pesquisar Conta à Pagar :"+e.getMessage());
            e.printStackTrace();
        }finally{
            manager.close();
        }
        return pgt;
        
    }
    public PagamentoDet pagamentoDet(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        try{
//           tx.begin();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, "Problemas de Conexão com Banco de Dados :"+e.getMessage());
//        }  
        PagamentoDet pgt = null;
        try{
            pgt = manager.find(PagamentoDet.class, id);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Pesquisar Detalhe de Conta à Pagar :"+e.getMessage());
            e.printStackTrace();
        }finally{
            manager.close();
        }
        return pgt;
        
    }
    public void alterar(PagamentoCab pgtCab, PagamentoDet pgtDet){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        
        try{
           tx.begin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com Banco de Dados :"+e.getMessage());
        }   
        try{  
           manager.merge(pgtCab);
           manager.merge(pgtDet);
           tx.commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Alterar Pagamento (DAO):"+e.getMessage());
        }finally{
            manager.close();    
        }            
    }
    
    public void excluirPagamento(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        PagamentoCab pgtCab = manager.find(PagamentoCab.class, id);
        
        manager.remove(pgtCab);
               
        
        tx.commit();
        manager.close();
    }
    
    public List<PagamentoDet> listaPorPeriodoDeVencimentoAPagar(Date dtIni, Date dtFim) {
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT p FROM PagamentoDet p WHERE p.vencimento BETWEEN :dtIni AND :dtFim and p.vl_pago = 0";
        return this.manager.createQuery(jpql, PagamentoDet.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
    }
    
    public List<PagamentoDet> listaPorPeriodoContasPaga(Date dtIni, Date dtFim) {
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT p FROM PagamentoDet p WHERE p.dt_pagamento BETWEEN :dtIni AND :dtFim ";
        return this.manager.createQuery(jpql, PagamentoDet.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
    }
    
    
    
    public Integer qtdParcelasPaga(Long id_pagtoCab){
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT count(pd)FROM PagamentoDet pd  WHERE pd.pagamentoCab = :idcab and pd.vencimento is not null";
                                                                   
        return this.manager.createQuery(jpql, Integer.class)
        .setParameter("idcab", id_pagtoCab)
        .getSingleResult();
    }
    
    
    public List<PagamentoCab> listarPagamentoPorFornecedor(Date dtIni, Date dtFim) {
        manager = JPAUtil.getEntityManager();
        List<PagamentoCab> pagamentos = null;
        try {
            Query query = manager.createQuery(
                    "Select p from PagamentoCab p  where p.emissao BETWEEN :data1 AND :data2 "
                            + "order by p.fornecedor.nome");
            query.setParameter("data1", dtIni);
            query.setParameter("data2", dtFim);
            
            pagamentos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return pagamentos;
    }
    
//    public List<PagamentoDet> listaPagamentoPorFornec(Date dtIni, Date dtFim) {
//        manager = JPAUtil.getEntityManager();
//        String jpql = "SELECT p FROM PagamentoCab p WHERE p.pagamento BETWEEN :dtIni AND :dtFim ";
//        return this.manager.createQuery(jpql, PagamentoDet.class)
//        .setParameter("dtIni", dtIni)
//        .setParameter("dtFim", dtFim)
//        .getResultList();
//    }
    
    
    
    
//    public double somaTotalAPagarMesCorrente(){
//        manager = JPAUtil.getEntityManager();
//        String jpql = "SELECT sum(pd.vl_parcela)FROM PagamentoDet pd  WHERE pd.pagamentoCab = :idcab and pd.vencimento is not null";
//                                                                   
//        return this.manager.createQuery(jpql, Integer.class)
//        //.setParameter("idcab", id_pagtoCab)
//        .getSingleResult();
//    }
    
    
    
    
    public double somaTotalAPagarMesCorrente(String mes) {
        manager = JPAUtil.getEntityManager();
        Query query = manager.createNativeQuery("select sum(pd.vl_parcela) from PagamentoDet pd "
         + "where to_char(pd.vencimento, 'MM') = :mes");
       // query.setParameter("mes", mes);
        return (Double) query.getSingleResult();
    }
    
//    String anoMes = "201304"; // SEU PARAMETRO
//String hql = "SELECT p FROM Pessoa AS p WHERE to_char(p.dataNascimento, 'YYYYMM') = :anoMes";
//Query query = em.createQuery(hql);
//query.setParameter("anoMes", anoMes);
    
}
