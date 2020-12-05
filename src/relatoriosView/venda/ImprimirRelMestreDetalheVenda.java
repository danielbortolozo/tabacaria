/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda;

import dao.EmpresaDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Empresa;
import model.Pedido;
import model.PedidoItens;
import model.PessoaFisica;
import model.PessoaJuridica;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.MascaraString;

/**
 *
 * @author daniel
 */
public class ImprimirRelMestreDetalheVenda {
    Empresa empresa = new Empresa();
    EmpresaDAO empDAO = new EmpresaDAO();
    DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");   
    MascaraString mascara = new MascaraString();

    
    public void relatorioMestreDetalhe(List<Pedido> pedidos, String dataIni, String dataFim) throws JRException{               
    List<VendaMaster> listaMaster = new ArrayList();
    List<VendaDetail> details;
    VendaMaster master;
    VendaDetail detail = new VendaDetail();
    this.empresa = this.empDAO.getEmpresa();
    int i = 0; 
    BigDecimal somaAPrazo = new BigDecimal(BigInteger.ZERO);
    master = new VendaMaster();
      
    for (Pedido p : pedidos){        
        details = new ArrayList();
        master.setIdVenda(p.getId());
        //sdf.format(venda.getVencimento())
        master.setData(df.format(p.getDtCad()));           
        master.setNome(p.getCliente().getNome());
         
        if (master.getNome().equals("ADMIN"))
           master.setNome("CONSUMIDOR");
           
        for (PedidoItens itens : p.getListaItens()){
                
            detail.setQtd(itens.getQuantidade().toString());
            detail.setProduto(itens.getProduto().getDescricao());
            detail.setVlunit(itens.getVlUnit().toString());
            detail.setTotal(itens.getVlSubtotal().toString());
                         
            details.add(new VendaDetail(detail.getQtd(), detail.getProduto(),
            detail.getVlunit(), detail.getTotal()));               
            somaAPrazo = somaAPrazo.add(new BigDecimal(detail.getTotal()));
        }
           
        if (p.getTipoVenda().equals("A VISTA")){
            master.setValor(p.getListaPagamento().get(0).getTotal().toString());           
            master.setDesconto(p.getListaPagamento().get(0).getDesconto().toString());
            master.setAcrescimo(p.getListaPagamento().get(0).getAcrescimo().toString());
        }else
            if (!p.getTipoVenda().equals("A VISTA")){
               master.setValor(somaAPrazo.toString());
               somaAPrazo = new BigDecimal(BigInteger.ZERO);
               master.setDesconto("0");
               master.setAcrescimo("0");       
            }          
        master.setItens(details);          
           //Adicionando as Venda na lista, já com os itens.
        listaMaster.add(new VendaMaster(master.getIdVenda(), master.getNome(),
        master.getData(), master.getValor(),master.getDesconto(), master.getAcrescimo(), master.getItens()));
    }
       
    HashMap param = new HashMap();        
    param.put("dataini", dataIni );
    param.put("datafim", dataFim);        
    param.put("logo", empresa.getLogo());
     
    param.put("empresa_telefone", empresa.getTelefone());
    param.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
    +" - "+empresa.getCidade()+" - "+empresa.getEstado());
      
    param.put("empresa_nome", empresa.getNomeFantasia());
    param.put("empresa_cnpj", empresa.getCnpj());
    param.put("empresa_ie", empresa.getIe());       
    param.put("totalVenda", listaMaster.size());
      
    InputStream is = getClass().getResourceAsStream("MestreDetalhe.jasper");              
     
    JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaMaster);
    JasperPrint jp = null;
    jp = JasperFillManager.fillReport(is, param, relat);
    JasperViewer jv = new JasperViewer(jp, false);
    jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
    jv.setVisible(true);       
}
    
    public void relatorioMestreDetalhe(List<Pedido> pedidos) throws JRException, ParseException {

        PessoaFisica pFisica = new PessoaFisica();
        PessoaFisicaDAO pFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridica pJuridica = new PessoaJuridica();
        PessoaJuridicaDAO pJuridicaDAO = new PessoaJuridicaDAO();
        
        
        List<VendaMaster> listaMaster = new ArrayList();
        List<VendaDetail> details;
        VendaMaster master;
        VendaDetail detail = new VendaDetail();
        this.empresa = this.empDAO.getEmpresa();
        int i = 0;
        BigDecimal somaAPrazo = new BigDecimal(BigInteger.ZERO);
        master = new VendaMaster();
        
        Pedido pedido = pedidos.get(0);
        String tipoCliente = pedido.getCliente().getTipo().toString();
           if (tipoCliente.equals("F")) {
              pFisica = pFisicaDAO.pessoaFisica(pedido.getCliente().getId());
              
              String cpf = pFisica.getCpf();
              cpf = mascara.formatarString(cpf, "###.###.###-##");
              master.setCpfCnpj(cpf);
           }else
               if (tipoCliente.equals("J")) {
                   pJuridica = pJuridicaDAO.pessoaJuridica(pedido.getCliente().getId());
                   String cnpj = pJuridica.getCnpj();
                   cnpj = mascara.formatarString(cnpj, "##.###.###/####-##");                   
                   master.setCpfCnpj(cnpj);
               }

        for (Pedido p : pedidos) {
            details = new ArrayList();
            master.setIdVenda(p.getId());
            //sdf.format(venda.getVencimento())
            master.setData(df.format(p.getDtCad()));
            master.setNome(p.getCliente().getNome());
            
          
           
            if (master.getNome().equals("ADMIN")) {
                master.setNome("CONSUMIDOR");
            }
            // TODO code application logic here

//           
            for (PedidoItens itens : p.getListaItens()) {

                detail.setQtd(itens.getQuantidade().toString());
                detail.setProduto(itens.getProduto().getDescricao());
                detail.setVlunit(itens.getVlUnit().toString());
                detail.setTotal(itens.getVlSubtotal().toString());

                details.add(new VendaDetail(detail.getQtd(), detail.getProduto(),
                        detail.getVlunit(), detail.getTotal()));
                somaAPrazo = somaAPrazo.add(new BigDecimal(detail.getTotal()));
            }

            if (!p.getTipoVenda().equals("A VISTA")) {
                master.setValor(somaAPrazo.toString());
                somaAPrazo = new BigDecimal(BigInteger.ZERO);
                master.setDesconto("0");
                master.setAcrescimo("0");
            } else if (p.getTipoVenda().equals("A VISTA")) {
                master.setValor(p.getListaPagamento().get(0).getTotal().toString());
                master.setDesconto(p.getListaPagamento().get(0).getDesconto().toString());
                master.setAcrescimo(p.getListaPagamento().get(0).getAcrescimo().toString());
            }

            master.setItens(details);

            //Adicionando as Venda na lista, já com os itens.
            listaMaster.add(new VendaMaster(master.getIdVenda(), master.getNome(),
            master.getData(), master.getValor(), master.getDesconto(), master.getAcrescimo(), master.getItens(), master.getCpfCnpj()));
        }

        HashMap param = new HashMap();

        //   param.put("dataini", dataIni );
        //    param.put("datafim", dataFim);
        param.put("logo", empresa.getLogo());

        param.put("empresa_telefone", empresa.getTelefone());
        param.put("empresa_endereco", empresa.getLogradouro() + " , " + empresa.getNumero() + " - " + empresa.getBairro()
                + " - " + empresa.getCidade() + " - " + empresa.getEstado());

        param.put("empresa_nome", empresa.getNomeFantasia());
        param.put("empresa_cnpj", empresa.getCnpj());
        param.put("empresa_ie", empresa.getIe());
        param.put("totalVenda", listaMaster.size());
       
        InputStream is = getClass().getResourceAsStream("MestreDetalhePorCliente.jasper");

        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaMaster);
        JasperPrint jp = null;
        jp = JasperFillManager.fillReport(is, param, relat);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true);

    }

}
