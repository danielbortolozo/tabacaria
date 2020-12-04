/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.CategoriaProduto;
import model.Produto;

/**
 *
 * @author daniel
 */
public class ProdutoDAO {
    private EntityManager manager;
    
    
    public void salvar(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();          
        manager.persist(produto);           
        tx.commit();
        manager.close();
    }    
    public List<Produto> listaProduto(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Produto> prod = manager.createQuery("from Produto order by descricao", Produto.class).getResultList();
        
        manager.close();
        return prod;
    }  
    public Produto produtoCodBarras(String codigo){
        manager = JPAUtil.getEntityManager();
        String jpql = "select p from Produto p where p.codBarras = :codBarras";
        return this.manager
        .createQuery(jpql, Produto.class)
        .setParameter("codBarras", codigo)
        .getSingleResult();
    }
    public Produto produtoCodInterno(String codigo){
        manager = JPAUtil.getEntityManager();        
        String jpql = "select p from Produto p where p.cod_interno = :codInterno";
        return this.manager
        .createQuery(jpql, Produto.class)
        .setParameter("codInterno", codigo)
        .getSingleResult();
    }
    
    public Produto produtoIdAtivo(Long id){
        manager = JPAUtil.getEntityManager();        
        String jpql = "select p from Produto p where p.id = :id and p.status=0";
        return this.manager
        .createQuery(jpql, Produto.class)
        .setParameter("id", id)
        .getSingleResult();
    }
    
    public List<Produto> produtoIdAtivoCategoria(CategoriaProduto categoria){
        manager = JPAUtil.getEntityManager();        
        String jpql = "select p from Produto p where p.status=0 "
                + "and p.categoria = :cat order by p.descricao";
        return this.manager
        .createQuery(jpql, Produto.class) 
        .setParameter("cat", categoria)        
        .getResultList();
    }
    
    
    
    public Produto produtoId(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        Produto produto = manager.find(Produto.class, id);
        manager.close();
        return produto;        
    }    
    public void alterar (Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();       
        manager.merge(produto);        
        tx.commit();
        manager.close();                       
    }    
    public List<Produto> listaProdutoStatus(int status) {
        manager = JPAUtil.getEntityManager();
        String jpql = "select p from Produto p where p.status = :status order by p.descricao";
        return this.manager
        .createQuery(jpql, Produto.class)
        .setParameter("status", status)
        .getResultList();
    }
    public List<Produto> listaProdutoStatusEstoqueMinimo(int status) {
        manager = JPAUtil.getEntityManager();
        String jpql = "select p from Produto p where p.status = :status and p.estoque_minimo >= p.estoque order by p.descricao";
        return this.manager
        .createQuery(jpql, Produto.class)
        .setParameter("status", status)
        .getResultList();
    }
    
    
    public List<Produto> listaProdutoAtivo(){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Produto> prod = manager.createQuery("from Produto  where status = 0 order by descricao", Produto.class).getResultList();
        
        manager.close();
        return prod;
    }
    
    public void excluir(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        Produto prod = manager.find(Produto.class, id);
        
        manager.remove(prod);
        
        tx.commit();
        manager.close();
    }
    
     public List<Object[]> listarProdutosEstoque() {
        List<Object[]> objects = null;
        try {               
            manager = JPAUtil.getEntityManager();            
            List<String> lista = new ArrayList();            
        
                                           
            Query query = manager.createNativeQuery(
                "select id, descricao, estoque, vl_compra as compra, vl_venda as venda,"
            + " (vl_venda - vl_compra)  as lucro, ( vl_compra * estoque) as valor_estoque_custo, \n" +
              " (vl_venda * estoque) as valor_estoque_venda, ( (vl_venda * estoque)- (vl_compra * estoque)) as valor_estoque_lucro from produto order by estoque desc");
            
            objects = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return objects;
    }
    
    
    
    
    
//    public List<Produto> relatorioProduto(int status, String estoqueMinimo, String todos){
//        EntityManager manager = JPAUtil.getEntityManager();
//        List<Produto> produtos = null;
//        if (estoqueMinimo.equals("sim") &&  todos.equals("nao")){
//            System.out.println(" entrei na query"+status);
//           Query query = manager.createNamedQuery("from Produto p where p.status = :status order by p.descricao ", Produto.class);
//           query.setParameter("status", status);
//           produtos = query.getResultList();
//        }   
//        
//        
//        return produtos;
//    }
    
//    public List<Produto> listaProdutoStatus(){
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        
//        List<Produto> prod = manager.createQuery("from Produto where status = :status order by descricao", Produto.class).getResultList();
//        
//        manager.close();
//        return prod;
//    } 

}
