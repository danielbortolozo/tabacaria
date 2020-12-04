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
import javax.swing.JOptionPane;
import model.OrcamentoCab;
import model.OrcamentoDet;

/**
 *
 * @author daniel
 */
public class OrcamentoCabDAO {
    
    //, List<OrcamentoDet> listOrcamentoDet
    public void salvar(OrcamentoCab orcamentoCab ){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        
        try{
           tx.begin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com Banco de Dados :"+e.getMessage());
        }   
        try{  
           manager.persist(orcamentoCab);
           if (orcamentoCab.getListOrcamentoDet() != null){
              for (OrcamentoDet orcDet: orcamentoCab.getListOrcamentoDet()){
                  orcDet.setOrcamentoCab(orcamentoCab);
                  manager.persist(orcDet);
              }
           }
             tx.commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Salvar Produto :"+e.getMessage());
        }finally{
            manager.close();    
        }            
    }
    
    public List<OrcamentoCab> listaOrcCabAberto(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<OrcamentoCab> orcCab = manager.createQuery("from OrcamentoCab ", OrcamentoCab.class).getResultList(); //where status = 'ABERTO' or status = 'PENDENTE'
        manager.close();
        return orcCab;
    }
    
    public OrcamentoCab orcamentoCab(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
           tx.begin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com Banco de Dados :"+e.getMessage());
        }  
        OrcamentoCab orc = null;
        try{
            orc = manager.find(OrcamentoCab.class, id);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Pesquisar Orcamento :"+e.getMessage());
            e.printStackTrace();
        }finally{
            manager.close();
        }
        return orc;
        
    }
    public void alteraStatusOrcamento(Long id, String status){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        OrcamentoCab orcCab = manager.find(OrcamentoCab.class, id);        
        orcCab.setStatus(status);
        manager.merge(orcCab);
        tx.commit();
        manager.close();
    }
    
    public void alterarOrcamento(OrcamentoCab orcCab){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.merge(orcCab);
        if (orcCab.getListOrcamentoDet() != null){
              for (OrcamentoDet orcDet: orcCab.getListOrcamentoDet()){
                  orcDet.setOrcamentoCab(orcCab);
                  manager.merge(orcDet);
              }
        }
               
        
        tx.commit();
        manager.close();
        
    }
    
    
    public void excluirOrcamento(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        OrcamentoCab orc = manager.find(OrcamentoCab.class, id);
        
        manager.remove(orc);
               
        
        tx.commit();
        manager.close();
    }
    
}
