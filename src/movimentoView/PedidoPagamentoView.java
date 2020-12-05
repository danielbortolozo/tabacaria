/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.CaixaDAO;
import dao.CashBackDAO;
import dao.ClienteDAO;
import dao.PedidoCrediarioDAO;
import dao.PedidoDAO;
import dao.PedidoPagamentoDAO;
import dao.TipoPagamentoDAO;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Caixa;
import model.CaixaItens;
import model.CashBack;
import model.Cliente;
import model.Pedido;
import model.PedidoCrediario;
import model.PedidoPagamento;
import model.PedidoPagamentoItens;
import model.Pessoa;

import model.TipoPagamento;
import relatoriosView.ImprimeRelatorio;

/**
 *
 * @author daniel
 */
public class PedidoPagamentoView extends javax.swing.JDialog {

    /**
     * Creates new form PedidoPagamentoView
     */
    List<TipoPagamento> listaTipoPagamento;
    TipoPagamentoDAO tipoPagDAO;
    List<PedidoPagamentoItens> listaItensPag = new ArrayList<PedidoPagamentoItens>();
    GregorianCalendar calendar = new GregorianCalendar();
    SimpleDateFormat formatadorHD = new SimpleDateFormat("dd/MM/yyyy' - 'HH':'mm");
    Locale locale = new Locale("pt", "BR");
    String tipoPagamento, tipoPedido;
    String subTotal = "0";
    PedidoCrediarioDAO pCrediarioDao = new PedidoCrediarioDAO();
    PedidoPagamentoDAO pPedPagDao = new PedidoPagamentoDAO();
    PedidoPagamento pedPag;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dtPagamento = new Date();
    
    
    public PedidoPagamentoView(java.awt.Frame parent, boolean modal, String tipoPedido) {
        super(parent, modal);
        initComponents();
        carregarCombobox();
        jcbFormaPagto.setEnabled(false);
      //  jcbFormaPagto.setEnabled(true);
        this.tipoPedido = tipoPedido;
        jtfAcrescimos.setEnabled(true);                
        if (tipoPedido.equals("BALCAO1"))
           jLabel1.setText(PedidoView1.jtfSubTotal.getText());           
        else
            if (tipoPedido.equals("BALCAO")){
                jLabel1.setText(PedidoView.jtfSubTotal.getText());
                jtfRestante.setText(jLabel1.getText());
                pedPag = new PedidoPagamento();
                jtfAcrescimos.requestFocus();
            }else
            if (tipoPedido.equals("DELIVERY")){
                jLabel1.setText(PedidoDeliveryView.jtfSubTotal.getText());
                jtfRestante.setText(jLabel1.getText());
                pedPag = new PedidoPagamento();
                jtfAcrescimos.requestFocus();
            }else
                if (tipoPedido.equals("FIADO")){
                    //System.out.println("passei aqui");                   
                   jLabel1.setText(PedidoRecebeFiadoView.vlTotalStr);
                   jtfRestante.setText(jLabel1.getText());
                   pedPag = new PedidoPagamento();
                   jtfAcrescimos.requestFocus();
                }else
                    if (tipoPedido.equals("CREDIARIO")){
                      //  pedPag = new PedidoPagamento();
                        jLabel1.setText(PedidoRecebeCrediarioView.vlTotalStr);
                       // System.out.println("Pedido id ="+PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido().getId());
                       // System.out.println("pedido Pagamento ="+PedidoRecebeCrediarioView.pedidoCrediario.getIdPedidoPagamento().getId());
                        if (PedidoRecebeCrediarioView.pedidoCrediario.getIdPedidoPagamento() == null){
                           pedPag = new PedidoPagamento();
                           jtfRestante.setText(jLabel1.getText());
                          // pedPag.setPedido(PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido());
                           jtfAcrescimos.requestFocus();
                        }else{
                            
                             pedPag = pPedPagDao.pedidoPagamentoID(PedidoRecebeCrediarioView.pedidoCrediario.getIdPedidoPagamento().getId());
                             
                             jLabel1.setText(new DecimalFormat("#,##0.00").format(pedPag.getTotal()));
                             jtfAcrescimos.setText(pedPag.getAcrescimo().toString());
                             jtfDesconto.setText(pedPag.getDesconto().toString());
                             listaItensPag = pedPag.getListaPagamentoItens();
                             jtfRestante.setText(new DecimalFormat("#,##0.00").format(pedPag.getTroco()));
                             if (jtfAcrescimos.getText().equals("0.00"))
                                 jtfAcrescimos.setText("");
                             
                             if (pedPag.getAcrescimo().signum() > 0 || pedPag.getDesconto().signum() > 0){
                                jtfAcrescimos.setEnabled(false);
                                jtfDesconto.setEnabled(false);
                                jcbFormaPagto.setEnabled(true);
                                jcbFormaPagto.requestFocus();
                             }
                             carregaTable();
                        }     
                    }
        
        
        subTotal = jLabel1.getText();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jbtFinalizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jcbFormaPagto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtfVlRecebido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfRestante = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfAcrescimos = new javax.swing.JTextField();
        jtfDesconto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbCashBack = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbtFinalizar.setText("Finalizar");
        jbtFinalizar.setEnabled(false);
        jbtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFinalizarActionPerformed(evt);
            }
        });
        jbtFinalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtFinalizarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jbtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de Pagamento"));

        jcbFormaPagto.setEnabled(false);
        jcbFormaPagto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbFormaPagtoKeyPressed(evt);
            }
        });

        jLabel6.setText("R$ Valor Recebido - eu");

        jtfVlRecebido.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jtfVlRecebido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfVlRecebido.setEnabled(false);
        jtfVlRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfVlRecebidoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfVlRecebidoKeyPressed(evt);
            }
        });

        jLabel7.setText("R$ Valor Restante");

        jtfRestante.setEditable(false);
        jtfRestante.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jtfRestante.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfRestante.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfVlRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfRestante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfVlRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Total do Pedido"));

        jLabel2.setText("Acréscimos");

        jtfAcrescimos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfAcrescimos.setEnabled(false);
        jtfAcrescimos.setNextFocusableComponent(jButton2);
        jtfAcrescimos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAcrescimosKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfAcrescimosKeyPressed(evt);
            }
        });

        jtfDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfDesconto.setEnabled(false);
        jtfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoActionPerformed(evt);
            }
        });
        jtfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDescontoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescontoKeyTyped(evt);
            }
        });

        jLabel3.setText("Descontos");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(17, 17, 243));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("jLabel1");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        jLabel4.setText("R$");

        jLabel5.setText("R$");

        jcbCashBack.setText("Cash Back ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfAcrescimos, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jcbCashBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfAcrescimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jcbCashBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Forma Pagamento", "R$ Valor", "Data Pagamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAcrescimosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAcrescimosKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            
            if (jtfAcrescimos.getText().equals("") || jtfAcrescimos.getText().equals("0")){
                jtfAcrescimos.setText("0.0");                           
                jLabel1.setText(subTotal);
                
                 if (pedPag.getId() != null){                    
                    jtfRestante.setText(new DecimalFormat("#,##0.00").format(pedPag.getTroco()));
                }else
                    jtfRestante.setText(subTotal);
                jtfDesconto.setEnabled(true);
                jtfDesconto.setText("");
                jtfDesconto.requestFocus();
            }else{
                //Calcular Acrescimo.                
                String acrescimoStr = jtfAcrescimos.getText();
                String vltotalStr = jLabel1.getText();
                vltotalStr = vltotalStr.replace(",", ".");
                acrescimoStr = acrescimoStr.replace(",", ".");                
                double acrecimo = Double.parseDouble(acrescimoStr);
                double vltotal = Double.parseDouble(vltotalStr);
                vltotal = (vltotal + acrecimo);
                jLabel1.setText(new DecimalFormat("#,##0.00").format(vltotal));
                
               
                if (pedPag.getId() != null){
                    BigDecimal acrescimoBig = new BigDecimal(0);
                    double vlrestante = Double.parseDouble(pedPag.getTroco().toString());
                  
                    BigDecimal totalBig;
                    totalBig = new BigDecimal(vltotal + acrecimo);
                    pedPag.setTotal(totalBig);
                   //acrescimoBig.add(new BigDecimal(acrescimoStr));
                   acrescimoBig = new BigDecimal(vlrestante + acrecimo);
                   
                    pedPag.setTroco(acrescimoBig);
                  // pedPag.setTroco(acrescimoBig.add(new BigDecimal(pedPag.getTroco())));
                    jtfRestante.setText(new DecimalFormat("#,##0.00").format(pedPag.getTroco()));
                }else
                   jtfRestante.setText(jLabel1.getText());
                
                jtfDesconto.setText("0.0");
                jcbFormaPagto.setEnabled(true);
                jcbFormaPagto.requestFocus();                                      
            }
        }
    }//GEN-LAST:event_jtfAcrescimosKeyPressed

     private  void carregaTable(){
        DefaultTableModel amodel1 = (DefaultTableModel) jTable1.getModel();
         amodel1.setNumRows(0);
         
                            
       for (PedidoPagamentoItens o : listaItensPag){
           //dtPagamento = o.getDtPagamento();
           amodel1.addRow(new Object[]{o.getTipoPagamento().getDescricao(), o.getValor().toString(), formatadorHD.format(o.getDtPagamento())});                   
        }
 
      
    }  
      
        
                    
    
    
    private void jtfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfDesconto.getText().equals("") || (jtfDesconto.getText().equals("0")
                    || (jtfDesconto.getText().equals("0.0")))){
                jtfDesconto.setText("0,0");
                jLabel1.setText(subTotal);
                
                 
                 if (pedPag.getId() != null){                    
                    jtfRestante.setText(new DecimalFormat("#,##0.00").format(pedPag.getTroco()));
                }else
                    jtfRestante.setText(subTotal);
                
                
                
            }else{
                //Calcular o desconto. 
                String descontoStr = jtfDesconto.getText();
                String vltotalStr = jLabel1.getText();
                vltotalStr = vltotalStr.replace(",", ".");
                descontoStr = descontoStr.replace(",", ".");
                
                double desconto = Float.parseFloat(descontoStr);
                double vltotal = Float.parseFloat(vltotalStr);
                vltotal = (vltotal -  desconto);
                jLabel1.setText(new DecimalFormat("#,##0.00").format(vltotal));
                
                
                if (pedPag.getId() != null){
                    BigDecimal descontoBig = new BigDecimal(0);
                    double vlrestante = Double.parseDouble(pedPag.getTroco().toString());
                  
                    BigDecimal totalBig;
                    totalBig = new BigDecimal(desconto - vltotal);
                    pedPag.setTotal(totalBig);
                   //acrescimoBig.add(new BigDecimal(acrescimoStr));
                   descontoBig = new BigDecimal(vlrestante - desconto);
                   
                    pedPag.setTroco(descontoBig);
                  // pedPag.setTroco(acrescimoBig.add(new BigDecimal(pedPag.getTroco())));
                    jtfRestante.setText(new DecimalFormat("#,##0.00").format(pedPag.getTroco()));
                }else
                   jtfRestante.setText(jLabel1.getText());
                
                jtfAcrescimos.setEnabled(false);
                jtfDesconto.setEnabled(false);
                
                
                
                
                
            }
            jcbFormaPagto.setEnabled(true);
            jcbFormaPagto.requestFocus();
        }
    }//GEN-LAST:event_jtfDescontoKeyPressed

    private void jtfAcrescimosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAcrescimosKeyTyped
        String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfAcrescimosKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (tipoPedido.equals("FIADO"))
            PedidoRecebeFiadoView.jrbTodos.doClick();
        else
            if (tipoPedido.equals("BALCAO")){
               //PedidoView.jtfCliente.setText("");
               PedidoView.jtfCodProd.requestFocus();
               PedidoView.pedidoPagView = null;
            }   
            else
            if (tipoPedido.equals("BALCAO1")){
               PedidoView1.jcbCliente.setSelectedIndex(0);
               PedidoView1.jcbCliente.requestFocus();
            } 
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcbFormaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbFormaPagtoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jcbFormaPagto.getSelectedIndex() > -1){
                jtfVlRecebido.setEnabled(true);
                tipoPagamento = jcbFormaPagto.getSelectedItem().toString();
                
                if (tipoPedido.equals("CREDIARIO")){
                                       
                    if (tipoPagamento.equals("CREDIARIO")){
                        JOptionPane.showMessageDialog(null, "Este tipo de pagamento já é um Crediário.");
                        return;
                    }
                    if (tipoPagamento.equals("FIADO")){
                        JOptionPane.showMessageDialog(null, "Tipo de pagamento não aceito pelo Sistema.");
                        return;
                    }
                }
                               
                jtfVlRecebido.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma forma de Pagamento");
            }
        }
    }//GEN-LAST:event_jcbFormaPagtoKeyPressed

    private void jtfDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyTyped
         String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfDescontoKeyTyped

    private void jtfVlRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfVlRecebidoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            
            if (jcbFormaPagto.getSelectedIndex() < 0){
                JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento.");
                return;
            }
            if (jcbFormaPagto.getSelectedItem().equals("FIADO") || (jcbFormaPagto.getSelectedItem().equals("CREDIARIO"))){
                
                if (this.tipoPedido.equals("BALCAO")){
                   if (PedidoView.cliente.getId().equals(1L)){                      
                       JOptionPane.showMessageDialog(null, "Pedido sem Cliente.");                    
                       return;
                    }
                }else               
                   if (this.tipoPedido.equals("BALCAO1")){
                      if (PedidoView1.cliente.getId().equals(1L)){                         
                          JOptionPane.showMessageDialog(null, "Pedido sem Cliente.");                    
                          return;
                       }
                    }
                
                if (jcbFormaPagto.getSelectedItem().equals("CREDIARIO")){
                    PedidoCrediarioView p = null;
                    
                    float descont , acresc;
                    String descontStr, acrescStr;
                    descontStr = jtfDesconto.getText();
                    descontStr = descontStr.replace(".", "");
                    descontStr = descontStr.replace(",", ".");
                    
                    descont = Float.parseFloat(descontStr);
                    
                              
                    
                    if (tipoPedido.equals("BALCAO")){
                                              
                       if (descont > 0){
                          JOptionPane.showMessageDialog(null, "Não se aplica desconto neste tipo de pagamento");
                          jtfDesconto.setText("0,0");
                          subTotal = PedidoView.jtfSubTotal.getText();
                          jLabel1.setText(subTotal);
                          jtfRestante.setText(subTotal);                       
                       }                  
                        
                       if(listaItensPag.size() > 0){
                           JOptionPane.showMessageDialog(null, "Operação não Permitida, Cancela e faça de novo.");
                           return;
                       }  
                        
                       String totalVendaStr = jLabel1.getText();
                       totalVendaStr = totalVendaStr.replace(".", "");
                       totalVendaStr = totalVendaStr.replace(",", ".");
                       double totalVenda = Double.parseDouble(totalVendaStr);
                       double credito = Double.parseDouble(PedidoView.cliente.getCli().getCredito().toString());                        
                       if (credito >= totalVenda){
                          jtfVlRecebido.setText("");
                          p = new PedidoCrediarioView(new java.awt.Frame(), true, PedidoView.pedido );
                          p.setTitle("CREDIÁRIO");
                          p.setLocationRelativeTo(null); // centraliza a tela
                          p.jlTotal.setText(jLabel1.getText());
                          p.setVisible(true);
                          
                          //Diminuindo o Credito do cliente.
                          ClienteDAO cliDao = new ClienteDAO();
                          Cliente cli = PedidoView.cliente.getCli();
                          credito = (credito - totalVenda);
                          cli.setCredito(new BigDecimal(credito));
                          cliDao.alterarCreditoCliente(cli);
                          //fim.        
                          
                       }else{
                           JOptionPane.showMessageDialog(null, "Crédito do Cliente é de: "+ new DecimalFormat("#,##0.00").format(credito));
                           return;
                       }    
                    }else{
                        return;
                    }
                    if (p.botao.equals("cancelar"))
                        return;
                    else
                        if (p.botao.equals("ok")){
                            jbtFinalizarActionPerformed(null);
                        }                   
                }else{               
                    jbtFinalizar.setEnabled(true);
                    jbtFinalizar.requestFocus();
                    return;
                }    
            }           
            
            if (jtfVlRecebido.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Digite o Valor Recebido");
            else{
               // float vlTotal = Float.parseFloat(jLabel1.getText().replace(",", ".")); 
               float totalpago = 0;
               // dtPagamento = new Date();
                
                String restanteStr = null; String recebidoStr = null;
                restanteStr = jtfRestante.getText();
                restanteStr = restanteStr.replace(".", "");
                restanteStr = restanteStr.replace(",", ".");
                float restante = Float.parseFloat(restanteStr);
                
                recebidoStr = jtfVlRecebido.getText();
                recebidoStr = recebidoStr.replace(".", "");
                recebidoStr = recebidoStr.replace(",", ".");
                
                float recebido = Float.parseFloat(recebidoStr); 
                
                totalpago = (restante - recebido);
                                               
                jtfRestante.setText(new DecimalFormat("#,##0.00").format(totalpago));                
                
                DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
                
                amodel.addRow(new Object[]{jcbFormaPagto.getSelectedItem(), recebido,sdf.format(dtPagamento)});
                           
              //Inserindo Forma de Pagamento no PedidoPagamentoItens.
                PedidoPagamentoItens pItens = new PedidoPagamentoItens();                
                pItens.setTipoPagamento(listaTipoPagamento.get(jcbFormaPagto.getSelectedIndex()));
                pItens.setValor(new BigDecimal(recebidoStr));
                
                
              //  System.out.println("Data pagamento ="+dtPagamento);
              //  pItens.setDtPagamento(dtPagamento);
                
                listaItensPag.add(new PedidoPagamentoItens(pItens.getValor(), pItens.getTipoPagamento(), dtPagamento));
                //fim.
                //Verifica o total pago.
                if (this.tipoPedido.equals("CREDIARIO")){
                    jbtFinalizar.setEnabled(true);
                    //jbtFinalizar.requestFocus();
                }
                
                if (totalpago <= 0 ){
                    jcbFormaPagto.setSelectedIndex(-1);
                    jcbFormaPagto.setEnabled(false);
                    jtfVlRecebido.setEnabled(false);
                    jtfVlRecebido.setText("");                    
                    jbtFinalizar.setEnabled(true);
                    jbtFinalizar.requestFocus();
                }else{
                     jcbFormaPagto.setSelectedIndex(-1);                    
                     jtfVlRecebido.setText("");
                     jcbFormaPagto.requestFocus();
                } 
                    //fim.
            }
        }        
    }//GEN-LAST:event_jtfVlRecebidoKeyPressed

    private void jtfVlRecebidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfVlRecebidoKeyTyped
         String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfVlRecebidoKeyTyped

    private void jbtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFinalizarActionPerformed
       
        PedidoPagamentoDAO pedPagDAO = new PedidoPagamentoDAO();
        
        Caixa caixa = new Caixa();
        CaixaDAO caixaDao = new CaixaDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<CaixaItens> listaItensCaixa = new ArrayList<CaixaItens>();
        PedidoCrediario pCrediario = new PedidoCrediario();
        PedidoCrediarioDAO pCrediarioDao = new PedidoCrediarioDAO();
        BigDecimal pontosCashBack = new BigDecimal(BigInteger.ZERO);
        BigDecimal valorCompraCashBack = new BigDecimal(BigInteger.ZERO);
        BigDecimal pontosTotalCashBack = new BigDecimal(BigInteger.ZERO);
        
        //Se for Diferente de Fiado, entao registra o Pagamento do Pedido.
        //Registrar  Data e hora.
        String dataHora = (formatadorHD.format(calendar.getTime()));
           
       //  System.out.println("tipoPedido ="+this.tipoPedido);  
       //  SE FOR FIADO OU CREDIARIO ENTAO FACA LOGO ABAIXO:
            //aqui é fiado.
            if (tipoPagamento.equals("FIADO")){
                //float vlRecebido = Float.parseFloat(jtfVlRecebido.getText().replace(",", "."));
                if (jtfVlRecebido.getText().equals(""))
                    jtfVlRecebido.setText("0");
                
                float vlRecebido = Float.parseFloat(jtfVlRecebido.getText().replace(",", "."));
                
                if (vlRecebido == 0){
                    if (this.tipoPedido.equals("BALCAO")){
                        PedidoView.pedido.setStatus("FIADO");
                        PedidoView.pedido.setTipoVenda("FIADO");                        
                    }else
                        if (this.tipoPedido.equals("BALCAO1")){
                            PedidoView1.pedido.setStatus("FIADO");
                            PedidoView.pedido.setTipoVenda("FIADO");   
                        }else
                            if (this.tipoPedido.equals("DELIVERY")){
                                PedidoDeliveryView.pedido.setStatus("FIADO");
                                PedidoView.pedido.setTipoVenda("FIADO");
                            }    
                }else{
                    JOptionPane.showMessageDialog(null, "Este tipo de pagamento, não recebe no momento da venda");
                    jtfRestante.setText(jLabel1.getText());
                    jtfVlRecebido.setEnabled(true);
                    DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
                    amodel.setNumRows(0);
                    jcbFormaPagto.setEnabled(true);
                    jtfVlRecebido.requestFocus();
                    return;
                }
            }
              
        else
          //aqui é crediario
            if (tipoPagamento.equals("CREDIARIO")){
               
               if (jtfVlRecebido.getText().equals(""))
                  jtfVlRecebido.setText("0");
                    
                  float vlRecebido = Float.parseFloat(jtfVlRecebido.getText().replace(",", "."));
                    
                  if (vlRecebido == 0){
                     if (this.tipoPedido.equals("BALCAO")){
                        PedidoView.pedido.setStatus("CREDIARIO");
                        PedidoView.pedido.setTipoVenda("CREDIARIO");
                     }else
                        if (this.tipoPedido.equals("BALCAO1")){
                           PedidoView1.pedido.setStatus("CREDIARIO");
                           PedidoView1.pedido.setTipoVenda("CREDIARIO");
                        }else
                           if (this.tipoPedido.equals("DELIVERY")){
                              PedidoDeliveryView.pedido.setStatus("CREDIARIO");
                              PedidoDeliveryView.pedido.setTipoVenda("CREDIARIO");
                           }  
                  }else{
                       JOptionPane.showMessageDialog(null, "Este tipo de pagamento, não recebe no momento da venda");
                       jtfRestante.setText(jLabel1.getText());
                       jtfVlRecebido.setEnabled(true);
                       DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
                       amodel.setNumRows(0);
                       jcbFormaPagto.setEnabled(true);
                       jtfVlRecebido.requestFocus();
                       return;
                   }
                  
                }       
            else{
            //Carrega o PedidoPagamento e salva.
            
            if (pedPag != null){                  
                String totalStr = null;
                totalStr = jLabel1.getText();
                totalStr = totalStr.replace(".", "");
                totalStr = totalStr.replace(",", ".");
                pedPag.setAcrescimo(new BigDecimal(jtfAcrescimos.getText().replace(",", ".")));
                pedPag.setDesconto(new BigDecimal(jtfDesconto.getText().replace(",", ".")));
                pedPag.setTotal(new BigDecimal(totalStr));
                pedPag.setTroco(new BigDecimal(jtfRestante.getText().replace(",", ".")));               
                pedPag.setListaPagamentoItens(listaItensPag);
                                
                if (this.tipoPedido.equals("BALCAO1")){
                    pedPag.setPedido(PedidoView1.pedido);
                    PedidoView1.pedido.setTipoVenda("A VISTA");
                }else
                    if (this.tipoPedido.equals("BALCAO")){
                       PedidoView.pedido.setTipoVenda("A VISTA");
                        pedPag.setPedido(PedidoView.pedido);
                    }else
                        if (this.tipoPedido.equals("DELIVERY")){
                            PedidoDeliveryView.pedido.setTipoVenda("A VISTA");
                            pedPag.setPedido((PedidoDeliveryView.pedido));
                        }else
                            if (this.tipoPedido.equals("FIADO"))
                                pedPag.setPedido(PedidoRecebeFiadoView.pedido);
                            else
                                if (this.tipoPedido.equals("CREDIARIO")){
                                    pedPag.setPedido(PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido());
                                    
                                                                       
                                    if (pedPag.getTroco().signum() <= 0)
                                        PedidoRecebeCrediarioView.pedidoCrediario.setStatus("FECHADO");
                                }              
                try {
                    pedPag.setDtPagamento(formatadorHD.parse(dataHora));
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoPagamentoView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (pedPag.getId() == null){                   
                   pedPag = pedPagDAO.salvar(pedPag);
                }else
                    pedPag = pedPagDAO.alterar(pedPag);
            }
            //Fim.

            //Implementando CashBack
            
            if (jcbCashBack.isSelected()){
                
               if (this.tipoPedido.equals("BALCAO")){
                   if (PedidoView.cliente.getId().equals(1L)){                      
                       JOptionPane.showMessageDialog(null, "Pedido sem Cliente para calcular o cash back.");                    
                       return;
                    }
                }else               
                   if (this.tipoPedido.equals("BALCAO1")){
                      if (PedidoView1.cliente.getId().equals(1L)){                         
                          JOptionPane.showMessageDialog(null, "Pedido sem Cliente para calcular o cash back.");                    
                          return;
                       }
                    }  
                ClienteDAO cliDAO = new ClienteDAO();
                CashBackDAO cbDAO = new CashBackDAO();
                Cliente cliente = new Cliente();
                cliente = PedidoView.cliente.getCli();
                CashBack cb = new CashBack();
                cb = cbDAO.cashBack(1L);
                valorCompraCashBack = valorCompraCashBack.add(cb.getValorCompra());
                System.out.println("Cash back valor compra: "+valorCompraCashBack);
              
                pontosCashBack = pontosCashBack.add(cb.getPontos());
                System.out.println("PontosCashBack :"+pontosCashBack);
                  System.out.println("pedTotal :"+pedPag.getTotal());      
                double totalCompra = Double.parseDouble(pedPag.getTotal().toString());
                double valorCashBack = Double.parseDouble(valorCompraCashBack.toString());
                double cashBackCliente = (totalCompra / valorCashBack);
                
                String cashBackClienteStr = String.valueOf(cashBackCliente);
                int pos = cashBackClienteStr.indexOf(".");
                cashBackClienteStr = cashBackClienteStr.substring(0, pos);
                cashBackCliente = Double.parseDouble(cashBackClienteStr);
            
                System.out.println("Cash back cliente str: "+cashBackClienteStr);
                   
                System.out.println("Cashback cliente :"+cashBackCliente);
                
                pontosTotalCashBack = (pontosCashBack.multiply(new BigDecimal(cashBackCliente)));
                           
                System.out.println("PontosTotal totalCompra/valorCompraCashBack :"+pontosTotalCashBack);
                
                
                System.out.println("Total passando pelo cash back :"+cashBackCliente);
               // pedPag.getTotal()
              
                System.out.println("Cash  Back do cliente :"+cliente.getCashBack());
                
                
                 pontosTotalCashBack =  pontosTotalCashBack.add(new BigDecimal(cliente.getCashBack().toString()));
                
                 System.out.println("Total acumulado :"+pontosTotalCashBack);
                cliente.setCashBack(pontosTotalCashBack);
                
                cliDAO.alterarCreditoCliente(cliente);
                
                
                
                
                
                
                
                
                
                JOptionPane.showMessageDialog(null, "Aqui implemento o cash back.");
                
            }
            
            //fimCashBackk
            
            
            
            //Registra no caixa.
            caixa = caixaDao.carregaCaixa(menuView.Menu.colaborador);
            
            // String descricao = null;
            String entradaStr = null;
            // String obs = null;
            // String formaPagto = null;
            float somaPagamento = 0;
            float entrada = 0;
            
            
            for (PedidoPagamentoItens itens: pedPag.getListaPagamentoItens()){
                float vltotal = itens.getPedidoPagamento().getTotal().floatValue();
                float troco = itens.getPedidoPagamento().getTroco().floatValue();
                somaPagamento = (somaPagamento + itens.getValor().floatValue());
                float vlpago = itens.getValor().floatValue();
                
                if (somaPagamento > vltotal){
                    //Para subtrair o valor do troco, colocou mais porque
                    //o troco é um valor negativo, e negativo com negativo é positivo, por isso que colocou operador de "+".
                    //Subtrair.
                    if (itens.getTipoPagamento().getDescricao().equals("CHEQUE")){   // 4 = Cheque.                                          
                        if (javax.swing.JOptionPane.showConfirmDialog(null, "O valor recebido é Maior que o total. \n"
                                + "Não foi apresentado valor em dinheiro para o troco. \n "
                                + "Faça um lançamento no caixa para o troco. Deseja realmente continuar? ", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
                        }
                        entradaStr = String.valueOf(itens.getValor());
                        
                    }else{
                        entrada = (vlpago + troco);                   
                        entradaStr = String.valueOf(entrada);
                    }
                }else
                    entradaStr = String.valueOf(itens.getValor());
                //(1) = Dinheiro.
                
                if (itens.getTipoPagamento().getDescricao().equals("DINHEIRO")){
                    
                    //Inserir no caixa
                    caixa.setDinheiroEntrada(caixa.getDinheiroEntrada().add(new BigDecimal(entradaStr)));
                    caixa.setTotalEntrada(caixa.getTotalEntrada().add(new BigDecimal(entradaStr)));
                    caixa.setSaldoDinheiro(caixa.getSaldoDinheiro().add(new BigDecimal(entradaStr)));
                    caixa.setSaldoFinal(caixa.getSaldoFinal().add(new BigDecimal(entradaStr)));
                    
                    CaixaItens caixaItens = new CaixaItens();
                    caixaItens.setDescricao("VENDA Nº: "+pedPag.getPedido().getId());
                    caixaItens.setFormaPagto("DINHEIRO");
                    caixaItens.setIdCaixa(caixa);
                    caixaItens.setTipo("VENDA");
                    if (this.tipoPedido.equals("BALCAO") || this.tipoPedido.equals("BALCAO1"))
                        caixaItens.setObs("LOJA");
                    else
                        if (this.tipoPedido.equals("DELIVERY"))
                            caixaItens.setObs("DELIVERY");
                        else
                            if (this.tipoPedido.equals("FIADO"))
                                caixaItens.setObs(PedidoRecebeFiadoView.pedido.getTipoPedido()+" - F");
                            else
                                if (this.tipoPedido.equals("CREDIARIO")){
                                    caixaItens.setObs("CREDIÁRIO");
                                    PedidoRecebeCrediarioView.pedidoCrediario.setIdPedidoPagamento(pedPag); 
                                    
                                    pCrediarioDao.salvar(PedidoRecebeCrediarioView.pedidoCrediario); 
                                    
                                }    
                    caixaItens.setVlEntrada(new BigDecimal(entradaStr));
                    caixaItens.setVlSaida(BigDecimal.ZERO);
//                    if (this.tipoPedido.equals("BALCAO1"))
//                        caixaItens.setPedido(PedidoView1.pedido);
//                    else
//                        if (this.tipoPedido.equals("BALCAO"))
//                            caixaItens.setPedido(PedidoView.pedido);
//                    if (this.tipoPedido.equals("DELIVERY"))
//                        caixaItens.setPedido(PedidoDeliveryView.pedido);
//                    else
//                        if (this.tipoPedido.equals("FIADO"))
//                            caixaItens.setPedido(PedidoRecebeFiadoView.pedido);
//                        else
//                            if (this.tipoPedido.equals("CREDIARIO"))
//                                caixaItens.setPedido(PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido());
                    //Date e Hora.
                    try {
                        caixaItens.setDtHora(formatadorHD.parse(dataHora));
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Problema com Data CaixaItens.");
                    }
                    //fim.
                    //Adiciona o Itens de Entrada do Caixa, como (Dinheiro, Cartao, Cheque ...).
                    
                    if (caixaItens.getId()== null)
                    listaItensCaixa.add(caixaItens);                   
                }//fim se for dinheiro.
                else   //Cartão de Credito.
                    if (itens.getTipoPagamento().getDescricao().equals("CARTAO CREDITO")){
                        //Inserir no caixa
                        caixa.setCartaoCredito(caixa.getCartaoCredito().add(new BigDecimal(entradaStr)));
                        caixa.setTotalEntrada(caixa.getTotalEntrada().add(new BigDecimal(entradaStr)));
                        caixa.setSaldoCartaoCredito(caixa.getSaldoCartaoCredito().add(new BigDecimal(entradaStr)));
                        caixa.setSaldoFinal(caixa.getSaldoFinal().add(new BigDecimal(entradaStr)));
                        
                        CaixaItens caixaItens = new CaixaItens();
                        caixaItens.setDescricao("VENDA Nº: "+pedPag.getPedido().getId());
                        caixaItens.setFormaPagto("CARTAO CREDITO");
                        caixaItens.setIdCaixa(caixa);
                        caixaItens.setTipo("VENDA");
                        if (this.tipoPedido.equals("BALCAO") || this.tipoPedido.equals("BALCAO1"))
                            caixaItens.setObs("LOJA");
                        else
                            if (this.tipoPedido.equals("DELIVERY"))
                                caixaItens.setObs("DELIVERY");
                            else
                                if (this.tipoPedido.equals("FIADO"))
                                    caixaItens.setObs(PedidoRecebeFiadoView.pedido.getTipoPedido()+" - F");
                                else
                                    if (this.tipoPedido.equals("CREDIARIO")){
                                        caixaItens.setObs("CREDIARIO");
                                        PedidoRecebeCrediarioView.pedidoCrediario.setIdPedidoPagamento(pedPag);
                                        pCrediarioDao.salvar(PedidoRecebeCrediarioView.pedidoCrediario);
                                    }    
                        caixaItens.setVlEntrada(new BigDecimal(entradaStr));
                        caixaItens.setVlSaida(BigDecimal.ZERO);
//                        if (this.tipoPedido.equals("BALCAO1"))
//                            caixaItens.setPedido(PedidoView1.pedido);
//                        else
//                            if (this.tipoPedido.equals("BALCAO"))
//                                caixaItens.setPedido(PedidoView.pedido);
//                            else
//                                if (this.tipoPedido.equals("DELIVERY"))
//                                    caixaItens.setPedido(PedidoDeliveryView.pedido);
//                                else
//                                    if (this.tipoPedido.equals("FIADO"))
//                                        caixaItens.setPedido(PedidoRecebeFiadoView.pedido);
//                                    else
//                                        if (this.tipoPedido.equals("CREDIARIO"))
//                                           caixaItens.setPedido(PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido());
                        //Date e Hora.
                        try {
                            caixaItens.setDtHora(formatadorHD.parse(dataHora));
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, "Problema com Data CaixaItens.");
                        }
                        //fim.
                        //Adiciona o Itens de Entrada do Caixa, como (Dinheiro, Cartao, Cheque ...).
                        if (caixaItens.getId()== null)
                        listaItensCaixa.add(caixaItens);
                    }else   //Cartão de Débito.
                        if (itens.getTipoPagamento().getDescricao().equals("CARTAO DEBITO")){
                            //Inserir no caixa.
                            caixa.setCartaoDebito(caixa.getCartaoDebito().add(new BigDecimal(entradaStr)));
                            caixa.setTotalEntrada(caixa.getTotalEntrada().add(new BigDecimal(entradaStr)));
                            caixa.setSaldoCartaoDebito(caixa.getSaldoCartaoDebito().add(new BigDecimal(entradaStr)));
                            caixa.setSaldoFinal(caixa.getSaldoFinal().add(new BigDecimal(entradaStr)));
                            
                            CaixaItens caixaItens = new CaixaItens();
                            caixaItens.setDescricao("VENDA Nº: "+pedPag.getPedido().getId());
                            caixaItens.setFormaPagto("CARTAO DEBITO");
                            caixaItens.setIdCaixa(caixa);
                            caixaItens.setTipo("VENDA");
                            if (this.tipoPedido.equals("BALCAO") || this.tipoPedido.equals("BALCAO1"))
                                caixaItens.setObs("LOJA");
                            else
                                if (this.tipoPedido.equals("DELIVERY"))
                                    caixaItens.setObs("DELIVERY");
                                else
                                    if (this.tipoPedido.equals("FIADO"))
                                        caixaItens.setObs(PedidoRecebeFiadoView.pedido.getTipoPedido()+" - F");
                                    else
                                         if (this.tipoPedido.equals("CREDIARIO")){
                                            caixaItens.setObs("CREDIÁRIO");
                                            PedidoRecebeCrediarioView.pedidoCrediario.setIdPedidoPagamento(pedPag);                                    
                                            pCrediarioDao.salvar(PedidoRecebeCrediarioView.pedidoCrediario);                               
                                         }
                            caixaItens.setVlEntrada(new BigDecimal(entradaStr));
                            caixaItens.setVlSaida(BigDecimal.ZERO);
//                            if (this.tipoPedido.equals("BALCAO"))
//                                caixaItens.setPedido(PedidoView.pedido);
//                            else
//                                if (this.tipoPedido.equals("BALCAO1"))
//                                    caixaItens.setPedido(PedidoView1.pedido);
//                                else
//                                    if (this.tipoPedido.equals("DELIVERY"))
//                                        caixaItens.setPedido(PedidoDeliveryView.pedido);
//                                    else
//                                        if (this.tipoPedido.equals("FIADO"))
//                                            caixaItens.setPedido(PedidoRecebeFiadoView.pedido);
//                                        else
//                                            if (this.tipoPedido.equals("CREDIARIO"))
//                                               caixaItens.setPedido(PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido());
                            //Date e Hora.
                            try {
                                caixaItens.setDtHora(formatadorHD.parse(dataHora));
                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(null, "Problema com Data CaixaItens.");
                            }
                            //fim.
                            //Adiciona o Itens de Entrada do Caixa, como (Dinheiro, Cartao, Cheque ...).
                          
                            listaItensCaixa.add(caixaItens);                           
                        }else //Cheque
                            if (itens.getTipoPagamento().getDescricao().equals("CHEQUE")){
                                //Inserir no caixa.
                                caixa.setChequeEntrada(caixa.getChequeEntrada().add(new BigDecimal(entradaStr)));
                                caixa.setTotalEntrada(caixa.getTotalEntrada().add(new BigDecimal(entradaStr)));
                                caixa.setSaldoCheque(caixa.getSaldoCheque().add(new BigDecimal(entradaStr)));
                                caixa.setSaldoFinal(caixa.getSaldoFinal().add(new BigDecimal(entradaStr)));
                                
                                CaixaItens caixaItens = new CaixaItens();
                                caixaItens.setDescricao("VENDA Nº: "+pedPag.getPedido().getId());
                                caixaItens.setFormaPagto("CHEQUE");
                                caixaItens.setIdCaixa(caixa);
                                caixaItens.setTipo("VENDA");
                                if (this.tipoPedido.equals("BALCAO") || this.tipoPedido.equals("BALCAO1"))
                                    caixaItens.setObs("LOJA");
                                else
                                    if (this.tipoPedido.equals("DELIVERY"))
                                        caixaItens.setObs("DELIVERY");
                                    else
                                        if (this.tipoPedido.equals("FIADO"))
                                            caixaItens.setObs(PedidoRecebeFiadoView.pedido.getTipoPedido()+" - F");
                                        else 
                                           if (this.tipoPedido.equals("CREDIARIO"))
                                              caixaItens.setObs("CREDIARIO");
                                caixaItens.setVlEntrada(new BigDecimal(entradaStr));
                                caixaItens.setVlSaida(BigDecimal.ZERO);
//                                if (this.tipoPedido.equals("BALCAO"))
//                                    caixaItens.setPedido(PedidoView.pedido);
//                                else
//                                    if (this.tipoPedido.equals("BALCAO1"))
//                                        caixaItens.setPedido(PedidoView1.pedido);
//                                    else
//                                        if (this.tipoPedido.equals("DELIVERY"))
//                                            caixaItens.setPedido(PedidoDeliveryView.pedido);
//                                        else
//                                            if (this.tipoPedido.equals("FIADO"))
//                                                caixaItens.setPedido(PedidoRecebeFiadoView.pedido);
//                                            else
                                                 if (this.tipoPedido.equals("CREDIARIO")){
                                                    caixaItens.setObs("CREDIÁRIO");
                                                    PedidoRecebeCrediarioView.pedidoCrediario.setIdPedidoPagamento(pedPag);                                    
                                                    pCrediarioDao.salvar(PedidoRecebeCrediarioView.pedidoCrediario);                               
                                                 }
                                //Date e Hora.
                                try {
                                    caixaItens.setDtHora(formatadorHD.parse(dataHora));
                                } catch (ParseException ex) {
                                    JOptionPane.showMessageDialog(null, "Problema com Data CaixaItens.");
                                }
                                //fim.
                                //Adiciona o Itens de Entrada do Caixa, como (Dinheiro, Cartao, Cheque ...).
                                listaItensCaixa.add(caixaItens);
                            }else // Vale Alimentacao
                                if (itens.getTipoPagamento().getId() == 5){
                                    caixa.setValeAlimentacao(caixa.getValeAlimentacao().add(new BigDecimal(entradaStr)));
                                    caixa.setTotalEntrada(caixa.getTotalEntrada().add(new BigDecimal(entradaStr)));
                                    caixa.setSaldoValeAliment(caixa.getSaldoValeAliment().add(new BigDecimal(entradaStr)));
                                    caixa.setSaldoFinal(caixa.getSaldoFinal().add(new BigDecimal(entradaStr)));
                                    
                                    CaixaItens caixaItens = new CaixaItens();
                                    caixaItens.setDescricao("VENDA Nº: "+pedPag.getPedido().getId());
                                    caixaItens.setFormaPagto("VALE ALIMENTACAO");
                                    caixaItens.setIdCaixa(caixa);
                                    caixaItens.setTipo("VENDA");
                                    if (this.tipoPedido.equals("BALCAO")|| this.tipoPedido.equals("BALCAO1"))
                                        caixaItens.setObs("LOJA");
                                    else
                                        if (this.tipoPedido.equals("DELIVERY"))
                                            caixaItens.setObs("DELIVERY");
                                        else
                                            if (this.tipoPedido.equals("FIADO"))
                                                caixaItens.setObs(PedidoRecebeFiadoView.pedido.getTipoPedido()+" - F");
                                            else
                                                if (this.tipoPedido.equals("CREDIARIO"))
                                                    caixaItens.setObs("CREDIARIO");
                                    caixaItens.setVlEntrada(new BigDecimal(entradaStr));
                                    caixaItens.setVlSaida(BigDecimal.ZERO);
                                    
//                                    if (this.tipoPedido.equals("BALCAO"))
//                                        caixaItens.setPedido(PedidoView.pedido);
//                                    else
//                                        if (this.tipoPedido.equals("BALCAO1"))
//                                            caixaItens.setPedido(PedidoView1.pedido);
//                                        else
//                                            
//                                            if (this.tipoPedido.equals("DELIVERY"))
//                                                caixaItens.setPedido(PedidoDeliveryView.pedido);
//                                            else
//                                                if (this.tipoPedido.equals("FIADO"))
//                                                    caixaItens.setPedido(PedidoRecebeFiadoView.pedido);
//                                                else
                                                     if (this.tipoPedido.equals("CREDIARIO")){
                                                        caixaItens.setObs("CREDIÁRIO");
                                                        PedidoRecebeCrediarioView.pedidoCrediario.setIdPedidoPagamento(pedPag);                                    
                                                        pCrediarioDao.salvar(PedidoRecebeCrediarioView.pedidoCrediario);                               
                                                      }
                                    //Date e Hora.
                                    try {
                                        caixaItens.setDtHora(formatadorHD.parse(dataHora));
                                    } catch (ParseException ex) {
                                        JOptionPane.showMessageDialog(null, "Problema com Data CaixaItens.");
                                    }
                                    //fim.
                                    //Adiciona o Itens de Entrada do Caixa, como (Dinheiro, Cartao, Cheque ...).
                                    listaItensCaixa.add(caixaItens);  
                                }
            }              
            caixa.setCaixaItensList(listaItensCaixa);
            caixaDao.alterarCaixa(caixa);
            if (this.tipoPedido.equals("BALCAO"))
                PedidoView.pedido.setStatus("FECHADO");
            else
                if (this.tipoPedido.equals("BALCAO1"))
                    PedidoView1.pedido.setStatus("FECHADO");
                else
                    if (this.tipoPedido.equals("DELIVERY"))
                        PedidoDeliveryView.pedido.setStatus("FECHADO");
                    else
                        if (this.tipoPedido.equals("FIADO"))
                            PedidoRecebeFiadoView.pedido.setStatus("FECHADO");
//                        else
//                            if (this.tipoPedido.equals("CREDIARIO"))
//                                PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido().setStatus("FECHADO");
        }
        //Zerar Formulario de Pedido e Imprimir Recibo.
        if (this.tipoPedido.equals("BALCAO")){
           //Salvar pagamento pedido.
           pedidoDAO.alterar(PedidoView.pedido);            
           //Imprimir pagamentno pedido.
           if (tipoPagamento.equals("FIADO") || tipoPagamento.equals("CREDIARIO")){
               System.out.println("nao fazer nada");
           } else {
               if (javax.swing.JOptionPane.showConfirmDialog(null, "IMPRIMIR RECIBO?", "RECIBO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
                   try {
                       ImprimeRelatorio pedidoRel = new ImprimeRelatorio();
                       // recebidoStr = (new DecimalFormat("#,##0.00").format(Float.parseFloat(recebidoStr)));
                       String acresc = jtfAcrescimos.getText();
                       String descont = jtfDesconto.getText();
                       String trocoStr = jtfRestante.getText();
                       trocoStr = trocoStr.replace(",", ".");
                       float troco = Float.parseFloat(trocoStr);
                       //   Se o troco for valor negativo, converte-lo em positivo, para exibir no relatorio.
                       if (troco < 0)
                           troco = troco * (-1);
                       acresc = acresc.replace(",", ".");
                       descont = descont.replace(",", ".");
                       
                       trocoStr = String.valueOf(new DecimalFormat("#,##0.00").format(troco));
                       acresc = (new DecimalFormat("#,##0.00").format(Float.parseFloat(acresc)));
                       descont =(new DecimalFormat("#,##0.00").format(Float.parseFloat(descont)));
                       
                       pedidoRel.pedido(PedidoView.pedido, PedidoView.jtfCliente.getText(), menuView.Menu.nomeUsuario,
                               subTotal, jLabel1.getText(), acresc, descont, trocoStr);
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null, "Erro ao imprimir recibo.");
                   }
               }
           } //Fim Impressão.
             //Fim Impressão.
           //Zerar Pedido
           PedidoView.pedido = new Pedido();
           PedidoView.jlStatusCaixa.setText("CAIXA LIVRE");
           PedidoView.jlStatusCaixa.setForeground(Color.BLUE);
           PedidoView.jlNumPedido.setVisible(false);
           PedidoView.jtfCliente.setText("");
           PedidoView.jtfObs.setText("");
            
           PedidoView.jtfSubTotal.setText("");
           PedidoView.subtotal = 0;
           PedidoView.cliente = new Pessoa() {};
           PedidoView.listaItens = new ArrayList<>();
           DefaultTableModel modelPedido = (DefaultTableModel) PedidoView.jTable1.getModel();
           modelPedido.setNumRows(0);
           PedidoView.jbtPagamento.setEnabled(false);
           PedidoView.jtfCliente.setEnabled(true);
           PedidoView.jbtCliente.setEnabled(true);
           PedidoView.pedidoPagView = null;
          
                 
        }else
            if (this.tipoPedido.equals("BALCAO1")){
               pedidoDAO.alterar(PedidoView1.pedido);
               //Zerar Pedido
               PedidoView1.pedido = new Pedido();
               PedidoView1.jlStatusCaixa.setText("CAIXA LIVRE");
               PedidoView1.jlStatusCaixa.setForeground(Color.BLUE);
               PedidoView1.jlNumPedido.setVisible(false);
              //  PedidoView1.jtfCliente.setText("");
               PedidoView1.jtfObs.setText("");
               PedidoView1.jtfSubTotal.setText("");
               PedidoView1.subtotal = 0;
               PedidoView1.cliente = new Pessoa() {};
               PedidoView1.listaItens = new ArrayList<>();
               DefaultTableModel modelPedido = (DefaultTableModel) PedidoView1.jTable1.getModel();
               modelPedido.setNumRows(0);
               PedidoView1.jbtPagamento.setEnabled(false);
               PedidoView1.jbtConfig.setEnabled(true);
               PedidoView1.jcbCliente.setSelectedIndex(0);
               //    PedidoView1.jtfCodProd.requestFocus();          
            }else     
              if (this.tipoPedido.equals("DELIVERY")){
                  pedidoDAO.alterar(PedidoDeliveryView.pedido);
                  //Zerar Pedido
                  PedidoDeliveryView.pedido = new Pedido();
                  PedidoDeliveryView.jlStatusCaixa.setText("CAIXA LIVRE");
                  PedidoDeliveryView.jlStatusCaixa.setForeground(Color.BLUE);
                  PedidoDeliveryView.jlNumPedido.setVisible(false);
                  PedidoDeliveryView.jtfCliente.setText("");
                  PedidoDeliveryView.jtfObs.setText("");
                  PedidoDeliveryView.jtfSubTotal.setText("");
                  PedidoDeliveryView.subtotal = 0;
                  PedidoDeliveryView.cliente = new Pessoa() {};
                  PedidoDeliveryView.listaItens = new ArrayList<>();
                  DefaultTableModel modelPedido = (DefaultTableModel) PedidoDeliveryView.jTable1.getModel();
                  modelPedido.setNumRows(0);
                  PedidoDeliveryView.jbtOK.setEnabled(false);
//                PedidoDeliveryView.jbtConfig.setEnabled(true);
                  PedidoDeliveryView.jtfCodProd.requestFocus();
              }else
                  if (this.tipoPedido.equals("FIADO")){                                        
                      pedidoDAO.alterar(PedidoRecebeFiadoView.pedido);
                     // PedidoRecebeFiadoView.jrbTodos.doClick();                  
                   }
                  else
                      if (this.tipoPedido.equals("CREDIARIO")){
                          
                          pedidoDAO.alterar(PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido());
                         // PedidoRecebeCrediarioView.pedidoCrediario = null;
                      }
                    
         pedPag = new PedidoPagamento();
        
        //Sair.
        jButton2ActionPerformed(evt);

    }//GEN-LAST:event_jbtFinalizarActionPerformed

    private void jbtFinalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtFinalizarKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)) 
                jbtFinalizarActionPerformed(null);
        }
    }//GEN-LAST:event_jbtFinalizarKeyPressed

    private void jtfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoActionPerformed

    private void carregarCombobox(){         
        tipoPagDAO = new TipoPagamentoDAO();
        listaTipoPagamento = new ArrayList<>();
        
        listaTipoPagamento = tipoPagDAO.listTipoPag();
        jcbFormaPagto.removeAllItems();
         for (TipoPagamento pag : listaTipoPagamento){
              jcbFormaPagto.addItem(pag.getDescricao()); 
//             if ((((pag.getDescricao().equals("DINHEIRO") || pag.getDescricao().equals("CARTAO CREDITO")) || pag.getDescricao().equals("CARTAO DEBITO")) || pag.getDescricao().equals("CHEQUE")) || pag.getDescricao().equals("VALE ALIMENTACAO")) {
//                           
//             }
         }
         jcbFormaPagto.setSelectedIndex(-1);
    }
    
    
    
    
    
    
    
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
//            java.util.logging.Logger.getLogger(PedidoPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PedidoPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PedidoPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PedidoPagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                PedidoPagamentoView dialog = new PedidoPagamentoView(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JCheckBox jcbCashBack;
    private javax.swing.JComboBox<String> jcbFormaPagto;
    private javax.swing.JTextField jtfAcrescimos;
    private javax.swing.JTextField jtfDesconto;
    private javax.swing.JTextField jtfRestante;
    private javax.swing.JTextField jtfVlRecebido;
    // End of variables declaration//GEN-END:variables
}
