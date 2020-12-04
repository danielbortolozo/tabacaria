/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.CaixaDAO;
import dao.CaixaItensDAO;
import dao.PessoaDAO;
import java.awt.AWTEvent;
import java.awt.Color;
import static java.awt.Color.YELLOW;
import java.awt.EventQueue;

import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Caixa;
import model.CaixaItens;
import model.Pessoa;
import org.apache.poi.hssf.util.HSSFColor;
import util.JTableFonteColunaDireitaAzul;
import util.JTableFonteColunaDireitaVermelha;



/**
 *
 * @author del
 */
public class CaixaVisaoView extends javax.swing.JDialog {

    /**
     * Creates new form CaixaView
     */
    private CaixaDAO caixaDAO = new CaixaDAO();
    private final CaixaItensDAO caixaItensDAO = new CaixaItensDAO();
    public static Caixa caixa = new Caixa();
    CaixaItens itensCaixa;
 //   private final Pessoa idUsuario;
    SimpleDateFormat sdfDH = new SimpleDateFormat("dd/MM/yyyy' - 'HH':'mm");
   // Toolkit toolkit = Toolkit.getDefaultToolkit();  
   // Dimension screenSize = toolkit.getScreenSize(); 
    Locale locale = new Locale("pt", "BR");
    GregorianCalendar calendar = new GregorianCalendar();
   // DefaultTableModel amodel;
    public CaixaVisaoView(java.awt.Frame parent, boolean modal, Long idCaixa) {
        super(parent, modal);
        initComponents();
        
      //  Long id = Long.parseLong(menuView.Menu.idColaborador);
      //  PessoaDAO pDAO = new PessoaDAO();
   //     idUsuario = pDAO.pessoa(id);
      
        carregaTable(idCaixa);        
        jbtFechaCaixa.setEnabled(false);
        jbtAlterar.setEnabled(false);
        
                
        
    }

    private void carregaTable(Long idCaixa) {
        try{
            caixa = caixaDAO.caixaId(idCaixa);
            
            jPanel1.setVisible(true);
            jPanel2.setVisible(true);
            
            
            if (caixa.getStatus().equals("FECHADO")){
                jlStatus.setVisible(true);
                jlStatus1.setVisible(false);
            }else
                if (caixa.getStatus().equals("ABERTO")){
                   jlStatus1.setVisible(true);
                   jlStatus.setVisible(false);
                }
            jlDataHoraAbert.setVisible(true);
            jlDataHoraAbert.setText(sdfDH.format(caixa.getDtAbertura()));
            
            System.out.println("Data fechamento ="+caixa.getDtFechamento());
            if (caixa.getDtFechamento() == null){
                jlDataHoraFechado.setVisible(false);
                jLabel19.setVisible(false);                
            }else{    
                
//                JOptionPane.showMessageDialog(null, "data null");
                  jlDataHoraFechado.setText(sdfDH.format(caixa.getDtFechamento()));
            }        
            jTextArea1.setText(caixa.getObs());                      
 
            DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
            amodel.setNumRows(0);
            String vlEntrada = null;
            float valorEntrada = 0;
            String vlSaida = null;
            String dataHoraStr = null;           
                       
            for (CaixaItens itens : caixa.getCaixaItensList()){
                if (itens.getTipo().equals("INICIAL")){
                    //  vlSaida = "";
                    jtfSaldoIni.setText(new DecimalFormat("#,##0.00").format((itens.getVlEntrada())));
                    jtfSaldoInicial.setText(jtfSaldoIni.getText());
                    jtfSaldoIni.setEnabled(false);
                }
                //Carregando a Jtable. 
                
                vlEntrada = itens.getVlEntrada().toString();                
                if (vlEntrada.equals("0.00"))
                    vlEntrada = "";
                else{
                    
                    //valorEntrada = Float.parseFloat(vlEntrada);
                    vlEntrada = new DecimalFormat("#,##0.00").format(itens.getVlEntrada());
                }
                
                vlSaida = itens.getVlSaida().toString();                
                if (vlSaida.equals("0.00"))
                    vlSaida = "";
                else{
                    vlSaida = new DecimalFormat("#,##0.00").format(itens.getVlSaida());
                }
                
                
                // dataHoraStr = sdfDH.format(itens.getDtHora());
                amodel.addRow(new Object[]{sdfDH.format(itens.getDtHora()), itens.getDescricao(),
                    vlEntrada, vlSaida, itens.getFormaPagto(), itens.getObs(), itens.getId()});                                 
            }
            
            //Coloca Fonte a Direita na cor Azul
            if (!vlEntrada.equals("0,00")){
                jTable1.getColumnModel().getColumn(2).setCellRenderer(new JTableFonteColunaDireitaAzul());    
            }
            //Coloca Fonte a Direita na cor Vermelha
            if (!vlSaida.equals("0,00")){
                jTable1.getColumnModel().getColumn(3).setCellRenderer(new JTableFonteColunaDireitaVermelha());
                
            }
            //Muda cor da Linha Selecionada na Jtable1.
            jTable1.setSelectionBackground( new Color(255,230,22) );
            //Altera cor da Fonte na linha selecionada.          
            jTable1.setSelectionForeground(Color.BLACK);
            //Adicionar Valores do Caixa
            //Entradas.
            jtfDinheiroEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getDinheiroEntrada()));
            jtfChequeEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getChequeEntrada()));
            jtfCartaoCredito.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoCredito()));
            jtfCartaoDebito.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoDebito()));
            jtfValeAlimentacao.setText(new DecimalFormat("#,##0.00").format(caixa.getValeAlimentacao()));
            jtfTotalEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getTotalEntrada()));
            
            //Saidas.
            jtfDinheiroSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getDinheiroSaida()));
            jtfChequeSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getChequeSaida()));
            jtfTotalSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getTotalSaida()));
            
            //Saldos.
            jtfSaldoDinheiro.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoDinheiro()));
            jtfSaldoFinal.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoFinal()));
            
            
            
            this.setBounds(0, 0, 970, 650);
            
            jbtAbrirCaixa.setEnabled(false);
            
       
        }catch(Exception e){
        
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
            //jPanel4.setVisible(false);
            jbtAlterar.setVisible(false);
            jbtExcluir.setVisible(false);
            jlStatus.setVisible(true);
            jlStatus1.setVisible(false);
            jlDataHoraAbert.setVisible(true);
            
            this.setBounds(0, 0, 200, 460);                
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jbtSair = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();
        jbtAlterar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfSaldoInicial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfDinheiroEntrada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfCartaoDebito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfCartaoCredito = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfChequeEntrada = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfValeAlimentacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfDinheiroSaida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfChequeSaida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfTotalEntrada = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jtfTotalSaida = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtfSaldoDinheiro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtfSaldoFinal = new javax.swing.JTextField();
        jbtFechaCaixa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jlStatus = new javax.swing.JLabel();
        jbtAbrirCaixa = new javax.swing.JButton();
        jlStatus1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jtfSaldoIni = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jlDataHoraAbert = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlDataHoraFechado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.setToolTipText("Sair ");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jbtExcluir.setText("Excluir Lançamento");
        jbtExcluir.setEnabled(false);
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jbtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jbtAlterar.setText("Adicinar Entrada / Saída");
        jbtAlterar.setToolTipText("Alterar Conta à Pagar");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jbtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtExcluir)
                        .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(java.awt.SystemColor.control);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumo"));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel1.setText("S. Inicial (Dinheiro):");

        jtfSaldoInicial.setEditable(false);
        jtfSaldoInicial.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jtfSaldoInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoInicial.setText("0,00");
        jtfSaldoInicial.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setText("(+) Todas Entradas");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel3.setText("Dinheiro:");

        jtfDinheiroEntrada.setEditable(false);
        jtfDinheiroEntrada.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfDinheiroEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfDinheiroEntrada.setText("0,00");
        jtfDinheiroEntrada.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel4.setText("Cartão-Débito:");

        jtfCartaoDebito.setEditable(false);
        jtfCartaoDebito.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfCartaoDebito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCartaoDebito.setText("0,00");
        jtfCartaoDebito.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel5.setText("Cartão-Crédito:");

        jtfCartaoCredito.setEditable(false);
        jtfCartaoCredito.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfCartaoCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCartaoCredito.setText("0,00");
        jtfCartaoCredito.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel6.setText("Cheque:");

        jtfChequeEntrada.setEditable(false);
        jtfChequeEntrada.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfChequeEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfChequeEntrada.setText("0,00");
        jtfChequeEntrada.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel7.setText("Vale Alimentação:");

        jtfValeAlimentacao.setEditable(false);
        jtfValeAlimentacao.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfValeAlimentacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfValeAlimentacao.setText("0,00");
        jtfValeAlimentacao.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setText("(-) Todas Saídas");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel9.setText("Dinheiro:");

        jtfDinheiroSaida.setEditable(false);
        jtfDinheiroSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfDinheiroSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfDinheiroSaida.setText("0,00");
        jtfDinheiroSaida.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel10.setText("Cheque:");

        jtfChequeSaida.setEditable(false);
        jtfChequeSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfChequeSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfChequeSaida.setText("0,00");
        jtfChequeSaida.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel11.setText("Total (No Caixa):");

        jtfTotalEntrada.setEditable(false);
        jtfTotalEntrada.setBackground(new java.awt.Color(132, 237, 218));
        jtfTotalEntrada.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jtfTotalEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfTotalEntrada.setText("0,00");
        jtfTotalEntrada.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel12.setText("Total (Saída):");

        jtfTotalSaida.setEditable(false);
        jtfTotalSaida.setBackground(new java.awt.Color(250, 158, 141));
        jtfTotalSaida.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jtfTotalSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfTotalSaida.setText("0,00");
        jtfTotalSaida.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 10)); // NOI18N
        jLabel13.setText("(=) Saldo(Inicial + Entrada - Saida)");

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel15.setText("Saldo (dinheiro):");

        jtfSaldoDinheiro.setEditable(false);
        jtfSaldoDinheiro.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfSaldoDinheiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoDinheiro.setText("0,00");
        jtfSaldoDinheiro.setFocusable(false);

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel16.setText("Saldo Final:");

        jtfSaldoFinal.setEditable(false);
        jtfSaldoFinal.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jtfSaldoFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoFinal.setText("0,00");
        jtfSaldoFinal.setFocusable(false);

        jbtFechaCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadeado2.png"))); // NOI18N
        jbtFechaCaixa.setText("Fechar Caixa [F3]");
        jbtFechaCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFechaCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfChequeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfValeAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfDinheiroSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfChequeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfDinheiroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfTotalEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfTotalSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfSaldoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfSaldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jbtFechaCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfDinheiroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfChequeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfValeAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtfTotalEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDinheiroSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfChequeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTotalSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSaldoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSaldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbtFechaCaixa))
        );

        jPanel2.setBackground(java.awt.SystemColor.control);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimentação do Caixa"));

        jTable1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data / Hora", "Descrição", "Entrada", "Saída", "Forma Pagto.", "Observação", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(115);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(145);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel3.setBackground(java.awt.SystemColor.control);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Status Caixa"));
        jPanel3.setNextFocusableComponent(jtfSaldoIni);

        jlStatus.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlStatus.setForeground(java.awt.Color.black);
        jlStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cxFechado.png"))); // NOI18N
        jlStatus.setText("FECHADO");
        jlStatus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jbtAbrirCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbtAbrirCaixa.setMnemonic('q');
        jbtAbrirCaixa.setText("Abrir - [F2]");
        jbtAbrirCaixa.setToolTipText("Abrir Caixa");
        jbtAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAbrirCaixaActionPerformed(evt);
            }
        });

        jlStatus1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlStatus1.setForeground(java.awt.Color.black);
        jlStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStatus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cxAberto.png"))); // NOI18N
        jlStatus1.setText("ABERTO");
        jlStatus1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel14.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 12)); // NOI18N
        jLabel14.setText("Saldo Inicial (Dinheiro)");

        jTextArea1.setColumns(5);
        jTextArea1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 10)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(4);
        jTextArea1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel17.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel17.setText("Observação");

        jtfSaldoIni.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfSaldoIni.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSaldoIniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSaldoIniKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 12)); // NOI18N
        jLabel18.setText("Data / Hora de Abertura");

        jlDataHoraAbert.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jlDataHoraAbert.setText("Data e Hora");

        jLabel19.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 12)); // NOI18N
        jLabel19.setText("Data / Hora de Fechamento");

        jlDataHoraFechado.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jlDataHoraFechado.setText("Data e Hora");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jlStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtAbrirCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jtfSaldoIni)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlDataHoraAbert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlDataHoraFechado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jlStatus1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSaldoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDataHoraAbert)
                .addGap(34, 34, 34)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDataHoraFechado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed
        CaixaLancamentoView cLanc = new CaixaLancamentoView(new java.awt.Frame(), true);
        cLanc.setTitle("Lançamentos Entrada/Saída");
        cLanc.setLocationRelativeTo(null); // centraliza a tela
        cLanc.setVisible(true);
        
    }//GEN-LAST:event_jbtAlterarActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
              
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir o Lançamento Selecionado?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
          //Tem que saber se é entrada ou saída. Se for diferente de 0, é entrada.
                      
            String entrada = String.valueOf(itensCaixa.getVlEntrada());
            String saida = String.valueOf(itensCaixa.getVlSaida());
           if (!entrada.equals("0.00")){
                //Tem que saber se é Dinheiro ou Cheque.
                if (itensCaixa.getFormaPagto().equals("DINHEIRO")){
                    caixa.setDinheiroEntrada(caixa.getDinheiroEntrada().subtract(itensCaixa.getVlEntrada()));
                    caixa.setTotalEntrada(caixa.getTotalEntrada().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoDinheiro(caixa.getSaldoDinheiro().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().subtract(itensCaixa.getVlEntrada()));
                }else
                    if (itensCaixa.getFormaPagto().equals("CHEQUE")){
                        caixa.setChequeEntrada(caixa.getChequeEntrada().subtract(itensCaixa.getVlEntrada()));
                        caixa.setTotalEntrada(caixa.getTotalEntrada().subtract(itensCaixa.getVlEntrada()));
                        caixa.setSaldoFinal(caixa.getSaldoFinal().subtract(itensCaixa.getVlEntrada()));
                    }               
            }
            //Senão. Se for Saída.
            else 
               if (!saida.equals("0.00")){
                   if (itensCaixa.getFormaPagto().equals("DINHEIRO")){
                    caixa.setDinheiroSaida(caixa.getDinheiroSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setTotalSaida(caixa.getTotalSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setSaldoDinheiro(caixa.getSaldoDinheiro().add(itensCaixa.getVlSaida()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().add(itensCaixa.getVlSaida()));
                }else
                    if (itensCaixa.getFormaPagto().equals("CHEQUE")){
                        caixa.setChequeSaida(caixa.getChequeSaida().subtract(itensCaixa.getVlSaida()));
                        caixa.setTotalSaida(caixa.getTotalSaida().subtract(itensCaixa.getVlSaida()));
                        caixa.setSaldoFinal(caixa.getSaldoFinal().add(itensCaixa.getVlSaida()));
                    }                
            }     
            
             //Excluir Iten do Caixa
            int idItensCaixa = (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 6);
            caixaItensDAO.excluir(idItensCaixa);
           
            //caixa.getCaixaItensList().clear();
            DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();        
            amodel.removeRow(jTable1.getSelectedRow());
            
            //Atualiza Caixa
            //Remover o Objeto da Lista do caixa, para poder altera objeto.
            caixa.setCaixaItensList(caixaItensDAO.listaCaixaItens(caixa));
                
            
            caixaDAO.alterarCaixa(caixa);
            
         
            //Carrega o Caixa novamente
            caixa = caixaDAO.caixaId(caixa.getId());
//            
//            
//            
//            //Alterar Caixa.
//           //
//            //Carrega Formulário Caixa.
            jtfDinheiroEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getDinheiroEntrada()));
            jtfChequeEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getChequeEntrada()));
            jtfTotalEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getTotalEntrada()));
            jtfDinheiroSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getDinheiroSaida()));
            jtfChequeSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getChequeSaida()));
            jtfTotalSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getTotalSaida()));
            jtfSaldoDinheiro.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoDinheiro()));
            jtfSaldoFinal.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoFinal()));
        
           
            
            JOptionPane.showMessageDialog(null, "Lançamento Excluído com Sucesso !!!");
            jbtExcluir.setEnabled(false);
        }        
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAbrirCaixaActionPerformed
        //Se o Caixa não está aberto, ou melhor, se a pesquisa for vazia, entao abra o caixa.
//        if (caixaDAO.caixaAbertoUsuario(idUsuario).isEmpty()){ 
//            Locale locale = new Locale("pt", "BR");
//            GregorianCalendar calendar = new GregorianCalendar();
//            SimpleDateFormat formatadorHD = new SimpleDateFormat("dd/MM/yyyy' - 'HH':'mm", locale);
//            SimpleDateFormat formatadorH = new SimpleDateFormat("HH':'mm", locale);
//            jlDataHora.setText(formatadorHD.format(calendar.getTime()));
//            jlDataHora.setVisible(true);
//            if (jtfSaldoIni.getText().equals("")) {
//                jtfSaldoIni.setText("0,00");
//            }else{
//                String saldoIni = jtfSaldoIni.getText().replace(",", ".");
//                jtfSaldoIni.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
//                jtfSaldoInicial.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
//                jtfTotalEntrada.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
//                jtfSaldoDinheiro.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
//                jtfSaldoFinal.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
//            }
//            if (jTextArea1.getText().equals("")) {
//                jTextArea1.setText("Aberto às " + formatadorH.format(calendar.getTime()) + "\nPor: " + menuView.Menu.nomeUsuario);
//            }            
//            //Este método salva caixa e itens do caixa, caixa inicial.
//            abrirCaixa();    
//            
//            DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();        
//            amodel.setNumRows(0);
//            String vlSaldoInicial;
//            
//            caixa = caixaDAO.caixaId(caixa.getId());
//            String saida = null;
//            for (CaixaItens itens : caixa.getCaixaItensList() ){           
//                 vlSaldoInicial = new DecimalFormat("#,##0.00").format(itens.getVlEntrada());           
//                 //Carregando a Jtable.
//                 saida = "";                 
//                 amodel.addRow(new Object[]{itens.getDtHora(), itens.getDescricao(), 
//                 vlSaldoInicial, saida, itens.getFormaPagto(), itens.getObs(), itens.getId()});                  
//            }       
//            DefaultTableCellRenderer coluna = new DefaultTableCellRenderer();
//            coluna.setForeground(Color.BLUE); // fonte azul
//            // coluna.setBackground(Color.YELLOW); // fundo amarelo            
//            jTable1.getColumnModel().getColumn(2).setCellRenderer(coluna); // usei a coluna 0 como exe                            
//        }       
//        jlStatus1.setVisible(true);
//        jlStatus.setVisible(false);
//        jPanel2.setVisible(true);
//        jPanel1.setVisible(true);
//        jPanel4.setVisible(true);
//        //Data e Hora.            
//        jtfSaldoIni.setEnabled(false);
//        jbtAbrirCaixa.setEnabled(false);
//        jbtAlterar.setVisible(true);
//        jbtExcluir.setVisible(true);
//
//        this.setBounds(0, 0, 970, 650);
//        
//        
//        if (javax.swing.JOptionPane.showConfirmDialog(null, "Agora você pode Sair e Abrir o Pedido de Venda. Sair do Caixa Agora? ", "Caixa Aberto com Sucesso.", javax.swing.JOptionPane.OK_OPTION) == 0) {
//            jbtSairActionPerformed(evt);
//        }
        
    }//GEN-LAST:event_jbtAbrirCaixaActionPerformed

//    private Caixa abrirCaixa (){        
//        Caixa cx = new Caixa();
//        CaixaItens itens = new CaixaItens();
//        try{
//        cx.setStatus("ABERTO");
//        cx.setDtAbertura(new Date());
//        cx.setIdUsuario(idUsuario);        
//        //Iniciando Entradas 
//        cx.setDinheiroEntrada(new BigDecimal(0.00));
//        cx.setCartaoDebito(new BigDecimal(0.00));
//        cx.setCartaoCredito(new BigDecimal(0.00));
//        cx.setChequeEntrada(new BigDecimal(0.00));
//        cx.setValeAlimentacao(new BigDecimal(0.00));
//        //Iniciando Saida
//        cx.setDinheiroSaida(new BigDecimal(0.00));
//        cx.setChequeSaida(new BigDecimal(0.00));
//        cx.setTotalSaida(BigDecimal.ZERO);
//        //Saldos
//        cx.setSaldoDinheiro(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
//        
//        cx.setTotalEntrada(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
//        cx.setSaldoFinal(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
//        jtfTotalEntrada.setText(jtfSaldoIni.getText());
//     //   cx.setTotalEntrada(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
//       
//        cx.setObs(jTextArea1.getText());
//        // Salvar Caixa.
//        caixa = caixaDAO.salvar(cx);
//        
//        //Caixa Itens.       
//        itens.setDtHora(new Date());
//        itens.setDescricao("SALDO INICIAL");
//        itens.setVlEntrada(new BigDecimal(jtfSaldoIni.getText().replace(",", ".")));
//        itens.setFormaPagto("DINHEIRO");
//        itens.setIdCaixa(caixa);
//        itens.setTipo("INICIAL");
//        itens.setPedido(null);
//        itens.setVlSaida(BigDecimal.ZERO);        
//        // Chamar a DAO Caixa, e da CaixaItens.       
//        caixaItensDAO.salvar(itens);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Problemas ao Carregar Novo Caixa.!!!"+e.getMessage());
//        }       
//        return caixa;
 //   }
    
//    private Caixa carregarCaixa(){
//        Caixa cx = new Caixa();
//        cx = caixaDAO.carregaCaixa(idUsuario);
//        
//        return 
//        
//    }
//    
    private void fechaCaixa(){
//       jlStatus1.setVisible(false);
//       jlStatus.setVisible(true);
//       jPanel2.setVisible(false);
//       jPanel1.setVisible(false);
//       jlDataHora.setVisible(false);
//       jTextArea1.setText("");
//       jbtAbrirCaixa.setEnabled(true);
//       jtfSaldoIni.setText("");
//       jbtAlterar.setVisible(false);
//       jbtExcluir.setVisible(false); 
//       this.setBounds(0, 0, 200, 420);
//       jtfSaldoIni.setEnabled(true);
       caixa.setStatus("FECHADO");
       caixa.setDtFechamento(calendar.getTime());
       caixaDAO.alterarCaixa(caixa);  
       JOptionPane.showMessageDialog(null, "CAIXA FECHADO COM SUCESSO !!!");
       jbtSairActionPerformed(null);
    }
    
    
    
    private void jbtFechaCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFechaCaixaActionPerformed
      
         if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente Fechar o Caixa?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {          
            
            fechaCaixa();            
        }
        
        
        
       
        //dialog.setPreferredSize(new Dimension(400,557));
    }//GEN-LAST:event_jbtFechaCaixaActionPerformed

    private void jtfSaldoIniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSaldoIniKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfSaldoIni.getText().equals(""))
               jtfSaldoIni.setText("0,00");
            jbtAbrirCaixa.requestFocus();
            
        }
    }//GEN-LAST:event_jtfSaldoIniKeyPressed

    private void jtfSaldoIniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSaldoIniKeyTyped
        String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfSaldoIniKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        itensCaixa  = new CaixaItens();
       // caixaDAO = new CaixaDAO();
        int idItensCaixa = (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 6);
        
        itensCaixa = caixaItensDAO.caixaId(idItensCaixa);
        if (itensCaixa.getTipo().equals("LANCAMENTO")){
            jbtExcluir.setEnabled(true);         
        }//Fim Lancamento      
        else{
            jbtExcluir.setEnabled(false);
        }
              
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
////        /* Create and display the dialog */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                CaixaView dialog = new CaixaView(new javax.swing.JFrame(), true);
////                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
////                    @Override
////                    public void windowClosing(java.awt.event.WindowEvent e) {
////                        System.exit(0);
////                    }
////                });
////                dialog.setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtAbrirCaixa;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtFechaCaixa;
    private javax.swing.JButton jbtSair;
    private javax.swing.JLabel jlDataHoraAbert;
    private javax.swing.JLabel jlDataHoraFechado;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlStatus1;
    private javax.swing.JTextField jtfCartaoCredito;
    private javax.swing.JTextField jtfCartaoDebito;
    public static javax.swing.JTextField jtfChequeEntrada;
    public static javax.swing.JTextField jtfChequeSaida;
    public static javax.swing.JTextField jtfDinheiroEntrada;
    public static javax.swing.JTextField jtfDinheiroSaida;
    public static javax.swing.JTextField jtfSaldoDinheiro;
    public static javax.swing.JTextField jtfSaldoFinal;
    private javax.swing.JTextField jtfSaldoIni;
    private javax.swing.JTextField jtfSaldoInicial;
    public static javax.swing.JTextField jtfTotalEntrada;
    public static javax.swing.JTextField jtfTotalSaida;
    private javax.swing.JTextField jtfValeAlimentacao;
    // End of variables declaration//GEN-END:variables
}
