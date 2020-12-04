/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.CategoriaProdutoDAO;
import dao.ProdutoDAO;
import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.CategoriaProduto;
import model.Produto;


import util.JTableRenderer;

/**
 *
 * @author daniel
 */
public class PesquisaProdutoView extends javax.swing.JDialog {

    List<CategoriaProduto> listCategoria;
    List<Produto> listaProdutos = new ArrayList<Produto>();;
    CategoriaProdutoDAO categoriaDao;
    public static Produto produtoSelecionado;
    String configPesquisaProd;
    String codProduto;
    String tipoPedido;
    boolean ativaAdicinarProdutoFormVenda = false;
   // ProdutoDAO prodDAO;
    public PesquisaProdutoView(java.awt.Frame parent, boolean modal,  String tipoPedido) {
        super(parent, modal);
        initComponents();
        carregaCombobox();
        listaProdutos = null;
        jcbCategoria.setSelectedItem("TODOS");
        
                
        carregaTable();
      //  configPesquisaProd = configPesquisaProduto;
        this.tipoPedido = tipoPedido;
        
        
//        EventQueue queuePedidoDet = new EventQueue(){
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
//                                 PedidoView1.formPesquisaProduto();
//                              else
//                                  if (tipoPedido.equals("DELIVERY"))
//                                      PedidoDeliveryView.formPesquisaProduto();
//                              break;
//                          }case 115:{
//                              jButton1ActionPerformed(null);
////                              if (tipoPedido.equals("BALCAO"))
////                                 PedidoView1.formPesquisaCliente();
////                              else
//                                  if (tipoPedido.equals("DELIVERY"))
//                                      PedidoDeliveryView.formPesquisaCliente();
//                              break;
//                          }case 116:{
//                              jButton1ActionPerformed(null);
//                              if (tipoPedido.equals("BALCAO")){
//                                 PedidoView1.registraPedido();
//                                 PedidoView1.formPedidoPagamento();
//                              }else
//                                  if (tipoPedido.equals("DELIVERY")){
//                                      PedidoDeliveryView.registraPedido();
//                                      PedidoDeliveryView.formPedidoPagamento();
//                                  }
//                              break;
//                          }
//                      }
//                  }
//               }               
//           }
//       };
//       Toolkit.getDefaultToolkit().getSystemEventQueue().push(queuePedidoDet);
//        
        
        
    }

    private void carregaTable(){
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0); 
       // ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Add.png"));
        TableColumnModel columnModel = jTable1.getColumnModel();
        JTableRenderer renderer = new JTableRenderer();
        columnModel.getColumn(5).setCellRenderer(renderer);       
        ProdutoDAO prodDAO = new ProdutoDAO();     
        
        if (listaProdutos == null){
           listaProdutos = prodDAO.listaProdutoAtivo();            
        } 
        
        if (jcbCategoria.getSelectedItem().equals("TODOS")){
            for (Produto prod1 : listaProdutos){
               amodel.addRow(new Object[]{prod1.getId(), prod1.getCategoria().getDescricao(),
               prod1.getDescricao(), prod1.getVlVenda(), prod1.getEstoque(),new ImageIcon(getClass().getResource("/imagens/addProd.png")), prod1.getCod_interno(), prod1.getCodBarras()});                    
                
            }
        }else                   
            for (Produto prod : listaProdutos){            
                if (jcbCategoria.getSelectedItem().equals(prod.getCategoria().getDescricao())){
                   amodel.addRow(new Object[]{prod.getId(), prod.getCategoria().getDescricao(),
                   prod.getDescricao(), prod.getVlVenda(), prod.getEstoque(),new ImageIcon(getClass().getResource("/imagens/addProd.png")), prod.getCod_interno(), prod.getCodBarras()}); 
                }
            }    
    }
    
    private void carregaCombobox(){
        categoriaDao = new CategoriaProdutoDAO();
        listCategoria = new ArrayList<CategoriaProduto>();
        listCategoria = categoriaDao.listCategoriaProduto(); 
        
    
         jcbCategoria.removeAllItems();
         for (CategoriaProduto catProd : listCategoria){
             jcbCategoria.addItem(catProd.getDescricao());
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        rowSorterToStringConverter1 = new converter.RowSorterToStringConverter();
        jPanel1 = new javax.swing.JPanel();
        jtfPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        rowSorterToStringConverter1.setTable(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Produto"));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${rowSorter}"), jtfPesquisa, org.jdesktop.beansbinding.BeanProperty.create("text_ON_ACTION_OR_FOCUS_LOST"));
        binding.setConverter(rowSorterToStringConverter1);
        bindingGroup.addBinding(binding);

        jtfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisaActionPerformed(evt);
            }
        });
        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyPressed(evt);
            }
        });

        jLabel1.setText("CATEGORIA:");

        jcbCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbCategoriaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCategoria, 0, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD.", "CATEGORIA", "PRODUTO", "PREÇO", "ESTOQUE", "ADD", "COD.INTERNO", "COD.BARRAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setToolTipText("");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        listaProdutos = null;
        PedidoView.pProdView = null;
        limparJtable1EFocusJtfPesquisa();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void limparJtable1EFocusJtfPesquisa() {
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        jtfPesquisa.requestFocus();
    }

    private void jcbCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbCategoriaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            carregaTable();
        }
    }//GEN-LAST:event_jcbCategoriaKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        adicionaProdutoSelecionadoFormVendaDetalhe();
        
      
        jButton1ActionPerformed(null);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void adicionaProdutoSelecionadoFormVendaDetalhe() throws HeadlessException {
        codProduto = (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        
        String idProduto = (codProduto);
        
        PedidoDetalheView pedidoDet = new PedidoDetalheView(new java.awt.Frame(), true, idProduto, this.tipoPedido, null);
        pedidoDet.setLocationRelativeTo(null);
        pedidoDet.setBounds(350, 350, 950, 280);
        this.setVisible(false);
        pedidoDet.setVisible(true);
       
    }

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jButton1ActionPerformed(null);
        } 
    }//GEN-LAST:event_jButton1KeyPressed

    private void jtfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyPressed
         if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jTable1.requestFocus();
        } 
    }//GEN-LAST:event_jtfPesquisaKeyPressed

    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaActionPerformed
      
        
//        if (jTable1.getSize())
       if (jTable1.getRowCount() > 0) {
          jTable1.requestFocus();
       }
       ativaAdicinarProdutoFormVenda = false;
    }//GEN-LAST:event_jtfPesquisaActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
           if (ativaAdicinarProdutoFormVenda != false) 
              adicionaProdutoSelecionadoFormVendaDetalhe();
           ativaAdicinarProdutoFormVenda = true;
        //    String op = System.getProperty("os.name");
         //   if (!"Linux".equals(op))
          //      jTable1MouseClicked(null);
          
        } 
    }//GEN-LAST:event_jTable1KeyPressed

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
//            java.util.logging.Logger.getLogger(PesquisaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PesquisaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PesquisaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PesquisaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                PesquisaProdutoView dialog = new PesquisaProdutoView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbCategoria;
    public static javax.swing.JTextField jtfPesquisa;
    private converter.RowSorterToStringConverter rowSorterToStringConverter1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

//    public  Produto getProdutoSelecionado() {
//        return produtoSelecionado;
//    }
//
//    public void setProdutoSelecionado(Produto produtoSelecionado) {
//        this.produtoSelecionado = produtoSelecionado;
//    }




}
