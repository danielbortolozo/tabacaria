/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.ProdutoDAO;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PedidoItens;
import model.PedidoTrocaPresenteItens;
import model.Produto;
import util.JTableFonteColunaDireitaAzul;

/**
 *
 * @author daniel
 */
public class PedidoDetalheView extends javax.swing.JDialog {

    /**
     * Creates new form PedidoDetalheView
     */
    public static Produto produto;
    public static float vlPrecoMeiaPizza;
    ProdutoDAO produtoDAO;
    String idProduto;
    private float qtd, vlunit, total,totalCusto, vlCusto, vlcomplemento;
    public static String codProduto;
    public static String configPesquisa;
    String tipoPedido;
    
    public PedidoDetalheView(java.awt.Frame parent, boolean modal, String codigoProduto, String tipoPedido, String configPesquisaProduto) {
        super(parent, modal);
        initComponents();
        idProduto = codigoProduto;
        
        configPesquisa = configPesquisaProduto;
        
        iniciar();
        qtd = 0;
        vlunit = 0;
        total = 0;
        vlcomplemento = 0;
  //        jlCodProdMeia.setVisible(false);
  //      jlDescProdMeia.setVisible(false);
        this.tipoPedido = tipoPedido;      
        
        
//       EventQueue queuePedidoDet = new EventQueue(){
//           protected void dispatchEvent(final AWTEvent event){
//               super.dispatchEvent(event);
//               String a[];
//               String tecla[];
//               if (!event.paramString().equals("")){
//                  if (event.paramString().substring(0, 5).equals("KEY_P")){
//                      a = event.paramString().split(",");
//                      tecla = a[1].split("=");
//                     // System.out.println("tecla"+Integer.parseInt(tecla[1]));
//                      switch (Integer.parseInt(tecla[1])){                          
//                          case 27:{
//                              jButton1ActionPerformed(null);
//                              break;
//                          }case 114:{
//                              jButton1ActionPerformed(null);
//                              if (tipoPedido.equals("BALCAO"))
//                                 PedidoView.formPesquisaProduto();
//                              else
//                                 if (tipoPedido.equals("BALCAO1"))
//                                    PedidoView1.formPesquisaProduto();
//                                 else
//                                   if (tipoPedido.equals("DELIVERY"))
//                                       PedidoDeliveryView.formPesquisaProduto();
//                              break;
//                          }case 115:{
//                              jButton1ActionPerformed(null);
//                              if (tipoPedido.equals("BALCAO"))
//                                 PedidoView.formPesquisaCliente();
//                              else
//                                  if (tipoPedido.equals("DELIVERY"))
//                                      PedidoDeliveryView.formPesquisaCliente();
//                              break;
//                          }case 116:{
//                              jButton1ActionPerformed(null);
//                              if (tipoPedido.equals("BALCAO")){
//                                 if (PedidoView.jTable1.getRowCount() > 0){ 
//                                    PedidoView.registraPedido();
//                                    PedidoView.formPedidoPagamento();
//                                 }
//                              }else
//                                 if (tipoPedido.equals("BALCAO1")){
//                                   if (PedidoView1.jTable1.getRowCount() > 0){ 
//                                       PedidoView1.registraPedido();
//                                       PedidoView1.formPedidoPagamento();
//                                    }
//                                 }else
//                                     if (tipoPedido.equals("DELIVERY")){
//                                        if (PedidoDeliveryView.jTable1.getRowCount()> 0){
//                                           PedidoDeliveryView.registraPedido();
//                                         
//                                           if (PedidoDeliveryView.status == 1)
//                                              PedidoDeliveryView.formPedidoPagamento();
//                                        }
//                                     }
//                              break;
//                          }
//                      }
//                  }
//               }               
//           }
//       };
//       Toolkit.getDefaultToolkit().getSystemEventQueue().push(queuePedidoDet);
        
       
    }

   

    private void iniciar() throws NumberFormatException {
        produto = new Produto();
        produtoDAO = new ProdutoDAO();
        
        
        String idProd =  String.valueOf(idProduto);        
        
        if (configPesquisa == null){
        
           produto = produtoDAO.produtoIdAtivo(Long.parseLong(idProd));
           jtfCodigoProduto.setText(idProd);
        }else
            if (configPesquisa.equals("CODIGO")){
               produto = produtoDAO.produtoIdAtivo(Long.parseLong(idProd));
               jLabel1.setText("CÓDIGO");
               jtfCodigoProduto.setText(idProd); 
            }else
                if (configPesquisa.equals("CODIGOINTERNO")){
                   produto = produtoDAO.produtoCodInterno(idProd);
                   jLabel1.setText("CÓD. INTERNO");
                   jtfCodigoProduto.setText(produto.getCod_interno()); 
                }else
                    if (configPesquisa.equals("CODIGOBARRAS")){
                        System.out.println("estou no cod barras");
                       produto = produtoDAO.produtoCodBarras(idProd);
                       jLabel1.setText("CÓD. BARRAS");
                       jtfCodigoProduto.setText(produto.getCodBarras()); 
                       // jbtAdicionarActionPerformed(null);
                    }
        if (produto.getDescricao().equals("DIVERSOS")){
           jLabel3.setText("R$ VALOR");
        }
       
//
//        switch (configPesquisa) {
//            case "CODIGO":
//                //Long.parseLong(PedidoView.jtfCodProd.getText());
//                produto = produtoDAO.produtoIdAtivo(Long.parseLong(idProd));
//                jLabel1.setText("CÓDIGO");
//                jtfCodigoProduto.setText(idProd);
//                break;
//            case "CODIGOINTERNO":
//                produto = produtoDAO.produtoCodInterno(idProd);
//                jLabel1.setText("CÓD. INTERNO");
//                jtfCodigoProduto.setText(produto.getCod_interno());
//                break;
//            case "CODIGOBARRAS":
//                produto = produtoDAO.produtoCodBarras(idProd);
//                jLabel1.setText("CÓD. BARRAS");
//                jtfCodigoProduto.setText(produto.getCodBarras());
//                break;               
//            default:
//                break;
//        }
        
        jlDescricao.setText(produto.getDescricao());
        jlPreco.setText(new DecimalFormat("#,##0.00").format(produto.getVlVenda()));
        jlPreco.setText("R$ "+ jlPreco.getText());
        this.setTitle("ADICIONAR AO PEDIDO - "+produto.getCategoria().getDescricao());
      
        jrbVarejo.setSelected(true);
        
        jtfQuantidade.requestFocus();

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfCodigoProduto = new javax.swing.JTextField();
        jlDescricao = new javax.swing.JLabel();
        jlPreco = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jrbAtacado = new javax.swing.JRadioButton();
        jrbVarejo = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jbtAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 262));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(38, 43, 105));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("CÓD. PRODUTO");

        jtfCodigoProduto.setEditable(false);
        jtfCodigoProduto.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jtfCodigoProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoProduto.setFocusable(false);
        jtfCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodigoProdutoKeyTyped(evt);
            }
        });

        jlDescricao.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlDescricao.setForeground(java.awt.Color.white);
        jlDescricao.setText("Descricao");

        jlPreco.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlPreco.setForeground(java.awt.Color.white);
        jlPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlPreco.setText("Preco");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfCodigoProduto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jlDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setNextFocusableComponent(jtfQuantidade);

        jtfQuantidade.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jtfQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuantidadeActionPerformed(evt);
            }
        });
        jtfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("QUANTIDADE");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("VENDA TIPO"));

        buttonGroup1.add(jrbAtacado);
        jrbAtacado.setText("ATACADO");
        jrbAtacado.setFocusable(false);
        jrbAtacado.setRequestFocusEnabled(false);
        jrbAtacado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAtacadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbVarejo);
        jrbVarejo.setSelected(true);
        jrbVarejo.setText("VAREJO");
        jrbVarejo.setFocusable(false);
        jrbVarejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbVarejoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbVarejo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jrbAtacado)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbVarejo)
                    .addComponent(jrbAtacado))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(247, 247, 247)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jButton1.setText("Cancelar[ESC]");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jbtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jbtAdicionar.setText("Adicinar");
        jbtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionarActionPerformed(evt);
            }
        });
        jbtAdicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtAdicionarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(808, 292));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoProdutoKeyTyped
        String caracteres="0987654321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfCodigoProdutoKeyTyped

    private void jtfQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyTyped
        String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfQuantidadeKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        jtfQuantidade.setText("");
        PedidoView.pProdView =null;
        dispose();
//        if (tipoPedido.equals("BALCAO")){
//           PedidoView.jtfCodProd.setText("");
//           PedidoView.jtfCodProd.requestFocus();
//        }else
//            if (tipoPedido.equals("DELIVERY")){
//                PedidoDeliveryView.jtfCodProd.setText("");
//                PedidoDeliveryView.jtfCodProd.requestFocus();
//            }
        
        
        
        
        
       // Toolkit.getDefaultToolkit().getSystemEventQueue().push();
        //this.set
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionarActionPerformed
        DefaultTableModel amodelBalcao = null;
        DefaultTableModel amodelDelivery = null; 
       
        if (tipoPedido.equals("BALCAO"))
           amodelBalcao = (DefaultTableModel) PedidoView.jTable1.getModel();
        else
            if (tipoPedido.equals("BALCAO1"))
                amodelBalcao = (DefaultTableModel) PedidoView1.jTable1.getModel();
        else
            if (tipoPedido.equals("DELIVERY"))
                amodelDelivery = (DefaultTableModel) PedidoDeliveryView.jTable1.getModel();
            else
                if (this.tipoPedido.equals("DEVOLUCAO"))
                    amodelBalcao = (DefaultTableModel) PedidoTrocaDevolucaoView.jTable1.getModel();
                else
                    if (this.tipoPedido.equals("PEDIDOTROCA"))
                        amodelBalcao = (DefaultTableModel) PedidoTrocaPresenteView.jTable2.getModel();
        
        

       //Adicionar Descricao do Produto no Pedido
        String descricao = null;
        descricao = produto.getDescricao();
  //      String vlComplementoStr = null;
        
        
        //Pegando a Quantidade
        if (!produto.getDescricao().equals("DIVERSOS")){
           if (jtfQuantidade.getText().equals(""))
              qtd = 1;
           else{
               String qtdStr = null;
               qtdStr = jtfQuantidade.getText();
               qtdStr = qtdStr.replace(",", ".");
               qtd = Float.parseFloat(qtdStr);
               
           }
           if (jrbVarejo.isSelected())       
               vlunit = (produto.getVlVenda());
            else
               if (jrbAtacado.isSelected())
                  vlunit = (produto.getVlVendaAtacado()); 
            vlCusto = produto.getVl_compra();
            totalCusto = (qtd * vlCusto);
            total = (qtd * vlunit); 
            
        }else{
            //Quando o produto for com a descrição Diversos, o campo Quantidade 
            //vira de Valor, utilizamos o campo quantidade em questão de reaproveita o campo.
            String totalStr = null;
            if (!jtfQuantidade.getText().equals("")){
               totalStr = jtfQuantidade.getText();
               totalStr = totalStr.replace(",", ".");
               total = Float.parseFloat(totalStr); 
               qtd = 1;
            }else{
                JOptionPane.showMessageDialog(null, "Digite o valor.");
                return;
            }
        }
        
              
        if (tipoPedido.equals("BALCAO1")){ 
           //Passando o Total para a variável subtotal de PedidoView.            
           PedidoView1.subtotal = (PedidoView1.subtotal + total);        
           PedidoView1.jtfSubTotal.setText(new DecimalFormat("#,##0.000").format(PedidoView1.subtotal));
           PedidoView1.jtfSubTotal.setEnabled(true);
           
           String tipoVenda = null;
           
           if (jrbVarejo.isSelected())
              tipoVenda = "V";
           else
               if (jrbAtacado.isSelected())
                   tipoVenda = "A";
                      
           //Adicionando Campos na JTable de PedidoView.
           amodelBalcao.addRow(new Object[]{qtd, descricao, vlunit, total, produto.getId(), tipoVenda});
        
           PedidoView1.jTable1.getColumnModel().getColumn(2).setCellRenderer(new JTableFonteColunaDireitaAzul());
           PedidoView1.jTable1.getColumnModel().getColumn(3).setCellRenderer(new JTableFonteColunaDireitaAzul());
           //Mensagem Caixa
           if (PedidoView1.jlStatusCaixa.getText().equals("CAIXA LIVRE")){
               PedidoView1.jlStatusCaixa.setText("CAIXA OCUPADO");
               PedidoView1.jlStatusCaixa.setForeground(Color.red);
           } 
           //Habilitar Campos PedidoView
           //PedidoView1.jtfCliente.setEnabled(true);
           PedidoView1.jtfObs.setEnabled(true);
         //  PedidoView1.jbtCliente.setEnabled(true);
           PedidoView1.jbtConfig.setEnabled(false);
           PedidoView1.jbtPagamento.setEnabled(true);
        }else
            if(tipoPedido.equals("BALCAO")){
               
                //Passando o Total para a variável subtotal de PedidoView.            
               PedidoView.subtotal = (PedidoView.subtotal + total);        
               PedidoView.jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(PedidoView.subtotal));
               PedidoView.jtfSubTotal.setEnabled(true);
               PedidoView.pProdView =null;
               String tipoVenda = null;
           
               if (jrbVarejo.isSelected())
                  tipoVenda = "V";
               else
                  if (jrbAtacado.isSelected())
                      tipoVenda = "A";                      
               //Adicionando Campos na JTable de PedidoView.
               String totalStr = null;
               //totalStr = String.valueOf(total);
               totalStr = (new DecimalFormat("#,##0.00").format(total));
               
               amodelBalcao.addRow(new Object[]{qtd,produto.getUnidade().getSigla(), descricao, vlunit, totalStr, produto.getId(), tipoVenda});
        
               PedidoView.jTable1.getColumnModel().getColumn(3).setCellRenderer(new JTableFonteColunaDireitaAzul());
               PedidoView.jTable1.getColumnModel().getColumn(4).setCellRenderer(new JTableFonteColunaDireitaAzul());
               //Mensagem Caixa
               if (PedidoView.jlStatusCaixa.getText().equals("CAIXA LIVRE")){
                   PedidoView.jlStatusCaixa.setText("CAIXA OCUPADO");
                   PedidoView.jlStatusCaixa.setForeground(Color.red);
               } 
                //Habilitar Campos PedidoView
                //PedidoView1.jtfCliente.setEnabled(true);
                PedidoView.jtfObs.setEnabled(true);
              //  PedidoView1.jbtCliente.setEnabled(true);
                // PedidoView.jbtConfig.setEnabled(false);
                PedidoView.jbtPagamento.setEnabled(true);
                PedidoView.jtfCodProd.setText("");                
            }
            else           
            if (tipoPedido.equals("DELIVERY")){
                //Passando o Total para a variável subtotal de PedidoView.            
               PedidoDeliveryView.subtotal = (PedidoDeliveryView.subtotal + total);        
               PedidoDeliveryView.jtfSubTotal.setText(new DecimalFormat("#,##0.000").format(PedidoDeliveryView.subtotal));
               PedidoDeliveryView.jtfSubTotal.setEnabled(true);
        
               //Adicionando Campos na JTable de PedidoView.
               amodelDelivery.addRow(new Object[]{qtd, descricao, vlunit, total, produto.getId(), 0});
        
               //Mensagem Caixa
               if (PedidoDeliveryView.jlStatusCaixa.getText().equals("CAIXA LIVRE")){
                   PedidoDeliveryView.jlStatusCaixa.setText("CAIXA OCUPADO");
                   PedidoDeliveryView.jlStatusCaixa.setForeground(Color.red);
               } 
               //Habilitar Campos PedidoView
               PedidoDeliveryView.jtfCliente.setEnabled(true);
               PedidoDeliveryView.jtfObs.setEnabled(true);
               PedidoDeliveryView.jbtCliente.setEnabled(true);
//               PedidoDeliveryView.jbtConfig.setEnabled(false);
               PedidoDeliveryView.jbtOK.setEnabled(true);
              // PedidoDeliveryView.jbtPagamento.setEnabled(true);               
           }else
                if (this.tipoPedido.equals("DEVOLUCAO")){                                     
                   amodelBalcao.addRow(new Object[]{qtd, produto.getUnidade().getSigla(), descricao, vlunit, total, "TROCA"});
                }else
                    if (this.tipoPedido.equals("PEDIDOTROCA")){
                        amodelBalcao.addRow(new Object[]{qtd, produto.getUnidade().getSigla(), descricao, new DecimalFormat("#,##0.00").format(vlunit), 
                            new DecimalFormat("#,##0.00").format(total), "DEVOLVIDO"});
                        PedidoTrocaPresenteItens itensTroca = new PedidoTrocaPresenteItens();
                       
                        itensTroca.setProduto(produto);
                        String qtdStr = String.valueOf(qtd);
                        itensTroca.setQtd(new BigDecimal(qtdStr));
                        itensTroca.setVlUnit(new BigDecimal(vlunit));
                        itensTroca.setVltotal(new BigDecimal(total));
                       // itensTroca.setStatus("teste");
                       
                               
                        
                        PedidoTrocaPresenteView.listaItens.add(itensTroca);
                        PedidoTrocaPresenteView.jbtCalcular.setEnabled(true);
                        jButton1ActionPerformed(null);  
                        return;                         
                    }
        
        
        //Adicionar na lista de pedido ao salvar pedido.
        PedidoItens itens = new PedidoItens();
        
        itens.setDescricao(descricao);
        itens.setProduto(produto);
        //Inserindo quantidade.
        String qtdStr = String.valueOf(qtd);
        itens.setQuantidade(new BigDecimal(qtdStr));
        //Inserindo vl unitario
        String vlunitStr = String.valueOf(vlunit);        
        itens.setVlUnit(new BigDecimal(vlunitStr));
        
        String vltotalStr = String.valueOf(total);
        itens.setVlSubtotal(new BigDecimal(vltotalStr));
        itens.setVl_custo(new BigDecimal(qtd * produto.getVl_compra()));
        
        itens.setVlLucro(new BigDecimal(total - totalCusto));
        
        itens.setStatus("VENDIDO");
        
        if (jrbVarejo.isSelected())
            itens.setTipoVenda("VAREJO");
        else
            if (jrbAtacado.isSelected())
                itens.setTipoVenda("ATACADO");
        //Adicionar a lista de itens.
        //PedidoView.listaItens = new ArrayList<>();
        if (tipoPedido.equals("BALCAO1"))
           PedidoView1.listaItens.add(itens);       
        else
            if (tipoPedido.equals("BALCAO"))
                PedidoView.listaItens.add(itens);
            else
               if (tipoPedido.equals("DELIVERY"))
                  PedidoDeliveryView.listaItens.add(itens);
               else
                   if (this.tipoPedido.equals("DEVOLUCAO")){
                       itens.setStatus("TROCA");
                       PedidoTrocaDevolucaoView.pedido.getListaItens().add(itens);
                      // PedidoTrocaDevolucaoView.jbtExcluir.setEnabled(true);
                       PedidoTrocaDevolucaoView.jbtCalcular.setEnabled(true);
                   }
        //Chama o Botão de Sair.
        jButton1ActionPerformed(null);  
        
        
    }//GEN-LAST:event_jbtAdicionarActionPerformed

    private void jtfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){ 
           jbtAdicionar.requestFocus();
        }
        
    }//GEN-LAST:event_jtfQuantidadeKeyPressed

    private void jrbVarejoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbVarejoActionPerformed
        
        if (jrbVarejo.isSelected()){
            jlPreco.setText(new DecimalFormat("#,##0.00").format(produto.getVlVenda()));
            jtfQuantidade.requestFocus();
        }
    }//GEN-LAST:event_jrbVarejoActionPerformed

    private void jrbAtacadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAtacadoActionPerformed
        if (jrbAtacado.isSelected()){
            jlPreco.setText(new DecimalFormat("#,##0.00").format(produto.getVlVendaAtacado()));
            jtfQuantidade.requestFocus();
        }
    }//GEN-LAST:event_jrbAtacadoActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jButton1ActionPerformed(null);
        }  
    }//GEN-LAST:event_jButton1KeyPressed

    private void jbtAdicionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtAdicionarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtAdicionarActionPerformed(null);
        }  
        
    }//GEN-LAST:event_jbtAdicionarKeyPressed

    private void jtfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuantidadeActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jtfQuantidadeActionPerformed

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
//            java.util.logging.Logger.getLogger(PedidoDetalheView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PedidoDetalheView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PedidoDetalheView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PedidoDetalheView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                PedidoDetalheView dialog = new PedidoDetalheView(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbtAdicionar;
    private javax.swing.JLabel jlDescricao;
    public static javax.swing.JLabel jlPreco;
    private javax.swing.JRadioButton jrbAtacado;
    private javax.swing.JRadioButton jrbVarejo;
    public static javax.swing.JTextField jtfCodigoProduto;
    public static final javax.swing.JTextField jtfQuantidade = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables

//    public Produto getProduto() {
//        return produto;
//    }
//
//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }

   



}
