/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuView;

import cadastroView.BancoView;
import cadastroView.CategoriaPagamentoView;
import cadastroView.CategoriaView;
import cadastroView.CepView;
import cadastroView.ClienteView;
import cadastroView.ColaboradorView;
import cadastroView.ComplementosView;
import cadastroView.EmpresaView;
import cadastroView.FornecedorView;

import cadastroView.MarcaProdutoView;
import cadastroView.NivelAcessoView;
import cadastroView.ObservacoesPedidoView;
import cadastroView.ProdutoView;
import cadastroView.TipoPagamentoView;
import cadastroView.UnidadeView;
import conexao.JPAUtil;
import dao.EmpresaDAO;
import dao.NivelAcessoDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import graficosView.venda.GraficoVendaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Empresa;
import model.Pessoa;

import movimentoView.BancoMovimentoView;
import movimentoView.CaixaView;

import movimentoView.CompraCabView;
import movimentoView.HistoricoCaixaView;
import movimentoView.OrcamentoCabView;
import movimentoView.PagamentoCabView;
import movimentoView.PedidoConfView;
import movimentoView.PedidoCreditoDiferencaView;
import movimentoView.PedidoPesquisaDeliveryView;
import movimentoView.PedidoRecebeCrediarioView;
import movimentoView.PedidoRecebeFiadoView;
import movimentoView.PedidoTrocaDevolucaoView;
import movimentoView.PedidoTrocaPresenteView;
import movimentoView.PedidoView;



import movimentoView.PedidoView1;
import movimentoView.RecebimentoCrediarioView;
import relatoriosView.compra.CompraPorPeriodoDeEmissaoView;
import relatoriosView.etiquetas.EtiquetasProdutoView;
import relatoriosView.ImprimeRelatorio;
import relatoriosView.contasapagar.PagamentoPorPeriodoDeVencimentoAPagar;
import relatoriosView.RelatorioProdutoView;
import relatoriosView.VendaPorClienteView;
import relatoriosView.movimentoConta.SaldoContasView;
import relatoriosView.venda.RelatorioVendaView;
import relatoriosView.venda.categoria.RelVendaPorCategoriaProdView;
import relatoriosView.venda.itens.RelVendaPorItenView;
import relatoriosView.venda.resumo.ResumoVendaView;

/**
 *
 * @author daniel
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public static String nomeUsuario;
    public static String idColaborador;
    public static Pessoa colaborador;
    public static String localizacao;
    //PessoaDAO pessoaDao = new PessoaDAO();
    OrcamentoCabView orcamentoView = null;
    public static ProdutoView produtoView = null;
    PedidoCreditoDiferencaView pedidoCreditoDiferencaView;
    ResumoVendaView resumoVendaView = null;
    public static PedidoTrocaPresenteView pedidoTrocaPresenteView = null;
    PedidoTrocaDevolucaoView pedidoTrocaDevView;
    NivelAcessoView nivelAcesso = null;
    ClienteView cliView = null;
    NivelAcessoDAO daoNivelAcesso = null;
    GraficoVendaView graficoVendaView = null;
    public static RelVendaPorCategoriaProdView relVendCat = null;
    public Menu() {

        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        Empresa emp = new Empresa();
        EmpresaDAO empDao = new EmpresaDAO();
        daoNivelAcesso = new NivelAcessoDAO();
        emp = empDao.getEmpresa();        
        
        setTitle("Sistema de Gestão Empresarial - "+emp.getNomeFantasia()+" - Versão 1.0");
        jmenuComplemento.setVisible(false);
        jmenuObservacao.setVisible(false);
        jmenuTipoPag.setVisible(false);
        
        localizacao = (emp.getLogradouro()+" "+emp.getNumero()+" "+emp.getBairro()+" "+emp.getCidade()
                +" "+emp.getEstado());
        
        
        //Desabilitar troca de mercadoria pelo codigo da venda.
        jmenuTrocaDevolucao.setVisible(false);
        jmenuCreditoDiferencaCliente.setVisible(false);
        
        
        
     //   System.out.println("Localizacao ="+localizacao);
    //    System.out.println("Colaborador ="+colaborador.getNome());
//        // um JDesktopPane dentro de um JScrollPane
//        JScrollPane scrollPane = null;
//scrollPane.getViewport().add(desktopPane);
//// no JFrame usar o BorderLayout
//getContentPane().setLayout(new BorderLayout());
//        Component barraFerramentas = null;
//// algo no topo do JFrame (se precisar), geralmente uma barra de ferramentas
////getContentPane().add(barraFerramentas, BorderLayout.NORTH);
//// aqui o conteudo central que é justamente o JScrollPane
//getContentPane().add(scrollPane, BorderLayout.CENTER);
//        Component painelBottom = null;
//// aqui alguma coisa que vai no rodapé do seu JFrame (geralmente uma barra de status)
//getContentPane().add(painelBottom, BorderLayout.SOUTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jbtCaixa = new javax.swing.JButton();
        jbtProdutos = new javax.swing.JButton();
        jbtClientes = new javax.swing.JButton();
        jbtPedido = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jbHistoricoCaixa = new javax.swing.JButton();
        jbDelivery = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jbtClientes1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlUsuario = new javax.swing.JLabel();
        jlData = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        carregadorDesktop1 = new util.CarregadorDesktop();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmenuEmpresa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmenuCliente = new javax.swing.JMenuItem();
        jmenuFornecedor = new javax.swing.JMenuItem();
        jmenuColaborador = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jmenuProduto = new javax.swing.JMenuItem();
        jmenuCategoria = new javax.swing.JMenuItem();
        jmenuMarca = new javax.swing.JMenuItem();
        jmenuUnidade = new javax.swing.JMenuItem();
        jmenuComplemento = new javax.swing.JMenuItem();
        jmenuObservacao = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmenuCategoriaConta = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmenuTipoPag = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmenuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jmenuOrcamento = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jmenuVenda = new javax.swing.JMenuItem();
        jmenuTrocaDevolucao = new javax.swing.JMenuItem();
        jmenuPedidoTrocaPresente = new javax.swing.JMenuItem();
        jmenuCreditoDiferencaCliente = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jmenuHistVenda = new javax.swing.JMenuItem();
        jmenuCaixa = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jmenuFinancContasPagar = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jmenuContasReceber = new javax.swing.JMenu();
        jmenuContaReceberFiado = new javax.swing.JMenuItem();
        jmenuContaReceberCrediario = new javax.swing.JMenuItem();
        jmenuMovimentacaoConta = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmenuRelProdutos = new javax.swing.JMenu();
        jmenuTodosProduto = new javax.swing.JMenuItem();
        jmenuEtiquetasProduto = new javax.swing.JMenuItem();
        jmenuFiltroPesquisa = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmenuRelCompraPorPeriodo = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jmenuRelCompraPerCompra = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jmenuRelContasaPagarPerVenc = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jmenuSaldoContas = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jmenuGraficoFaturamento = new javax.swing.JMenu();
        jmenuGraficoFatMes = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setBackground(java.awt.Color.darkGray);

        jPanel2.setBackground(java.awt.Color.gray);

        jbtCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Dollar.png"))); // NOI18N
        jbtCaixa.setMnemonic('c');
        jbtCaixa.setToolTipText("Caixa ");
        jbtCaixa.setContentAreaFilled(false);
        jbtCaixa.setName("jbtCaixa"); // NOI18N
        jbtCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCaixaActionPerformed(evt);
            }
        });

        jbtProdutos.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jbtProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/products-32.png"))); // NOI18N
        jbtProdutos.setMnemonic('p');
        jbtProdutos.setToolTipText("Produtos");
        jbtProdutos.setContentAreaFilled(false);
        jbtProdutos.setFocusCycleRoot(true);
        jbtProdutos.setFocusable(false);
        jbtProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProdutosActionPerformed(evt);
            }
        });

        jbtClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clients-32.png"))); // NOI18N
        jbtClientes.setMnemonic('a');
        jbtClientes.setToolTipText("Clientes");
        jbtClientes.setContentAreaFilled(false);
        jbtClientes.setFocusCycleRoot(true);
        jbtClientes.setFocusable(false);
        jbtClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClientesActionPerformed(evt);
            }
        });

        jbtPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho.png"))); // NOI18N
        jbtPedido.setMnemonic('v');
        jbtPedido.setToolTipText(" Venda Balcão");
        jbtPedido.setContentAreaFilled(false);
        jbtPedido.setFocusCycleRoot(true);
        jbtPedido.setFocusable(false);
        jbtPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPedidoActionPerformed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Log-Out-icon (Custom).png"))); // NOI18N
        jbtSair.setToolTipText("Sair");
        jbtSair.setBorderPainted(false);
        jbtSair.setContentAreaFilled(false);
        jbtSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtSair.setFocusCycleRoot(true);
        jbtSair.setFocusable(false);
        jbtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSair.setName(""); // NOI18N
        jbtSair.setRolloverEnabled(false);
        jbtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbHistoricoCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Relogio.png"))); // NOI18N
        jbHistoricoCaixa.setMnemonic('h');
        jbHistoricoCaixa.setToolTipText("Histórico do Caixa");
        jbHistoricoCaixa.setContentAreaFilled(false);
        jbHistoricoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHistoricoCaixaActionPerformed(evt);
            }
        });

        jbDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telaCaminhao04.png"))); // NOI18N
        jbDelivery.setToolTipText("Pedido Delivery");
        jbDelivery.setContentAreaFilled(false);
        jbDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeliveryActionPerformed(evt);
            }
        });

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbtClientes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoGaveta.png"))); // NOI18N
        jbtClientes1.setMnemonic('a');
        jbtClientes1.setToolTipText("Recebimento Crediário");
        jbtClientes1.setContentAreaFilled(false);
        jbtClientes1.setFocusCycleRoot(true);
        jbtClientes1.setFocusable(false);
        jbtClientes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtClientes1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtClientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClientes1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jbtCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbHistoricoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDelivery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 629, Short.MAX_VALUE)
                .addComponent(jbtSair)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10)
                    .addComponent(jSeparator11)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtProdutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtCaixa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbHistoricoCaixa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtClientes1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbDelivery, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator9)
        );

        jTabbedPane1.addTab("VENDAS", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlUsuario.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jlUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlUsuario.setText("Usuario");
        jlUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jlData.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jlData.setForeground(new java.awt.Color(10, 3, 3));
        jlData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlData.setText("Data");
        jlData.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jlHora.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jlHora.setForeground(new java.awt.Color(10, 3, 3));
        jlHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlHora.setText("Hora");
        jlHora.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlData, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUsuario)
                    .addComponent(jlData)
                    .addComponent(jlHora)))
        );

        jMenu1.setText("Cadastros");

        jmenuEmpresa.setText("Empresa");
        jmenuEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuEmpresaActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuEmpresa);
        jMenu1.add(jSeparator1);

        jmenuCliente.setText("Cliente");
        jmenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuCliente);

        jmenuFornecedor.setText("Fornecedor");
        jmenuFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuFornecedorActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuFornecedor);

        jmenuColaborador.setText("Colaborador");
        jmenuColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuColaboradorActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuColaborador);
        jMenu1.add(jSeparator5);

        jmenuProduto.setText("Produto");
        jmenuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuProduto);

        jmenuCategoria.setText("Categoria Produto");
        jmenuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuCategoria);

        jmenuMarca.setText("Marca");
        jmenuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuMarcaActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuMarca);

        jmenuUnidade.setText("Unidade");
        jmenuUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuUnidadeActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuUnidade);

        jmenuComplemento.setText("Complementos");
        jmenuComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuComplementoActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuComplemento);

        jmenuObservacao.setText("Observações");
        jmenuObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuObservacaoActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuObservacao);
        jMenu1.add(jSeparator2);

        jmenuCategoriaConta.setText("Categoria Conta");
        jmenuCategoriaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCategoriaContaActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuCategoriaConta);

        jMenuItem1.setText("Conta / Banco");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmenuTipoPag.setText("Tipo Pagamento");
        jmenuTipoPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuTipoPagActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuTipoPag);
        jMenu1.add(jSeparator3);

        jMenuItem2.setText("Cep");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator4);

        jmenuSair.setText("Sair");
        jmenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimento");

        jMenu3.setText("Controle de Estoque");

        jMenuItem7.setText("Entrada Mercadoria");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem5.setText("Reajuste de Estoque");
        jMenu3.add(jMenuItem5);

        jMenu2.add(jMenu3);
        jMenu2.add(jSeparator7);

        jmenuOrcamento.setText("Condicional");
        jmenuOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuOrcamentoActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuOrcamento);
        jMenu2.add(jSeparator8);

        jmenuVenda.setText("Venda");
        jmenuVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuVendaActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuVenda);

        jmenuTrocaDevolucao.setText("Troca/Devolução de Mercadoria");
        jmenuTrocaDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuTrocaDevolucaoActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuTrocaDevolucao);

        jmenuPedidoTrocaPresente.setText("Troca/Devolucao de Mercadoria");
        jmenuPedidoTrocaPresente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuPedidoTrocaPresenteActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuPedidoTrocaPresente);

        jmenuCreditoDiferencaCliente.setText("Crédito e Diferenças de Cliente");
        jmenuCreditoDiferencaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCreditoDiferencaClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuCreditoDiferencaCliente);
        jMenu2.add(jSeparator12);

        jmenuHistVenda.setText("Historico Venda");
        jmenuHistVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuHistVendaActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuHistVenda);

        jmenuCaixa.setText("Caixa");
        jmenuCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCaixaActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuCaixa);

        jMenuBar1.add(jMenu2);

        jMenu11.setText("Financeiro");

        jMenu4.setText("Contas");

        jmenuFinancContasPagar.setText("Pagar");
        jmenuFinancContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuFinancContasPagarActionPerformed(evt);
            }
        });
        jMenu4.add(jmenuFinancContasPagar);
        jMenu4.add(jSeparator6);

        jmenuContasReceber.setText("Receber");

        jmenuContaReceberFiado.setText("Fiado");
        jmenuContaReceberFiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuContaReceberFiadoActionPerformed(evt);
            }
        });
        jmenuContasReceber.add(jmenuContaReceberFiado);

        jmenuContaReceberCrediario.setText("Crediário");
        jmenuContaReceberCrediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuContaReceberCrediarioActionPerformed(evt);
            }
        });
        jmenuContasReceber.add(jmenuContaReceberCrediario);

        jMenu4.add(jmenuContasReceber);

        jMenu11.add(jMenu4);

        jmenuMovimentacaoConta.setText("Movimentação de Conta");
        jmenuMovimentacaoConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuMovimentacaoContaActionPerformed(evt);
            }
        });
        jMenu11.add(jmenuMovimentacaoConta);

        jMenuBar1.add(jMenu11);

        jMenu5.setText("Relatórios");

        jmenuRelProdutos.setText("Produtos");

        jmenuTodosProduto.setText("Todos Produto Ordem Alfabética");
        jmenuTodosProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuTodosProdutoActionPerformed(evt);
            }
        });
        jmenuRelProdutos.add(jmenuTodosProduto);

        jmenuEtiquetasProduto.setText("Etiqueta de Produto");
        jmenuEtiquetasProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuEtiquetasProdutoActionPerformed(evt);
            }
        });
        jmenuRelProdutos.add(jmenuEtiquetasProduto);

        jmenuFiltroPesquisa.setText("Filtro de Pesquisa");
        jmenuFiltroPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuFiltroPesquisaActionPerformed(evt);
            }
        });
        jmenuRelProdutos.add(jmenuFiltroPesquisa);

        jMenuItem9.setText("Controde de Estoque");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jmenuRelProdutos.add(jMenuItem9);

        jMenu5.add(jmenuRelProdutos);

        jMenu8.setText("Venda");

        jMenuItem3.setText("Por Cliente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jmenuRelCompraPorPeriodo.setText("Por Período");
        jmenuRelCompraPorPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuRelCompraPorPeriodoActionPerformed(evt);
            }
        });
        jMenu8.add(jmenuRelCompraPorPeriodo);

        jMenuItem4.setText("Resumo de Venda do Dia");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenuItem6.setText("Por Categoria de Produto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem6);

        jMenuItem8.setText("Por Itens");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem8);

        jMenu5.add(jMenu8);

        jMenu9.setText("Compra");

        jmenuRelCompraPerCompra.setText("Por Período de Emissão da Compra");
        jmenuRelCompraPerCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuRelCompraPerCompraActionPerformed(evt);
            }
        });
        jMenu9.add(jmenuRelCompraPerCompra);

        jMenu5.add(jMenu9);

        jMenu10.setText("Contas à Pagar");

        jmenuRelContasaPagarPerVenc.setText("Por Período de Vencimento");
        jmenuRelContasaPagarPerVenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuRelContasaPagarPerVencActionPerformed(evt);
            }
        });
        jMenu10.add(jmenuRelContasaPagarPerVenc);

        jMenu5.add(jMenu10);

        jMenu12.setText("Contas");

        jmenuSaldoContas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmenuSaldoContas.setText("Saldo de Contas Selecionadas");
        jmenuSaldoContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuSaldoContasActionPerformed(evt);
            }
        });
        jMenu12.add(jmenuSaldoContas);

        jMenu5.add(jMenu12);

        jMenuBar1.add(jMenu5);

        jMenu14.setText("Gráficos");

        jmenuGraficoFaturamento.setText("Faturamento");

        jmenuGraficoFatMes.setText("Por Mês");
        jmenuGraficoFatMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuGraficoFatMesActionPerformed(evt);
            }
        });
        jmenuGraficoFaturamento.add(jmenuGraficoFatMes);

        jMenu14.add(jmenuGraficoFaturamento);

        jMenuBar1.add(jMenu14);

        jMenu6.setText("Utilitários");

        jMenu13.setText("Configurações");

        jMenuItem14.setText("Nível de Acesso do Usuário");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem14);

        jMenu6.add(jMenu13);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Sobre");
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addComponent(carregadorDesktop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carregadorDesktop1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        BancoView bancoView;
        bancoView = new BancoView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
          carregadorDesktop1.add(bancoView);
           bancoView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
             carregadorDesktop1.add(bancoView);
             bancoView.setVisible(true);   
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");              
    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CepView cepView = new CepView();               
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(cepView);
           cepView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
             carregadorDesktop1.add(cepView);
             cepView.setVisible(true);   
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");      
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmenuTipoPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuTipoPagActionPerformed
        TipoPagamentoView tipoPagView;
        tipoPagView = new TipoPagamentoView();        
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(tipoPagView);
           tipoPagView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
             carregadorDesktop1.add(tipoPagView);
             tipoPagView.setVisible(true);   
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");           
        
    }//GEN-LAST:event_jmenuTipoPagActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        CompraCabView compraView;
        compraView = new CompraCabView();
        
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(compraView);
           compraView.setVisible(true);
           compraView.setResizable(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
             carregadorDesktop1.add(compraView);
             compraView.setVisible(true);   
             compraView.setResizable(true);
            }else
             JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
                    
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jmenuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCategoriaActionPerformed
        CategoriaView categoriaView;
        categoriaView = new CategoriaView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            
            int larg = this.getWidth();
            System.out.println("lagru = "+larg);
            int soma = 0;
            
            soma = (larg/2);
            System.out.println("soma ="+soma);
            
           carregadorDesktop1.add(categoriaView).setLocation(200, 50);
           //categoriaView.show();
           categoriaView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
             carregadorDesktop1.add(categoriaView);
             categoriaView.setVisible(true);   
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
          
    }//GEN-LAST:event_jmenuCategoriaActionPerformed

    private void jmenuUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuUnidadeActionPerformed
        UnidadeView unidadeView;
        unidadeView = new UnidadeView();
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
        carregadorDesktop1.add(unidadeView);
           unidadeView.setVisible(true);
           unidadeView.setTitle("Cadastro de Unidade");
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
          carregadorDesktop1.add(unidadeView);
              unidadeView.setVisible(true);
              unidadeView.setTitle("Cadastro de Unidade"); 
           }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
                
        
    }//GEN-LAST:event_jmenuUnidadeActionPerformed

    private void jmenuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuMarcaActionPerformed
        MarcaProdutoView marcaView;       
        marcaView = new MarcaProdutoView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
         carregadorDesktop1.add(marcaView);
           marcaView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
         carregadorDesktop1.add(marcaView);
             marcaView.setVisible(true);   
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                       
    }//GEN-LAST:event_jmenuMarcaActionPerformed

    private void jmenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuClienteActionPerformed
        jbtClientesActionPerformed(evt);
        
        
        
    }//GEN-LAST:event_jmenuClienteActionPerformed

    private void jmenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmenuSairActionPerformed

    private void jmenuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuFornecedorActionPerformed
        FornecedorView fornecedor = new FornecedorView();
              
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
      carregadorDesktop1.add(fornecedor);
           fornecedor.setVisible(true);
           jmenuFornecedor.setEnabled(false);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
      carregadorDesktop1.add(fornecedor);
             fornecedor.setVisible(true);
             jmenuFornecedor.setEnabled(false);    
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
               
    }//GEN-LAST:event_jmenuFornecedorActionPerformed

    private void jmenuColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuColaboradorActionPerformed
        ColaboradorView colaboradorView = new ColaboradorView();        
         if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
             carregadorDesktop1.add(colaboradorView);
             colaboradorView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), this.colaborador.getColaborad())){
              carregadorDesktop1.add(colaboradorView);
             colaboradorView.setVisible(true);              
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
         
    }//GEN-LAST:event_jmenuColaboradorActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // jlData.setText(new Date());  
        Date dataAtual = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
        String dataExtenso = formatador.format(dataAtual);
        jlData.setText(dataExtenso);

        Timer timer = new Timer(1000, new hora());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void jmenuOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuOrcamentoActionPerformed
                
        if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           if (orcamentoView == null)
              this.orcamentoView = new OrcamentoCabView();
             // carregadorDesktop1.add(orcamento);
           orcamentoView.setVisible(true); 
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuOrcamento.getText(), this.colaborador.getColaborad())){
              if (orcamentoView == null)
                 this.orcamentoView = new OrcamentoCabView();
               //  carregadorDesktop1.add(orcamento);
                 orcamentoView.setVisible(true);            
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");          
    }//GEN-LAST:event_jmenuOrcamentoActionPerformed

    private void jmenuTodosProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuTodosProdutoActionPerformed
        try {
            ImprimeRelatorio imprimeRel = new relatoriosView.ImprimeRelatorio();
            if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
                
                imprimeRel.relatorioProdutoJPA();
            }else       
                if (daoNivelAcesso.verificaAcesso("Relatório Produtos "+jmenuTodosProduto.getText(), this.colaborador.getColaborad())){
                   imprimeRel.relatorioProdutoJPA();                
                }else
                   JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");          
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuTodosProdutoActionPerformed

    private void jmenuEtiquetasProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuEtiquetasProdutoActionPerformed
        EtiquetasProdutoView etiqueta = new EtiquetasProdutoView();
       
        if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(etiqueta);
           etiqueta.setVisible(true);                    
            }else       
                if (daoNivelAcesso.verificaAcesso("Relatório Produtos "+jmenuEtiquetasProduto.getText(), this.colaborador.getColaborad())){
                   carregadorDesktop1.add(etiqueta);
                   etiqueta.setVisible(true);
                }else
                   JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");         
        
    }//GEN-LAST:event_jmenuEtiquetasProdutoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VendaPorClienteView vpCliente;
        vpCliente = new VendaPorClienteView(new java.awt.Frame(), true);
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           vpCliente.setTitle("Relatório de Todas as Venda para um Cliente.");
           vpCliente.setLocationRelativeTo(null); // centraliza a tela        
           vpCliente.setVisible(true); 
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuFinancContasPagar.getText(), colaborador.getColaborad())){
              vpCliente.setTitle("Relatório de Todas as Venda para um Cliente.");
              vpCliente.setLocationRelativeTo(null); // centraliza a tela        
              vpCliente.setVisible(true);           
           }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                           
                
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jmenuFinancContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuFinancContasPagarActionPerformed
        PagamentoCabView pagamentoView = new PagamentoCabView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(pagamentoView);
            
            pagamentoView.setVisible(true);            
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuFinancContasPagar.getText(), colaborador.getColaborad())){
               carregadorDesktop1.add(pagamentoView);
               pagamentoView.setVisible(true);
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                           
           
        
    }//GEN-LAST:event_jmenuFinancContasPagarActionPerformed

    private void jmenuFiltroPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuFiltroPesquisaActionPerformed
        RelatorioProdutoView rlprodutoview;
        rlprodutoview = new RelatorioProdutoView();
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(rlprodutoview);
           rlprodutoview.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso("Relatório Produtos "+jmenuRelProdutos.getText(), colaborador.getColaborad())){               
              carregadorDesktop1.add(rlprodutoview);
              rlprodutoview.setVisible(true);
         }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                                        
 
        
        
        
    }//GEN-LAST:event_jmenuFiltroPesquisaActionPerformed

    private void jmenuRelCompraPerCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuRelCompraPerCompraActionPerformed
        CompraPorPeriodoDeEmissaoView periodoView;
        periodoView = new CompraPorPeriodoDeEmissaoView();        
        //System.out.println("Rel compra menu ="+jmenuRelCompraPerCompra.getText());
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
             carregadorDesktop1.add(periodoView);
             periodoView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso("Compra "+jmenuRelCompraPerCompra.getText(), colaborador.getColaborad())){               
              carregadorDesktop1.add(periodoView);
              periodoView.setVisible(true);        
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                                        
    }//GEN-LAST:event_jmenuRelCompraPerCompraActionPerformed

    private void jmenuRelContasaPagarPerVencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuRelContasaPagarPerVencActionPerformed

        PagamentoPorPeriodoDeVencimentoAPagar pagtoVencimento = new PagamentoPorPeriodoDeVencimentoAPagar();
               
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(pagtoVencimento);
            pagtoVencimento.setVisible(true);
            
        }else       
           if (daoNivelAcesso.verificaAcesso("Contas à Pagar "+jmenuRelContasaPagarPerVenc.getText(), colaborador.getColaborad())){
               carregadorDesktop1.add(pagtoVencimento);
               pagtoVencimento.setVisible(true);
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                           
   
        
    }//GEN-LAST:event_jmenuRelContasaPagarPerVencActionPerformed

    private void jmenuRelCompraPorPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuRelCompraPorPeriodoActionPerformed
        RelatorioVendaView relVenda = new RelatorioVendaView();   
                        
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
      //      desktopPane.add(relVenda);
            carregadorDesktop1.add(relVenda);
            relVenda.setVisible(true);
                         
        }else       
           if (daoNivelAcesso.verificaAcesso("Relatórios Compra "+jmenuRelCompraPorPeriodo.getText(), colaborador.getColaborad())){
      //         desktopPane.add(relVenda);
               carregadorDesktop1.add(relVenda);
               relVenda.setVisible(true);
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                                     
    }//GEN-LAST:event_jmenuRelCompraPorPeriodoActionPerformed

    private void jmenuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuProdutoActionPerformed
        jbtProdutosActionPerformed(evt);
    }//GEN-LAST:event_jmenuProdutoActionPerformed

    private void jmenuVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuVendaActionPerformed

        
          PedidoView pedidoView = new PedidoView(new java.awt.Frame(), true, null,null);
       //   desktopPane.add(pedidoView);
         
          
            if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
               pedidoView.setLocationRelativeTo(null); // centraliza a tela   
               pedidoView.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuVenda.getText(), this.colaborador.getColaborad())){
             pedidoView.setLocationRelativeTo(null); // centraliza a tela   
             pedidoView.setVisible(true);        
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
         
          
          
    }//GEN-LAST:event_jmenuVendaActionPerformed

    private void jmenuCategoriaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCategoriaContaActionPerformed
        CategoriaPagamentoView categoria;
        categoria = new CategoriaPagamentoView();
        carregadorDesktop1.add(categoria);
        categoria.setVisible(true);
    }//GEN-LAST:event_jmenuCategoriaContaActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente encerrar o Sistema?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
            // JPAUtil.getEntityManager().close();

            JPAUtil.close();
            System.exit(0);
            //  conex.desconectar();
        }
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPedidoActionPerformed
       if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           PedidoView pedido = new PedidoView(new java.awt.Frame(), true, null, null);
           pedido.setTitle("Caixa : " + menuView.Menu.nomeUsuario);
           pedido.setLocationRelativeTo(null); // centraliza a tela
           pedido.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso("Venda", colaborador.getColaborad())){
              PedidoView pedido = new PedidoView(new java.awt.Frame(), true, null, null);
              pedido.setTitle("Caixa : " + menuView.Menu.nomeUsuario);
              pedido.setLocationRelativeTo(null); // centraliza a tela
              pedido.setVisible(true);
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");      
             
    }//GEN-LAST:event_jbtPedidoActionPerformed

    private void jbtProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProdutosActionPerformed
       if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            
           if (this.produtoView ==  null)
              this.produtoView = new ProdutoView();            
            produtoView.setVisible(true); 
          //  jbtProdutos.setEnabled(false);
          //  jmenuProduto.setEnabled(false);
        }else       
           if (daoNivelAcesso.verificaAcesso("Produto", this.colaborador.getColaborad())){
              if (this.produtoView == null)
                 this.produtoView = new ProdutoView();
              produtoView.setVisible(true); 
             // jbtProdutos.setEnabled(false);
             // jmenuProduto.setEnabled(false);
            }else
                JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");
        
    }//GEN-LAST:event_jbtProdutosActionPerformed

    private void jbtClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClientesActionPerformed
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           if (this.cliView == null)
               this.cliView = new ClienteView();
           this.cliView.setVisible(true);
           jmenuCliente.setEnabled(false);
        }else       
           if (daoNivelAcesso.verificaAcesso("Cliente", colaborador.getColaborad())){
              if (this.cliView == null)
                 this.cliView = new ClienteView();
              this.cliView.setVisible(true);
              jmenuCliente.setEnabled(false);           
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
    
 
    }//GEN-LAST:event_jbtClientesActionPerformed

    private void jmenuComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuComplementoActionPerformed
        //Este recurso de complemento é para pizzaria, no caso de
        //mais azeitona, gelo, milho e etc.
        ComplementosView compView;
        compView = new ComplementosView();
               
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(compView);
           compView.setVisible(true);
           jmenuComplemento.setEnabled(false);
              
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuComplemento.getText(), colaborador.getColaborad())){
              carregadorDesktop1.add(compView);
              compView.setVisible(true);
              jmenuComplemento.setEnabled(false);       
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");            
    }//GEN-LAST:event_jmenuComplementoActionPerformed

    private void jbtCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCaixaActionPerformed
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            CaixaView caixa = new CaixaView(new java.awt.Frame(), true);
            caixa.setTitle("Caixa : " + menuView.Menu.nomeUsuario);
            caixa.setLocationRelativeTo(null); // centraliza a tela
            caixa.setVisible(true);              
        }else       
           if (daoNivelAcesso.verificaAcesso("Caixa", colaborador.getColaborad())){
             CaixaView caixa = new CaixaView(new java.awt.Frame(), true);
             caixa.setTitle("Caixa : " + menuView.Menu.nomeUsuario);
             caixa.setLocationRelativeTo(null); // centraliza a tela
             caixa.setVisible(true);    
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado."); 
           
    }//GEN-LAST:event_jbtCaixaActionPerformed

    private void jmenuObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuObservacaoActionPerformed
        ObservacoesPedidoView obsView = new ObservacoesPedidoView();        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(obsView);
            obsView.setVisible(true);
            jmenuObservacao.setEnabled(false);  
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
              carregadorDesktop1.add(obsView);
              obsView.setVisible(true);
              jmenuObservacao.setEnabled(false);      
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                
    }//GEN-LAST:event_jmenuObservacaoActionPerformed

    private void jbHistoricoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHistoricoCaixaActionPerformed
        HistoricoCaixaView historico = new HistoricoCaixaView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(historico);
            historico.setVisible(true);
            jbHistoricoCaixa.setEnabled(false); 
        }else       
           if (daoNivelAcesso.verificaAcesso("Historico Venda", colaborador.getColaborad())){
               carregadorDesktop1.add(historico);
               historico.setVisible(true);
               jbHistoricoCaixa.setEnabled(false);     
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                           
    }//GEN-LAST:event_jbHistoricoCaixaActionPerformed

    private void jbDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeliveryActionPerformed
        
        
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            PedidoPesquisaDeliveryView ppd = new PedidoPesquisaDeliveryView(new java.awt.Frame(), true);
            ppd.setTitle("Pesquisa Pedido Delivery");
            ppd.setLocationRelativeTo(null);
            ppd.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
              PedidoPesquisaDeliveryView ppd = new PedidoPesquisaDeliveryView(new java.awt.Frame(), true);
              ppd.setTitle("Pesquisa Pedido Delivery");
              ppd.setLocationRelativeTo(null);
              ppd.setVisible(true);    
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");          
         
    }//GEN-LAST:event_jbDeliveryActionPerformed

    private void jmenuEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuEmpresaActionPerformed
        EmpresaView empresa = new EmpresaView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(empresa);
           empresa.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuEmpresa.getText(), colaborador.getColaborad())){
              carregadorDesktop1.add(empresa);
              empresa.setVisible(true);           
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");       
    }//GEN-LAST:event_jmenuEmpresaActionPerformed

    private void jmenuMovimentacaoContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuMovimentacaoContaActionPerformed
        BancoMovimentoView bancoMovimento = new BancoMovimentoView();
        
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
           carregadorDesktop1.add(bancoMovimento);
           bancoMovimento.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuMovimentacaoConta.getText(), colaborador.getColaborad())){
              carregadorDesktop1.add(bancoMovimento);
              bancoMovimento.setVisible(true);        
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                  
    }//GEN-LAST:event_jmenuMovimentacaoContaActionPerformed

    private void jmenuSaldoContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuSaldoContasActionPerformed

        SaldoContasView mov = new SaldoContasView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(mov);
            mov.setVisible(true);
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuSaldoContas.getText(), colaborador.getColaborad())){
              carregadorDesktop1.add(mov);
              mov.setVisible(true);        
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                  
            
    }//GEN-LAST:event_jmenuSaldoContasActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
      
         if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            if (nivelAcesso == null)
               this.nivelAcesso = new NivelAcessoView();       
            nivelAcesso.setVisible(true);
        }else
             JOptionPane.showMessageDialog(null, "O usuário tem que ser do tipo (ADMIN) ");
        
        
        
       
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jmenuHistVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuHistVendaActionPerformed

        HistoricoCaixaView historico = new HistoricoCaixaView();
        
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(historico);
            historico.setVisible(true);
            jbHistoricoCaixa.setEnabled(false); 
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuHistVenda.getText(), colaborador.getColaborad())){
               carregadorDesktop1.add(historico);
               historico.setVisible(true);
               jbHistoricoCaixa.setEnabled(false);     
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");                           
   
    }//GEN-LAST:event_jmenuHistVendaActionPerformed

    private void jmenuCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCaixaActionPerformed
        jbtCaixaActionPerformed(evt);
    }//GEN-LAST:event_jmenuCaixaActionPerformed

    private void jmenuContaReceberFiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuContaReceberFiadoActionPerformed
        PedidoRecebeFiadoView pedidoFiado = new PedidoRecebeFiadoView();
          
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(pedidoFiado);
            pedidoFiado.setVisible(true);
            pedidoFiado.setTitle("Contas à Receber (Fiado)");
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuContaReceberFiado.getText(), colaborador.getColaborad())){
               carregadorDesktop1.add(pedidoFiado);
               pedidoFiado.setVisible(true);
               pedidoFiado.setTitle("Contas à Receber (Fiado)");
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");
    }//GEN-LAST:event_jmenuContaReceberFiadoActionPerformed

    private void jmenuContaReceberCrediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuContaReceberCrediarioActionPerformed
       PedidoRecebeCrediarioView pedidoCrediario = new PedidoRecebeCrediarioView();
          
        if (colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
            carregadorDesktop1.add(pedidoCrediario);
            pedidoCrediario.setVisible(true);
            pedidoCrediario.setTitle("Contas à Receber (Crediário)");
        }else       
           if (daoNivelAcesso.verificaAcesso(jmenuContaReceberCrediario.getText(), colaborador.getColaborad())){     
               carregadorDesktop1.add(pedidoCrediario);
               pedidoCrediario.setVisible(true);
               pedidoCrediario.setTitle("Contas à Receber (Crediário)");
            }else
              JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");
    }//GEN-LAST:event_jmenuContaReceberCrediarioActionPerformed

    private void jbtClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClientes1ActionPerformed
        
        jmenuContaReceberCrediarioActionPerformed(evt);        
        
    }//GEN-LAST:event_jbtClientes1ActionPerformed

    private void jmenuTrocaDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuTrocaDevolucaoActionPerformed

        if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {

            if (this.pedidoTrocaDevView == null) {
                this.pedidoTrocaDevView = new PedidoTrocaDevolucaoView();
            }
            pedidoTrocaDevView.setVisible(true);
           
        } else if (daoNivelAcesso.verificaAcesso("Produto", this.colaborador.getColaborad())) {
            if (this.pedidoTrocaDevView == null) {
                this.pedidoTrocaDevView = new PedidoTrocaDevolucaoView();
            }
            pedidoTrocaDevView.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");
        }

    }//GEN-LAST:event_jmenuTrocaDevolucaoActionPerformed

    private void jmenuCreditoDiferencaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCreditoDiferencaClienteActionPerformed

        if (pedidoCreditoDiferencaView == null)
            pedidoCreditoDiferencaView = new PedidoCreditoDiferencaView();
        pedidoCreditoDiferencaView.setVisible(true);
        pedidoCreditoDiferencaView.setLocationRelativeTo(null);
        
            
    }//GEN-LAST:event_jmenuCreditoDiferencaClienteActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (resumoVendaView == null)
            try {
                resumoVendaView = new ResumoVendaView();
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        resumoVendaView.setVisible(true);
        resumoVendaView.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmenuPedidoTrocaPresenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuPedidoTrocaPresenteActionPerformed
        if (pedidoTrocaPresenteView == null)
            pedidoTrocaPresenteView = new PedidoTrocaPresenteView();
        pedidoTrocaPresenteView.setVisible(true);
        pedidoTrocaPresenteView.setLocationRelativeTo(null);

    }//GEN-LAST:event_jmenuPedidoTrocaPresenteActionPerformed

    private void jmenuGraficoFatMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuGraficoFatMesActionPerformed
        if (graficoVendaView == null)
            graficoVendaView = new GraficoVendaView();
        graficoVendaView.setVisible(true);
        graficoVendaView.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_jmenuGraficoFatMesActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

       if (relVendCat == null)
            relVendCat = new RelVendaPorCategoriaProdView();       
       relVendCat.setVisible(true);
       relVendCat.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        RelVendaPorItenView rvpiView = new RelVendaPorItenView();
        carregadorDesktop1.add(rvpiView);
        rvpiView.setVisible(true);
        rvpiView.setTitle("Relatório de Vendas por Itens");
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       
         try {
            ImprimeRelatorio imprimeRel = new relatoriosView.ImprimeRelatorio();
            if (this.colaborador.getColaborad().getTipo_usuario().equals("ADMIN")) {
                ProdutoDAO prodDao = new ProdutoDAO();
                List<Object[]> objectsProdutos = new ArrayList<>();
                objectsProdutos = prodDao.listarProdutosEstoque();
                System.out.println("Tamanho da lista Estoque : "+objectsProdutos.size());
                        
                imprimeRel.gerarRelatorioProdutoEstoque(objectsProdutos);
            }else       
                if (daoNivelAcesso.verificaAcesso("Relatório Produtos "+jmenuTodosProduto.getText(), this.colaborador.getColaborad())){
                   imprimeRel.relatorioProdutoJPA();                
                }else
                   JOptionPane.showMessageDialog(null, "Você não têm permissão. Acesso Negado.");          
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    class hora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            jlHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }
    
    
    
    
    

    
    

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
                jlUsuario.setText("OPERADOR : " + args[0]);
                nomeUsuario = args[0];
                idColaborador = args[1];

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.CarregadorDesktop carregadorDesktop1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbDelivery;
    public static javax.swing.JButton jbHistoricoCaixa;
    private javax.swing.JButton jbtCaixa;
    public static javax.swing.JButton jbtClientes;
    public static javax.swing.JButton jbtClientes1;
    public static javax.swing.JButton jbtPedido;
    public static javax.swing.JButton jbtProdutos;
    private javax.swing.JButton jbtSair;
    private javax.swing.JLabel jlData;
    private javax.swing.JLabel jlHora;
    public static javax.swing.JLabel jlUsuario;
    private javax.swing.JMenuItem jmenuCaixa;
    private javax.swing.JMenuItem jmenuCategoria;
    private javax.swing.JMenuItem jmenuCategoriaConta;
    public static javax.swing.JMenuItem jmenuCliente;
    private javax.swing.JMenuItem jmenuColaborador;
    public static javax.swing.JMenuItem jmenuComplemento;
    private javax.swing.JMenuItem jmenuContaReceberCrediario;
    private javax.swing.JMenuItem jmenuContaReceberFiado;
    private javax.swing.JMenu jmenuContasReceber;
    private javax.swing.JMenuItem jmenuCreditoDiferencaCliente;
    public static javax.swing.JMenuItem jmenuEmpresa;
    private javax.swing.JMenuItem jmenuEtiquetasProduto;
    private javax.swing.JMenuItem jmenuFiltroPesquisa;
    private javax.swing.JMenuItem jmenuFinancContasPagar;
    public static javax.swing.JMenuItem jmenuFornecedor;
    private javax.swing.JMenuItem jmenuGraficoFatMes;
    private javax.swing.JMenu jmenuGraficoFaturamento;
    private javax.swing.JMenuItem jmenuHistVenda;
    private javax.swing.JMenuItem jmenuMarca;
    private javax.swing.JMenuItem jmenuMovimentacaoConta;
    public static javax.swing.JMenuItem jmenuObservacao;
    public static javax.swing.JMenuItem jmenuOrcamento;
    private javax.swing.JMenuItem jmenuPedidoTrocaPresente;
    public static javax.swing.JMenuItem jmenuProduto;
    private javax.swing.JMenuItem jmenuRelCompraPerCompra;
    private javax.swing.JMenuItem jmenuRelCompraPorPeriodo;
    private javax.swing.JMenuItem jmenuRelContasaPagarPerVenc;
    private javax.swing.JMenu jmenuRelProdutos;
    private javax.swing.JMenuItem jmenuSair;
    private javax.swing.JMenuItem jmenuSaldoContas;
    private javax.swing.JMenuItem jmenuTipoPag;
    private javax.swing.JMenuItem jmenuTodosProduto;
    private javax.swing.JMenuItem jmenuTrocaDevolucao;
    private javax.swing.JMenuItem jmenuUnidade;
    public static javax.swing.JMenuItem jmenuVenda;
    // End of variables declaration//GEN-END:variables
}
