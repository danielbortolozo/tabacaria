/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import br.com.adilson.util.PrinterMatrix;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import java.util.List;
import model.OrcamentoCab;
import model.OrcamentoDet;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import static movimentoView.OrcamentoCabView.jtfSubTotal;
import static movimentoView.OrcamentoCabView.jtfValorTotal;
import static movimentoView.VendaCabView.jcbCliente;

/**
 *
 * @author del
 */
public class ImpressaoMatricial {
    
    
     public void orcamentoCabMatricial(OrcamentoCab orcCab, List<Pessoa> listaCliente, int indexCliente) {
        OrcamentoCab orcamentoCab = new OrcamentoCab();
        orcamentoCab =  orcCab;        
        PessoaFisicaDAO daoPF = new PessoaFisicaDAO();
        PessoaJuridicaDAO daoPJ = new PessoaJuridicaDAO();
        //  PessoaJuridicaDAO daoPJ = new PessoaJuridicaDAO();
        Pessoa cliente = (Pessoa) listaCliente.get(indexCliente);
        
        PessoaFisica pf = new PessoaFisica();
        PessoaJuridica pj = new PessoaJuridica();
                     
        PrinterMatrix printer = new PrinterMatrix();
       
        //Define o tamanho do papel/tela para impressão, aqui 25 linhas e 80 colunas
        printer.setOutSize(25, 81);
        
        printer.printCharAtCol(1, 1, 80, "=");
        // printer.printCharAtCol(2,1,80, printer.centralizar(9, "Orcamento"));
        //printer.centralizar(8, "danielas");
        
        printer.printTextLinCol(2, 40, "ORÇAMENTO");
        printer.printCharAtCol(3, 1, 80, "=");
        
        printer.printTextLinCol(4, 1, "AUTO PEÇA PINHEIRO");
        printer.printTextLinCol(4, 30, "Tel. 3462-2889");
        printer.printTextLinCol(4, 57, "CNPJ:00.000.000/0001-00");
       
        printer.printTextLinCol(5, 1, "Cliente:"+cliente.getNome());
               
        if (cliente.getTipo().equals("F")){
            pf = daoPF.pessoaFisica(cliente.getId());
            printer.printTextLinCol(5, 57, "CPF:"+pf.getCpf());
        }   
        if (cliente.getTipo().equals("J")){
            pj = daoPJ.pessoaJuridica(cliente.getId());
            printer.printTextLinCol(5, 57, "CNPJ:"+pj.getCnpj());
        }
        
        printer.printCharAtCol(6, 1, 80,"-");
        printer.printTextLinCol(7, 1, "Itens");
        printer.printTextLinCol(7, 8, "Cód.Prod.");
        printer.printTextLinCol(7, 23, "Descrição");
        printer.printTextLinCol(7, 57, "QTD");
        printer.printTextLinCol(7, 62, "R$ Unit.");
        printer.printTextLinCol(7, 72, "R$ Total");
               
        printer.printCharAtCol(8, 1, 80, "-");
        Integer linha = 9;
        int cont = 1;
        for (OrcamentoDet det : orcamentoCab.getListOrcamentoDet()){
            printer.printTextLinCol(linha, 4, String.valueOf(cont));
            if (det.getProduto().getId() < 10)
                printer.printTextLinCol(linha, 10, "000"+String.valueOf(det.getProduto().getId()));
            if (det.getProduto().getId() > 9)
                printer.printTextLinCol(linha, 10, "00"+String.valueOf(det.getProduto().getId()));
            if (det.getProduto().getId() > 99)
                printer.printTextLinCol(linha, 10, "0"+String.valueOf(det.getProduto().getId()));
            if (det.getProduto().getId() > 999)
                printer.printTextLinCol(linha, 10, String.valueOf(det.getProduto().getId()));
            
            
            printer.printTextLinCol(linha, 20, det.getProduto().getDescricao());
            printer.printTextLinCol(linha, 57, String.valueOf(det.getQuantidade()));
            printer.printTextLinCol(linha, 65, String.valueOf(det.getVl_unitario()));
            printer.printTextLinCol(linha, 74, String.valueOf(det.getVl_total()));
            
            cont++;
            linha++;
        }
        
        printer.printCharAtCol(linha, 1, 80, "-");
        linha = linha+1;
        printer.printTextLinCol(linha, 40, "SubTotal:"+jtfSubTotal.getText());
        printer.printTextLinCol(linha, 65, "Total:"+jtfValorTotal.getText());
       
        printer.toFile("impressao.txt");
        String arg[] = {""};
        ImpressaoView.main(arg);
    }
    
    
    
    
    
    
}
