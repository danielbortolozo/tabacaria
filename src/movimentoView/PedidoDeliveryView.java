/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.CaixaDAO;
import dao.PedidoConfigDAO;
import dao.PedidoDAO;
import dao.PedidoEntregaDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import maps.java.Geocoding;
import maps.java.MapsJava;
import model.Caixa;
import model.Pedido;
import model.PedidoConfig;
import model.PedidoEntrega;
import model.PedidoItens;
import model.Pessoa;
import model.Produto;
import util.Localizacao;

/**
 *
 * @author daniel
 */
public class PedidoDeliveryView extends javax.swing.JDialog {

    /**
     * Creates new form PedidoView
     */
    public static Caixa caixa;
    public static CaixaDAO caixaDAO;
    public static Pessoa colaborador;
    public static PessoaDAO pessoaDAO;    
    public static PedidoConfig configPesProduto = new PedidoConfig();
    public static List<Pessoa> listEntregador = new ArrayList<Pessoa>();
    
    
    
   // PessoaDAO pessoaDAO;
   // PedidoDetalheView pedidoDet;
    //public static Long idProduto;
    public static float subtotal;
    public static Pessoa cliente;
    public static List<PedidoItens> listaItens = new ArrayList<>();
    public static Pedido pedido;
    Locale locale = new Locale("pt", "BR");
    SimpleDateFormat formatadorHD = new SimpleDateFormat("dd/MM/yyyy' - 'HH':'mm", locale);
    
    //Essa variavel (status), é para habilitar o atalho F5, para chamar o form de Pagamento
    // se o status for 0, o form de pagamento não abre com o atalho e se for 1 ai abre o form pagamento.
    public static int status;
    public PedidoDeliveryView(java.awt.Frame parent, boolean modal, int status, Pedido pedido) {
        super(parent, modal);
        initComponents();
       // requestFocus();
    //   this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       
        this.status = status;    
        subtotal = 0;
        this.pedido =  new Pedido();
        cliente = new Pessoa() {};
        listEntregador = null;
        carregaCombobox();
        
        
        //Se o status for igual a 1, carrega o formulario para edicao.
        if (this.status == 1){
           this.pedido = pedido;
           
           jcbEntregador.setSelectedItem(this.pedido.getEntregador().getNome());
           jtfObs.setText(this.pedido.getObservacao());
           jbtOK.setEnabled(true);
          jtfCliente.setText(this.pedido.getCliente().getNome());
          jtfTelefone.setText(this.pedido.getPedidoEntrega().getTelefone());
          jtfLogradouro.setText(this.pedido.getPedidoEntrega().getLogradouro());
          jtfNumero.setText(this.pedido.getPedidoEntrega().getNumero());
          jtfBairro.setText(this.pedido.getPedidoEntrega().getBairro());
          jtfCidade.setText(this.pedido.getPedidoEntrega().getCidade());
          jtfEstado.setText(this.pedido.getPedidoEntrega().getEstado());
          jcbStatus.setSelectedItem(this.pedido.getStatus());
          cliente = this.pedido.getCliente();
          
          jlNumPedido.setText("Nº PEDIDO: "+(String.valueOf(this.pedido.getId())));
          jlNumPedido.setVisible(true);
          
           
           carregaTable(this.pedido.getListaItens());
        }  
        
        
        PedidoConfigDAO configDAO = new PedidoConfigDAO();
        
        configPesProduto = new PedidoConfig();
        configPesProduto = configDAO.configuracao(1L);
        
        System.out.println("confPesquisa Produto ="+configPesProduto.getTipoPesquisa());
        if (configPesProduto.getTipoPesquisa().equals("CODIGO"))
           jlCodigoProduto.setText("CÓDIGO");
        else
            if (configPesProduto.getTipoPesquisa().equals("CODIGOINTERNO"))
                jlCodigoProduto.setText("CÓDIGO INTERNO");
            else
                if (configPesProduto.getTipoPesquisa().equals("CODIGOBARRAS"))
                    jlCodigoProduto.setText("CÓDIGO BARRAS");
        
        
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
           
           if (this.status == 0)
           jlNumPedido.setVisible(false);
           else
               jlNumPedido.setVisible(true);
           //jtfSubTotal.setEnabled(false);          
        }catch(Exception e){
           jlStatusCaixa.setText("CAIXA FECHADO");
           jlStatusCaixa.setForeground(Color.RED);
           jbtPesquisaProduto.setEnabled(false);
           jtfCodProd.setEnabled(false);
           jlNumPedido.setVisible(false);
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
                          case 115:{
                              jbtClienteActionPerformed(null);
                              break;
                          }
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
       
       jTabbedPane1.setEnabledAt(1, true);
       jtfCliente.setEnabled(true);
       jbtCliente.setEnabled(true);
       //jtfCodProd.requestFocus();
        
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
        jLabel5 = new javax.swing.JLabel();
        jtfObs = new javax.swing.JTextField();
        jlNumPedido = new javax.swing.JLabel();
        jlCodigoProduto = new javax.swing.JLabel();
        jtfCodProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfSubTotal = new javax.swing.JTextField();
        jcbEntregador = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbtSair = new javax.swing.JButton();
        jbtImprimir = new javax.swing.JButton();
        jbtOK = new javax.swing.JButton();
        jbtExcluirPedido = new javax.swing.JButton();
        jbtPagamento = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbtPesquisaProduto = new javax.swing.JButton();
        jbtExcluirProduto = new javax.swing.JButton();
        jcbStatus = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlabelLogradouro = new javax.swing.JLabel();
        jtfLogradouro = new javax.swing.JTextField();
        jlabelLogradouro1 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfBairro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfEstado = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jtfCliente = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jbtCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);
        setResizable(false);
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

        jLabel5.setText("OBSERVAÇÃO");

        jtfObs.setEnabled(false);

        jlNumPedido.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlNumPedido.setForeground(java.awt.Color.blue);
        jlNumPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNumPedido.setText("PEDIDO Nº - 0");
        jlNumPedido.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlCodigoProduto.setText("CÓD. PRODUTO");

        jtfCodProd.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jtfCodProd.setNextFocusableComponent(jbtSair);
        jtfCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodProdKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCodProdKeyPressed(evt);
            }
        });

        jLabel2.setText("R$ SUBTOTAL");

        jtfSubTotal.setEditable(false);
        jtfSubTotal.setBackground(new java.awt.Color(255, 244, 131));
        jtfSubTotal.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jtfSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSubTotal.setFocusable(false);

        jcbEntregador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbEntregadorKeyPressed(evt);
            }
        });

        jLabel6.setText("ENTREGADOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfObs, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(189, 189, 189))
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtfCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jlNumPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumPedido)
                    .addComponent(jlStatusCaixa)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCodigoProduto)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfCodProd)
                    .addComponent(jtfSubTotal))
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

        jbtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbtOK.setText("OK");
        jbtOK.setEnabled(false);
        jbtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOKActionPerformed(evt);
            }
        });
        jbtOK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtOKKeyPressed(evt);
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

        jbtPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Calculator.png"))); // NOI18N
        jbtPagamento.setText("Pagamento[F5]");
        jbtPagamento.setEnabled(false);
        jbtPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jbtExcluirPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtOK, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jbtOK)
                .addComponent(jbtExcluirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtPagamento))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EM ANDAMENTO", "PRONTO P/ ENTREGA", "SAIU P/ ENTREGA" }));

        jLabel9.setText("STATUS:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtPesquisaProduto)
                        .addComponent(jbtExcluirProduto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbStatus)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "QTD.", "PRODUTO", "R$ PREÇO UNIT.", "R$ SUBTOTAL", "COD.PROD.", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class
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
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jTabbedPane1.addTab("PEDIDO", jScrollPane1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("ENDEREÇO ENTREGA"));

        jlabelLogradouro.setText("LOGRADOURO");

        jtfLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfLogradouroKeyPressed(evt);
            }
        });

        jlabelLogradouro1.setText("NUMERO");

        jtfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNumeroKeyPressed(evt);
            }
        });

        jLabel1.setText("BAIRRO");

        jtfBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfBairroKeyPressed(evt);
            }
        });

        jLabel3.setText("CIDADE");

        jtfCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCidadeKeyPressed(evt);
            }
        });

        jLabel8.setText("ESTADO");

        jtfEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfEstadoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                .addComponent(jtfBairro)
                                .addComponent(jtfLogradouro)
                                .addComponent(jlabelLogradouro, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jlabelLogradouro1)
                            .addComponent(jtfEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jtfNumero))))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelLogradouro)
                    .addComponent(jlabelLogradouro1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("CLIENTE"));

        jtfCliente.setEditable(false);
        jtfCliente.setEnabled(false);

        jtfTelefone.setEditable(false);

        jLabel7.setText("TELEFONE");

        jbtCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jbtCliente.setText("[F4]");
        jbtCliente.setEnabled(false);
        jbtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("NOME");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTE / ENTREGA", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
 
        dispose();
        
        
        
//        if (pedido.getId() == null){
//           dispose();
//        }else{
//           JOptionPane.showMessageDialog(null, "Exclua o Pedido, ou finaliza com algum /n"
//                   + " tipo de pagamento para Sair");
//        }
        
            
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisaProdutoActionPerformed
       formPesquisaProduto();
        
    }//GEN-LAST:event_jbtPesquisaProdutoActionPerformed

    public static void formPesquisaProduto(){
        PesquisaProdutoView pProd = new PesquisaProdutoView(new java.awt.Frame(), true,  "DELIVERY");
        pProd.setTitle("Pesquisa Produto");
        pProd.setLocationRelativeTo(null); // centraliza a tela
        pProd.setVisible(true);
        
    }
    
    public static void formPedidoPagamento(){        
        
        PedidoPagamentoView p = new PedidoPagamentoView(new java.awt.Frame(), true, "DELIVERY");
        p.setTitle("Pagamento Delivery");
        p.setLocationRelativeTo(null); // centraliza a tela
        p.setVisible(true);
        
    }
    
    
    
    public static void formPesquisaCliente(){
        PesquisaClienteDeliveryView pesCli = new PesquisaClienteDeliveryView(new java.awt.Frame(), true);
        pesCli.setTitle("Pesquisa de Cliente - Adicionar ao Pedido Delivery");        
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
              
              PedidoDetalheView pedidoDet; 
              String codProd = (jtfCodProd.getText());
               
              pedidoDet = new PedidoDetalheView(new java.awt.Frame(), true, codProd, "DELIVERY", configPesProduto.getTipoPesquisa());
             // pedidoDet.setTitle("Adicionar ao Pedido");
              pedidoDet.setLocationRelativeTo(null);
              pedidoDet.setVisible(true); 
              jtfCodProd.setText("");
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Produto não encontrado !!!");
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

    private void jbtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirProdutoActionPerformed
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        
        
        float vlRemovido = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        
        subtotal = (subtotal - vlRemovido);
        jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(subtotal));
        //Remover da listaItens.
        listaItens.remove(jTable1.getSelectedRow());
       // System.out.println("tamanho da lista ="+listaItens.size());
        amodel.removeRow(jTable1.getSelectedRow());
        jbtExcluirProduto.setEnabled(false);
        
    }//GEN-LAST:event_jbtExcluirProdutoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jbtExcluirProduto.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOKActionPerformed
       
        //pedido = null;
       //Chamando formulario de PedidoPagamento.
        if (jcbEntregador.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(null, "Selecione um Entregador");
            return;
        }
        
        if (this.status == 0){
           registraPedido();
           DefaultTableModel amodelPPDV = (DefaultTableModel) PedidoPesquisaDeliveryView.jTable1.getModel();
           String dataHora = formatadorHD.format(pedido.getDtCad());
           amodelPPDV.addRow(new Object[]{pedido.getId(), dataHora, pedido.getCliente().getNome(), pedido.getPedidoEntrega().getTelefone(),
           pedido.getStatus(), jtfSubTotal.getText()});
           
                 
        }else
            if (this.status == 1){
                
                //Alterar Pedido de Entrega
                this.pedido.setStatus(jcbStatus.getSelectedItem().toString());
                this.pedido.setEntregador(listEntregador.get(jcbEntregador.getSelectedIndex()));
                
                //cliente = this.pedido.getCliente();
                System.out.println("cliente = "+cliente);
                this.pedido.setCliente(cliente);
                
                System.out.println("Cliente = "+ this.pedido.getCliente().getNome());
                           
                //Atualizar Endereco Entrega
                PedidoEntregaDAO peDao = new PedidoEntregaDAO();
                PedidoEntrega pe = new PedidoEntrega();
                
                pe = this.pedido.getPedidoEntrega();
                
                pe.setLogradouro(jtfLogradouro.getText());
                pe.setNumero(jtfNumero.getText());
                pe.setBairro(jtfBairro.getText());
                pe.setCidade(jtfCidade.getText());
                pe.setEstado(jtfEstado.getText());
                pe.setTelefone(jtfTelefone.getText());
                
                peDao.alterar(pe);
                PedidoItens pItens = new PedidoItens();
                Produto prod = new Produto();
                ProdutoDAO prodDao = new ProdutoDAO();
                Long idProduto = null;
                int idIten = 0;
                for(int i=0; i < jTable1.getRowCount(); i++){
                    
                    idIten = Integer.parseInt(jTable1.getValueAt(i, 5).toString());
                    if (idIten == 0){
                        
                        pItens.setQuantidade(new BigDecimal(jTable1.getValueAt(i, 0).toString()));
                        pItens.setDescricao(jTable1.getValueAt(i, 1).toString());
                        pItens.setVlUnit(new BigDecimal(jTable1.getValueAt(i, 2).toString()));
                        pItens.setVlSubtotal(new BigDecimal(jTable1.getValueAt(i, 3).toString()));
                        
                        //Adicionar o produto
                        idProduto = Long.parseLong(jTable1.getValueAt(i, 4).toString());
                        
                        prod = prodDao.produtoId(idProduto);
                        pItens.setProduto(prod);  
                        pItens.setPedido(this.pedido);
                        pItens.setId(null);
                        this.pedido.getListaItens().add(pItens);
                    }
                    
                }
                
                
                PedidoDAO pedidoDAO = new PedidoDAO();
                pedidoDAO.alterar(pedido);
                PedidoPesquisaDeliveryView.jTable1.setValueAt(this.pedido.getCliente().getNome(), PedidoPesquisaDeliveryView.jTable1.getSelectedRow(), 2);
                PedidoPesquisaDeliveryView.jTable1.setValueAt(jtfTelefone.getText(), PedidoPesquisaDeliveryView.jTable1.getSelectedRow(), 3);
                PedidoPesquisaDeliveryView.jTable1.setValueAt(this.pedido.getStatus(), PedidoPesquisaDeliveryView.jTable1.getSelectedRow(), 4);
                PedidoPesquisaDeliveryView.jTable1.setValueAt(jtfSubTotal.getText(), PedidoPesquisaDeliveryView.jTable1.getSelectedRow(), 5);
                
                
            }
        //formPedidoPagamento();
       // PedidoPesquisaDeliveryView
       //Zerar Variaveis.
       listaItens = new ArrayList<>();
       pedido = new Pedido();
       JOptionPane.showMessageDialog(null, "Pedido Alterado com Sucesso !!!");
       dispose();    
    }//GEN-LAST:event_jbtOKActionPerformed

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
            amodel.addRow(new Object[]{iten.getQuantidade(), iten.getDescricao(), iten.getVlUnit(), iten.getVlSubtotal(), iten.getProduto().getId(), iten.getId()});                  
        }       
        jtfSubTotal.setText(String.valueOf(new DecimalFormat("#,##0.00").format(subtotal)));
        jtfSubTotal.setEnabled(true);
        jbtPagamento.setEnabled(true);
        jbtPagamento.requestFocus();
        
    }
    
    
    
    
    
    
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
            jbtOK.setEnabled(false);
      //      jbtConfig.setEnabled(true);
            jtfCodProd.requestFocus();          
            
            JOptionPane.showMessageDialog(null, "Pedido Excluido com Sucesso!!!");
        }        
    }//GEN-LAST:event_jbtExcluirPedidoActionPerformed

    private void jbtExcluirPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtExcluirPedidoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtExcluirPedidoActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtExcluirPedidoKeyPressed

    private void jbtOKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtOKKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtOKActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtOKKeyPressed

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtSairActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSairKeyPressed

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
                jbtExcluirPedidoActionPerformed(null);
        } 
    }//GEN-LAST:event_jbtExcluirProdutoKeyPressed

    private void jcbEntregadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbEntregadorKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            
            if (jcbEntregador.getSelectedIndex() < 0){
                JOptionPane.showMessageDialog(null, "Seleciona um Entregador !!!");
                return;
            }else{
                jtfCodProd.requestFocus();
            }
                
        }
    }//GEN-LAST:event_jcbEntregadorKeyPressed

    private void jtfLogradouroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLogradouroKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfLogradouro.getText().equals("")){
                JOptionPane.showMessageDialog(null, "O endereço não pode ficar vazio !!!");
                return;
            }else{
                jtfLogradouro.setText(jtfLogradouro.getText().toUpperCase());
                jtfNumero.requestFocus();
            }
            
            
        }
    }//GEN-LAST:event_jtfLogradouroKeyPressed

    private void jbtPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPagamentoActionPerformed

        registraPedido();
        formPedidoPagamento();
    }//GEN-LAST:event_jbtPagamentoActionPerformed

    private void jtfNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumeroKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfNumero.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Digite um número. Caso não tenha número digite zero (0)");
            else{
                jtfBairro.requestFocus();
            }
                
            
            
        }
    }//GEN-LAST:event_jtfNumeroKeyPressed

    private void jtfBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBairroKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfBairro.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Digite o Bairro");
            else{
                jtfBairro.setText(jtfBairro.getText().toUpperCase());
                jtfCidade.requestFocus();
            }
                
            
        }
    }//GEN-LAST:event_jtfBairroKeyPressed

    private void jtfCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCidadeKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfCidade.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Digite a Cidade");
            else{
                jtfCidade.setText(jtfCidade.getText().toUpperCase());
                jtfEstado.requestFocus();
            }
                
            
        }
    }//GEN-LAST:event_jtfCidadeKeyPressed

    private void jtfEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstadoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfEstado.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Digite o Estado");
            else{
                jtfEstado.setText(jtfEstado.getText().toUpperCase());
                jbtOK.requestFocus();
            }
                
            
        }
    }//GEN-LAST:event_jtfEstadoKeyPressed

//    private void validarDestino(String destino) throws UnsupportedEncodingException, MalformedURLException{
//        if(!destino.isEmpty()){
//          Geocoding ObjGeocoding=new Geocoding();
//          ObjGeocoding.getCoordinates(destino);
//         // jlDestino.setText("DESTINO: "+ObjGeocoding.getAddressFound());
//        }
//    }      
    
//    private void calculaRuta(String destino){
//        if(!destino.isEmpty()){
//           // this.setVisible(false);
//            RutaCalcula formulario=new RutaCalcula(destino,true);
//           // Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//          //  formulario.setLocation((d.width/2)-(formulario.getWidth()/2), (d.height/2)-(formulario.getHeight()/2));
////            formulario.setSize(new Dimension(400, 350));
//            formulario.setVisible(true);
//        }
//    }
    
    
    
    
    public static void  registraPedido() {
        Pedido p = new Pedido(); 
        PedidoEntrega pe = new PedidoEntrega();
        
               
        if (pedido.getId() == null ){            
          
            
            if (jtfCliente.getText().equals("")){
               // cliente = pessoaDAO.pessoa(1L);
               // p.setCliente(cliente);
               JOptionPane.showMessageDialog(null, "Pedido de Entrega sem  Cliente.");
               return;
            }else
                p.setCliente(cliente);    
            
            //Valida Endereço de Entrega
            if (validaEndereco())return;
            //Salvar Endereco de Entrega do Pedido.
            pe.setLogradouro(jtfLogradouro.getText());
            pe.setNumero(jtfNumero.getText());
            pe.setBairro(jtfBairro.getText());
            pe.setCidade(jtfCidade.getText());
            pe.setEstado(jtfEstado.getText());
            pe.setTelefone(jtfTelefone.getText());
            
            PedidoEntregaDAO peDAO = new PedidoEntregaDAO();
            peDAO.salvar(pe);
            

            //Salvar Pedido.
            p.setColaborador(colaborador);            
            p.setEntregador(listEntregador.get(jcbEntregador.getSelectedIndex()));
            p.setDtCad(new Date());
            p.setObservacao(jtfObs.getText());
            p.setTipoPedido("DELIVERY");
            p.setStatus("EM ANDAMENTO");
            p.setListaItens(listaItens); 
            p.setPedidoEntrega(pe);
            
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedido = pedidoDAO.salvar(p);
            
 
        }
        jlNumPedido.setVisible(true);
        jlNumPedido.setText("Nº Pedido:  "+pedido.getId().toString());
        jbtExcluirPedido.setEnabled(true);
        
 
    }

    private static boolean validaEndereco() throws HeadlessException {
        if (jtfLogradouro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Endereço de Entrega esta vazio !!!");
            //  jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            jtfLogradouro.requestFocus();
            return true;
        }
        if (jtfNumero.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Número do Endereço de Entrega esta vazio !!!");
            jTabbedPane1.setSelectedIndex(1);
            jtfNumero.requestFocus();
            return true;
        }
        if (jtfBairro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bairro do Endereço de Entrega esta vazio !!!");
            jTabbedPane1.setSelectedIndex(1);
            jtfBairro.requestFocus();
            return true;
        }
        if (jtfCidade.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Cidade do Endereço de Entrega esta vazio !!!");
            jTabbedPane1.setSelectedIndex(1);
            jtfCidade.requestFocus();
            return true;
        }
        if (jtfEstado.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Estado do Endereço de Entrega esta vazio !!!");
            jTabbedPane1.setSelectedIndex(1);
            jtfEstado.requestFocus();
            return true;
        }
        
        
        return false;
    }

    
    private void habilitar(boolean habilita){       
        jbtExcluirPedido.setEnabled(habilita);
        jbtOK.setEnabled(habilita);
        jbtPesquisaProduto.setEnabled(habilita);
        jbtExcluirProduto.setEnabled(habilita);
        jlNumPedido.setEnabled(habilita);
        jbtCliente.setEnabled(habilita); 
        jtfCodProd.setEnabled(habilita);
        jtfSubTotal.setEnabled(habilita);
    }
    
    private void carregaCombobox(){
        pessoaDAO = new PessoaDAO();
        //listEntregador = 
        
        if (listEntregador == null){
           listEntregador = pessoaDAO.listaColaboradorALL();             
        }
    
         jcbEntregador.removeAllItems();
         for (Pessoa p : listEntregador){
             jcbEntregador.addItem(p.getNome());
         }
         jcbEntregador.setSelectedIndex(-1);
        
        
    }
    private void limpar(){
        
        jtfLogradouro.setText("");
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
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JButton jbtCliente;
    public static javax.swing.JButton jbtExcluirPedido;
    private javax.swing.JButton jbtExcluirProduto;
    private javax.swing.JButton jbtImprimir;
    public static javax.swing.JButton jbtOK;
    public static javax.swing.JButton jbtPagamento;
    public static javax.swing.JButton jbtPesquisaProduto;
    private javax.swing.JButton jbtSair;
    public static javax.swing.JComboBox<String> jcbEntregador;
    private javax.swing.JComboBox<String> jcbStatus;
    public static javax.swing.JLabel jlCodigoProduto;
    public static javax.swing.JLabel jlNumPedido;
    public static javax.swing.JLabel jlStatusCaixa;
    private javax.swing.JLabel jlabelLogradouro;
    private javax.swing.JLabel jlabelLogradouro1;
    public static javax.swing.JTextField jtfBairro;
    public static javax.swing.JTextField jtfCidade;
    public static javax.swing.JTextField jtfCliente;
    public static javax.swing.JTextField jtfCodProd;
    public static javax.swing.JTextField jtfEstado;
    public static javax.swing.JTextField jtfLogradouro;
    public static javax.swing.JTextField jtfNumero;
    public static javax.swing.JTextField jtfObs;
    public static javax.swing.JTextField jtfSubTotal;
    public static javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}
