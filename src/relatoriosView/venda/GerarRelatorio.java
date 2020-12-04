/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author daniel
 */
public class GerarRelatorio {
    
   
public GerarRelatorio() {
super();
}
 
public static void main(String[] args) {
    
final String RELATORIO= "MestreDetalhe.jasper";
 
//autor 1
VendaMaster master1 = new VendaMaster();

   master1.setIdVenda(1);
   master1.setNome("Daniel");
   master1.setData("10/10/2018");
   master1.setValor("100,50");

 
List itens = new ArrayList();
 
VendaDetail detail1 = new VendaDetail();
detail1.setQtd("1");
detail1.setProduto("Rosca Doce");
detail1.setVlunit("10,00");
detail1.setTotal("10,00");

 
VendaDetail detail2 = new VendaDetail();
detail2.setQtd("2");
detail2.setProduto("Pao caseiro");
detail2.setVlunit("10,00");
detail2.setTotal("20,00");
 
itens.add(detail1);
itens.add(detail2);
 
master1.setItens(itens);

//autor1.setLivros(livros);
 
List listaVenda = new ArrayList();
 
//autor 2
VendaMaster master2 = new VendaMaster();

master2.setIdVenda(2);
master2.setNome("Rodrigo");
master2.setData("10/11/2018");
master2.setValor("200,50");
 
List itens2 = new ArrayList();
 
VendaDetail detail3 = new VendaDetail();
detail3.setQtd("2");
detail3.setProduto("Coca cola");
detail3.setVlunit("7");
detail3.setTotal("14");


VendaDetail detail4 = new VendaDetail();
detail4.setQtd("1");
detail4.setProduto("Mussarela");
detail4.setVlunit("2,50");
detail4.setTotal("2,50");

itens2.add(detail3);
itens2.add(detail4);
itens2.add(detail1);

master2.setItens(itens2);

listaVenda.add(master1);
listaVenda.add(master2);

//VendaDetail detail7 = new VendaDetail();
//VendaDetail det = new VendaDetail();
//for (Object d : master1.getItens()){
//    
//    det = (VendaDetail) d;
//    System.out.println("Produto"+det.getProduto());
//}

//master1.getItens().forEach((Object a) -> {
    //VendaDetail d = it.next();
    
//    System.out.println("produto ="+a.toString());
//    });
//    System.out.println("--------------------");
//master2.getItens().forEach((o) -> {
//    //VendaDetail d = it.next();
//    
//    System.out.println("produto ="+o.toString());
//    });
 
InputStream inpStream = GerarRelatorio.class.getResourceAsStream(RELATORIO);
JasperPrint print = null;
try {
HashMap param = new HashMap();
param.put("totalVenda", listaVenda.size());
print = JasperFillManager.fillReport(inpStream, param, new JRBeanCollectionDataSource(listaVenda));
} catch (JRException e) {
e.printStackTrace();
}
JasperViewer.viewReport(print);
 
}
}
    
    
    
    
    
    

