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
public class CaixaView extends javax.swing.JDialog {

    /**
     * Creates new form CaixaView
     */
    private CaixaDAO caixaDAO = new CaixaDAO();
    private final CaixaItensDAO caixaItensDAO = new CaixaItensDAO();
    public static Caixa caixa = new Caixa();
    CaixaItens itensCaixa;
    private final Pessoa idUsuario;
    SimpleDateFormat sdfDH = new SimpleDateFormat("dd/MM/yyyy' - 'HH':'mm");
   // Toolkit toolkit = Toolkit.getDefaultToolkit();  
   // Dimension screenSize = toolkit.getScreenSize(); 
    Locale locale = new Locale("pt", "BR");
    GregorianCalendar calendar = new GregorianCalendar();
   // DefaultTableModel amodel;
    public CaixaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Long id = Long.parseLong(menuView.Menu.idColaborador);
        PessoaDAO pDAO = new PessoaDAO();
        idUsuario = pDAO.pessoa(id);
      
        carregaTable();        
     //   this.setBounds(550, 550, 900, 654);
//        EventQueue queue = new EventQueue(){
//           protected void dispatchEvent(final AWTEvent event){
//               super.dispatchEvent(event);
//               String a[];
//               String tecla[];
//               if (!event.paramString().equals("")){
//                  if (event.paramString().substring(0, 5).equals("KEY_P")){
//                      a = event.paramString().split(",");
//                      tecla = a[1].split("=");
//                      switch (Integer.parseInt(tecla[1])){
////                          case 112:
////                              
////                              JOptionPane.showMessageDialog(null, "F1");
////                              break;
//                          case 113: // = Tecla - F2
//                              jbtAbrirCaixaActionPerformed(null);
//                              break;
////                          case 114:
////                              JOptionPane.showMessageDialog(null, "F3");
////                              break;
////                          case 115:
////                              JOptionPane.showMessageDialog(null, "F4");
////                              break;
////                          case 116:
////                              JOptionPane.showMessageDialog(null, "F5");
////                              break;
////                          case 117: //F6 Cancela Item Generico
////                                {
////                               String item = JOptionPane.showInputDialog("Qual item deseja cancelar ?");
////                              // BemaECF.cancelaItemGenerico(item);
////                              // v.insereItemCancelado(item);
////                               break;
////                               }
////                          case 118: //F7 Cancela Último Item
////                            //  v.insereItemCancelado("Anterior");
////                             // BemaECF.cancelaItemAnterior();
////                              break;
////                          case 119:
////                              JOptionPane.showMessageDialog(null, "F8");
////                              break;
////                          case 120:
////                              JOptionPane.showMessageDialog(null, "F9");
////                              break;
////                          case 121: //F10 Desconto
////                             // v.vlrDesconto = JOptionPane.showInputDialog("Digite o valor do Desconto R$ ");
//
//
////                              break;
////                          case 122: //F11
////                             // JOptionPane.showMessageDialog(null, "F11");
////                            //  BemaECF.abreCupom();
////                              break;
////                          case 123:
////                           //   v.fechaCupom();
////                              break;
//                      }
//                  }
//               }
//           }
//       };
//       Toolkit.getDefaultToolkit().getSystemEventQueue().push(queue);
//        
        
        
        
    }

    private void carregaTable() {
        try{
            caixa = caixaDAO.carregaCaixa(idUsuario);
            
            jPanel1.setVisible(true);
            jPanel2.setVisible(true);
            jlStatus.setVisible(false);
            jlStatus1.setVisible(true);
            jlDataHora.setVisible(true);
            jlDataHora.setText(sdfDH.format(caixa.getDtAbertura()));
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
            jtfCartaoDebitoSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoDebitoSaida()));
            jtfCartaoCreditoSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoCreditoSaida()));
            jtfValeAlimentSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getValeAlimentacaoSaida()));
            
            jtfTotalSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getTotalSaida()));
            
            //Saldos.
            jtfSaldoDinheiro.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoDinheiro()));
            jtfSaldoCartaoCredito.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoCartaoCredito()));
            jtfSaldoCartaoDebito.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoCartaoDebito()));
            jtfSaldoCheque.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoCheque()));
            jtfSaldoValeAliment.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoValeAliment()));
            jtfSaldoFinal.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoFinal()));
            
            
            
           // this.setBounds(0, 0, 900, 550);  //(0, 0, 970, 650)
             
            jbtAbrirCaixa.setVisible(false);
            jbtSair.requestFocus();
            
       
        }catch(Exception e){
        
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
            //jPanel4.setVisible(false);
            jbtAlterar.setVisible(false);
            jbtExcluir.setVisible(false);
            jlStatus.setVisible(true);
            jlStatus1.setVisible(false);
            jlDataHora.setVisible(true);
            jbtAbrirCaixa.setVisible(true);
            
            this.setBounds(0, 0, 220, 560); //560                
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
        jlDataHora = new javax.swing.JLabel();
        jbtAlterar = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jbtFechaCaixa = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfSaldoInicial = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfDinheiroEntrada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfChequeEntrada = new javax.swing.JTextField();
        jtfTotalEntrada = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfValeAlimentacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCartaoCredito = new javax.swing.JTextField();
        jtfCartaoDebito = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jtfDinheiroSaida = new javax.swing.JTextField();
        jtfTotalSaida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfChequeSaida = new javax.swing.JTextField();
        jtfCartaoDebitoSaida = new javax.swing.JTextField();
        jtfCartaoCreditoSaida = new javax.swing.JTextField();
        jtfValeAlimentSaida = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtfSaldoFinal = new javax.swing.JTextField();
        jtfSaldoDinheiro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtfSaldoCartaoDebito = new javax.swing.JTextField();
        jtfSaldoCartaoCredito = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtfSaldoCheque = new javax.swing.JTextField();
        jtfSaldoValeAliment = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caixa");
        setBounds(new java.awt.Rectangle(550, 550, 800, 550));

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
        jbtAbrirCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtAbrirCaixaKeyPressed(evt);
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

        jlDataHora.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jlDataHora.setText("Data e Hora");

        jbtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jbtAlterar.setText("Entrada R$ / Saída R$");
        jbtAlterar.setToolTipText("Registra Entrada e Saída de Dinheiro");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });
        jbtAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtAlterarKeyPressed(evt);
            }
        });

        jbtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jbtExcluir.setText("Excluir Lançamento");
        jbtExcluir.setToolTipText("Excluir Registro de  Lançamento");
        jbtExcluir.setEnabled(false);
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });
        jbtExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtExcluirKeyPressed(evt);
            }
        });

        jbtFechaCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadeado2.png"))); // NOI18N
        jbtFechaCaixa.setText("Fechar Caixa [F3]");
        jbtFechaCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFechaCaixaActionPerformed(evt);
            }
        });
        jbtFechaCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtFechaCaixaKeyPressed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.setToolTipText("Sair ");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });
        jbtSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtSairKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jlStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jtfSaldoIni)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlDataHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jbtAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addComponent(jbtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtAbrirCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtFechaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jlDataHora)
                .addGap(18, 18, 18)
                .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtFechaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair)
                .addContainerGap(23, Short.MAX_VALUE))
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
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jScrollPane6.setEnabled(false);

        jPanel1.setBackground(java.awt.SystemColor.control);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumo"));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.activeCaption);
        jLabel1.setText("S. Inicial (Dinheiro):");

        jtfSaldoInicial.setEditable(false);
        jtfSaldoInicial.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jtfSaldoInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoInicial.setText("0,00");
        jtfSaldoInicial.setFocusable(false);

        jPanel5.setBackground(java.awt.SystemColor.control);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "( + ) Entradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), java.awt.Color.blue)); // NOI18N

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel5.setText("Cartão-Crédito");

        jtfDinheiroEntrada.setEditable(false);
        jtfDinheiroEntrada.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfDinheiroEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfDinheiroEntrada.setText("0,00");
        jtfDinheiroEntrada.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel6.setText("Pix");
        jLabel6.setToolTipText("");

        jtfChequeEntrada.setEditable(false);
        jtfChequeEntrada.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfChequeEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfChequeEntrada.setText("0,00");
        jtfChequeEntrada.setFocusable(false);

        jtfTotalEntrada.setEditable(false);
        jtfTotalEntrada.setBackground(new java.awt.Color(132, 237, 218));
        jtfTotalEntrada.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jtfTotalEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfTotalEntrada.setText("0,00");
        jtfTotalEntrada.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel7.setText("Vale Alimentação");

        jtfValeAlimentacao.setEditable(false);
        jtfValeAlimentacao.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfValeAlimentacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfValeAlimentacao.setText("0,00");
        jtfValeAlimentacao.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel3.setText("Dinheiro");

        jtfCartaoCredito.setEditable(false);
        jtfCartaoCredito.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfCartaoCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCartaoCredito.setText("0,00");
        jtfCartaoCredito.setFocusable(false);

        jtfCartaoDebito.setEditable(false);
        jtfCartaoDebito.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfCartaoDebito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCartaoDebito.setText("0,00");
        jtfCartaoDebito.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel11.setText("Total (No Caixa):");

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel4.setText("Cartão-Débito");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jtfDinheiroEntrada)
                    .addComponent(jtfCartaoDebito)
                    .addComponent(jtfCartaoCredito)
                    .addComponent(jtfChequeEntrada)
                    .addComponent(jtfValeAlimentacao)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfTotalEntrada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDinheiroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfChequeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValeAlimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTotalEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(java.awt.SystemColor.control);
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "( - ) Saídas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), java.awt.Color.red)); // NOI18N

        jtfDinheiroSaida.setEditable(false);
        jtfDinheiroSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfDinheiroSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfDinheiroSaida.setText("0,00");
        jtfDinheiroSaida.setFocusable(false);

        jtfTotalSaida.setEditable(false);
        jtfTotalSaida.setBackground(new java.awt.Color(250, 158, 141));
        jtfTotalSaida.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jtfTotalSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfTotalSaida.setText("0,00");
        jtfTotalSaida.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel12.setText("Total (Saída):");

        jtfChequeSaida.setEditable(false);
        jtfChequeSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfChequeSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfChequeSaida.setText("0,00");
        jtfChequeSaida.setFocusable(false);

        jtfCartaoDebitoSaida.setEditable(false);
        jtfCartaoDebitoSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfCartaoDebitoSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCartaoDebitoSaida.setText("0,00");
        jtfCartaoDebitoSaida.setFocusable(false);

        jtfCartaoCreditoSaida.setEditable(false);
        jtfCartaoCreditoSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfCartaoCreditoSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCartaoCreditoSaida.setText("0,00");
        jtfCartaoCreditoSaida.setFocusable(false);

        jtfValeAlimentSaida.setEditable(false);
        jtfValeAlimentSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfValeAlimentSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfValeAlimentSaida.setText("0,00");
        jtfValeAlimentSaida.setFocusable(false);
        jtfValeAlimentSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfValeAlimentSaidaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel8.setText("Dinheiro");

        jLabel25.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel25.setText("Cartão-Débito");

        jLabel26.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel26.setText("Cartão-Crédito");

        jLabel27.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel27.setText("Pix");

        jLabel28.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel28.setText("Vale Alimentação");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addComponent(jLabel27)
                    .addComponent(jLabel8)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfValeAlimentSaida)
                    .addComponent(jtfChequeSaida)
                    .addComponent(jtfCartaoCreditoSaida)
                    .addComponent(jtfCartaoDebitoSaida)
                    .addComponent(jtfDinheiroSaida)
                    .addComponent(jtfTotalSaida)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDinheiroSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCartaoDebitoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCartaoCreditoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfChequeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValeAlimentSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTotalSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(java.awt.SystemColor.control);
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "( = ) Saldo (Inicial + Entrada - Saida)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel15.setText("Saldo (Dinheiro):");

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel16.setText("Saldo Final:");

        jtfSaldoFinal.setEditable(false);
        jtfSaldoFinal.setBackground(java.awt.Color.yellow);
        jtfSaldoFinal.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jtfSaldoFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoFinal.setText("0,00");
        jtfSaldoFinal.setFocusable(false);

        jtfSaldoDinheiro.setEditable(false);
        jtfSaldoDinheiro.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfSaldoDinheiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoDinheiro.setText("0,00");
        jtfSaldoDinheiro.setFocusable(false);

        jLabel21.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel21.setText("Saldo (Cartão-Débito):");

        jLabel22.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel22.setText("Saldo (Cartão-Crédito):");

        jtfSaldoCartaoDebito.setEditable(false);
        jtfSaldoCartaoDebito.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfSaldoCartaoDebito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoCartaoDebito.setText("0,00");
        jtfSaldoCartaoDebito.setFocusable(false);

        jtfSaldoCartaoCredito.setEditable(false);
        jtfSaldoCartaoCredito.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfSaldoCartaoCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoCartaoCredito.setText("0,00");
        jtfSaldoCartaoCredito.setFocusable(false);

        jLabel23.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel23.setText("Saldo (Cheque):");

        jLabel24.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel24.setText("Saldo (Vale Alimentação):");

        jtfSaldoCheque.setEditable(false);
        jtfSaldoCheque.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfSaldoCheque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoCheque.setText("0,00");
        jtfSaldoCheque.setFocusable(false);

        jtfSaldoValeAliment.setEditable(false);
        jtfSaldoValeAliment.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfSaldoValeAliment.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSaldoValeAliment.setText("0,00");
        jtfSaldoValeAliment.setFocusable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSaldoFinal))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21)
                            .addComponent(jLabel15)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfSaldoCheque, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jtfSaldoCartaoCredito)
                            .addComponent(jtfSaldoCartaoDebito)
                            .addComponent(jtfSaldoDinheiro)
                            .addComponent(jtfSaldoValeAliment))
                        .addGap(0, 2, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtfSaldoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jtfSaldoCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jtfSaldoCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jtfSaldoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSaldoValeAliment, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSaldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtfSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(477, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1146, 699);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private Caixa abrirCaixa (){        
        Caixa cx = new Caixa();
        CaixaItens itens = new CaixaItens();
        try{
        cx.setStatus("ABERTO");
        cx.setDtAbertura(new Date()); //Data e Hora
        cx.setDt_cad(new Date());  //Data - Foi criada esta Data por causa do relatorio de grafico Faturamento Mes.
        cx.setIdUsuario(idUsuario);        
        //Iniciando Entradas 
        cx.setDinheiroEntrada(new BigDecimal(0.00));
        cx.setCartaoDebito(new BigDecimal(0.00));
        cx.setCartaoCredito(new BigDecimal(0.00));
        cx.setChequeEntrada(new BigDecimal(0.00));
        cx.setValeAlimentacao(new BigDecimal(0.00));
        //Iniciando Saida
        cx.setDinheiroSaida(new BigDecimal(0.00));
        cx.setChequeSaida(new BigDecimal(0.00));
        cx.setCartaoDebitoSaida(BigDecimal.ZERO);
        cx.setCartaoCreditoSaida(BigDecimal.ZERO);
        cx.setValeAlimentacaoSaida(BigDecimal.ZERO);
        cx.setTotalSaida(BigDecimal.ZERO);
        //Saldos
        cx.setSaldoDinheiro(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
        cx.setSaldoCartaoCredito(BigDecimal.ZERO);
        cx.setSaldoCartaoDebito(BigDecimal.ZERO);
        cx.setSaldoCheque(BigDecimal.ZERO);
        cx.setSaldoValeAliment(BigDecimal.ZERO);
        
        cx.setTotalEntrada(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
        cx.setSaldoFinal(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
        jtfTotalEntrada.setText(jtfSaldoIni.getText());
     //   cx.setTotalEntrada(new BigDecimal(jtfSaldoInicial.getText().replace(",", ".")));
       
        cx.setObs(jTextArea1.getText());
        // Salvar Caixa.
        caixa = caixaDAO.salvar(cx);
        
        //Caixa Itens.       
        itens.setDtHora(new Date());
        itens.setDescricao("SALDO INICIAL");
        itens.setVlEntrada(new BigDecimal(jtfSaldoIni.getText().replace(",", ".")));
        itens.setFormaPagto("DINHEIRO");
        itens.setIdCaixa(caixa);
        itens.setTipo("INICIAL");
//        itens.setPedido(null);
        itens.setVlSaida(BigDecimal.ZERO);        
        // Chamar a DAO Caixa, e da CaixaItens.       
        caixaItensDAO.salvar(itens);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao Carregar Novo Caixa.!!!"+e.getMessage());
        }       
        return caixa;
    }
    
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
      
        
        if (jtfSaldoFinal.getText().equals("0,00")){
            if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente Fechar o Caixa?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {          
               fechaCaixa();            
            }
        }else{
             JOptionPane.showMessageDialog(null, "O Saldo Final do Caixa tem que ser igual à Zero (0,00)");
             return;
        }
        
        
       
        //dialog.setPreferredSize(new Dimension(400,557));
    }//GEN-LAST:event_jbtFechaCaixaActionPerformed

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

    private void jbtFechaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtFechaCaixaKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtFechaCaixaActionPerformed(null);
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jbtFechaCaixaKeyPressed

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
              jbtSairActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSairKeyPressed

    private void jbtExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtExcluirKeyPressed
        if (evt.getKeyCode() ==  evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)){
                jbtExcluirActionPerformed(null);
            }

        }

    }//GEN-LAST:event_jbtExcluirKeyPressed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed

        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir o Lançamento Selecionado?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            //Tem que saber se é entrada ou saída. Se entrada for diferente de 0, é entrada.

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
                    caixa.setSaldoCheque(caixa.getSaldoCheque().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().subtract(itensCaixa.getVlEntrada()));
                }else
                if (itensCaixa.getFormaPagto().equals("CARTAO DEBITO")){
                    caixa.setCartaoDebito(caixa.getCartaoDebito().subtract(itensCaixa.getVlEntrada()));
                    caixa.setTotalEntrada(caixa.getTotalEntrada().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoCartaoDebito(caixa.getSaldoCartaoDebito().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().subtract(itensCaixa.getVlEntrada()));
                }else
                if (itensCaixa.getFormaPagto().equals("CARTAO CREDITO")){
                    caixa.setCartaoCredito(caixa.getCartaoCredito().subtract(itensCaixa.getVlEntrada()));
                    caixa.setTotalEntrada(caixa.getTotalEntrada().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoCartaoCredito(caixa.getSaldoCartaoCredito().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().subtract(itensCaixa.getVlEntrada()));
                }else
                if (itensCaixa.getFormaPagto().equals("VALE ALIMENTACAO")){
                    caixa.setValeAlimentacao(caixa.getValeAlimentacao().subtract(itensCaixa.getVlEntrada()));
                    caixa.setTotalEntrada(caixa.getTotalEntrada().subtract(itensCaixa.getVlEntrada()));
                    caixa.setSaldoValeAliment(caixa.getSaldoValeAliment().subtract(itensCaixa.getVlEntrada()));
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
                    caixa.setSaldoCheque(caixa.getSaldoCheque().add(itensCaixa.getVlSaida()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().add(itensCaixa.getVlSaida()));
                }else
                if (itensCaixa.getFormaPagto().equals("CARTAO DEBITO")){
                    caixa.setCartaoDebitoSaida(caixa.getCartaoDebitoSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setTotalSaida(caixa.getTotalSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setSaldoCartaoDebito(caixa.getSaldoCartaoDebito().add(itensCaixa.getVlSaida()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().add(itensCaixa.getVlSaida()));
                }else
                if (itensCaixa.getFormaPagto().equals("CARTAO CREDITO")){
                    caixa.setCartaoCreditoSaida(caixa.getCartaoCreditoSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setTotalSaida(caixa.getTotalSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setSaldoCartaoCredito(caixa.getSaldoCartaoCredito().add(itensCaixa.getVlSaida()));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().add(itensCaixa.getVlSaida()));
                }else
                if (itensCaixa.getFormaPagto().equals("VALE ALIMENTACAO")){
                    caixa.setValeAlimentacaoSaida(caixa.getValeAlimentacaoSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setTotalSaida(caixa.getTotalSaida().subtract(itensCaixa.getVlSaida()));
                    caixa.setSaldoValeAliment(caixa.getSaldoValeAliment().add(itensCaixa.getVlSaida()));
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
            //            //Alterar Caixa.
            //           //
            //            //Carrega Formulário Caixa.
            //Entradas
            jtfDinheiroEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getDinheiroEntrada()));
            jtfChequeEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getChequeEntrada()));
            jtfCartaoDebito.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoDebito()));
            jtfCartaoCredito.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoCredito()));
            jtfValeAlimentacao.setText(new DecimalFormat("#,##0.00").format(caixa.getValeAlimentacao()));
            jtfTotalEntrada.setText(new DecimalFormat("#,##0.00").format(caixa.getTotalEntrada()));

            //Saídas
            jtfDinheiroSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getDinheiroSaida()));
            jtfChequeSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getChequeSaida()));
            jtfCartaoDebitoSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoDebitoSaida()));
            jtfCartaoCreditoSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getCartaoCreditoSaida()));
            jtfValeAlimentSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getValeAlimentacaoSaida()));
            jtfTotalSaida.setText(new DecimalFormat("#,##0.00").format(caixa.getTotalSaida()));

            //Saldos
            jtfSaldoDinheiro.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoDinheiro()));
            jtfSaldoCheque.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoCheque()));
            jtfSaldoCartaoDebito.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoCartaoDebito()));
            jtfSaldoCartaoCredito.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoCartaoCredito()));
            jtfSaldoValeAliment.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoValeAliment()));

            jtfSaldoFinal.setText(new DecimalFormat("#,##0.00").format(caixa.getSaldoFinal()));

            JOptionPane.showMessageDialog(null, "Lançamento Excluído com Sucesso !!!");
            jbtExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtAlterarKeyPressed

        if (evt.getKeyCode() ==  evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)){
                jbtAlterarActionPerformed(null);
            }

        }
    }//GEN-LAST:event_jbtAlterarKeyPressed

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed
        CaixaLancamentoView cLanc = new CaixaLancamentoView(new java.awt.Frame(), true);
        cLanc.setTitle("Lançamentos Entrada/Saída");
        cLanc.setLocationRelativeTo(null); // centraliza a tela
        cLanc.setVisible(true);

    }//GEN-LAST:event_jbtAlterarActionPerformed

    private void jtfSaldoIniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSaldoIniKeyTyped
        String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_jtfSaldoIniKeyTyped

    private void jtfSaldoIniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSaldoIniKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfSaldoIni.getText().equals(""))
            jtfSaldoIni.setText("0,00");
            jbtAbrirCaixa.requestFocus();

        }
    }//GEN-LAST:event_jtfSaldoIniKeyPressed

    private void jbtAbrirCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtAbrirCaixaKeyPressed

        if (evt.getKeyCode() ==  evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)){
                jbtAbrirCaixaActionPerformed(null);
            }

        }
    }//GEN-LAST:event_jbtAbrirCaixaKeyPressed

    private void jbtAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAbrirCaixaActionPerformed
        //Se o Caixa não está aberto, ou melhor, se a pesquisa for vazia, entao abra o caixa.
        if (caixaDAO.caixaAbertoUsuario(idUsuario).isEmpty()){
            Locale locale = new Locale("pt", "BR");
            GregorianCalendar calendar = new GregorianCalendar();
            SimpleDateFormat formatadorHD = new SimpleDateFormat("dd/MM/yyyy' - 'HH':'mm", locale);
            SimpleDateFormat formatadorH = new SimpleDateFormat("HH':'mm", locale);
            jlDataHora.setText(formatadorHD.format(calendar.getTime()));
            jlDataHora.setVisible(true);
            if (jtfSaldoIni.getText().equals("")) {
                jtfSaldoIni.setText("0,00");
            }else{
                String saldoIni = jtfSaldoIni.getText().replace(",", ".");
                jtfSaldoIni.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
                jtfSaldoInicial.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
                jtfTotalEntrada.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
                jtfSaldoDinheiro.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
                jtfSaldoFinal.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(saldoIni)));
            }
            if (jTextArea1.getText().equals("")) {
                jTextArea1.setText("Aberto às " + formatadorH.format(calendar.getTime()) + "\nPor: " + menuView.Menu.nomeUsuario);
            }
            //Este método salva caixa e itens do caixa, caixa inicial.
            abrirCaixa();

            DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
            amodel.setNumRows(0);
            String vlSaldoInicial;

            caixa = caixaDAO.caixaId(caixa.getId());
            String saida = null;
            for (CaixaItens itens : caixa.getCaixaItensList() ){
                vlSaldoInicial = new DecimalFormat("#,##0.00").format(itens.getVlEntrada());
                //Carregando a Jtable.
                saida = "";
                amodel.addRow(new Object[]{itens.getDtHora(), itens.getDescricao(),
                    vlSaldoInicial, saida, itens.getFormaPagto(), itens.getObs(), itens.getId()});
        }
        DefaultTableCellRenderer coluna = new DefaultTableCellRenderer();
        coluna.setForeground(Color.BLUE); // fonte azul
        // coluna.setBackground(Color.YELLOW); // fundo amarelo
        jTable1.getColumnModel().getColumn(2).setCellRenderer(coluna); // usei a coluna 0 como exe
        }
        jlStatus1.setVisible(true);
        jlStatus.setVisible(false);
        jPanel2.setVisible(true);
        jPanel1.setVisible(true);
        //        jPanel4.setVisible(true);
        //Data e Hora.
        jtfSaldoIni.setEnabled(false);
        jbtAbrirCaixa.setEnabled(false);
        jbtAlterar.setVisible(true);
        jbtExcluir.setVisible(true);
        jbtAbrirCaixa.setVisible(false);

        this.setBounds(0, 0, 1200, 850);

        if (javax.swing.JOptionPane.showConfirmDialog(null, "Agora você pode Sair e Abrir o Pedido de Venda. Sair do Caixa Agora? ", "Caixa Aberto com Sucesso.", javax.swing.JOptionPane.OK_OPTION) == 0) {
            jbtSairActionPerformed(evt);
        }

    }//GEN-LAST:event_jbtAbrirCaixaActionPerformed

    private void jtfValeAlimentSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfValeAlimentSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfValeAlimentSaidaActionPerformed

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtAbrirCaixa;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtFechaCaixa;
    private javax.swing.JButton jbtSair;
    private javax.swing.JLabel jlDataHora;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlStatus1;
    public static javax.swing.JTextField jtfCartaoCredito;
    public static javax.swing.JTextField jtfCartaoCreditoSaida;
    public static javax.swing.JTextField jtfCartaoDebito;
    public static javax.swing.JTextField jtfCartaoDebitoSaida;
    public static javax.swing.JTextField jtfChequeEntrada;
    public static javax.swing.JTextField jtfChequeSaida;
    public static javax.swing.JTextField jtfDinheiroEntrada;
    public static javax.swing.JTextField jtfDinheiroSaida;
    public static javax.swing.JTextField jtfSaldoCartaoCredito;
    public static javax.swing.JTextField jtfSaldoCartaoDebito;
    public static javax.swing.JTextField jtfSaldoCheque;
    public static javax.swing.JTextField jtfSaldoDinheiro;
    public static javax.swing.JTextField jtfSaldoFinal;
    private javax.swing.JTextField jtfSaldoIni;
    public static javax.swing.JTextField jtfSaldoInicial;
    public static javax.swing.JTextField jtfSaldoValeAliment;
    public static javax.swing.JTextField jtfTotalEntrada;
    public static javax.swing.JTextField jtfTotalSaida;
    public static javax.swing.JTextField jtfValeAlimentSaida;
    public static javax.swing.JTextField jtfValeAlimentacao;
    // End of variables declaration//GEN-END:variables
}
