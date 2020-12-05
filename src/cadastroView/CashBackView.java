/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroView;

import dao.BancoDAO;
import dao.CashBackDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import model.Banco;
import model.CashBack;
import util.RemoverAcentosString;


/**
 *
 * @author daniel
 */
public class CashBackView extends javax.swing.JInternalFrame {

  
    
    String operacao;
    public CashBackView() {
        initComponents();
        
        jtfValorCompra.setEnabled(true);
        jtfPontos.setEnabled(true);
        
        carregarFormulario();
        jbtSalvar.setEnabled(true);
        operacao="alterar";
     //   jButton2.setVisible(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rowSorterToStringConverter1 = new converter.RowSorterToStringConverter();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jtfValorCompra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfPontos = new javax.swing.JTextField();
        jrbAtivo = new javax.swing.JRadioButton();
        jrbDesativado = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jbtSalvar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();

        setTitle("Cadastro de Cash Back");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfValorCompra.setEnabled(false);
        jtfValorCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfValorCompraFocusLost(evt);
            }
        });
        jtfValorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfValorCompraActionPerformed(evt);
            }
        });
        jtfValorCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfValorCompraKeyPressed(evt);
            }
        });

        jLabel1.setText("VALO COMPRA");

        jLabel2.setText("PONTO POR VALOR DA COMPRA");

        jtfPontos.setEnabled(false);
        jtfPontos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPontosFocusLost(evt);
            }
        });
        jtfPontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPontosActionPerformed(evt);
            }
        });
        jtfPontos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPontosKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrbAtivo);
        jrbAtivo.setText("ATIVADO");

        buttonGroup1.add(jrbDesativado);
        jrbDesativado.setText("DESATIVADO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jrbAtivo)
                            .addGap(57, 57, 57)
                            .addComponent(jrbDesativado))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbAtivo)
                    .addComponent(jrbDesativado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });
        jbtCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtCancelarKeyPressed(evt);
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
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtSalvar)
                .addComponent(jbtCancelar)
                .addComponent(jbtSair))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
       
           
      dispose();
  
        
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        // TODO add your handling code here:
        
        if (operacao == "salvar"){
           CashBackDAO dao = new CashBackDAO();
           dao.salvar(carregaObjeto());
           JOptionPane.showMessageDialog(null, "Salvo com sucesso");    
        }else
           if (operacao == "alterar"){
               CashBackDAO dao = new CashBackDAO();
               dao.alterar(carregaObjeto());
               JOptionPane.showMessageDialog(null, "Alterado com sucesso");
           }
      //  jbtCancelarActionPerformed(evt);
      //  jbNovo.setEnabled(true);
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jtfValorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfValorCompraActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jtfValorCompraActionPerformed

    private void jtfValorCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorCompraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            
            if(jtfValorCompra.getText().equals("")){
                JOptionPane.showMessageDialog(null, "A descrição não pode ser nullo ou vazio");
                jtfValorCompra.requestFocus();
            }else{
                jbtSalvar.setEnabled(true);
                jbtSalvar.requestFocus();
            }
                
            
            
        }
    }//GEN-LAST:event_jtfValorCompraKeyPressed

    private void jtfValorCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValorCompraFocusLost
        // TODO add your handling code here:
        
        jtfValorCompra.setText(RemoverAcentosString.semAcento(jtfValorCompra.getText().toUpperCase()));
    }//GEN-LAST:event_jtfValorCompraFocusLost

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        // TODO add your handling code here:
    //    limpar();
  //      habilita(false);
        
       // carregaTable();
        jbtSalvar.setEnabled(false);
        jbtCancelar.setEnabled(false);
           
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void carregarFormulario(){
        
        CashBackDAO cashDAO = new CashBackDAO();
        CashBack cb = new CashBack();
        cb = cashDAO.cashBack(1L);
        jtfValorCompra.setText((cb.getValorCompra().toString()));
        jtfPontos.setText(cb.getPontos().toString());
        
        if (cb.isAtivo())
            jrbAtivo.setSelected(true);
        else
            jrbDesativado.setSelected(true);
        
    }
    
    
    
    private void jbtCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtCancelarKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtCancelarActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtCancelarKeyPressed

    private void jbtSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSalvarKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtSalvarActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSalvarKeyPressed

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtSairActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSairKeyPressed

    private void jtfPontosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPontosFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPontosFocusLost

    private void jtfPontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPontosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPontosActionPerformed

    private void jtfPontosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPontosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPontosKeyPressed

    private CashBack carregaObjeto(){
      
        CashBack cb = new CashBack();
        
        //Passando os parâmetros para o Objeto Cep.
//      //  
        if (operacao == "alterar" )
            cb.setId(1L);
        
        if (jrbAtivo.isSelected())
           cb.setAtivo(true);
        else
            cb.setAtivo(false);
        
        cb.setValorCompra(new BigDecimal(jtfValorCompra.getText()));
        cb.setPontos(new BigDecimal(jtfPontos.getText()));
        
        return cb;
    }
    
    private void limpar(){
        
        jtfValorCompra.setText("");
    //    jtfPesquisa.setText("");
             
    }
    private void habilita(boolean habilita){
       
        jtfValorCompra.setEnabled(habilita);
       
        
    }
    
  
      
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JRadioButton jrbAtivo;
    private javax.swing.JRadioButton jrbDesativado;
    private javax.swing.JTextField jtfPontos;
    private javax.swing.JTextField jtfValorCompra;
    private converter.RowSorterToStringConverter rowSorterToStringConverter1;
    // End of variables declaration//GEN-END:variables
}
