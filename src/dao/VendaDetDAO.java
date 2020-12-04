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
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import model.VendaDet;
import relatoriosView.ProdutosMaisVendidos;

/**
 *
 * @author del
 */
public class VendaDetDAO {
    
    
    public void excluir(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction  tx = manager.getTransaction();
        tx.begin();
        
        VendaDet vendaDet = manager.find(VendaDet.class, id);
        try {
            manager.remove(vendaDet);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            JOptionPane.showMessageDialog(null, "Problemas ao Excluir Produto da Venda"+e.getMessage());
            e.printStackTrace();
        }finally{
                 manager.close();
        }       
        
    }
    
    
    public List<ProdutosMaisVendidos> listaMaisVendidos(){
         EntityManager manager = JPAUtil.getEntityManager();         
         
         TypedQuery<ProdutosMaisVendidos> query = manager.createQuery("select new relatoriosView.ProdutosMaisVendidos"
                 + "(vd.produto.descricao, sum(vd.quantidade) as quantidade, sum(vd.vl_total))"
                 + " from VendaDet vd "
                 + " group by vd.produto.descricao order by quantidade desc ", ProdutosMaisVendidos.class);
         
         return query.getResultList();             
    }
 public List<ProdutosMaisVendidos> listaMaisVendidoss(Date dtini, Date dtfim){
         EntityManager manager = JPAUtil.getEntityManager();         
         
         TypedQuery<ProdutosMaisVendidos> query = manager.createQuery("select new relatoriosView.ProdutosMaisVendidos"
                 + "(vd.produto.descricao, sum(vd.quantidade) as quantidade, sum(vd.vl_total))"
                 + " from VendaDet vd, VendaCab vc where vc.id = vd.venda and vc.dt_cad between :dtini and :dtfim"
                 + " group by vd.produto.descricao order by quantidade desc ", ProdutosMaisVendidos.class);
         
         query.setParameter("dtini", dtini);
         query.setParameter("dtfim", dtfim);
         return query.getResultList();             
    }
     
    
    //Teste ************
//    public List<ProdutosMaisVendidos> listaProdutoMaisVendidoPorData(Date inicio, Date fim) {
//       EntityManager manager = JPAUtil.getEntityManager();
//        String jpql = "select new relatoriosView.ProdutosMaisVendidos"
//                 + "(vd.produto.descricao, sum(vd.quantidade) as quantidade, sum(vd.vl_total))"
//                 + " from VendaDet vd, VendaCab vc where vc.id = vd.venda and vc.dt_cad between :dtini and :dtfim "
//                 + " group by vd.produto.descricao order by quantidade desc ";
//        
//        return manager
//        .createQuery(jpql, ProdutosMaisVendidos.class)
//        .setParameter("dtini", inicio)
//        .setParameter("dtfim", fim)
//        .getResultList();
//    }
    
    
    
    
    
//    
//    public List<VendaDet> maisVendidos(){
//        EntityManager manager = JPAUtil.getEntityManager();         
//         
//         TypedQuery<VendaDet> query = manager.createQuery("select new model.VendaDet"
//                 + "(produto, count(quantidade), sum(vl_total))"
//                 + " from VendaDet vd group by produto", VendaDet.class);
//         
//         return query.getResultList();
//        
//    }
//    
//    
    
//   public static void main(final String[] args) {
//        // TODO code application logic here
//         /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//     
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                
//                VendaDetDAO dao = new VendaDetDAO();
//                
//                System.out.println("Lista ="+ dao.listaMaisVendidos().size());
//                
//                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                System.out.println("passeiii");
//            //    .setDataCadastro
//                Date dtini = null, dtfim = null;
//                
//                
//               
//                try {
//                    dtini = (new Date(sdf.parse("10/01/2017").getTime()));
//                    dtfim = (new Date(sdf.parse("15/05/2017").getTime()));
//////                    
////                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////                     Date dtini = null;
////                try {
////                    dtini = sdf.parse("27/01/2017");
////                } catch (ParseException ex) {
////                    Logger.getLogger(VendaDetDAO.class.getName()).log(Level.SEVERE, null, ex);
////                }
////                     Date dtfim = null;
////                try {
////                    dtfim = sdf.parse("15/05/2017");
////                } catch (ParseException ex) {
////                    Logger.getLogger(VendaDetDAO.class.getName()).log(Level.SEVERE, null, ex);
////                }
////
////              
////                     System.out.println("cheguei aqui");
//                  System.out.println("Lista ="+ dao.listaMaisVendidoss(dtini, dtfim).size());
//////                
//                for (ProdutosMaisVendidos p : dao.listaMaisVendidoss(dtini, dtfim)){
//                    
//                    System.out.println("Produto: "+p.getDescricao()+" Quantidade:"+p.getQuantidade()+" Total:"+p.getTotal());
//                }
////                
//                } catch (ParseException ex) {
//                    Logger.getLogger(VendaDetDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                
//            }
//        });
//    }  
//    
    
    
    
    
    
    
    
}
