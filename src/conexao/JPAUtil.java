/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class JPAUtil {
    
    private static EntityManagerFactory factory;
    static{
        try{
        factory = Persistence.createEntityManagerFactory("SisDBPU");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problema ao Criar Connexão com Banco de Dados :"+ e.getMessage());
            e.printStackTrace();
        }
    } 
    
    public static EntityManager getEntityManager(){
        
        return factory.createEntityManager();
       
    }
    
    
    
    public static void close(){
        factory.close();
    }
    
}
