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
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.Timestamp;
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

/**
 *
 * @author daniel
 */
public class PedidoView extends javax.swing.JDialog {

    /**
     * Creates new form PedidoView
     */
    public static Caixa caixa;
    public static CaixaDAO caixaDAO;
    public static Pessoa colaborador;
    public static PessoaDAO pessoaDAO;    
    public static PedidoConfig config = new PedidoConfig();
    
    
    PedidoDetalheView pedidoDet;
    //public static Long idProduto;
    public static float subtotal;
    public static Pessoa cliente;
    public static List<PedidoItens> listaItens = new ArrayList<>();
    public static Pedido pedido = new Pedido();
    public static PedidoPagamentoView pedidoPagView = null;
    public static PesquisaClienteView pesCli = null;
    public static PesquisaProdutoView pProdView = null;
    public static PesquisaPedidoView formPesPedido = null;
    public PedidoView(java.awt.Frame parent, boolean modal, List<PedidoItens> listaItens, Pessoa clienteOrc ) {
        super(parent, modal);
        initComponents();
        requestFocus();
        subtotal = 0;
        cliente = clienteOrc;
        if (cliente != null){
               jtfCliente.setText(cliente.getNome());               
               carregaTable(listaItens);
               jlStatusCaixa.setText("CAIXA OCUPADO");
               jlStatusCaixa.setForeground(Color.RED); 
               
              // return;
        }else
            cliente = new Pessoa() {};
       
//        PedidoConfigDAO configDAO = new PedidoConfigDAO();
//        //listaItens = 
      //  listaItens = null;
        config.setTipoPesquisa("CODIGOBARRAS"); 
//                configDAO.configuracao(1L);
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
        
        try{
           caixa = caixaDAO.carregaCaixa(colaborador);
           jlStatusCaixa.setText("CAIXA LIVRE");
           jtfCodProd.setEnabled(true);
           jtfCliente.setEnabled(true);
           jtfCliente.setEditable(false);
           jbtCliente.setEnabled(true);
           jlNumPedido.setVisible(false);
           jtfSubTotal.setEnabled(false); 
           jtfCodProd.requestFocus();
           
//           carregaCombobox();
// 
//           
//           //quando vem do orçamento
          
           
           
           
        }catch(Exception e){
           jlStatusCaixa.setText("CAIXA FECHADO");
           jlStatusCaixa.setForeground(Color.RED);
           jbtPesquisaProduto.setEnabled(false);
           jtfCodProd.setEnabled(false);
           jlNumPedido.setVisible(false);
            habilitar(false);
        }
        
//          EventQueue queue = new EventQueue(){
//           protected void dispatchEvent(final AWTEvent event){
//               super.dispatchEvent(event);
//               String a[];
//               String tecla[];
//               if (!event.paramString().equals("")){
//                  if (event.paramString().substring(0, 5).equals("KEY_P")){
//                      a = event.paramString().split(",");
//                      tecla = a[1].split("=");
//          //            System.out.println("tecla"+Integer.parseInt(tecla[1]));
//                      switch (Integer.parseInt(tecla[1])){                          
////                          case 27:{
////                                
////                              break;
////                            }  
////                          case 113: // = Tecla - F2
////                              jbtAbrirCaixaActionPerformed(null);
////                              break;
//                          case 114:{
//                              if (jbtPesquisaProduto.isEnabled()){
//                                // jbtPesquisaProdutoActionPerformed(null);
////                                   PesquisaProdutoView pProd = new PesquisaProdutoView(new java.awt.Frame(), true, "BALCAO");
////                                   pProd.setTitle("Pesquisa Produto");
////                                   pProd.setLocationRelativeTo(null); // centraliza a tela
////                                   pProd.setVisible(true); 
//                              formPesquisaProduto();
//                              }else
//                                 JOptionPane.showMessageDialog(null, "Caixa Fechado");
//                              break;
//                              }
//                          case 115:{
//                                  System.out.println("entrei no F4");
//                                  jbtClienteActionPerformed(null);
//                              //JOptionPane.showMessageDialog(null, "F4");
//                              break;
//                              } 
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
       
        
       //Maximiza Formulario JDialog.
//       Toolkit toolkit = Toolkit.getDefaultToolkit();  
//       Dimension screenSize = toolkit.getScreenSize();  
//       this.setBounds(0, 0, screenSize.width, screenSize.height);
//       
        
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
        jlStatusCaixa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfCliente = new javax.swing.JTextField();
        jbtCliente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfObs = new javax.swing.JTextField();
        jlNumPedido = new javax.swing.JLabel();
        jlCodigoProduto = new javax.swing.JLabel();
        jtfCodProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfSubTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbtSair = new javax.swing.JButton();
        jbtImprimir = new javax.swing.JButton();
        jbtPagamento = new javax.swing.JButton();
        jbtExcluirPedido = new javax.swing.JButton();
        jbtPesquisaPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbtPesquisaProduto = new javax.swing.JButton();
        jbtExcluirProduto = new javax.swing.JButton();

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
        jPanel1.setNextFocusableComponent(jtfCodProd);

        jlStatusCaixa.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlStatusCaixa.setForeground(java.awt.Color.blue);
        jlStatusCaixa.setText("CAIXA OCUPADO");

        jLabel4.setText("CLIENTE");

        jtfCliente.setEnabled(false);
        jtfCliente.setFocusable(false);

        jbtCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jbtCliente.setText("Cliente");
        jbtCliente.setNextFocusableComponent(jtfCodProd);
        jbtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClienteActionPerformed(evt);
            }
        });
        jbtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtClienteKeyPressed(evt);
            }
        });

        jLabel5.setText("OBSERVAÇÃO");

        jtfObs.setEnabled(false);

        jlNumPedido.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlNumPedido.setForeground(java.awt.Color.blue);
        jlNumPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNumPedido.setText("VENDA Nº - 0");
        jlNumPedido.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlCodigoProduto.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jlCodigoProduto.setText("CÓD. PRODUTO");

        jtfCodProd.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jtfCodProd.setNextFocusableComponent(jbtPesquisaProduto);
        jtfCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodProdKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCodProdKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("R$ SUBTOTAL");

        jtfSubTotal.setEditable(false);
        jtfSubTotal.setBackground(new java.awt.Color(255, 244, 131));
        jtfSubTotal.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jtfSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSubTotal.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfObs, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(jtfCliente))
                    .addComponent(jlStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlNumPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumPedido)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlCodigoProduto))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlStatusCaixa)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodProd))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.setNextFocusableComponent(jbtCliente);
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
        jbtImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtImprimirActionPerformed(evt);
            }
        });
        jbtImprimir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtImprimirKeyPressed(evt);
            }
        });

        jbtPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Calculator.png"))); // NOI18N
        jbtPagamento.setText("Pagamento ");
        jbtPagamento.setEnabled(false);
        jbtPagamento.setNextFocusableComponent(jbtSair);
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

        jbtPesquisaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jbtPesquisaPedido.setText("Venda [F6]");
        jbtPesquisaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisaPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jbtExcluirPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtPesquisaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtImprimir)
                .addComponent(jbtPagamento)
                .addComponent(jbtExcluirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtPesquisaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "QTD.", "UND", "PRODUTO", "R$ PREÇO UNIT.", "R$ SUBTOTAL", "COD.PROD.", "VENDA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(65);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtPesquisaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jbtPesquisaProduto.setText("Produto ");
        jbtPesquisaProduto.setToolTipText("Pesquisa Produto");
        jbtPesquisaProduto.setNextFocusableComponent(jbtPagamento);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtPesquisaProduto)
                    .addComponent(jbtExcluirProduto))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
       
        if (pedido.getId() == null){
           listaItens.clear();
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
        
        if (pProdView == null)
           pProdView = new PesquisaProdutoView(new java.awt.Frame(), true, "BALCAO");
        pProdView.setTitle("Pesquisa Produto");
        pProdView.setLocationRelativeTo(null); // centraliza a tela
        pProdView.setVisible(true);
        pProdView.jtfPesquisa.setText("");
      //  pProdView.requestFocus();
        
    }
    public static void formPedidoPagamento(){    
        if (pedidoPagView == null)
           pedidoPagView = new PedidoPagamentoView(new java.awt.Frame(), true, "BALCAO");
        pedidoPagView.setTitle("Pagamento Balcão");
        pedidoPagView.setLocationRelativeTo(null); // centraliza a tela
        pedidoPagView.setVisible(true);        
    }
    public static void formPesquisaPedido(){    
       
        formPesPedido = new PesquisaPedidoView();
        
                
    }
    
    public static void formPesquisaCliente(){        
        if (pesCli == null)
           pesCli = new PesquisaClienteView(new java.awt.Frame(), true, "PEDIDO");
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

    private void jtfCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodProdKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
           try{ 
               
                
              String codProd = (jtfCodProd.getText());
              
               //System.out.println("CodigoProduto ="+codProd);
              pedidoDet = new PedidoDetalheView(new java.awt.Frame(), true, codProd, "BALCAO", config.getTipoPesquisa());
             // pedidoDet.setTitle("Adicionar ao Pedido");
              pedidoDet.idProduto = (jtfCodProd.getText());
              pedidoDet.setLocationRelativeTo(null);
            //pedidoDet.setPreferredSize(900, 115).;
            //this.setBounds(0, 0, 970, 650);
            //Redimensiona o formulário pedidoDet.
             //pedidoDet.setBounds(350, 350, 800, 254);
            // pedidoDet.setBounds(350, 350, 850, 280);
             pedidoDet.setVisible(true); 
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Produto não encontrado !!!");
               jtfCodProd.setText("");
           }
        }
    }//GEN-LAST:event_jtfCodProdKeyPressed

    private void jtfCodProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodProdKeyTyped
        String caracteres="0987654321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfCodProdKeyTyped

    private void jbtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClienteActionPerformed
        formPesquisaCliente();
        
    }//GEN-LAST:event_jbtClienteActionPerformed
private void carregaTable(List<PedidoItens> listaItens){
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();        
        amodel.setNumRows(0);
        //BigDecimal subTotal = new BigDecimal(BigInteger.ZERO);
        System.out.println("Tamanho da lista: "+listaItens.size());
                
        String vlTotalProd, vlUnitProd;
        subtotal = 0;
        for (PedidoItens iten : listaItens){            
           // vlTotalProd = new DecimalFormat("#,##0.00").format(iten.getVlSubtotal());
           // vlUnitProd = new DecimalFormat("#,##0.00").format(iten.getVlUnit());
            subtotal = (subtotal + Float.parseFloat(iten.getVlSubtotal().toString())) ;
            amodel.addRow(new Object[]{iten.getQuantidade(), iten.getProduto().getUnidade().getSigla(), iten.getDescricao(), iten.getVlUnit(), iten.getVlSubtotal(), iten.getProduto().getId(), iten.getTipoVenda()});                  
        }       
        jtfSubTotal.setText(String.valueOf(new DecimalFormat("#,##0.00").format(subtotal)));
        jtfSubTotal.setEnabled(true);
        jbtPagamento.setEnabled(true);
        jbtPagamento.requestFocus();
        
    }
    private void jbtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirProdutoActionPerformed
       DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        
        String vlRemovidoStr = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        vlRemovidoStr = vlRemovidoStr.replace(".", "");
        vlRemovidoStr = vlRemovidoStr.replace(",", ".");
        
        float vlRemovido = Float.parseFloat(vlRemovidoStr);        
        
        subtotal = (subtotal - vlRemovido);
        jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(subtotal));
        //Remover da listaItens.
        
        if (pedido.getId() == null)
           listaItens.remove(jTable1.getSelectedRow());
        else
            if (pedido.getId() != null){
                PedidoItens pItens = new PedidoItens();
                PedidoDAO pDAO = new PedidoDAO();
                
                pItens = listaItens.get(jTable1.getSelectedRow());
                if (pItens.getId() != null){
                   pDAO.removerItens(pItens);
                   pedido = pDAO.pedidoID(pedido.getId());
                   listaItens = pedido.getListaItens();
                }else{
                    listaItens.remove(jTable1.getSelectedRow());
                }
                    
            }
       // System.out.println("tamanho da lista ="+listaItens.size());
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
            jtfCliente.setText("");
            jtfObs.setText("");
            jtfSubTotal.setText("");
            subtotal = 0;
            cliente = new Pessoa() {};
            listaItens = new ArrayList<>();
            DefaultTableModel modelPedido = (DefaultTableModel) jTable1.getModel();
            modelPedido.setNumRows(0);
            jbtPagamento.setEnabled(false);
           
            jtfCodProd.requestFocus();          
            
            JOptionPane.showMessageDialog(null, "Pedido Excluido com Sucesso!!!");
        }        
    }//GEN-LAST:event_jbtExcluirPedidoActionPerformed

    private void jbtImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtImprimirActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jbtImprimirActionPerformed

    private void jbtPesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtPesquisaProdutoKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)) 
                formPesquisaProduto();
       }
        
    }//GEN-LAST:event_jbtPesquisaProdutoKeyPressed

    private void jbtPagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtPagamentoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)) { 
               registraPedido();
               formPedidoPagamento();
            }
       }
    }//GEN-LAST:event_jbtPagamentoKeyPressed

    private void jbtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtClienteKeyPressed

       if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)) {
                formPesquisaCliente();
            }
       }
    }//GEN-LAST:event_jbtClienteKeyPressed

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)) 
                jbtSairActionPerformed(null);
       }
    }//GEN-LAST:event_jbtSairKeyPressed

    private void jbtExcluirPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtExcluirPedidoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)) 
                jbtExcluirPedidoActionPerformed(null);
       }
    }//GEN-LAST:event_jbtExcluirPedidoKeyPressed

    private void jbtImprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtImprimirKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op)) 
                jbtImprimirActionPerformed(null);
       }
    }//GEN-LAST:event_jbtImprimirKeyPressed

    private void jbtPesquisaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisaPedidoActionPerformed

        formPesquisaPedido();
    }//GEN-LAST:event_jbtPesquisaPedidoActionPerformed

    public static void  registraPedido() {
        Pedido p = new Pedido();       
        PedidoDAO pedidoDAO = new PedidoDAO();
        if (pedido.getId() == null ){            
            if (jtfCliente.getText().equals("")){
                cliente = pessoaDAO.pessoa(1L);
                p.setCliente(cliente);
            }else
                p.setCliente(cliente);  
            
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
        jbtCliente.setEnabled(habilita); 
        jtfCodProd.setEnabled(habilita);
        jtfSubTotal.setEnabled(habilita);
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
    public static javax.swing.JButton jbtCliente;
    public static javax.swing.JButton jbtExcluirPedido;
    private javax.swing.JButton jbtExcluirProduto;
    private javax.swing.JButton jbtImprimir;
    public static javax.swing.JButton jbtPagamento;
    private javax.swing.JButton jbtPesquisaPedido;
    public static javax.swing.JButton jbtPesquisaProduto;
    private javax.swing.JButton jbtSair;
    public static javax.swing.JLabel jlCodigoProduto;
    public static javax.swing.JLabel jlNumPedido;
    public static javax.swing.JLabel jlStatusCaixa;
    public static javax.swing.JTextField jtfCliente;
    public static javax.swing.JTextField jtfCodProd;
    public static javax.swing.JTextField jtfObs;
    public static javax.swing.JTextField jtfSubTotal;
    // End of variables declaration//GEN-END:variables
}
