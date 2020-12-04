/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.CaixaDAO;
import dao.PedidoConfigDAO;
import dao.PedidoDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Caixa;
import model.Pedido;
import model.PedidoConfig;
import model.PedidoItens;
import model.Pessoa;
import model.Produto;

/**
 *
 * @author daniel
 */
public class PedidoView1 extends javax.swing.JDialog {

    /**
     * Creates new form PedidoView
     */
    public static Caixa caixa;
    public static CaixaDAO caixaDAO;
    public static Pessoa colaborador;
    public static PessoaDAO pessoaDAO;    
    //public static PedidoConfig config = new PedidoConfig();
    
    private ProdutoDAO produtoDAO;
    
    PedidoDetalheView pedidoDet;
    //public static Long idProduto;
    public static float subtotal;
    //float subTotalOrcamento;
    public static Pessoa cliente;
    public static List<PedidoItens> listaItens = new ArrayList<>();
    public static Pedido pedido = new Pedido();
    public static List<Pessoa> listaCliente = new ArrayList<>();
    List<Produto> listaProduto = new ArrayList<>();
    // = new ArrayList<>();
    public PedidoView1(java.awt.Frame parent, boolean modal, String cli, List<PedidoItens> listaItens ) {
        super(parent, modal);
        initComponents();
        requestFocus();
        subtotal = 0;
        cliente = new Pessoa() {};
        jbtConfig.setVisible(false);
//        PedidoConfigDAO configDAO = new PedidoConfigDAO();
        //listaItens = 
       // listaItens = null;
 //       config = configDAO.configuracao(1L);
//        if (config.getTipoPesquisa().equals("CODIGO")){
//           jlCodigoProduto.setText("CÓDIGO");
//           
//        }else
//            if (config.getTipoPesquisa().equals("CODIGOINTERNO")){
//                jlCodigoProduto.setText("CÓDIGO INTERNO");
//            }else
//                if (config.getTipoPesquisa().equals("CODIGOBARRAS")){
//                    jlCodigoProduto.setText("CÓDIGO BARRAS");
//                }    
               
        caixa = new Caixa();
        caixaDAO = new CaixaDAO();
        colaborador = new Pessoa() {};
        pessoaDAO = new PessoaDAO();
        
        
        Long idPessoa = Long.parseLong(menuView.Menu.idColaborador);
        colaborador = pessoaDAO.pessoa(idPessoa);
        jbtConfig.setVisible(false);
        try{
           caixa = caixaDAO.carregaCaixa(colaborador);
           jlStatusCaixa.setText("CAIXA LIVRE");
//           jtfCodProd.setEnabled(true);
       //    jlNumPedido.setVisible(false);
           carregaCombobox();
 
           
           //quando vem do orçamento
           if (!cli.equals("null")){
               jcbCliente.setSelectedItem(cli);
               
               carregaTable(listaItens);          
               return;
           }
           
           jtfSubTotal.setEnabled(false);          
        }catch(Exception e){
           jlStatusCaixa.setText("CAIXA FECHADO");
           jlStatusCaixa.setForeground(Color.RED);
           jbtPesquisaProduto.setEnabled(false);
       //    jtfCodProd.setEnabled(false);
          // jlNumPedido.setVisible(false);
            habilitar(false);
        }
        
   
        
         EventQueue queue = new EventQueue(){
           protected void dispatchEvent(final AWTEvent event){
               super.dispatchEvent(event);
               String a[];
               String tecla[];
               if (!event.paramString().equals("")){
                  if (event.paramString().substring(0, 5).equals("KEY_P")){
                      a = event.paramString().split(",");
                      tecla = a[1].split("=");
          //            System.out.println("tecla"+Integer.parseInt(tecla[1]));
                      switch (Integer.parseInt(tecla[1])){                          
//                          case 27:{
//                                
//                              break;
//                            }  
//                          case 113: // = Tecla - F2
//                              jbtAbrirCaixaActionPerformed(null);
//                              break;
                          case 114:{
                              if (jbtPesquisaProduto.isEnabled())
                                 jbtPesquisaProdutoActionPerformed(null);
                              else
                                 JOptionPane.showMessageDialog(null, "Caixa Fechado");
                              break;
                              }
//                          case 115:
//                              JOptionPane.showMessageDialog(null, "F4");
//                              break;
//                          case 116:
//                              JOptionPane.showMessageDialog(null, "F5");
//                              break;
//                          case 117: //F6 Cancela Item Generico
//                                {
//                               String item = JOptionPane.showInputDialog("Qual item deseja cancelar ?");
//                              // BemaECF.cancelaItemGenerico(item);
//                              // v.insereItemCancelado(item);
//                               break;
//                               }
//                          case 118: //F7 Cancela Último Item
//                            //  v.insereItemCancelado("Anterior");
//                             // BemaECF.cancelaItemAnterior();
//                              break;
//                          case 119:
//                              JOptionPane.showMessageDialog(null, "F8");
//                              break;
//                          case 120:
//                              JOptionPane.showMessageDialog(null, "F9");
//                              break;
//                          case 121: //F10 Desconto
//                             // v.vlrDesconto = JOptionPane.showInputDialog("Digite o valor do Desconto R$ ");


//                              break;
//                          case 122: //F11
//                             // JOptionPane.showMessageDialog(null, "F11");
//                            //  BemaECF.abreCupom();
//                              break;
//                          case 123:
//                           //   v.fechaCupom();
//                              break;
                      }
                  }
               }               
           }
       };
       Toolkit.getDefaultToolkit().getSystemEventQueue().push(queue);
        
        
        
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfObs = new javax.swing.JTextField();
        jlNumPedido = new javax.swing.JLabel();
        jlCodigoProduto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfSubTotal = new javax.swing.JTextField();
        jcbProduto = new javax.swing.JComboBox<>();
        jcbCliente = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jbtSair = new javax.swing.JButton();
        jbtImprimir = new javax.swing.JButton();
        jbtPagamento = new javax.swing.JButton();
        jbtExcluirPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbtConfig = new javax.swing.JButton();
        jbtPesquisaProduto = new javax.swing.JButton();
        jbtExcluirProduto = new javax.swing.JButton();
        jlStatusCaixa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("CLIENTE:");

        jLabel5.setText("OBSERVAÇÃO");

        jtfObs.setEnabled(false);

        jlNumPedido.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlNumPedido.setForeground(java.awt.Color.blue);
        jlNumPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNumPedido.setText("VENDA Nº - 0");
        jlNumPedido.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlCodigoProduto.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jlCodigoProduto.setText("PRODUTO");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("R$ SUBTOTAL");

        jtfSubTotal.setEditable(false);
        jtfSubTotal.setBackground(new java.awt.Color(255, 244, 131));
        jtfSubTotal.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jtfSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSubTotal.setFocusable(false);

        jcbProduto.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jcbProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbProdutoKeyPressed(evt);
            }
        });

        jcbCliente.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });
        jcbCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbClienteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfObs, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumPedido)
                    .addComponent(jLabel4)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCodigoProduto)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(jcbProduto))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbtSair.setText("Sair");
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

        jbtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print-icon.png"))); // NOI18N
        jbtImprimir.setText("Imprimir");
        jbtImprimir.setEnabled(false);

        jbtPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Calculator.png"))); // NOI18N
        jbtPagamento.setText("Pagamento [F5]");
        jbtPagamento.setEnabled(false);
        jbtPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPagamentoActionPerformed(evt);
            }
        });
        jbtPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtPagamentoKeyPressed(evt);
            }
        });

        jbtExcluirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jbtExcluirPedido.setText("Excluir Pedido");
        jbtExcluirPedido.setEnabled(false);
        jbtExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirPedidoActionPerformed(evt);
            }
        });
        jbtExcluirPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtExcluirPedidoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jbtExcluirPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtImprimir)
                .addComponent(jbtPagamento)
                .addComponent(jbtExcluirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "QTD.", "PRODUTO", "R$ PREÇO UNIT.", "R$ SUBTOTAL", "COD.PROD.", "VENDA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Application.png"))); // NOI18N
        jbtConfig.setToolTipText("Opção de Configuração de Pesquisa");
        jbtConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfigActionPerformed(evt);
            }
        });

        jbtPesquisaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jbtPesquisaProduto.setText("Produto [F3]");
        jbtPesquisaProduto.setToolTipText("Pesquisa Produto");
        jbtPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisaProdutoActionPerformed(evt);
            }
        });
        jbtPesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtPesquisaProdutoKeyPressed(evt);
            }
        });

        jbtExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jbtExcluirProduto.setText("Excluir Produto");
        jbtExcluirProduto.setEnabled(false);
        jbtExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirProdutoActionPerformed(evt);
            }
        });
        jbtExcluirProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtExcluirProdutoKeyPressed(evt);
            }
        });

        jlStatusCaixa.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jlStatusCaixa.setForeground(java.awt.Color.blue);
        jlStatusCaixa.setText("CAIXA OCUPADO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtPesquisaProduto)
                        .addComponent(jbtExcluirProduto))
                    .addComponent(jbtConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlStatusCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
       
        if (pedido.getId() == null){
           dispose();
        }else{
           JOptionPane.showMessageDialog(null, "Exclua o Pedido, ou finaliza com algum /n"
                   + " tipo de pagamento para Sair");
        }
        
            
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisaProdutoActionPerformed
       formPesquisaProduto();
        
    }//GEN-LAST:event_jbtPesquisaProdutoActionPerformed

    public static void formPesquisaProduto(){
        
        PesquisaProdutoView pProd = new PesquisaProdutoView(new java.awt.Frame(), true, "BALCAO");
        pProd.setTitle("Pesquisa Produto");
        pProd.setLocationRelativeTo(null); // centraliza a tela
        pProd.setVisible(true);
        
        
    }
    public static void formPedidoPagamento(){        
        
        PedidoPagamentoView p = new PedidoPagamentoView(new java.awt.Frame(), true, "BALCAO1");
        p.setTitle("Pagamento Balcão");
        p.setLocationRelativeTo(null); // centraliza a tela
        p.setVisible(true);
        
    }
    
    
    
    public static void formPesquisaCliente(){
        PesquisaClienteView pesCli = new PesquisaClienteView(new java.awt.Frame(), true, "PEDIDO1");
        pesCli.setTitle("Pesquisa de Cliente - Adicionar ao Pedido");        
        pesCli.setLocationRelativeTo(null);
        pesCli.setVisible(true);
    }
    
    
    
    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
         String caracteres="0987654321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

//        PedidoDetalheView pedidoDet = new PedidoDetalheView(new java.awt.Frame(), true);
//        pedidoDet.setTitle("Adicionar ao Pedido");
//        pedidoDet.setLocationRelativeTo(null);
//        pedidoDet.setVisible(true);
    }//GEN-LAST:event_formKeyPressed

    private void jbtConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfigActionPerformed
        PedidoConfView config = new PedidoConfView(new java.awt.Frame(), true);
        config.setTitle("Configuração de Pesquisa de Produto");
        config.setLocationRelativeTo(null);
        config.setVisible(true); 
        dispose();   
    }//GEN-LAST:event_jbtConfigActionPerformed

    private void jbtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirProdutoActionPerformed
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        
        
        float vlRemovido = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        
        subtotal = (subtotal - vlRemovido);
        jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(subtotal));
        //Remover da listaItens.
        
        listaItens.remove(jTable1.getSelectedRow());
       
        amodel.removeRow(jTable1.getSelectedRow());
        jbtExcluirProduto.setEnabled(false);
        
    }//GEN-LAST:event_jbtExcluirProdutoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jbtExcluirProduto.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPagamentoActionPerformed
        
       //Chamando formulario de PedidoPagamento.
        registraPedido();
        formPedidoPagamento();
          
    }//GEN-LAST:event_jbtPagamentoActionPerformed

    private void jbtExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirPedidoActionPerformed
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esta Pedido?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            PedidoDAO pedidoDAO = new PedidoDAO();
            
            pedidoDAO.remover(pedido);            
            
            //Zerar Pedido
            pedido = new Pedido();
            jlStatusCaixa.setText("CAIXA LIVRE");
            jlStatusCaixa.setForeground(Color.BLUE);
            jlNumPedido.setVisible(false);
//            jtfCliente.setText("");
            jtfObs.setText("");
            jtfSubTotal.setText("");
            subtotal = 0;
            cliente = new Pessoa() {};
            listaItens = new ArrayList<>();
            DefaultTableModel modelPedido = (DefaultTableModel) jTable1.getModel();
            modelPedido.setNumRows(0);
            jbtPagamento.setEnabled(false);
            jbtConfig.setEnabled(true);
         //   jtfCodProd.requestFocus();          
            
            JOptionPane.showMessageDialog(null, "Pedido Excluido com Sucesso!!!");
        }        
    }//GEN-LAST:event_jbtExcluirPedidoActionPerformed

    private void jcbClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbClienteKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            cliente = listaCliente.get(jcbCliente.getSelectedIndex());
           // System.out.println("cliente ="+cliente.getNome());
            jcbProduto.requestFocus();
        } 
    }//GEN-LAST:event_jcbClienteKeyPressed

    private void jcbProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbProdutoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            try{ 
                
              Produto produto = new Produto();
              produto = listaProduto.get(jcbProduto.getSelectedIndex());
              jcbProduto.setSelectedIndex(-1);
              String codProd = String.valueOf(produto.getId());
              //  System.out.println("codigo prod ="+codProd);
              pedidoDet = new PedidoDetalheView(new java.awt.Frame(), true, codProd, "BALCAO1", null);
             // pedidoDet.setTitle("Adicionar ao Pedido");
            //  pedidoDet.idProduto = codProd;
              pedidoDet.setLocationRelativeTo(null);
            //pedidoDet.setPreferredSize(900, 115).;
            //this.setBounds(0, 0, 970, 650);
            //Redimensiona o formulário pedidoDet.
             //pedidoDet.setBounds(350, 350, 800, 254);
             pedidoDet.setBounds(350, 350, 950, 280);
             pedidoDet.setVisible(true); 
             
             
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Produto não encontrado !!!");
           }

        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbProdutoKeyPressed

    private void jbtExcluirPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtExcluirPedidoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtExcluirPedidoActionPerformed(null);
        } 
    }//GEN-LAST:event_jbtExcluirPedidoKeyPressed

    private void jbtPesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtPesquisaProdutoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtPesquisaProdutoActionPerformed(null);
        } 
    }//GEN-LAST:event_jbtPesquisaProdutoKeyPressed

    private void jbtExcluirProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtExcluirProdutoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtExcluirProdutoActionPerformed(null);
        } 
    }//GEN-LAST:event_jbtExcluirProdutoKeyPressed

    private void jbtPagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtPagamentoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtPagamentoActionPerformed(null);
        } 
    }//GEN-LAST:event_jbtPagamentoKeyPressed

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed

       if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtSairActionPerformed(null);
        } 
    }//GEN-LAST:event_jbtSairKeyPressed

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed

       
    }//GEN-LAST:event_jcbClienteActionPerformed

    public static void  registraPedido() {
        Pedido p = new Pedido();       
        PedidoDAO pedidoDAO = new PedidoDAO();
        if (pedido.getId() == null ){            
 
           if (jcbCliente.getSelectedIndex() == -1){
                cliente = pessoaDAO.pessoa(1L);
                p.setCliente(cliente);
           }else{                 
               cliente = listaCliente.get(jcbCliente.getSelectedIndex());             
               p.setCliente(cliente);                
           }
      //      System.out.println("Cliente ="+p.getCliente().getNome());
            
            p.setColaborador(colaborador);
            p.setEntregador(colaborador);
            p.setDtCad(new Date());
            p.setObservacao(jtfObs.getText());
            p.setTipoPedido("BALCAO");
            p.setStatus("ABERTO");
            p.setListaItens(listaItens);            
          
            pedido = pedidoDAO.salvar(p);
        }else{            
            pedido.setCliente(cliente);
            pedidoDAO.alterar(pedido);           
        }
        jlNumPedido.setVisible(true);
        jlNumPedido.setText("Nº Pedido:  "+pedido.getId().toString());
        jbtExcluirPedido.setEnabled(true);
    }

    
    private void habilitar(boolean habilita){       
        jbtExcluirPedido.setEnabled(habilita);
        jbtPagamento.setEnabled(habilita);
        jbtPesquisaProduto.setEnabled(habilita);
        jbtExcluirProduto.setEnabled(habilita);
        jlNumPedido.setEnabled(habilita);
//        jbtCliente.setEnabled(habilita); 
//        jtfCodProd.setEnabled(habilita);
        jtfSubTotal.setEnabled(habilita);
        jcbProduto.setEnabled(habilita);
        jcbCliente.setEnabled(habilita);
    }
    

    private void carregaCombobox(){
        
        pessoaDAO = new PessoaDAO();
        listaCliente = pessoaDAO.listaClienteALL();
        
        jcbCliente.removeAllItems();
        for(Pessoa p : listaCliente){
            
           if (p.getNome().equals("ADMIN")) 
               jcbCliente.addItem("CONSUMIDOR");
           else
               jcbCliente.addItem(p.getNome()+" - "+p.getId());
        }
                
        jcbCliente.setSelectedIndex(0);
                
        produtoDAO = new ProdutoDAO();
        
        listaProduto = produtoDAO.listaProdutoAtivo();
        jcbProduto.removeAllItems();
        for(Produto pr : listaProduto){
            jcbProduto.addItem(pr.getDescricao());
        }
        
        jcbProduto.setSelectedIndex(-1);       
        
    }
     
    
    
    private void carregaTable(List<PedidoItens> listaItens){
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();        
        amodel.setNumRows(0);
        //BigDecimal subTotal = new BigDecimal(BigInteger.ZERO);
        String vlTotalProd, vlUnitProd;
        subtotal = 0;
        for (PedidoItens iten : listaItens){            
           // vlTotalProd = new DecimalFormat("#,##0.00").format(iten.getVlSubtotal());
           // vlUnitProd = new DecimalFormat("#,##0.00").format(iten.getVlUnit());
            subtotal = (subtotal + Float.parseFloat(iten.getVlSubtotal().toString())) ;
            amodel.addRow(new Object[]{iten.getQuantidade(), iten.getDescricao(), iten.getVlUnit(), iten.getVlSubtotal(), iten.getProduto().getId(), iten.getTipoVenda()});                  
        }       
        jtfSubTotal.setText(String.valueOf(new DecimalFormat("#,##0.00").format(subtotal)));
        jtfSubTotal.setEnabled(true);
        jbtPagamento.setEnabled(true);
        jbtPagamento.requestFocus();
        
    }

/*
if (evt.getKeyCode() == evt.VK_ENTER){
           try{ 
              Long codProd = Long.parseLong(jtfCodProd.getText());
              pedidoDet = new PedidoDetalheView(new java.awt.Frame(), true, codProd, config.getTipoPesquisa(), "BALCAO");
             // pedidoDet.setTitle("Adicionar ao Pedido");
              pedidoDet.idProduto = Long.parseLong(jtfCodProd.getText());
              pedidoDet.setLocationRelativeTo(null);
            //pedidoDet.setPreferredSize(900, 115).;
            //this.setBounds(0, 0, 970, 650);
            //Redimensiona o formulário pedidoDet.
             //pedidoDet.setBounds(350, 350, 800, 254);
             pedidoDet.setBounds(350, 350, 850, 280);
             pedidoDet.setVisible(true); 
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Produto não encontrado !!!");
           }



*/
    
    
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
//            java.util.logging.Logger.getLogger(PedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                PedidoView dialog = new PedidoView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JButton jbtConfig;
    public static javax.swing.JButton jbtExcluirPedido;
    private javax.swing.JButton jbtExcluirProduto;
    private javax.swing.JButton jbtImprimir;
    public static javax.swing.JButton jbtPagamento;
    public static javax.swing.JButton jbtPesquisaProduto;
    private javax.swing.JButton jbtSair;
    public static javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbProduto;
    public static javax.swing.JLabel jlCodigoProduto;
    public static javax.swing.JLabel jlNumPedido;
    public static javax.swing.JLabel jlStatusCaixa;
    public static javax.swing.JTextField jtfObs;
    public static javax.swing.JTextField jtfSubTotal;
    // End of variables declaration//GEN-END:variables
}
