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
import model.PedidoCrediario;
import model.Pessoa;

/**
 *
 * @author daniel
 */
public class PedidoCrediarioDAO {
    
    EntityManager manager;
    
    public void salvar(PedidoCrediario pCrediario){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();       
        manager.merge(pCrediario);               
        tx.commit();        
        manager.close();         
    } 
    
    public List<PedidoCrediario> listaPedidoCrediarioTodos(){
        EntityManager manager = JPAUtil.getEntityManager();
        //EntityTransaction tx = manager.getTransaction();
       // tx.begin();
        List<PedidoCrediario> pedidos = manager.createQuery("from PedidoCrediario where status = 'ABERTO' order by dtVencimento", PedidoCrediario.class).getResultList();
        manager.close();
        return pedidos;
    }
    
    
    
    
    
    public List<PedidoCrediario> listaPedidoCrediarioPorCliente(Pessoa cliente){
        EntityManager manager = JPAUtil.getEntityManager();
        
        Query query = manager.createQuery(
                        "from PedidoCrediario pc where pc.idPedidoPagamento = null and pc.idPedido = :cliente");
          query.setParameter("cliente", cliente);
          PedidoCrediario p = new PedidoCrediario();
        //  p.getIdPedido().getCliente().getNome() = cliente.getNome();
          //List veiculos = query.getResultList();
         manager.close();
          return query.getResultList();
        
    }
    
    public PedidoCrediario pedidoCrediarioId(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
       //   EntityTransaction tx = manager.getTransaction();
      //  tx.begin();
        
        PedidoCrediario pc = manager.find(PedidoCrediario.class, id);
        
        manager.close();
        return pc;            
    }
    
    public List<PedidoCrediario> listaPorPeriodo(Date dtIni, Date dtFim) {
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT p FROM PedidoCrediario p WHERE p.dtVencimento BETWEEN :dtIni AND :dtFim and p.idPedidoPagamento = null order by p.dtVencimento";
        
        return this.manager.createQuery(jpql, PedidoCrediario.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
        
    }
    
}
