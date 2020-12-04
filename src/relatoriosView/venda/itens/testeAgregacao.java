/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.itens;

import dao.PedidoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author daniel
 */
public class testeAgregacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        SimpleDateFormat sdfH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Date dtini = new Date();
    Date dtfim = new Date();
    String dtIniStr = sdf.format(dtini);
        String dtFimStr = sdf.format(dtfim);
        dtIniStr = dtIniStr+" 00:00:00";
        dtFimStr = dtFimStr+" 23:00:59";
        
        dtini = sdfH.parse(dtIniStr);
        dtfim = sdfH.parse(dtFimStr);
        PedidoDAO pDAO = new PedidoDAO();
        
        List<Object[]> resultado = pDAO.listaProdutoMaisVendido(dtini, dtfim );
        
        for (Object[] valores : resultado){
           
            System.out.println(valores[0]+ " - "+valores[1]+" - "+valores[2]+" - "+valores[3]+" - "+valores[4]+ " - "+valores[5]+" - "+valores[6]);
            
            
        }
        
        
        
        
        
    }
    
}
