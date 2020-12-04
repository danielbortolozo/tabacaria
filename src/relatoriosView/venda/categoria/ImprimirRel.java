/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.categoria;

import dao.CategoriaProdutoDAO;
import dao.EmpresaDAO;
import dao.PedidoDAO;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.CategoriaProduto;
import model.Empresa;
import model.PedidoItens;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author daniel
 */
public class ImprimirRel {
    
    
  //  private PedidoDAO pedidoDAO;
    private CategoriaProdutoDAO catDAO = new CategoriaProdutoDAO();
    Empresa empresa = new Empresa();
    EmpresaDAO empDAO = new EmpresaDAO();
    
    DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
    private void gerarRelatorioDesktop(JRDataSource jrds,Map<String, Object> parametros,  InputStream is) {
        try {
            JasperPrint print;
            print = JasperFillManager.fillReport(is, parametros, jrds);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void gerarRelatorioVendaPorCategoria(String categoria, String total, Date dtIni, Date dtFim, List<Object[]> objectsCategorias) {
        this.empresa = this.empDAO.getEmpresa();
        List listDados  = new ArrayList<>();
        
        for (Object[] objc : objectsCategorias){
            listDados.add(new VendaItensProdutoCategoria(objc[0].toString(), objc[1].toString(), objc[2].toString()));
        }
        
        HashMap param = new HashMap();
        String dataini=df.format(dtIni) ;
        String datafim=df.format(dtFim);
        
        param.put("dataini", dataini );
        param.put("datafim", datafim); 
        param.put("categoria", categoria);
        param.put("total", total);
        param.put("logo", empresa.getLogo());        
        param.put("empresa_telefone", empresa.getTelefone());
        param.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
        +" - "+empresa.getCidade()+" - "+empresa.getEstado());        
        param.put("empresa_nome", empresa.getNomeFantasia());
        param.put("empresa_cnpj", empresa.getCnpj());
        param.put("empresa_ie", empresa.getIe());      
                       
        InputStream is = getClass().getResourceAsStream("/relatoriosView/venda/categoria/relVendaProdutoPorCategoria.jasper");        
        JRDataSource jrds = new JRBeanCollectionDataSource(listDados);
       
        gerarRelatorioDesktop(jrds, param, is);         
   } 
    
    
}
