/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.itens;

import dao.PedidoDAO;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static relatoriosView.venda.RelatorioVendaView.jTable1;
import util.JTableFonteColunaDireitaAzul;
import util.JTableFonteColunaDireitaBlack;
import util.JTableFonteColunaDireitaGreen;
import util.JTableFonteColunaDireitaVermelha;




/**
 *
 * @author Daniel Rocca bortolozo. 
 */
public class RelVendaPorItenView extends javax.swing.JInternalFrame {
    public static Date dataIni = null, dataFim = null;
    PedidoDAO pedidoDAO = new PedidoDAO();
    DefaultTableModel amodel;
    SimpleDateFormat sdfH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<Object[]> listaObjeto = null;
    
    public RelVendaPorItenView() {
        initComponents();
        amodel = (DefaultTableModel) jTable1.getModel(); 
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
        jLabel1 = new javax.swing.JLabel();
        jcbDtInicial = new util.JCalendar(true);
        jLabel2 = new javax.swing.JLabel();
        jcbDtFinal = new util.JCalendar(true);
        jbtPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        jbtImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(880, 630));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Período de Venda"));

        jLabel1.setText("Data Inicial");

        jcbDtInicial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDtInicialMouseClicked(evt);
            }
        });
        jcbDtInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcbDtInicialKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbDtInicialKeyPressed(evt);
            }
        });

        jLabel2.setText("Data Final");

        jbtPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jbtPesquisar.setText("Pesquisar");
        jbtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jcbDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jbtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(585, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtPesquisar))
                        .addGap(2, 2, 2))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jbtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print-icon.png"))); // NOI18N
        jbtImprimir.setText("Imprimir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jbtImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(jbtImprimir)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD. PRODUTO", "DESCRIÇÃO DO PRODUTO", "QTD. VENDIDO", "MED. VL UNIT R$", "TOTAL VENDIDO R$", "MED. DO CUSTO R$", "TOTAL LUCRO R$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(280);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(140);
        }

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1071, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbDtInicialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDtInicialMouseClicked
        jcbDtFinal.requestFocus();
    }//GEN-LAST:event_jcbDtInicialMouseClicked

    private void jcbDtInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbDtInicialKeyTyped
        if (evt.getKeyCode() == 13) {
            System.out.println("Keypress");

        }
    }//GEN-LAST:event_jcbDtInicialKeyTyped

    private void jcbDtInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbDtInicialKeyPressed

    }//GEN-LAST:event_jcbDtInicialKeyPressed

    private void jbtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisarActionPerformed

       amodel.setNumRows(0);
       
       
       GregorianCalendar gc = new GregorianCalendar();
      
       RelVendaPorItens rvpi = new RelVendaPorItens();
        //Validação de Data Inicial e Final.

        if (!jcbDtInicial.getSelectedItem().equals("")){
            gc = (GregorianCalendar) jcbDtInicial.getSelectedItem();

            dataIni = gc.getTime();
            String dataStr = sdf.format(dataIni);
            dataStr = dataStr+" 00:00:00";
            System.out.println("DAta Str="+dataStr);
            try {
                dataIni = sdfH.parse(dataStr);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Data inicial inválida.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "A data inicial está vazia");
            return;
        }
        if (!jcbDtFinal.getSelectedItem().equals("")){
            gc = (GregorianCalendar) jcbDtFinal.getSelectedItem();

            dataFim = gc.getTime();
            String dataFimStr = sdf.format(dataFim);

            dataFimStr = (dataFimStr+" 23:59:59");
            try {
                dataFim = sdfH.parse(dataFimStr);
            } catch (ParseException ex) {
                Logger.getLogger(RelVendaPorItenView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "A data final está vazia");
            return;
        }
        if (dataIni.getTime() > dataFim.getTime()){
            JOptionPane.showMessageDialog(null, "Data Inicial maior que a Data Final");
            return;
        }

       
        try{
            listaObjeto = pedidoDAO.listaProdutoMaisVendido(dataIni, dataFim);

                if (listaObjeto.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Não têm Venda à Vista neste Período");
                    return;
                }
               
                for (Object[] obj : listaObjeto){
                    
                    rvpi.setCodproduto(String.valueOf(obj[0]));
                    rvpi.setDescricao((String) obj[1]);
                    rvpi.setQuantidade(String.valueOf(obj[2]));
                    rvpi.setVl_venda(String.valueOf(obj[3]));
                    rvpi.setVl_total(String.valueOf(obj[4]));
                    rvpi.setVl_lucro(String.valueOf(obj[5]));
                    //rvpi.setVl_custo(String.valueOf(obj[6]));
                    
                    rvpi.setVl_custo(new DecimalFormat("#,##0.00").format(obj[6]));
              
                    amodel.addRow(new Object[]{rvpi.getCodproduto(), rvpi.getDescricao(), rvpi.getQuantidade(),
                    rvpi.getVl_venda(), rvpi.getVl_total(), rvpi.getVl_custo() , rvpi.getVl_lucro()});

                    //Coloca coluna da jtable para a direita e muda cor da fonte.
                    jTable1.getColumnModel().getColumn(3).setCellRenderer(new JTableFonteColunaDireitaAzul());
                    jTable1.getColumnModel().getColumn(4).setCellRenderer(new JTableFonteColunaDireitaVermelha());
                    jTable1.getColumnModel().getColumn(5).setCellRenderer(new JTableFonteColunaDireitaAzul());
                    jTable1.getColumnModel().getColumn(6).setCellRenderer(new JTableFonteColunaDireitaVermelha());
                    

                }
               

                jbtImprimir.setEnabled(true);

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Problemas ao Carregar Tabela de Venda dos Itens"+ex.getMessage());
                ex.printStackTrace();
            }
        
    

        
    }//GEN-LAST:event_jbtPesquisarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtImprimir;
    private javax.swing.JButton jbtPesquisar;
    private javax.swing.JComboBox<String> jcbDtFinal;
    private javax.swing.JComboBox<String> jcbDtInicial;
    // End of variables declaration//GEN-END:variables
}