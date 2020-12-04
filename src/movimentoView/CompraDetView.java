/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;



import dao.ProdutoDAO;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produto;



/**
 *
 * @author daniel
 */
public class CompraDetView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CompraDet
     */
    private float  vlUnit, vlTotal, qtd, vlpago; 
    private ProdutoDAO prodDao;
    private Produto produto;
    public CompraDetView() {
        initComponents();
        carregaTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jtfCodProd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfValorUnit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfValorTotal = new javax.swing.JTextField();
        jtfUnidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfDesconto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfSubTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbtSalvar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();

        rowSorterToStringConverter1.setTable(jTable1);

        setTitle("Itens da Compra ");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa de Produto"));

        jtfPesquisa.setNextFocusableComponent(jbtSair);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${rowSorter}"), jtfPesquisa, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(rowSorterToStringConverter1);
        bindingGroup.addBinding(binding);

        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyPressed(evt);
            }
        });

        jTable1.setBorder(null);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD. PRODUTO", "DESCRIÇÃO", "ESTOQUE", "UNIDADE", "R$ VL. COMPRA", "MARCA", "CÓD. BARRAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
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
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setNextFocusableComponent(jtfQuantidade);
        jTable1.getTableHeader().setReorderingAllowed(false);
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
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(280);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 340, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        jtfCodProd.setEnabled(false);
        jtfCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCodProdKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel1.setText("CÓD. PRODUTO");

        jtfDescricao.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel2.setText("DESCRIÇÃO");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel3.setText("R$ UNITÁRIO");

        jtfValorUnit.setBackground(new java.awt.Color(237, 238, 100));
        jtfValorUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfValorUnit.setEnabled(false);
        jtfValorUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfValorUnitFocusGained(evt);
            }
        });
        jtfValorUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfValorUnitKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfValorUnitKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel4.setText("QUANTIDADE");

        jtfQuantidade.setBackground(new java.awt.Color(183, 211, 245));
        jtfQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfQuantidade.setEnabled(false);
        jtfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfQuantidadeFocusGained(evt);
            }
        });
        jtfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel6.setText("R$ TOTAL");

        jtfValorTotal.setBackground(new java.awt.Color(237, 238, 100));
        jtfValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfValorTotal.setEnabled(false);
        jtfValorTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfValorTotalFocusGained(evt);
            }
        });
        jtfValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfValorTotalKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfValorTotalKeyPressed(evt);
            }
        });

        jtfUnidade.setEditable(false);
        jtfUnidade.setBackground(new java.awt.Color(183, 211, 245));
        jtfUnidade.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel10.setText("UNIDADE");

        jtfDesconto.setBackground(new java.awt.Color(237, 238, 168));
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

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel5.setText("DESCONTO");

        jLabel7.setText("%");

        jtfSubTotal.setEditable(false);
        jtfSubTotal.setBackground(new java.awt.Color(237, 238, 100));
        jtfSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfSubTotal.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel8.setText("R$ SUBTOTAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfCodProd, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 575, Short.MAX_VALUE))
                            .addComponent(jtfDescricao)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfQuantidade)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtfValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jtfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        jbtSalvar.setText("Salvar");
        jbtSalvar.setEnabled(false);
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });
        jbtSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtSalvarKeyPressed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.setToolTipText("Fechar Formulário");
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtSalvar)
                .addComponent(jbtSair))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        DefaultTableModel amodel = (DefaultTableModel) CompraCabView.jTable2.getModel();
       // float qtd = (Float.parseFloat(jtfQuantidade.getText()));
        float totalNota; 
        
       
         if (jtfQuantidade.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Digite a Quantidade.");
                jtfQuantidade.requestFocus();
                return;
            }else
               if (vlUnit > vlTotal){
                 
                  JOptionPane.showMessageDialog(null, "O valor de Compra é Maior do que o Valor de Venda");
                  jtfValorTotal.requestFocus();
                  return;
                }else
                   if (jtfCodProd.getText().equals("")){
                       JOptionPane.showMessageDialog(null, "Digite o Código do Produto.");
                       jtfCodProd.requestFocus();
                       return;
                    }
           
        totalNota =  CompraCabView.vlNota;  
      
        totalNota = (totalNota +(vlpago)); 
      
        CompraCabView.jtfTotal.setText("");
       // CompraCabView.jtfTotal.setText(String.valueOf(totalNota));
       // CompraCabView.jtfTotal.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(CompraCabView.jtfTotal.getText())));
        CompraCabView.vlNota = totalNota;
        CompraCabView.jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(totalNota));
        jtfDesconto.setText(new DecimalFormat("0.0").format(Float.parseFloat(jtfDesconto.getText())));
        //Carrega Tabela do Formulário de Compra Cab.
        amodel.addRow(new Object[]{jtfCodProd.getText(), jtfDescricao.getText(), jtfQuantidade.getText(),jtfUnidade.getText(),
        jtfValorUnit.getText(), jtfDesconto.getText(), jtfValorTotal.getText(), 0});
        
        limpar();
        vlUnit = 0;vlTotal=0;
        jbtSalvar.setEnabled(false);
        jtfPesquisa.requestFocus();        
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        CompraCabView.jtfParcelas.setEnabled(true);
        CompraCabView.jbtProduto.setEnabled(true);
        CompraCabView.jtfParcelas.requestFocus();
        
        dispose();    
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jtfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            jtfCodProd.setEnabled(true);
            jtfDescricao.setEnabled(true);
            jtfCodProd.requestFocus();
        }
    }//GEN-LAST:event_jtfPesquisaKeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
      //  if (evt.getKeyCode() == evt.VK_ENTER){
           // DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
           // amodel.setRowCount();
           // jTable1.setRowSelectionAllowed(false);
          // jTable1.setValueAt(null, jTable1.getSelectedRow(), );
           // jTable1.setSelectionMode(jTable1.getSelectedRow() -1);
            
           // jTable1.setR
           // jtfValorUnit.requestFocus();
            
//        }
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    //    limpar();
        vlTotal = 0;
        jtfCodProd.setEnabled(true);
        jtfDescricao.setEnabled(true);
        jtfUnidade.setEnabled(true);
        jtfCodProd.setText((jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        jtfDescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jtfUnidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        //jtfValorUnit.setText(jTable1.getValueAt(jTable1.getSelectedRow(), WIDTH));
        //jtfCodProd.requestFocus();
        
        jtfQuantidade.setEnabled(true);
        jtfQuantidade.requestFocus();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jtfValorUnitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorUnitKeyPressed
       // float qtd=0;
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfValorUnit.getText().equals("")){
                JOptionPane.showMessageDialog(null, "O Valor Unitário não pode ficar em branco ou vazio !!!");
                jtfValorUnit.requestFocus(); 
            }else
                if (!jtfValorUnit.getText().equals("")){  
                   vlTotal = 0;
                   String unitario = jtfValorUnit.getText();
                   unitario = unitario.replace(",", ".");                   
                   vlUnit = (Float.parseFloat(unitario));
                   vlTotal = (qtd * vlUnit);                 
                   jtfSubTotal.setEnabled(true);
                   jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(vlTotal)); 
                   jtfValorUnit.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(unitario)));
                   jtfDesconto.setEnabled(true);
                   jtfDesconto.requestFocus();
            }           
        }
    }//GEN-LAST:event_jtfValorUnitKeyPressed

    private void jtfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            
            
            if (jtfQuantidade.getText().equals("")){
                JOptionPane.showMessageDialog(null, "A Quantidade não pode ficar em branco ou vazio !!!");
                jtfQuantidade.requestFocus();                
            }else{
                qtd = 0;
                qtd = Float.parseFloat(jtfQuantidade.getText());
                
                jtfQuantidade.setText(new DecimalFormat("#,##0").format(Float.parseFloat(jtfQuantidade.getText()))); //#,##
                jtfValorUnit.setEnabled(true);
                jtfValorUnit.requestFocus();
            }
                
            
        }
    }//GEN-LAST:event_jtfQuantidadeKeyPressed

    private void jtfValorTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorTotalKeyPressed
        float desconto = 0;
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfValorTotal.getText().equals("")){
                vlpago = vlTotal;
                jtfValorTotal.setText(new DecimalFormat("#,##0.00").format(vlTotal));
            }else {                
               desconto = 0; 
               String total = jtfValorTotal.getText();
               total = total.replace(",", ".");                
               vlpago = Float.parseFloat(total);
              
               desconto = ((vlpago / vlTotal)*100);
               desconto = (100 - desconto);
               jtfDesconto.setText(String.valueOf(desconto));
               jtfValorTotal.setText(new DecimalFormat("#,##0.00").format(vlpago));                           
            }
            jbtSalvar.setEnabled(true);
            jbtSalvar.requestFocus(); 
        }          
    }//GEN-LAST:event_jtfValorTotalKeyPressed

    private void jtfValorUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorUnitKeyTyped
        String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfValorUnitKeyTyped

    private void jtfQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyTyped
         String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfQuantidadeKeyTyped

    private void jtfValorTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorTotalKeyTyped
        String caracteres="0987654321,";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfValorTotalKeyTyped

    private void jtfCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodProdKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            prodDao = new ProdutoDAO();
            produto = new Produto();
            vlTotal = 0;
            if (jtfCodProd.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Código da Materia Prima não pode ficar em branco ou vazio !!!");
                jtfCodProd.setText("");
                jtfCodProd.requestFocus();
            }else{
                  Long id_produto = (Long.parseLong(jtfCodProd.getText()));
                  produto = prodDao.produtoId(id_produto);
                  if (produto == null){
                      JOptionPane.showMessageDialog(null, "Este Produto não existe");
                      jtfCodProd.setText("");
                      jtfCodProd.requestFocus();
                  }else{
                        jtfDescricao.setText(produto.getDescricao());
                        jtfUnidade.setText(produto.getUnidade().getSigla());
                        jtfQuantidade.setEnabled(true);
                        jtfQuantidade.requestFocus();
                  }   
//                  jtfQuantidade.setEnabled(true);
//                  jtfQuantidade.requestFocus();
            }    
            
        }
    }//GEN-LAST:event_jtfCodProdKeyPressed

    private void jbtSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSalvarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtSalvarActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSalvarKeyPressed

    private void jtfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoActionPerformed

    private void jtfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyPressed
        float desconto = 0, vlpagoD =0;
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfDesconto.getText().equals("")){
                jtfDesconto.setText("0.0");
                jtfValorTotal.setEnabled(true);
                jtfValorTotal.requestFocus();
            }else{
                desconto = Float.parseFloat(jtfDesconto.getText());
                vlpagoD = (vlTotal -(vlTotal*desconto/100));
                //vlTotal = vlpagoD;
                vlpago = vlpagoD;
                
                jtfValorTotal.setEnabled(true);
                jtfValorTotal.setText(new DecimalFormat("#,##0.00").format(vlpago));
                jbtSalvar.setEnabled(true);
                jbtSalvar.requestFocus();
            }
                
            
        }
    }//GEN-LAST:event_jtfDescontoKeyPressed

    private void jtfDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyTyped
         String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfDescontoKeyTyped

    private void jtfQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfQuantidadeFocusGained
        jtfQuantidade.setText("");
    }//GEN-LAST:event_jtfQuantidadeFocusGained

    private void jtfValorUnitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValorUnitFocusGained
      //  jtfValorUnit.setText("");
    }//GEN-LAST:event_jtfValorUnitFocusGained

    private void jtfValorTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValorTotalFocusGained
     //   jtfValorTotal.setText("");
    }//GEN-LAST:event_jtfValorTotalFocusGained

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtSairActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSairKeyPressed

    public void carregaTable(){
        List<Produto> listaProduto; 
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        prodDao = new ProdutoDAO();                   
        listaProduto = null;        
        listaProduto = prodDao.listaProdutoAtivo();        
        String vlCompraStr = null;
        for (Produto produto : listaProduto){
          //  vlCompraStr = (new DecimalFormat("#,##0.00").format(produto.getVl_compra()));
            amodel.addRow(new Object[]{produto.getId(),produto.getDescricao(),produto.getEstoque(),produto.getUnidade().getSigla(), produto.getVl_compra(), produto.getMarca().getDescricao(), produto.getCodBarras()});            
        }
        
    }

    
    private void limpar(){
        jtfCodProd.setText("");
        jtfDescricao.setText("");
        jtfValorUnit.setText("");
        jtfValorTotal.setText("");
        jtfQuantidade.setText("");        
        jtfPesquisa.setText("");
        jtfUnidade.setText("");
        jtfDesconto.setText("");
        jtfSubTotal.setText("");
        
    }
    
    private void habilitar(boolean habilita){
        jtfCodProd.setEnabled(habilita);
        jtfDescricao.setEnabled(habilita);
        jtfValorUnit.setEnabled(habilita);
        jtfValorTotal.setEnabled(habilita);
        jtfQuantidade.setEnabled(habilita);        
        jtfPesquisa.setEnabled(habilita);
        jtfUnidade.setEnabled(habilita);
        jtfDesconto.setEnabled(habilita);
        jtfSubTotal.setEnabled(habilita);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JTextField jtfCodProd;
    private javax.swing.JTextField jtfDesconto;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTextField jtfSubTotal;
    private javax.swing.JTextField jtfUnidade;
    private javax.swing.JTextField jtfValorTotal;
    private javax.swing.JTextField jtfValorUnit;
    private converter.RowSorterToStringConverter rowSorterToStringConverter1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
