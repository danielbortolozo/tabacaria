/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroView;

import dao.ClienteDAO;
import dao.PessoaContatoDAO;
import dao.PessoaEnderecoDAO;
import dao.PessoaFisicaDAO;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import model.Cliente;
import model.EstadoCivil;
import model.Pessoa;
import model.PessoaContato;
import model.PessoaEndereco;
import model.PessoaFisica;
import model.PessoaJuridica;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.RemoverAcentosString;
import util.ValidaCNP;

/**
 *
 * @author root
 */
public final class ClienteView extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    //Foi criado esta lista de cliente fisico por causa do cpf na jtable.
    List<PessoaFisica> listaClienteFisico;
    //Foi criado esta lista de cliente Juridico por causa do cpf na jtable.
    List<PessoaJuridica> listaClienteJuridico;
    List<Pessoa> listaCliente;
    ClienteDAO daoCliente;
    PessoaFisica pf = new PessoaFisica();
    PessoaJuridica pj = new PessoaJuridica();
    PessoaFisicaDAO daoPFisica = new PessoaFisicaDAO();
    public static String operacao;
    String cpf = null;
    String cnpj = null;
    //Variavél para chamar a tela de cadastro de endereco de pessoa
    private EnderecoView enderecoView;
    private ContatoView contatoView;
    Long idCliente;
    public ClienteView() {
        initComponents();
        habilitar(false);
        jTabbedPane1.setEnabled(true);
        jTabbedPane1.setEnabledAt(0, false);
        jTabbedPane1.setSelectedIndex(0);
        jtfPesquisaCliente.setEnabled(true);
       // jcbTipoCliente.setSelectedIndex(-1);
       
        jtfPesquisaCliente.requestFocus();
//        jtfNome.setDocument(new FixedLengthDocument(30));
        carregaTablePessoa();
     //   jrbFisicoPesquisa.setSelected(true);
     //   jrbFisicoPesquisaMouseClicked(null);
    //    jtfPesquisaCliente.setEnabled(true);
        // jtfPesquisaCliente.requestFocus();
        // jbtCancelarActionPerformed(null);
        /*
         EventQueue queue = new EventQueue(){
         protected void dispatchEvent(final AWTEvent event){
         super.dispatchEvent(event);
         String a[];
         String tecla[];
         if (!event.paramString().equals("")){
         if (event.paramString().substring(0, 5).equals("KEY_P")){
         a = event.paramString().split(",");
         tecla = a[1].split("=");
         System.out.println("btn = "+tecla[1]);
         setTecla1(tecla[1]);
         //tecla1[1] == tecla[1];
         switch (Integer.parseInt(tecla[1])){
         case 112:
                              
         JOptionPane.showMessageDialog(null, "F1");
         break;
         case 113:
         JOptionPane.showMessageDialog(null, "F2");
         break;
         case 114:
         JOptionPane.showMessageDialog(null, "F3");
         break;
         case 115:
         JOptionPane.showMessageDialog(null, "F4");
         break;
         case 116:
         JOptionPane.showMessageDialog(null, "F5");
         break;
         case 117: //F6 Cancela Item Generico
         {
         String item = JOptionPane.showInputDialog("Qual item deseja cancelar ?");
         //   BemaECF.cancelaItemGenerico(item);
         //   v.insereItemCancelado(item);
         break;
         }
         case 118: //F7 Cancela Último Item
         //  v.insereItemCancelado("Anterior");
         //  BemaECF.cancelaItemAnterior();
         break;
         case 119:
         JOptionPane.showMessageDialog(null, "F8");
         break;
         case 120:
         JOptionPane.showMessageDialog(null, "F9");
         break;
         case 121: //F10 Desconto
         //  v.vlrDesconto = JOptionPane.showInputDialog("Digite o valor do Desconto R$ ");


         break;
         case 122: //F11
         // JOptionPane.showMessageDialog(null, "F11");
         //    BemaECF.abreCupom();
         break;
         case 123:
         //   v.fechaCupom();
         break;
         }
         }
         }
         }
         };
         Toolkit.getDefaultToolkit().getSystemEventQueue().push(queue);
         */

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
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtfPesquisaCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jrbFisica = new javax.swing.JRadioButton();
        jrbJuridico = new javax.swing.JRadioButton();
        jftfDataCadastro = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfSite = new javax.swing.JTextField();
        jpanelPessoaFisi = new javax.swing.JPanel();
        jpanelPessoaFisica = new javax.swing.JPanel();
        cpfLabel = new javax.swing.JLabel();
        jtfCpf = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");

            jtfCpf = new javax.swing.JFormattedTextField(cpf);
        }catch(Exception e){
            e.printStackTrace();
        }
        rgLabel = new javax.swing.JLabel();
        jtfRG = new javax.swing.JTextField();
        orgaoRgLabel = new javax.swing.JLabel();
        jtfOrgaoRg = new javax.swing.JTextField();
        cpfLabel1 = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox();
        jcbSexo = new javax.swing.JComboBox();
        cpfLabel2 = new javax.swing.JLabel();
        orgaoRgLabel1 = new javax.swing.JLabel();
        jftfDt_EmissaoRG = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/###");

            jftfDt_EmissaoRG = new javax.swing.JFormattedTextField(data);
        }catch(Exception e){
            e.printStackTrace();
        }
        jLabel3 = new javax.swing.JLabel();
        jftfNascimento = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanelPessoaJuridica = new javax.swing.JPanel();
        cpfLabel5 = new javax.swing.JLabel();
        jtfCNPJ = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cnpj = new javax.swing.text.MaskFormatter("##.###.###/####-##");

            jtfCNPJ = new javax.swing.JFormattedTextField(cnpj);
        }catch(Exception e){
            e.printStackTrace();
        }
        cpfLabel6 = new javax.swing.JLabel();
        jtfInscricaoMunicipal = new javax.swing.JTextField();
        cpfLabel7 = new javax.swing.JLabel();
        jtfInscricaoEstadual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfRazaoSocial = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cpfLabel4 = new javax.swing.JLabel();
        jtfLimiteCredito = new javax.swing.JTextField();
        cpfLabel3 = new javax.swing.JLabel();
        jcbSituacaoCliente = new javax.swing.JComboBox();
        cpfLabel8 = new javax.swing.JLabel();
        jtfCreditoCliente = new javax.swing.JTextField();
        cpfLabel9 = new javax.swing.JLabel();
        jtfCashBack = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEndereco = new javax.swing.JTable();
        jbtAdicionarEndereco = new javax.swing.JButton();
        jbtExcluirEndereco = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableContato = new javax.swing.JTable();
        jbtAdicionaContato = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbtExcluir = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtSalvar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtNovo = new javax.swing.JButton();

        rowSorterToStringConverter1.setTable(jTable1);

        setTitle("CADASTRO DE CLIENTES");
        setLocationByPlatform(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Cliente"));

        jtfPesquisaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfPesquisaCliente.setNextFocusableComponent(jbtNovo);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${rowSorter}"), jtfPesquisaCliente, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(rowSorterToStringConverter1);
        bindingGroup.addBinding(binding);

        jtfPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisaClienteActionPerformed(evt);
            }
        });
        jtfPesquisaCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPesquisaClienteFocusLost(evt);
            }
        });
        jtfPesquisaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaClienteKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "CPF / CNPJ", "RG / IE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(260);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setToolTipText("Cliente");

        jPanel2.setDoubleBuffered(false);
        jPanel2.setEnabled(false);
        jPanel2.setFocusTraversalPolicyProvider(true);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("IDENTIFICAÇÃO DO CLIENTE"));

        jLabelNome.setText("NOME");

        jLabel6.setText("E-MAIL");

        jLabel7.setText("SITE");

        jtfNome.setEnabled(false);
        jtfNome.setNextFocusableComponent(jtfEmail);
        jtfNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNomeFocusLost(evt);
            }
        });
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNomeKeyPressed(evt);
            }
        });

        jtfEmail.setEnabled(false);
        jtfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEmailFocusLost(evt);
            }
        });
        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfEmailKeyPressed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Cliente"));

        buttonGroup2.add(jrbFisica);
        jrbFisica.setText("Física");
        jrbFisica.setNextFocusableComponent(jrbJuridico);
        jrbFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFisicaActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrbJuridico);
        jrbJuridico.setText("Jurídica");
        jrbJuridico.setNextFocusableComponent(jtfNome);
        jrbJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbJuridicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbJuridico)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbFisica)
                    .addComponent(jrbJuridico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jftfDataCadastro.setEditable(false);
        jftfDataCadastro.setEnabled(false);
        jftfDataCadastro.setFocusable(false);

        jLabel4.setText("DATA CADASTRO");

        jLabel2.setText("CÓDIGO");

        jtfCodigo.setEnabled(false);

        jtfSite.setEnabled(false);
        jtfSite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfSiteFocusLost(evt);
            }
        });
        jtfSite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSiteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfSite, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jftfDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(168, 168, 168))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftfDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNome)))
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTE", jPanel2);

        jpanelPessoaFisi.setDoubleBuffered(false);
        jpanelPessoaFisi.setEnabled(false);

        jpanelPessoaFisica.setBorder(javax.swing.BorderFactory.createTitledBorder("PESSOA FÍSICA :"));
        jpanelPessoaFisica.setDoubleBuffered(false);

        cpfLabel.setText("CPF ");

        //jtfCpf = DefinirTiposCaracteresETamanho(11, "0,1,2,3,4,5,6,7,8,9");
        jtfCpf.setEnabled(false);
        jtfCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfCpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCpfFocusLost(evt);
            }
        });
        jtfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCpfKeyPressed(evt);
            }
        });

        rgLabel.setText("RG ");

        jtfRG.setEnabled(false);
        jtfRG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfRGFocusLost(evt);
            }
        });
        jtfRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfRGKeyPressed(evt);
            }
        });

        orgaoRgLabel.setText("ORGAO RG  ");

        jtfOrgaoRg.setEnabled(false);
        jtfOrgaoRg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfOrgaoRgFocusLost(evt);
            }
        });
        jtfOrgaoRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfOrgaoRgKeyPressed(evt);
            }
        });

        cpfLabel1.setText("ESTADO CIVIL ");

        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLTEIRO", "CASADO", "UNIAO ESTAVEL", "AMASIADO", "VIUVO" }));
        jcbEstadoCivil.setEnabled(false);
        jcbEstadoCivil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbEstadoCivilFocusLost(evt);
            }
        });
        jcbEstadoCivil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbEstadoCivilKeyPressed(evt);
            }
        });

        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMININO" }));
        jcbSexo.setEnabled(false);
        jcbSexo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbSexoFocusLost(evt);
            }
        });
        jcbSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbSexoKeyPressed(evt);
            }
        });

        cpfLabel2.setText("SEXO");

        orgaoRgLabel1.setText("EMISSÃO RG");

        jftfDt_EmissaoRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jftfDt_EmissaoRG.setEnabled(false);
        jftfDt_EmissaoRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftfDt_EmissaoRGKeyPressed(evt);
            }
        });

        jLabel3.setText("DATA NASCIMENTO");

        jftfNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jftfNascimento.setEnabled(false);
        jftfNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftfNascimentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpanelPessoaFisicaLayout = new javax.swing.GroupLayout(jpanelPessoaFisica);
        jpanelPessoaFisica.setLayout(jpanelPessoaFisicaLayout);
        jpanelPessoaFisicaLayout.setHorizontalGroup(
            jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelPessoaFisicaLayout.createSequentialGroup()
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpfLabel)
                    .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpfLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 254, Short.MAX_VALUE))
            .addGroup(jpanelPessoaFisicaLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpanelPessoaFisicaLayout.createSequentialGroup()
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jftfNascimento)
                    .addComponent(jtfRG, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(rgLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(36, 36, 36)
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfOrgaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgaoRgLabel))
                .addGap(40, 40, 40)
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelPessoaFisicaLayout.createSequentialGroup()
                        .addComponent(orgaoRgLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpanelPessoaFisicaLayout.createSequentialGroup()
                        .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbSexo, 0, 161, Short.MAX_VALUE)
                            .addComponent(cpfLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftfDt_EmissaoRG))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpanelPessoaFisicaLayout.setVerticalGroup(
            jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelPessoaFisicaLayout.createSequentialGroup()
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(cpfLabel1)
                    .addComponent(cpfLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rgLabel)
                    .addComponent(orgaoRgLabel)
                    .addComponent(orgaoRgLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfOrgaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfDt_EmissaoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jftfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanelPessoaFisiLayout = new javax.swing.GroupLayout(jpanelPessoaFisi);
        jpanelPessoaFisi.setLayout(jpanelPessoaFisiLayout);
        jpanelPessoaFisiLayout.setHorizontalGroup(
            jpanelPessoaFisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelPessoaFisica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanelPessoaFisiLayout.setVerticalGroup(
            jpanelPessoaFisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelPessoaFisiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("P.FÍSICA", jpanelPessoaFisi);

        jPanelPessoaJuridica.setBorder(javax.swing.BorderFactory.createTitledBorder("PESSOA JURÍDICA"));
        jPanelPessoaJuridica.setAlignmentX(0.0F);
        jPanelPessoaJuridica.setAlignmentY(0.0F);

        cpfLabel5.setText("CNPJ");

        jtfCNPJ.setEnabled(false);
        jtfCNPJ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCNPJFocusLost(evt);
            }
        });
        jtfCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCNPJKeyPressed(evt);
            }
        });

        cpfLabel6.setText("INSCRIÇÃO MUNICIPAL");

        jtfInscricaoMunicipal.setEnabled(false);
        jtfInscricaoMunicipal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfInscricaoMunicipalFocusLost(evt);
            }
        });
        jtfInscricaoMunicipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfInscricaoMunicipalKeyPressed(evt);
            }
        });

        cpfLabel7.setText("INSCRIÇÃO ESTADUAL");

        jtfInscricaoEstadual.setEnabled(false);
        jtfInscricaoEstadual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfInscricaoEstadualFocusLost(evt);
            }
        });
        jtfInscricaoEstadual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfInscricaoEstadualKeyPressed(evt);
            }
        });

        jLabel1.setText("RAZÃO SOCIAL");

        jtfRazaoSocial.setEnabled(false);
        jtfRazaoSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfRazaoSocialFocusLost(evt);
            }
        });
        jtfRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfRazaoSocialKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPessoaJuridicaLayout = new javax.swing.GroupLayout(jPanelPessoaJuridica);
        jPanelPessoaJuridica.setLayout(jPanelPessoaJuridicaLayout);
        jPanelPessoaJuridicaLayout.setHorizontalGroup(
            jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPessoaJuridicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPessoaJuridicaLayout.createSequentialGroup()
                        .addGroup(jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfLabel5)
                            .addComponent(jtfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfLabel6)
                            .addComponent(jtfInscricaoMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPessoaJuridicaLayout.createSequentialGroup()
                                .addComponent(cpfLabel7)
                                .addGap(13, 13, 13))
                            .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(jPanelPessoaJuridicaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfRazaoSocial)))
        );
        jPanelPessoaJuridicaLayout.setVerticalGroup(
            jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPessoaJuridicaLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPessoaJuridicaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfLabel7)
                            .addComponent(cpfLabel6)))
                    .addGroup(jPanelPessoaJuridicaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cpfLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfInscricaoMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPessoaJuridica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPessoaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("P.JURÍDICA", jPanel10);

        jPanel5.setBorder(null);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("SITUAÇÃO DO CLIENTE"));

        cpfLabel4.setText("SITUAÇÃO");

        jtfLimiteCredito.setBackground(new java.awt.Color(187, 236, 216));
        jtfLimiteCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfLimiteCredito.setText("0,00");
        jtfLimiteCredito.setEnabled(false);
        jtfLimiteCredito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfLimiteCreditoFocusLost(evt);
            }
        });
        jtfLimiteCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfLimiteCreditoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfLimiteCreditoKeyPressed(evt);
            }
        });

        cpfLabel3.setText("LIMITE DE CRÉDITO");

        jcbSituacaoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NORMAL", "INADIMPLENTE" }));
        jcbSituacaoCliente.setEnabled(false);
        jcbSituacaoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbSituacaoClienteFocusLost(evt);
            }
        });
        jcbSituacaoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbSituacaoClienteKeyPressed(evt);
            }
        });

        cpfLabel8.setText("CRÉDITO");

        jtfCreditoCliente.setBackground(new java.awt.Color(249, 246, 145));
        jtfCreditoCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCreditoCliente.setText("0,00");
        jtfCreditoCliente.setEnabled(false);
        jtfCreditoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCreditoClienteActionPerformed(evt);
            }
        });
        jtfCreditoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCreditoClienteKeyPressed(evt);
            }
        });

        cpfLabel9.setText("CASH BACK");

        jtfCashBack.setEditable(false);
        jtfCashBack.setBackground(new java.awt.Color(249, 246, 145));
        jtfCashBack.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfCashBack.setText("0,00");
        jtfCashBack.setEnabled(false);
        jtfCashBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCashBackActionPerformed(evt);
            }
        });
        jtfCashBack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCashBackKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfCreditoCliente)
                    .addComponent(cpfLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpfLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfLimiteCredito, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(147, 147, 147)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cpfLabel4)
                    .addComponent(jcbSituacaoCliente, 0, 166, Short.MAX_VALUE)
                    .addComponent(cpfLabel9)
                    .addComponent(jtfCashBack))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel3)
                    .addComponent(cpfLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSituacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(cpfLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCreditoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(cpfLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCashBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SITUAÇÃO", jPanel5);

        jTableEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "UF", "CEP", "PRINCIPAL", "CORRESPONDENCIA", "ENTREGA", "COBRANCA", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEndereco.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnderecoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEndereco);
        if (jTableEndereco.getColumnModel().getColumnCount() > 0) {
            jTableEndereco.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTableEndereco.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableEndereco.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTableEndereco.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTableEndereco.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTableEndereco.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTableEndereco.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTableEndereco.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTableEndereco.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTableEndereco.getColumnModel().getColumn(10).setResizable(false);
            jTableEndereco.getColumnModel().getColumn(10).setPreferredWidth(50);
        }

        jbtAdicionarEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jbtAdicionarEndereco.setText("Adicionar Endereço");
        jbtAdicionarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionarEnderecoActionPerformed(evt);
            }
        });
        jbtAdicionarEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtAdicionarEnderecoKeyPressed(evt);
            }
        });

        jbtExcluirEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jbtExcluirEndereco.setText("Excluir Endereço");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableEndereco, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jbtExcluirEndereco, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbtExcluirEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirEnderecoActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Next.png"))); // NOI18N
        jButton2.setText("Próximo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jbtAdicionarEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExcluirEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtAdicionarEndereco)
                        .addComponent(jbtExcluirEndereco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("ENDEREÇOS", jPanel6);

        jTableContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIÇÃO", "DDD", "NÚMERO", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContato.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(jTableContato);
        if (jTableContato.getColumnModel().getColumnCount() > 0) {
            jTableContato.getColumnModel().getColumn(0).setResizable(false);
            jTableContato.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTableContato.getColumnModel().getColumn(1).setResizable(false);
            jTableContato.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTableContato.getColumnModel().getColumn(2).setResizable(false);
            jTableContato.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTableContato.getColumnModel().getColumn(3).setResizable(false);
            jTableContato.getColumnModel().getColumn(3).setPreferredWidth(0);
        }

        jbtAdicionaContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jbtAdicionaContato.setText("Adicionar Contato");
        jbtAdicionaContato.setNextFocusableComponent(jbtSalvar);
        jbtAdicionaContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionaContatoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jButton1.setText("Excluir Contato");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContato, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButton1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jbtAdicionaContato, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 303, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAdicionaContato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CONTATOS", jPanel9);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jbtExcluir.setText("Excluir");
        jbtExcluir.setEnabled(false);
        jbtExcluir.setFocusCycleRoot(true);
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });
        jbtExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtExcluirKeyPressed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.setEnabled(false);
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

        jbtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jbtNovo.setText("Novo");
        jbtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoActionPerformed(evt);
            }
        });
        jbtNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtNovoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtCancelar)
                .addComponent(jbtSair)
                .addComponent(jbtNovo)
                .addComponent(jbtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesquisaClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPesquisaClienteFocusLost
        // TODO add your handling code here:
        // btnNovo.requestFocus();
        //  jbtNovo.requestFocus();
    }//GEN-LAST:event_jtfPesquisaClienteFocusLost

    private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
        // TODO add your handling code here:
        operacao = "salvar";
        jbtCancelarActionPerformed(evt);
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
       
        
        jftfDataCadastro.setEnabled(true);
        jftfDataCadastro.setEditable(false);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras 
        Date y = new Date();
        jftfDataCadastro.setValue(y);
   //     jcbTipoCliente.setEnabled(true);
        // jTabbedPane1.setEnabled(true);
        jrbFisica.setSelected(true);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, false);
        jPanelPessoaJuridica.setVisible(false);
        jTabbedPane1.setSelectedIndex(0);
        jbtCancelar.setEnabled(true);
        jbtNovo.setEnabled(false);

        jtfPesquisaCliente.setEnabled(false);
        jtfNome.setEnabled(true);
        jrbFisica.setEnabled(true);
        jrbJuridico.setEnabled(true);
        //Criando Formulário EnderecoView
     //   enderecoView = new EnderecoView(new java.awt.Frame(), true);
     //   enderecoView.jtfLogradouro.setEnabled(true);
     //   enderecoView.setFormulario("cliente");
        //Criando Formulário ContatoView
    //    contatoView = new ContatoView(new java.awt.Frame(), true);
        // contatoView.jtfDescricao.setEnabled(true);
        jpanelPessoaFisi.setEnabled(true);
        jtfNome.requestFocus();
        //jrbFisica.requestFocus();
        //   jcbTipoCliente.requestFocus();
        jtfLimiteCredito.setText("0");
        
        pj = new PessoaJuridica();
        pf = new PessoaFisica();

    }//GEN-LAST:event_jbtNovoActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        // TODO add your handling code here:
        dispose();
       // jbtCancelarActionPerformed(evt);
        menuView.Menu.jbtClientes.setEnabled(true);
        menuView.Menu.jmenuCliente.setEnabled(true);
     //   menuView.Principal.jbtClientes.requestFocus();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed

        habilitar(false);
        jTabbedPane1.setSelectedIndex(0);      
        
        jbtNovo.setEnabled(true);

        jtfPesquisaCliente.setEnabled(true);
        jtfPesquisaCliente.requestFocus();

        //Limpar jTableEndereco
        DefaultTableModel amodel = (DefaultTableModel) jTableEndereco.getModel();
        amodel.setNumRows(0);
       
        //Limpar jTableContato
        DefaultTableModel amodel1 = (DefaultTableModel) jTableContato.getModel();
        amodel1.setNumRows(0);
        
        DefaultTableModel amodel2 = (DefaultTableModel) jTable1.getModel();
        amodel2.setNumRows(0);
        limpar();
        carregaTablePessoa();

        jbtSalvar.setEnabled(false);
        jbtExcluir.setEnabled(false);
        jbtCancelar.setEnabled(false);
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jtfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEmailFocusLost
        jtfEmail.setText(jtfEmail.getText().toLowerCase());

    }//GEN-LAST:event_jtfEmailFocusLost

    private void jtfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNomeFocusLost
        // TODO add your handling code here:
        //jtfNome.setText(jtfNome.getText().toUpperCase());
         jtfNome.setText(RemoverAcentosString.semAcento(jtfNome.getText().toUpperCase()));

    }//GEN-LAST:event_jtfNomeFocusLost

    private void jtfCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCpfFocusLost
        // TODO add your handling code here:


    }//GEN-LAST:event_jtfCpfFocusLost

    private void jcbEstadoCivilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbEstadoCivilFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jcbEstadoCivilFocusLost

    private void jtfRGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfRGFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jtfRGFocusLost

    private void jtfOrgaoRgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfOrgaoRgFocusLost
        // TODO add your handling code here:
        jtfOrgaoRg.setText(jtfOrgaoRg.getText().toUpperCase());

    }//GEN-LAST:event_jtfOrgaoRgFocusLost

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed

        // TODO add your handling code here:
        salvar();

       // jbtCancelarActionPerformed(evt);

    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        // TODO add your handling code here:


    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jtfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {

            if (jtfNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo nome não pode ser vazio ou nullo!!!");
                jtfNome.requestFocus();
            } else {
                jtfEmail.setEnabled(true);
              //  jbtSalvar.setEnabled(true);
                jtfEmail.requestFocus();
            }

        }
    }//GEN-LAST:event_jtfNomeKeyPressed

    private void jtfEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == evt.VK_ENTER) {

            if (jtfEmail.getText().equals("")) {

                jtfSite.setEnabled(true);
                jtfSite.requestFocus();
            } else {
                System.out.println("Validar email");
                jtfSite.setEnabled(true);
                jtfSite.requestFocus();
            }

        }

    }//GEN-LAST:event_jtfEmailKeyPressed

//    if (evt.getKeyCode() == evt.VK_ENTER){
//            jTabbedPane1.setEnabledAt(1, true);
//            jTabbedPane1.setSelectedIndex(1);
//               
//            if (jrbFisica.isSelected()){
//               jtfCpf.setEnabled(true);
//               jtfCpf.requestFocus();
//            }else{
//                  jtfCNPJ.setEnabled(true);
//                  jtfCNPJ.requestFocus();
//            }
//        
//         }jtfSite.setText(jtfSite.getText().toLowerCase());

    private void jtfCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCpfKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            
            cpf = jtfCpf.getText();
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            System.out.println("CPF ="+cpf);
            
            PessoaFisica p =  new PessoaFisica() ;
            p = daoPFisica.verificaSeExisteCPF(cpf);
            if ( p == null){         
               if (ValidaCNP.isValidCPF(cpf) == false) {
                JOptionPane.showMessageDialog(null, "CPF inválido");
                return;
               }
            }else{
                JOptionPane.showMessageDialog(null, "Cliente já Cadastrado !!! \n"
                        + "Nome: "+p.getNome());
                return;
            }   
            
            jcbEstadoCivil.setEnabled(true);
            jcbEstadoCivil.requestFocus();

           

        }
    }//GEN-LAST:event_jtfCpfKeyPressed

    private void jcbEstadoCivilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbEstadoCivilKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jcbSexo.setEnabled(true);
            jcbSexo.requestFocus();

        }
    }//GEN-LAST:event_jcbEstadoCivilKeyPressed

    private void jtfRGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfRGKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jtfOrgaoRg.setEnabled(true);
            jtfOrgaoRg.requestFocus();

        }
    }//GEN-LAST:event_jtfRGKeyPressed

    private void jtfOrgaoRgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfOrgaoRgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {

       //     jftfDataEmissaoRg.setEnabled(true);
            //     jftfDataEmissaoRg.requestFocus();
            jftfDt_EmissaoRG.setEnabled(true);
            jftfDt_EmissaoRG.requestFocus();

        }

    }//GEN-LAST:event_jtfOrgaoRgKeyPressed

    private void jtfLimiteCreditoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfLimiteCreditoFocusLost
        String limite = jtfLimiteCredito.getText();        
        limite = limite.replace(".", "");
        limite = limite.replace(",", ".");
        jtfLimiteCredito.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(limite)));
        if (operacao == "salvar")
           jtfCreditoCliente.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(limite)));
        jtfCashBack.setText("0.0");
        
    }//GEN-LAST:event_jtfLimiteCreditoFocusLost

    private void jtfLimiteCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLimiteCreditoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (jtfLimiteCredito.getText().equals("")){
                jtfLimiteCredito.setText("0"); 
                jtfCreditoCliente.setText("0");               
            }
            jcbSituacaoCliente.setEnabled(true);
            jtfCreditoCliente.setEnabled(true);
           
            jcbSituacaoCliente.requestFocus();
        }
    }//GEN-LAST:event_jtfLimiteCreditoKeyPressed

    private void jcbSituacaoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbSituacaoClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSituacaoClienteFocusLost

    private void jcbSituacaoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbSituacaoClienteKeyPressed

        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
           
            jtfCreditoCliente.setEnabled(true);
            jtfCreditoCliente.requestFocus();
            
            
//            jTabbedPane1.setEnabledAt(4, true);
//            jTabbedPane1.setSelectedIndex(4);
//            jbtAdicionarEndereco.setEnabled(true);
//            jbtAdicionarEndereco.requestFocus();

            // jbtSalvar.requestFocus();
        }
    }//GEN-LAST:event_jcbSituacaoClienteKeyPressed

    private void jrbJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbJuridicoActionPerformed
        // TODO add your handling code here:

      
        jTabbedPane1.setEnabledAt(1, false);
        jpanelPessoaFisica.setVisible(false);
        jPanelPessoaJuridica.setVisible(true);
        jLabelNome.setText("NOME FANTASIA");
        jtfNome.requestFocus();
      //  jPanelPessoaJuridica.setSize(300, 300);
        // jPanelPessoaJuridica.set

    }//GEN-LAST:event_jrbJuridicoActionPerformed

    private void jtfCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCNPJFocusLost
        
    }//GEN-LAST:event_jtfCNPJFocusLost

    private void jtfCNPJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCNPJKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {

            if (jtfCNPJ.getText().equals("  .   .   /    -  ")) {
                JOptionPane.showMessageDialog(null, "CNPJ não poder ser vazio ou nullo !!!");
            }else{
                  cnpj = jtfCNPJ.getText();                  
                  cnpj = cnpj.replace(".", "");
                  cnpj = cnpj.replace("/", "");
                  cnpj = cnpj.replace("-", "");
                  System.out.println("CNPJ para Validar ="+cnpj);
                  if (ValidaCNP.isValidCNPJ(cnpj)== false){
                      JOptionPane.showMessageDialog(null, "CNPJ INVÁLIDO !!!");
                      return;
                  }
                  jtfInscricaoMunicipal.setEnabled(true);
                  jtfInscricaoMunicipal.requestFocus();
            }

        }
    }//GEN-LAST:event_jtfCNPJKeyPressed

    private void jtfInscricaoMunicipalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfInscricaoMunicipalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfInscricaoMunicipalFocusLost

    private void jtfInscricaoMunicipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfInscricaoMunicipalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jtfInscricaoEstadual.setEnabled(true);
            jtfInscricaoEstadual.requestFocus();
        }
    }//GEN-LAST:event_jtfInscricaoMunicipalKeyPressed

    private void jtfInscricaoEstadualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfInscricaoEstadualFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfInscricaoEstadualFocusLost

    private void jtfInscricaoEstadualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfInscricaoEstadualKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTabbedPane1.setEnabledAt(3, true);
            jTabbedPane1.setSelectedIndex(3);
            jtfLimiteCredito.setEnabled(true);
            jtfLimiteCredito.requestFocus();
        }
    }//GEN-LAST:event_jtfInscricaoEstadualKeyPressed

    private void jrbFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFisicaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setEnabledAt(2, false);
        jPanelPessoaJuridica.setVisible(false);
        jpanelPessoaFisica.setVisible(true);
        jLabelNome.setText("NOME");
        if (operacao == "salvar") {
            jtfNome.requestFocus();
        }
    }//GEN-LAST:event_jrbFisicaActionPerformed

    private void jcbSexoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbSexoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSexoFocusLost

    private void jcbSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbSexoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jtfRG.setEnabled(true);
            jtfRG.requestFocus();
        }
    }//GEN-LAST:event_jcbSexoKeyPressed

    private void jbtAdicionarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionarEnderecoActionPerformed
        enderecoView = new EnderecoView(new java.awt.Frame(), true);
        enderecoView.jtfLogradouro.setEnabled(true);
        enderecoView.setFormulario("cliente");
        if (operacao == "alterar"){
           enderecoView.setPessoaId(Long.parseLong(jtfCodigo.getText()));
           enderecoView.setOperacao(operacao);
        }
        
      //  enderecoView.setSize(600, 354);
        enderecoView.setTitle("Cadastro de Endereco de Cliente");
        enderecoView.setLocationRelativeTo(null); // centraliza a tela 
        enderecoView.setVisible(true);
        
        //enderecoView.setFormulario("cliente");
        
//        System.out.println("Form btn add = "+enderecoView.getFormulario());
    }//GEN-LAST:event_jbtAdicionarEnderecoActionPerformed

    private void jTableEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEnderecoMouseClicked


    }//GEN-LAST:event_jTableEnderecoMouseClicked

    private void jbtExcluirEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirEnderecoActionPerformed
        try {
            Long id = (Long) jTableEndereco.getValueAt(jTableEndereco.getSelectedRow(), 10);
            if (id > 0) {
                PessoaEnderecoDAO daoEndereco = new PessoaEnderecoDAO();
                daoEndereco.remover(id);
                ((DefaultTableModel) jTableEndereco.getModel()).removeRow(jTableEndereco.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Endereço Excluído com Sucesso !!!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Endereço, Click no Botão Salvar e tente novamente.");
            //ex.printStackTrace();
        }


    }//GEN-LAST:event_jbtExcluirEnderecoActionPerformed

    private void jtfPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesquisaClienteActionPerformed

    private void jtfPesquisaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaClienteKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTable1.requestFocus();
        } else if (evt.getKeyCode() == evt.VK_TAB) {
            jbtNovo.requestFocus();
        }


    }//GEN-LAST:event_jtfPesquisaClienteKeyPressed

    private void jbtAdicionaContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionaContatoActionPerformed
        // TODO add your handling code here:
//        contatoView.setSize(404, 262);
//        contatoView.setTitle("Cadastro de Contato do Cliente");
//        contatoView.setLocationRelativeTo(null); // centraliza a tela 
//        contatoView.setVisible(true);
        
        
        
        
        
        contatoView = new ContatoView(new java.awt.Frame(), true);
      //  contatoView.setSize(404, 262);
        contatoView.setTitle("Cadastro de Contato do Cliente");
        contatoView.setLocationRelativeTo(null); // centraliza a tela                            
        contatoView.setFormulario("cliente");
        if (operacao == "alterar"){
           contatoView.setPessoaId(Long.parseLong(jtfCodigo.getText()));
           contatoView.setOperacao(operacao);
        }
        contatoView.setVisible(true);
        


    }//GEN-LAST:event_jbtAdicionaContatoActionPerformed

    private void jbtAdicionarEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtAdicionarEnderecoKeyPressed
        // TODO add your handling code here:
//        if (evt.getKeyCode() == evt.VK_ENTER){
//            jbtAdicionarEnderecoActionPerformed(null);
//        }

        // 
    }//GEN-LAST:event_jbtAdicionarEnderecoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setEnabledAt(5, true);
        jTabbedPane1.setSelectedIndex(5);
        jbtAdicionaContato.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        operacao = "alterar";
        habilitar(true);
        limpar();
        ClienteDAO dao = new ClienteDAO();
        //Instancia pessoa fisica.
//        PessoaFisica pf = new PessoaFisica();
//        PessoaJuridica pj = new PessoaJuridica();
        //Instancia cliente
        Pessoa cliente = new Pessoa() {};
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Código de pessoa.
        Long id = (Long) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        jTabbedPane1.setSelectedIndex(0);
        enderecoView = new EnderecoView(new java.awt.Frame(), true);
        contatoView = new ContatoView(new java.awt.Frame(), true);
        //Se for Pessoa Física faça isso abaixo;
        cliente = dao.cliente(id);
        
        idCliente = cliente.getCli().getId();
        
        if (cliente.getTipo().equals("F")) {
            pf = dao.pessoaFisica(id);         
            
            jPanelPessoaJuridica.setVisible(false);
            jrbFisica.setSelected(true);
            jtfCodigo.setEditable(false);
            jtfCodigo.setFocusable(false);

            jcbEstadoCivil.setSelectedItem(pf.getEstado_civil().toString());

            if (pf.getSexo().equals("M"))
                jcbSexo.setSelectedIndex(0);
            if (pf.getSexo().equals("F"))
                jcbSexo.setSelectedIndex(1);
            
            jtfCodigo.setText((pf.getId().toString()));
            //jftfDataCadastro.setText(cli.get);
            SimpleDateFormat sdfdt_cad = new SimpleDateFormat("dd/MM/yyyy");
            //if (cli.getda)
            
            String dt_cad = sdfdt_cad.format(cliente.getCli().getDataCadastro());
            jftfDataCadastro.setText(dt_cad);            
          
            jtfNome.setText(pf.getNome());
            jtfEmail.setText(pf.getEmail());
            jtfSite.setText(pf.getSite());
            jtfCpf.setText(pf.getCpf());
            cpf = pf.getCpf();
            jtfRG.setText(pf.getRg());
            jtfOrgaoRg.setText(pf.getOrgao_rg());
            //Data Emissao RG
            if (pf.getData_emissao() == null) {
                jftfDt_EmissaoRG.setText("");              
            } else {                
                String dt_emissao = sdf.format(pf.getData_emissao()); // Converte data para string.
                jftfDt_EmissaoRG.setText(dt_emissao);
            }
            //pf.getData_nascimento() == null
            //Data Emissao RG
            System.out.println("data nasc: pf"+pf.getData_nascimento());
            if (pf.getData_nascimento() == null || pf.getData_nascimento().equals("")) {         
                jftfNascimento.setText("");
                System.out.println("data vazia...");                
            } else {                
                String dt_nasc = sdf.format(pf.getData_nascimento()); // Converte data para string.
                System.out.println("Data nascimento :"+dt_nasc);
                jftfNascimento.setText(dt_nasc);
            }           
            
            jtfLimiteCredito.setText(cliente.getCli().getLimite().toString());
            jtfLimiteCredito.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(jtfLimiteCredito.getText()))); 
            jtfCreditoCliente.setText(cliente.getCli().getCredito().toString());
            jtfCreditoCliente.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(jtfCreditoCliente.getText())));
            jcbSituacaoCliente.setSelectedItem(cliente.getCli().getSituacao());
            jtfCashBack.setText(cliente.getCli().getCashBack().toString());
            jtfCashBack.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(jtfCashBack.getText()))); 
         
            //Adicionar enderecos na jTableEndereco.
            List<PessoaEndereco> listaEndereco = new ArrayList<PessoaEndereco>();
            listaEndereco = dao.enderecos(id);
            DefaultTableModel amodel = (DefaultTableModel) jTableEndereco.getModel();
            amodel.setNumRows(0);
            for (PessoaEndereco endereco : listaEndereco) {
                amodel.addRow(new Object[]{endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(),
                    endereco.getCidade(), endereco.getUf(), endereco.getCep(), endereco.getPrincipal(),
                    endereco.getCorrespondencia(), endereco.getEntrega(), endereco.getCobranca(), endereco.getId()});
            }
            List<PessoaContato> listaContato = new ArrayList<PessoaContato>();
            listaContato = dao.contatos(id);
            DefaultTableModel amodel1 = (DefaultTableModel) jTableContato.getModel();
            amodel1.setNumRows(0);
            for (PessoaContato contato : listaContato) {
                amodel1.addRow(new Object[]{contato.getDescricao(), contato.getDdd(), contato.getNumero(), contato.getId()});
            }
            jbtSalvar.setEnabled(true);
            jTabbedPane1.setEnabledAt(1, true);
            jpanelPessoaFisica.setEnabled(true);
            jTabbedPane1.setEnabledAt(2, false);
           // jTabbedPane1.setVisible(false);
        } else if (cliente.getTipo().equals("J")) {
            pj = dao.pessoaJuridica(id);
            cliente = dao.cliente(id);
            //Desabilitar Panel de Pessoa Juridica
            jLabelNome.setText("NOME FANTASIA");
           // jpanelPessoaFisica.setVisible(false);
            jrbJuridico.setSelected(true);
            jtfCodigo.setEditable(false);
            jtfCodigo.setFocusable(false);
            jtfCodigo.setText((pj.getId().toString()));
            SimpleDateFormat sdfdt_cad = new SimpleDateFormat("dd/MM/yyyy");
            String dt_cad = sdfdt_cad.format(cliente.getCli().getDataCadastro());
            jftfDataCadastro.setText(dt_cad);
            jtfNome.setText(pj.getNome());
            jtfEmail.setText(pj.getEmail());
            jtfSite.setText(pj.getSite());
            jtfRazaoSocial.setText(pj.getRazao_social());
            jtfCNPJ.setText(pj.getCnpj());
            jtfInscricaoEstadual.setText(pj.getInscrecao_estadual());
            jtfInscricaoMunicipal.setText(pj.getInscrecao_municipal());
            
            jtfLimiteCredito.setText(cliente.getCli().getLimite().toString());
            jtfLimiteCredito.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(jtfLimiteCredito.getText()))); 
           
            jtfCreditoCliente.setText(cliente.getCli().getCredito().toString());
            jtfCreditoCliente.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(jtfCreditoCliente.getText())));
            jcbSituacaoCliente.setSelectedItem(cliente.getCli().getSituacao());
            jtfCashBack.setText(cliente.getCli().getCashBack().toString());
            jtfCashBack.setText(new DecimalFormat("#,##0.00").format(Double.parseDouble(jtfCashBack.getText()))); 
                    
            if (cliente.getCli().getSituacao().equals("NORMAL"))
                jcbSituacaoCliente.setSelectedIndex(0);
            if (cliente.getCli().getSituacao().equals("INADIMPLENTE"))
                jcbSituacaoCliente.setSelectedIndex(1);
            //Adicionar Enderço no Cliente Juridico
            List<PessoaEndereco> listaEndereco = new ArrayList<PessoaEndereco>();
            listaEndereco = dao.enderecos(id);
            DefaultTableModel amodel = (DefaultTableModel) jTableEndereco.getModel();
            amodel.setNumRows(0);
            for (PessoaEndereco endereco : listaEndereco) {
                amodel.addRow(new Object[]{endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(),
                    endereco.getCidade(), endereco.getUf(), endereco.getCep(), endereco.getPrincipal(),
                    endereco.getCorrespondencia(), endereco.getEntrega(), endereco.getCobranca(), endereco.getId()});
            }
            List<PessoaContato> listaContato = new ArrayList<PessoaContato>();
            listaContato = dao.contatos(id);
            DefaultTableModel amodel1 = (DefaultTableModel) jTableContato.getModel();
            amodel1.setNumRows(0);
            for (PessoaContato contato : listaContato) {
                amodel1.addRow(new Object[]{contato.getDescricao(), contato.getDdd(), contato.getNumero(), contato.getId()});
            }
            
            jTabbedPane1.setEnabledAt(1, false);
            jTabbedPane1.setEnabledAt(2, true);
            jPanelPessoaJuridica.setVisible(true);          
        }
        jbtSalvar.setEnabled(true);
        jbtNovo.setEnabled(false);
        jbtCancelar.setEnabled(true);
        jbtExcluir.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jftfDt_EmissaoRGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftfDt_EmissaoRGKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == evt.VK_ENTER) {
            jftfNascimento.setEnabled(true);
            jftfNascimento.requestFocus();
//            jTabbedPane1.setEnabledAt(3, true);
//            jTabbedPane1.setSelectedIndex(3);
//            jtfLimiteCredito.setEnabled(true);
//            jtfLimiteCredito.requestFocus();
        }
    }//GEN-LAST:event_jftfDt_EmissaoRGKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Long id = (Long) jTableContato.getValueAt(jTableContato.getSelectedRow(), 3);
            if (id > 0) {
                PessoaContatoDAO daoContato = new PessoaContatoDAO();
                daoContato.remover(id);
                ((DefaultTableModel) jTableContato.getModel()).removeRow(jTableContato.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Contato Excluído com Sucesso !!!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Contato, click no Botão Salvar e Tente novamente.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfLimiteCreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLimiteCreditoKeyTyped
    
    }//GEN-LAST:event_jtfLimiteCreditoKeyTyped

    private void jtfSiteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSiteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (jrbFisica.isSelected()) {
                jTabbedPane1.setEnabledAt(1, true);
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setSelectedIndex(1);
                jtfCpf.setEnabled(true);
                jtfCpf.requestFocus();
            } else {
                jTabbedPane1.setEnabledAt(2, true);
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setSelectedIndex(2);
                jtfRazaoSocial.setEnabled(true);
                jtfRazaoSocial.requestFocus();
            }

        }
    }//GEN-LAST:event_jtfSiteKeyPressed

    private void jtfSiteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfSiteFocusLost
        // TODO add your handling code here:
        jtfSite.setText(jtfSite.getText().toLowerCase());
    }//GEN-LAST:event_jtfSiteFocusLost

    private void jtfRazaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfRazaoSocialKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (!jtfRazaoSocial.getText().equals("")){
                jtfCNPJ.setEnabled(true);
                jtfCNPJ.requestFocus();
            }else
                JOptionPane.showMessageDialog(null, "Razão Social não pode ficar em branco ou vazio !!!!");
        }
    }//GEN-LAST:event_jtfRazaoSocialKeyPressed

    private void jtfRazaoSocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfRazaoSocialFocusLost
         jtfRazaoSocial.setText(RemoverAcentosString.semAcento(jtfRazaoSocial.getText().toUpperCase()));
    }//GEN-LAST:event_jtfRazaoSocialFocusLost

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            jTable1MouseClicked(null);
          //  jTable1.a
        }
    }//GEN-LAST:event_jTable1KeyPressed

    
    public void imprimirClientes(){
        
         //  PessoaFisica pf = new PessoaFisica();
       
        
        
        

        // compilacao do JRXML
        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport("src/relatorios/RelCliente.jrxml");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao compilar Rel :"+ex.getMessage());
        }

	// preenchimento do relatorio, note que o metodo recebe 3 parametros:
	// 1 - o relatorio
	//
	// 2 - um Map, com parametros que sao passados ao relatorio
	// no momento do preenchimento. No nosso caso eh null, pois nao
	// estamos usando nenhum parametro
	//
	// 3 - o data source. Note que nao devemos passar a lista diretamente,
	// e sim "transformar" em um data source utilizando a classe
	// JRBeanCollectionDataSource
        
        
        
        
        
		JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaClienteFisico));
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao gerar pdf :"+ex.getMessage());
        }

        try {
            // exportacao do relatorio para outro formato, no caso PDF
            JasperExportManager.exportReportToPdfFile(print,
                    "src/relatorios/RelCliente.pdf");
        } catch (JRException ex) {
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }

		System.out.println("Relatório gerado.");
        
        
        
    }
    
    
    
    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jtfCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCpfFocusGained
       
    }//GEN-LAST:event_jtfCpfFocusGained

    private void jbtNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtNovoKeyPressed

         if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))            
                jbtNovoActionPerformed(null);
           
        }
    }//GEN-LAST:event_jbtNovoKeyPressed

    private void jbtExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtExcluirKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))            
                jbtExcluirActionPerformed(null);
           
        }
    }//GEN-LAST:event_jbtExcluirKeyPressed

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

    private void jtfCreditoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCreditoClienteKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
           
           if (jtfCreditoCliente.equals(""))
               jtfCreditoCliente.setText("0");
            jTabbedPane1.setEnabledAt(4, true);
            jTabbedPane1.setSelectedIndex(4);
            jbtAdicionarEndereco.setEnabled(true);
            jbtAdicionarEndereco.requestFocus();

            // jbtSalvar.requestFocus();
            jbtSalvar.setEnabled(true);
        }
        
    }//GEN-LAST:event_jtfCreditoClienteKeyPressed

    private void jftfNascimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftfNascimentoKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
//            

            jTabbedPane1.setEnabledAt(3, true);
            jTabbedPane1.setSelectedIndex(3);
            jtfLimiteCredito.setEnabled(true);
            jtfLimiteCredito.requestFocus();

        }
        
      
              
    }//GEN-LAST:event_jftfNascimentoKeyPressed

    private void jtfCreditoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCreditoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCreditoClienteActionPerformed

    private void jtfCashBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCashBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCashBackActionPerformed

    private void jtfCashBackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCashBackKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCashBackKeyPressed

    public void habilitar(boolean habilita) {
        jtfNome.setEnabled(habilita);

        jftfDataCadastro.setEditable(habilita);
        jTabbedPane1.setEnabledAt(0, habilita);
        jTabbedPane1.setEnabledAt(1, habilita);
        jTabbedPane1.setEnabledAt(2, habilita);
        jTabbedPane1.setEnabledAt(3, habilita);
        jTabbedPane1.setEnabledAt(4, habilita);
        jTabbedPane1.setEnabledAt(5, habilita);
        jrbFisica.setEnabled(habilita);
        jrbJuridico.setEnabled(habilita);
        jTableEndereco.setEnabled(habilita);

        jtfRG.setEnabled(habilita);
        jtfCpf.setEnabled(habilita);
        jtfEmail.setEnabled(habilita);
        jtfSite.setEnabled(habilita);
        jtfOrgaoRg.setEnabled(habilita);
        jtfCreditoCliente.setEnabled(habilita);

        jcbEstadoCivil.setEnabled(habilita);
        jcbSexo.setEnabled(habilita);
//        jftfDataEmissaoRg.setEnabled(habilita);
        jtfPesquisaCliente.setEnabled(habilita);

        jtfCodigo.setEnabled(habilita);
        jftfDataCadastro.setEnabled(habilita);

        jtfLimiteCredito.setEnabled(habilita);
        jcbSituacaoCliente.setEnabled(habilita);

        jftfDt_EmissaoRG.setEnabled(habilita);

        jtfSite.setEnabled(habilita);
        jtfInscricaoEstadual.setEnabled(habilita);
        jtfCNPJ.setEnabled(habilita);
        jtfInscricaoMunicipal.setEnabled(habilita);
        jtfRazaoSocial.setEnabled(habilita);
        jtfCashBack.setEnabled(habilita);
        jftfNascimento.setEnabled(habilita);
    }

    public void salvar() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if (jrbFisica.isSelected()) {           
            pf.setTipo("F");
            pf.setCliente("S");
            if (!jtfNome.getText().equals("")) {
                pf.setNome(jtfNome.getText());
            } else {
                JOptionPane.showMessageDialog(null, "O campo Nome não pode ser vazio!!!");
                jTabbedPane1.setSelectedIndex(0);
                jtfNome.requestFocus();
            }
            if (!jtfEmail.getText().equals("")) {
                pf.setEmail(jtfEmail.getText());
            } else {
                pf.setEmail("");
            }
            if (!jtfSite.getText().equals("")) {
                pf.setSite(jtfSite.getText());
            } else {
                pf.setSite("");
            }
            if (!jtfCpf.getText().equals("")) {                
                pf.setCpf(cpf);                
            } else {
                pf.setCpf("00000000000");
            }
//        pf.setId_estadocivil(1);
            if (jcbSexo.getSelectedIndex() == 0) {
                pf.setSexo("M");
            } else {
                pf.setSexo("F");
            }
            if (!jtfRG.getText().equals("")) {
                pf.setRg(jtfRG.getText());
            } else {
                pf.setRg("");
            }
            if (!jtfOrgaoRg.getText().equals("")) {
                pf.setOrgao_rg(jtfOrgaoRg.getText());
            } else {
                pf.setOrgao_rg("");
            }
           // System.out.println("Valor do combobox =" + jcbEstadoCivil.getSelectedIndex());
            switch (jcbEstadoCivil.getSelectedIndex()) {
                case 0: {
                    pf.setEstado_civil(EstadoCivil.SOLTEIRO);
                    break;
                }
                case 1: {
                    pf.setEstado_civil(EstadoCivil.CASADO);
                    break;
                }
                case 2: {
                    pf.setEstado_civil(EstadoCivil.UNIAO_ESTAVEL);
                    break;
                }
                case 3: {
                    pf.setEstado_civil(EstadoCivil.AMASIADO);
                    break;
                }
                case 4: {
                    pf.setEstado_civil(EstadoCivil.VIUVO);
                    break;
                }
                
            }
            if (jftfDt_EmissaoRG.getText() == null || jftfDt_EmissaoRG.getText().equals("")) {               
                jftfDt_EmissaoRG.setText(null);
            } else {                
                try {
                    pf.setData_emissao(sdf.parse(jftfDt_EmissaoRG.getText()));
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data Inválida!!!");
                }
            }       
            if (jftfNascimento.getText() == null || jftfNascimento.getText().equals("")) {
                jftfNascimento.setText(null);
            }else {
                try {
                    pf.setData_nascimento(sdf.parse(jftfNascimento.getText()));
                }catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data inválida!!!");
                }
            }
        } else 
            if (jrbJuridico.isSelected()) { 
               pj.setTipo("J");
               pj.setCliente("S");
               if (!jtfNome.getText().equals("")) {
                pj.setNome(jtfNome.getText());
               } else {
                   JOptionPane.showMessageDialog(null, "O campo Nome não pode ser vazio!!!");
                   jTabbedPane1.setSelectedIndex(0);
                   jtfNome.requestFocus();
               }
               if (!jtfEmail.getText().equals("")) {
                   pj.setEmail(jtfEmail.getText());
               } else {
                   pj.setEmail(null);
               }
               if (!jtfSite.getText().equals("")) {
                   pj.setSite(jtfSite.getText());
               } else {
                   pj.setSite(null);
               } 
               if (!jtfRazaoSocial.getText().equals("")){
                   pj.setRazao_social(jtfRazaoSocial.getText());               
               }
               if (jtfCNPJ.getText().equals("  .   .   /    -  ")){
                   JOptionPane.showMessageDialog(null, "O campo CNPJ não pode ser nullo ou vazio !!!");
                   jtfCNPJ.requestFocus();
                  return;
               }else{
                   cnpj = jtfCNPJ.getText();                  
                   cnpj = cnpj.replace(".", "");
                   cnpj = cnpj.replace("/", "");
                   cnpj = cnpj.replace("-", "");
                   if (ValidaCNP.isValidCNPJ(cnpj)== false){
                      JOptionPane.showMessageDialog(null, "CNPJ INVÁLIDO 1!!!");
                      jtfCNPJ.requestFocus();
                      return;
                   }
                   pj.setCnpj(cnpj);
                   System.out.println("passeia aqui tambem");
                }   
            
               if (!jtfInscricaoEstadual.getText().equals("")){
                   pj.setInscrecao_estadual(jtfInscricaoEstadual.getText());
               }else
                   pj.setInscrecao_estadual(null);
               if (!jtfInscricaoMunicipal.getText().equals("")){
                   pj.setInscrecao_municipal(jtfInscricaoMunicipal.getText());
               }else
                   pj.setInscrecao_municipal(null);
                 
        }
        //Cliente
 //         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Cliente cliente = new Cliente();
            try {
                cliente.setDataCadastro(new Date(sdf.parse(jftfDataCadastro.getText()).getTime()));
            } catch (ParseException ex) {
                System.out.println("Data inválida!!!");
            }
            //cliente
            
            String limite = jtfLimiteCredito.getText();
            limite = limite.replace(".", "");
            limite = limite.replace(",", ".");            
            cliente.setLimite(new BigDecimal(limite));
            cliente.setSituacao(jcbSituacaoCliente.getSelectedItem().toString());
            
            String credito= jtfCreditoCliente.getText();
            credito = credito.replace(".", "");
            credito = credito.replace(",", ".");
            cliente.setCredito(new BigDecimal(credito));
            
            String cashBack = jtfCashBack.getText();
            cashBack = cashBack.replace(".", "");
            cashBack = cashBack.replace(",", ".");
            cliente.setCashBack(new BigDecimal(cashBack));
            
            //Adicionando Endereço no Cliente Juridico
             List<PessoaEndereco> listaEndereco = new ArrayList<PessoaEndereco>();
            if (!jTableEndereco.getSize().equals(0)) {

                for (int i = 0; i < jTableEndereco.getRowCount(); i++) {

                    PessoaEndereco pEndereco = new PessoaEndereco();
                   
                    pEndereco.setLogradouro((String) jTableEndereco.getValueAt(i, 0));
                    pEndereco.setLogradouro(pEndereco.getLogradouro().toUpperCase());
                    pEndereco.setNumero((String) jTableEndereco.getValueAt(i, 1));
                    pEndereco.setBairro((String) jTableEndereco.getValueAt(i, 2));
                    pEndereco.setBairro(pEndereco.getBairro().toUpperCase());
                    pEndereco.setCidade((String) jTableEndereco.getValueAt(i, 3));
                    pEndereco.setCidade(pEndereco.getCidade().toUpperCase());
                    pEndereco.setUf((String) jTableEndereco.getValueAt(i, 4));
                    pEndereco.setUf(pEndereco.getUf().toUpperCase());
                    pEndereco.setCep((String) jTableEndereco.getValueAt(i, 5));

                    Boolean principal = (Boolean) (jTableEndereco.getValueAt(i, 6));
                    Boolean correspondencia = (Boolean) (jTableEndereco.getValueAt(i, 7));
                    Boolean entrega = (Boolean) (jTableEndereco.getValueAt(i, 8));
                    Boolean cobranca = (Boolean) (jTableEndereco.getValueAt(i, 9));
                    
                    if (operacao == "alterar"){
                        pEndereco.setId((Long) jTableEndereco.getValueAt(i, 10));
                        if (pEndereco.getId() == 0L)
                            pEndereco.setId(null);                       
                    }else 
                        pEndereco.setId(null);
                    
                  
                    listaEndereco.add(new PessoaEndereco(pEndereco.getId(),pEndereco.getLogradouro(), pEndereco.getNumero(), null, pEndereco.getBairro(), pEndereco.getCidade(),
                            pEndereco.getCep(), pEndereco.getUf(), entrega, cobranca, principal, correspondencia));
                }
                
                
            } else {
                listaEndereco = null;
            }
            //Adicionando Contato no Cliente Juridico
             List<PessoaContato> listaContato = new ArrayList<PessoaContato>();
             
            if (!jTableContato.getSize().equals(0)) {
                for (int i = 0; i < jTableContato.getRowCount(); i++) {                    
                    PessoaContato pContato = new PessoaContato();
                    pContato.setDescricao((String) jTableContato.getValueAt(i, 0));
                    pContato.setDescricao(pContato.getDescricao().toUpperCase());
                    pContato.setDdd((String) jTableContato.getValueAt(i, 1));
                    pContato.setNumero((String) jTableContato.getValueAt(i, 2));
                    if (operacao == "alterar"){
                        pContato.setId((Long) jTableContato.getValueAt(i, 3));
                        if (pContato.getId() == 0L)
                            pContato.setId(null);                       
                    }else
                        pContato.setId(null);
                   
                    listaContato.add(new PessoaContato(pContato.getId(), pContato.getDescricao(), pContato.getDdd(), pContato.getNumero()));
                }
                
            } else {
                listaContato = null;
            }
        
              
        //   ClienteDAO daoCli = new ClienteDAO();
        
            if (jrbFisica.isSelected()){//  
                try{
                    pf.setListaEndereco(listaEndereco);
                    pf.setListaContato(listaContato);                
                    if (operacao == "alterar"){ 
                        cliente.setId(idCliente);
                        cliente.setPessoa(pf);                    
                        daoCliente.alterarPessoaFisica(pf, cliente);
                    }else
                        if (operacao == "salvar"){                       
                           cliente.setPessoa(pf);                       
                           pf.setCli(cliente);
                           daoCliente.salvarPessoaFisica(pf);
                          
                        }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Cancela este Cadastro e Faça de Novo. Error:"+e.getMessage());
                }
            }else
                if (jrbJuridico.isSelected()){  
                    try{
                       pj.setListaEndereco(listaEndereco);
                       pj.setListaContato(listaContato);                
                       if (operacao == "alterar"){ 
                          cliente.setId(idCliente);
                          cliente.setPessoa(pj);                    
                          daoCliente.alterarPessoaJuridica(pj, cliente);
                       }else
                           if (operacao == "salvar"){                       
                               cliente.setPessoa(pj);                       
                               pj.setCli(cliente);
                               daoCliente.salvarPessoaJuridica(pj);
                               
                            }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Cancela este Cadastro e Faça de Novo. Error:"+e.getMessage());
                    }
                }
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso !!!");
        
            
        jtfPesquisaCliente.setText("");
        jbtCancelarActionPerformed(null);
    }

    private void carregaTablePessoaFisica() {

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {

    },
    new String [] {
        "CÓDIGO.", "NOME", "CPF", "RG"
    }
) {
    Class[] types = new Class [] {
        java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
    };
    boolean[] canEdit = new boolean [] {
        false, false, false, false
    };

    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
});
        
        
        
        
        
        
      //  String[] tableColumsName = {"CÓDIGO", "NOME", "CPF", "RG"};
     //   DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
       // amodel.setColumnIdentifiers(tableColumsName);
        // amodel..setPreferredWidth(95);
        //Definindo Largura da Coluna da Tabela de Pesquisa.
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);

        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        ClienteDAO daoCli = new ClienteDAO();

        listaClienteFisico = null;

        listaClienteFisico = daoCli.getClienteFisico();
        for (PessoaFisica cli : listaClienteFisico) {

            amodel.addRow(new Object[]{cli.getId(), cli.getNome(), cli.getCpf(), cli.getRg()});

        }
    }
    private void carregaTablePessoaJuridica() {

        
 //   jTable1.setModel(new javax.swing.table.DefaultTableModel(
 //   new Object [][] {

 //   },
 //   new String [] {
 //       "CÓDIGO", "NOME FANTASIA", "CNPJ", "RAZÃO SOCIAL"
 //   }
//) {
 //   Class[] types = new Class [] {
 //       java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
 //   };
 //   boolean[] canEdit = new boolean [] {
 //       false, false, false, false
  //  };

  //  public Class getColumnClass(int columnIndex) {
   //     return types [columnIndex];
  //  }

  //  public boolean isCellEditable(int rowIndex, int columnIndex) {
  //      return canEdit [columnIndex];
  //  }
//});        

  DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
  amodel.setNumRows(0);

String[] tableColumsName = {"CÓDIGO", "NOME FANTASIA", "CNPJ", "RAZÃO SOCIAL"};
      
        amodel.setColumnIdentifiers(tableColumsName);
        // amodel..setPreferredWidth(95);
        //Definindo Largura da Coluna da Tabela de Pesquisa.
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);

     
        
        
     //   DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        
        ClienteDAO daoCli = new ClienteDAO();

        listaClienteJuridico = null;

        listaClienteJuridico = daoCli.getClienteJuridica();
        for (PessoaJuridica cli : listaClienteJuridico) {

            amodel.addRow(new Object[]{cli.getId(), cli.getNome(),cli.getCnpj(), cli.getRazao_social()});

        }
    }

    
    
    
    public void limpar() {
        jtfCodigo.setText("");
        jtfNome.setText("");
        jftfDataCadastro.setText("");
        //      jcbTipoCliente.setSelectedIndex(-1);
        jtfEmail.setText("");
        jtfSite.setText("");
        jtfCpf.setText("");
        //  jtfPesquisaCliente.setText("");
        jtfRG.setText("");
        jtfCpf.setText("");
        jtfOrgaoRg.setText("");
        jftfDt_EmissaoRG.setText("");
//        jftfDataEmissaoRg.setText("");
        jcbEstadoCivil.setSelectedIndex(0);
        jcbSexo.setSelectedIndex(0);
        jtfLimiteCredito.setText("");
        jtfInscricaoEstadual.setText("");
        jtfInscricaoMunicipal.setText("");
        jtfRazaoSocial.setText("");
        jtfCreditoCliente.setText("");
        jtfCashBack.setText("");  
        jftfNascimento.setText("");
    }

    public JTextField DefinirTiposCaracteresETamanho(int tamanho, String caracteres) {
        try {
            //defino a variável que vai guardar a quantidade de caracteres
            String quantidade = "";

		//defino um método de repetição para repetir o numero de
            //vezes  do tamanho
            for (int i = 0; i < tamanho; i++) {
                // defino asterisco para aceitar qualquer coisa e crio a máscara
                quantidade = quantidade + "*";
            }
		//  **********...   de acordo com o tamanho informado
            // defino que a mascara possui essa
            //quantidade de elementos que foi informado em tamanho e
            // foi colocada com * dentro de quantidade
            javax.swing.text.MaskFormatter nome = new javax.swing.text.MaskFormatter(quantidade);

		//defino que o parâmetro caracter recebido pelo
            //método contém os caracteres válidos 
            nome.setValidCharacters(caracteres);

            //retorno a mascara que foi criada  
            return new javax.swing.JFormattedTextField(nome);
        }// fim do try
        catch (Exception e) {
            //mensagem se acontecer erro
            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
            //retorno um campo de texto comum  
            return new JTextField();
        }//fim do catch
    }
    //Não estou usando
    public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
            excecao.printStackTrace();
        } 
        return F_Mascara;
    }
     private void carregaTablePessoa() {

   

        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        //List<PessoaFisica> pf = new List<PessoaFisica>() {};
        //PessoaJuridica pj = new PessoaJuridica();
        
        daoCliente = new ClienteDAO();
        listaClienteFisico = daoCliente.getClienteFisico();
        listaClienteJuridico = daoCliente.getClienteJuridica();
        listaCliente = daoCliente.listaCliente();//daoCli.getClienteFisico();
        for (Pessoa p : listaCliente) {
            System.out.println("pessoa :"+p.getNome());
                    
            if (p.getTipo().equals("F")){
               for (PessoaFisica pf : listaClienteFisico){
                   if (Objects.equals(p.getId(), pf.getId())){    
                       System.out.println("Carregar Cliente: "+pf.getId()+" - "+pf.getNome());
                       
                      amodel.addRow(new Object[]{pf.getId(), pf.getNome(), pf.getCpf(), pf.getRg()});
                      break;
                   }
               }               
            }else
                if (p.getTipo().equals("J")){
                    for (PessoaJuridica pj : listaClienteJuridico){
                        if (Objects.equals(p.getId(), pj.getId())){
                            amodel.addRow(new Object[]{pj.getId(), pj.getNome(), pj.getCnpj(), pj.getInscrecao_estadual()}); 
                            break;
                        }
                            
                    }
                   
                }

            

        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JLabel cpfLabel1;
    private javax.swing.JLabel cpfLabel2;
    private javax.swing.JLabel cpfLabel3;
    private javax.swing.JLabel cpfLabel4;
    private javax.swing.JLabel cpfLabel5;
    private javax.swing.JLabel cpfLabel6;
    private javax.swing.JLabel cpfLabel7;
    private javax.swing.JLabel cpfLabel8;
    private javax.swing.JLabel cpfLabel9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelPessoaJuridica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable jTableContato;
    public static javax.swing.JTable jTableEndereco;
    private javax.swing.JButton jbtAdicionaContato;
    private javax.swing.JButton jbtAdicionarEndereco;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtExcluirEndereco;
    private javax.swing.JButton jbtNovo;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JComboBox jcbEstadoCivil;
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JComboBox jcbSituacaoCliente;
    private javax.swing.JFormattedTextField jftfDataCadastro;
    private javax.swing.JFormattedTextField jftfDt_EmissaoRG;
    private javax.swing.JFormattedTextField jftfNascimento;
    private javax.swing.JPanel jpanelPessoaFisi;
    private javax.swing.JPanel jpanelPessoaFisica;
    public static javax.swing.JRadioButton jrbFisica;
    public static javax.swing.JRadioButton jrbJuridico;
    private javax.swing.JTextField jtfCNPJ;
    private javax.swing.JTextField jtfCashBack;
    public static javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCpf;
    private javax.swing.JTextField jtfCreditoCliente;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfInscricaoEstadual;
    private javax.swing.JTextField jtfInscricaoMunicipal;
    private javax.swing.JTextField jtfLimiteCredito;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfOrgaoRg;
    public static javax.swing.JTextField jtfPesquisaCliente;
    private javax.swing.JTextField jtfRG;
    private javax.swing.JTextField jtfRazaoSocial;
    private javax.swing.JTextField jtfSite;
    private javax.swing.JLabel orgaoRgLabel;
    private javax.swing.JLabel orgaoRgLabel1;
    private javax.swing.JLabel rgLabel;
    private converter.RowSorterToStringConverter rowSorterToStringConverter1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
