/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroView;

import dao.ColaboradorDAO;
import dao.LicencaDAO;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import menuView.Menu;
import java.util.GregorianCalendar;
import java.util.Locale;
import licencaView.LicencaView;
import model.Licenca;
import model.Pessoa;
import util.GerarChaveLic;
import static util.GerarChaveLic.descriptografa;

/**
 *
 * @author daniel
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
   Locale locale = new Locale("pt", "BR");
   GregorianCalendar calendar = new GregorianCalendar();
   int verificaLicenca =0;
   int chaveLicenca = 0;
   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
   Date y = new Date();
    String sy;
   LicencaDAO lDao = new LicencaDAO();
   public LoginView() {
       // super("Login");
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel2 = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisDB-Financeiro - Versão:1.0.");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("LOGIN");

        jtfLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfLoginFocusLost(evt);
            }
        });
        jtfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfLoginKeyPressed(evt);
            }
        });

        jLabel3.setText("SENHA");

        jtfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSenhaKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton1.setText("Entrar");
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addComponent(jtfSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfLogin, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(24, 24, 24))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadeado1.png"))); // NOI18N
        jLabel4.setBorder(null);

        jLabel7.setText("Site: www.sisdb.com.br - Celular: (17) 99784-1731");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Sistema de Auto Peça - SysAuto - Versão:1.0");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLoginKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER){
           
           if (jtfLogin.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Digite o Login do Usuário");
               jtfLogin.requestFocus();
           }else{
               jtfLogin.setText(jtfLogin.getText().toUpperCase());
               jtfSenha.requestFocus();
           }
               
               
           
           
       }
    }//GEN-LAST:event_jtfLoginKeyPressed

    private void jtfLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfLoginFocusLost
         jtfLogin.setText(jtfLogin.getText().toUpperCase());
    }//GEN-LAST:event_jtfLoginFocusLost

    private void jtfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSenhaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfSenha.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Digite uma Senha");
            }else{
                 jButton1.requestFocus();
            }
                
        }
    }//GEN-LAST:event_jtfSenhaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ColaboradorDAO colabDAO = new ColaboradorDAO();
       // Pessoa colaborador;  
        
        if (jtfLogin.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Digite o Login do Usuário");
            jtfLogin.requestFocus();
            return;
        }
        if (jtfSenha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Digite a senha do Usuário");
            jtfSenha.requestFocus();
            return;
        }
         
        if (colabDAO.autenticaColaborador(jtfLogin.getText(), jtfSenha.getText())){
            Pessoa colaborador = new Pessoa() {};
            
            validaLicenca(); 
            
            String args[] = new String[2];
           // colab = dao.getColaborador(jtfLogin.getText());
            args[0] = colabDAO.getNome();    
            args[1] = String.valueOf(colabDAO.getId());
            colaborador = colabDAO.colaboradorIDPessoa(colabDAO.getId());
            colaborador.getColaborad().setUltimo_acesso(calendar.getTime());
            colabDAO.registroDataHoraAcesso(colaborador.getColaborad());
            menuView.Menu.colaborador = colaborador;
            Menu.main(args);
            dispose();
        }else{
             int cont = 0;
             cont = cont + 1;
             jtfLogin.setText("");
             jtfSenha.setText("");
             JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida !!!");
             jtfLogin.requestFocus();
        }
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
            jButton1ActionPerformed(null);
        }  
    }//GEN-LAST:event_jButton1KeyPressed
    private void validaLicenca(){
        verificaLicenca = 0;
        Licenca licenca = lDao.licenca();
        sy = sdf.format(y);
        int atual = Integer.parseInt(sy);        
        try{
            if (licenca.getInstalacao() == 0 ){
                String dtStr;
                String chave;
                Calendar c = Calendar.getInstance();
                c.setTime(y);
                c.add(Calendar.DATE, +31);
               // c.add(Calendar.DATE, 0);
                Date dtChave = new Date();
                dtChave = c.getTime();
                dtStr = sdf.format(dtChave);
                chave = GerarChaveLic.criptografia(dtStr);               
                System.out.println("A data da chave é :"+dtStr);
                System.out.println("A chave é :"+chave);            
                
                licenca.setInstalacao(1);
                licenca.setPwd(chave);
                lDao.salvar(licenca);                
            }       
            
        chaveLicenca = (Integer.parseInt(descriptografa(licenca.getPwd())));       
        if (chaveLicenca < atual){
            verificaLicenca = 1;
            LicencaView l = new LicencaView(new java.awt.Frame(), true);
            l.setLocationRelativeTo(null); // centraliza a tela
            l.setVisible(true);
            dispose();
            System.exit(0);
        }else
            if (chaveLicenca == atual)
                JOptionPane.showMessageDialog(null, "Seu Sistema será Cancelado Amanhã");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Código Serial Inválido");
            System.exit(0);
        }
    }
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JPasswordField jtfSenha;
    // End of variables declaration//GEN-END:variables
}
