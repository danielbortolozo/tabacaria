/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroView;

import dao.ColaboradorDAO;
import dao.NivelAcessoDAO;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import model.Colaborador;
import model.NivelAcesso;

/**
 *
 * @author daniel
 */
public class NivelAcessoView extends javax.swing.JFrame {

    /**
     * Creates new form NivelAcessoView
     */
    
    List<Colaborador> listaColaborador;
    List<NivelAcesso> listaNivelAcesso;
    NivelAcessoDAO daoNivel = new NivelAcessoDAO();
    NivelAcesso nivelAcesso ;
    ColaboradorDAO daoColab = new ColaboradorDAO();
    Colaborador colaborador = new Colaborador();
    DefaultTableModel amodelNivel;
    public NivelAcessoView() {
        initComponents();
        carregaTableColaborador();
        amodelNivel = (DefaultTableModel) jTable2.getModel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultMutableTreeNode pai = new DefaultMutableTreeNode("SisDB-Financeiro-1.0");

        //Cadastros
        DefaultMutableTreeNode filho1 = new DefaultMutableTreeNode("Cadastros");
        pai.add(filho1);
        DefaultMutableTreeNode neto1 = new DefaultMutableTreeNode("Empresa");
        filho1.add(neto1);
        DefaultMutableTreeNode neto2 = new DefaultMutableTreeNode("Cliente");
        filho1.add(neto2);
        DefaultMutableTreeNode neto3 = new DefaultMutableTreeNode("Fornecedor");
        filho1.add(neto3);
        DefaultMutableTreeNode neto4 = new DefaultMutableTreeNode("Colaborador");
        filho1.add(neto4);
        DefaultMutableTreeNode neto5 = new DefaultMutableTreeNode("Produto");
        filho1.add(neto5);
        DefaultMutableTreeNode neto6 = new DefaultMutableTreeNode("Categoria Produto");
        filho1.add(neto6);
        DefaultMutableTreeNode neto7 = new DefaultMutableTreeNode("Marca");
        filho1.add(neto7);
        DefaultMutableTreeNode neto8 = new DefaultMutableTreeNode("Unidade");
        filho1.add(neto8);
        DefaultMutableTreeNode neto9 = new DefaultMutableTreeNode("Categoria Conta");
        filho1.add(neto9);
        DefaultMutableTreeNode neto10 = new DefaultMutableTreeNode("Conta / Banco");
        filho1.add(neto10);
        DefaultMutableTreeNode neto11 = new DefaultMutableTreeNode("Cep");
        filho1.add(neto11);

        //Movimentação
        DefaultMutableTreeNode filho2 = new DefaultMutableTreeNode("Movimento");
        pai.add(filho2);
        DefaultMutableTreeNode neto14 = new DefaultMutableTreeNode("Controle Estoque");
        filho2.add(neto14);
        DefaultMutableTreeNode bisneto1 = new DefaultMutableTreeNode("Entrada Mercadoria");
        neto14.add(bisneto1);
        DefaultMutableTreeNode bisneto2 = new DefaultMutableTreeNode("Reajuste de Estoque");
        neto14.add(bisneto2);
        DefaultMutableTreeNode neto15 = new DefaultMutableTreeNode("Condicional");
        filho2.add(neto15);
        DefaultMutableTreeNode neto16 = new DefaultMutableTreeNode("Venda");
        filho2.add(neto16);
        DefaultMutableTreeNode neto17 = new DefaultMutableTreeNode("Historico Venda");
        filho2.add(neto17);
        DefaultMutableTreeNode neto18 = new DefaultMutableTreeNode("Caixa");
        filho2.add(neto18);

        //Financeiro
        DefaultMutableTreeNode filho3 = new DefaultMutableTreeNode("Financeiro");
        pai.add(filho3);
        DefaultMutableTreeNode neto19 = new DefaultMutableTreeNode("Contas");
        filho3.add(neto19);
        DefaultMutableTreeNode bisneto3 = new DefaultMutableTreeNode("Pagar");
        neto19.add(bisneto3);
        DefaultMutableTreeNode bisneto4 = new DefaultMutableTreeNode("Receber");
        neto19.add(bisneto4);
        DefaultMutableTreeNode bisneto12 = new DefaultMutableTreeNode("Fiado");
        bisneto4.add(bisneto12);
        DefaultMutableTreeNode bisneto13 = new DefaultMutableTreeNode("Crediário");
        bisneto4.add(bisneto13);
        DefaultMutableTreeNode neto20 = new DefaultMutableTreeNode("Movimentação de Conta");
        filho3.add(neto20);

        //Relatorios
        DefaultMutableTreeNode filho4 = new DefaultMutableTreeNode("Relatórios");
        pai.add(filho4);
        //Produtos
        DefaultMutableTreeNode neto21 = new DefaultMutableTreeNode("Produtos");
        filho4.add(neto21);
        DefaultMutableTreeNode bisneto5 = new DefaultMutableTreeNode("Relatório Produtos Todos Produto Ordem Alfabética");
        neto21.add(bisneto5);
        DefaultMutableTreeNode bisneto6 = new DefaultMutableTreeNode("Relatório Produtos Etiqueta de Produto");
        neto21.add(bisneto6);
        DefaultMutableTreeNode bisneto7 = new DefaultMutableTreeNode("Relatório Produtos Filtro de Pesquisa");
        neto21.add(bisneto7);
        //Venda
        DefaultMutableTreeNode neto22 = new DefaultMutableTreeNode("Venda");
        filho4.add(neto22);
        DefaultMutableTreeNode bisneto8 = new DefaultMutableTreeNode("Relatório Venda Por Cliente");
        neto22.add(bisneto8);
        DefaultMutableTreeNode bisneto9 = new DefaultMutableTreeNode("Relatório Venda Por Período");
        neto22.add(bisneto9);
        //Compra
        DefaultMutableTreeNode neto23 = new DefaultMutableTreeNode("Compra");
        filho4.add(neto23);
        DefaultMutableTreeNode bisneto10 = new DefaultMutableTreeNode("Compra Por Período de Emissão da Compra");
        neto23.add(bisneto10);
        //Contas à Pagar
        DefaultMutableTreeNode neto24 = new DefaultMutableTreeNode("Contas à Pagar");
        filho4.add(neto24);
        DefaultMutableTreeNode bisneto11 = new DefaultMutableTreeNode("Contas à Pagar Por Período de Vencimento");
        neto24.add(bisneto11);
        //DefaultMutableTreeNode bisneto
        jTree1 = new javax.swing.JTree(pai);
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbRetirar = new javax.swing.JButton();
        jbConceder = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jbSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nivel de Acesso do Usuário");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Login"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jbRetirar.setText("Retirar Acesso");
        jbRetirar.setEnabled(false);
        jbRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRetirarActionPerformed(evt);
            }
        });

        jbConceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbConceder.setText("Conceder Acesso");
        jbConceder.setEnabled(false);
        jbConceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConcederActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbConceder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbRetirar)
                .addComponent(jbConceder))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Acesso ao Sistema"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Módulo", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(450);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbSair)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed

        carregaTableColaborador();       
        dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      //   carregaTableColaborador();
        
        this.colaborador = listaColaborador.get(jTable1.getSelectedRow());
       
        carregaTableNivelAcesso(this.colaborador.getListaAcesso());
        jbConceder.setEnabled(true);
        jbRetirar.setEnabled(false);
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbConcederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConcederActionPerformed

//       
        String moduloAdd = jTree1.getLastSelectedPathComponent().toString();
        String modulo = null;
        boolean moduloExistente = false;
        jbRetirar.setEnabled(false);
        
        
        if (jTable1.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null, "Selecione um usuário!!!");
            return;
        }
        
        for (int linhas = 0; linhas < amodelNivel.getRowCount(); linhas ++ ){
            
            modulo = amodelNivel.getValueAt(linhas, 0).toString();
            if (moduloAdd.equals(modulo)){
                JOptionPane.showMessageDialog(null, "Este módulo, já está permitido para o usuário");
                moduloExistente = true;
                break;                
            }             
        }     
        
        if (moduloExistente == false){
           
            nivelAcesso = new NivelAcesso();
            nivelAcesso.setIdColaborador(this.colaborador);
            nivelAcesso.setNomeModulo(moduloAdd);
            this.nivelAcesso = daoNivel.salvar(nivelAcesso);
            this.nivelAcesso.setId(nivelAcesso.getId());
            listaNivelAcesso.add(nivelAcesso);
            System.out.println("salvo com sucesso.");
           amodelNivel.addRow(new Object[]{moduloAdd, nivelAcesso.getId()});
           
        }

//System.out.println("modulo jtree ="+jTree1.getLastSelectedPathComponent().toString());
//       
//        System.out.println("Teste tamanho"+jTable2.getRowCount());
//        int index = jTable2.getRowCount();
//        index = index +1;
//         System.out.println("index jtable 2 = "+index);
//         jTable2.addRowSelectionInterval(index, index);
//        jTable2.setValueAt(jTree1.getLastSelectedPathComponent().toString(), index, 0);
//        
       // this.colaborador.setListaAcesso(listaNivelAcesso);
       // this.colaborador.getListaAcesso().add(jTree1.getLastSelectedPathComponent().toString());
      //  amodelNivel.addRow("teste"));
        //amodelNivel.addRow(Object[]());
        //jTable2.setValueAt(evt, ERROR, NORMAL);
//        NivelAcesso n = new NivelAcesso();
//        
//        n.setIdFuncionario(F.getIdFuncionario());
//        n.setNomeModulo(jTree1.getLastSelectedPathComponent().toString());
//        
//
//       
//        entityManager.persist(n);
//
//        na.add(n);
//        jTable1.clearSelection();
//        jTable1.setRowSelectionInterval(index, index);
//        int row = na.size() - 1;
//        jTable2.setRowSelectionInterval(row, row);
//        jTable2.scrollRectToVisible(jTable2.getCellRect(row, 0, true));
    }//GEN-LAST:event_jbConcederActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked

        
    }//GEN-LAST:event_jTree1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        jbRetirar.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jbRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRetirarActionPerformed

        Long idNivelAcesso = 0L;
        
        
        if (jTable2.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null, "Selecione um Módulo, para excluir!!!");
            return;
        }
        
        
        idNivelAcesso = Long.parseLong(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        
        
        if (idNivelAcesso == 0L){
            JOptionPane.showMessageDialog(null, "Para excluir este Módulo, feche o formulário e abra novamente.(Click no botão Sair)");
            return;
        }
       // NivelAcesso n = new NivelAcesso();
        
        daoNivel.excluir(idNivelAcesso);
        
         listaNivelAcesso.remove(jTable2.getSelectedRow());
        amodelNivel.removeRow(jTable2.getSelectedRow());
       
        jbRetirar.setEnabled(false);
      //  jTable2.removeRowSelectionInterval(jTable2.getSelectedRow(), jTable2.getSelectedRow());
        
        
        
    }//GEN-LAST:event_jbRetirarActionPerformed

    private void carregaTableColaborador(){
        
      
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        
        this.listaColaborador = null;
     
        this.listaColaborador = daoColab.getListColab();
        for (Colaborador colab : this.listaColaborador){
                         
            amodel.addRow(new Object[]{colab.getId(),colab.getPessoa().getNome(), colab.getLogin()});            
            
        }   
    }
    
    private void carregaTableNivelAcesso(List<NivelAcesso> listaNivel){
        
        amodelNivel.setNumRows(0);
        
        this.listaNivelAcesso = null;
        this.listaNivelAcesso = listaNivel;
        for (NivelAcesso acesso: listaNivel){
                       
            amodelNivel.addRow(new Object[]{acesso.getNomeModulo(), acesso.getId()});
                    
        }
       
    }
    
    /**
     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(NivelAcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NivelAcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NivelAcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NivelAcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NivelAcessoView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbConceder;
    private javax.swing.JButton jbRetirar;
    private javax.swing.JButton jbSair;
    // End of variables declaration//GEN-END:variables
}
