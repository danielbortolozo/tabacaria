/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author del
 */
@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "obs")
    private String obs;
    @Column(name = "dt_abertura")
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAbertura;
    @Column(name = "dt_fechamento")
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFechamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Temporal(TemporalType.DATE)
    private Date dt_cad;
    
    @Column(name = "dinheiro_entrada")
    private BigDecimal dinheiroEntrada;
    
    @Column(name = "cartao_debito")
    private BigDecimal cartaoDebito;
    @Column(name = "cartao_credito")
    private BigDecimal cartaoCredito;
    @Column(name = "cheque_entrada")
    private BigDecimal chequeEntrada;
    @Column(name = "vale_alimentacao")
    private BigDecimal valeAlimentacao;
    @Column(name = "total_entrada")
    private BigDecimal totalEntrada;
    
    
    @Column(name = "dinheiro_saida")
    private BigDecimal dinheiroSaida;
    
    @Column(name = "cartao_credito_saida")
    private BigDecimal cartaoCreditoSaida;
    
    @Column(name = "cartao_debito_saida")
    private BigDecimal cartaoDebitoSaida;
    
    @Column(name = "vale_alimentacao_saida")
    private BigDecimal valeAlimentacaoSaida;
    
    
    
    
    @Column(name = "cheque_saida")
    private BigDecimal chequeSaida;    
    @Column(name = "total_saida")
    private BigDecimal totalSaida;
   
    
    @Column(name = "saldo_dinheiro")
    private BigDecimal saldoDinheiro;
    @Column(name = "saldo_cartao_debito")
    private BigDecimal saldoCartaoDebito;
    @Column(name = "saldo_cartao_credito")
    private BigDecimal saldoCartaoCredito;
    @Column(name = "saldo_cheque")
    private BigDecimal saldoCheque;
    @Column(name = "saldo_vale_aliment")
    private BigDecimal saldoValeAliment;
    
    
    
    @Column(name = "saldo_final")
    private BigDecimal saldoFinal;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idUsuario;
    
    @OneToMany(mappedBy = "idCaixa")
    @OrderBy(value="id")
    private List<CaixaItens> caixaItensList;

    public Caixa() {
    }

    public Caixa(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Date getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(Date dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public BigDecimal getDinheiroEntrada() {
        return dinheiroEntrada;
    }

    public void setDinheiroEntrada(BigDecimal dinheiroEntrada) {
        this.dinheiroEntrada = dinheiroEntrada;
    }

    public BigDecimal getCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(BigDecimal cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    public BigDecimal getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(BigDecimal cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public BigDecimal getChequeEntrada() {
        return chequeEntrada;
    }

    public void setChequeEntrada(BigDecimal chequeEntrada) {
        this.chequeEntrada = chequeEntrada;
    }

    public BigDecimal getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(BigDecimal valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

    public BigDecimal getTotalEntrada() {
        return totalEntrada;
    }

    public void setTotalEntrada(BigDecimal totalEntrada) {
        this.totalEntrada = totalEntrada;
    }

    public BigDecimal getDinheiroSaida() {
        return dinheiroSaida;
    }

    public void setDinheiroSaida(BigDecimal dinheiroSaida) {
        this.dinheiroSaida = dinheiroSaida;
    }

    public BigDecimal getChequeSaida() {
        return chequeSaida;
    }

    public void setChequeSaida(BigDecimal chequeSaida) {
        this.chequeSaida = chequeSaida;
    }

    public BigDecimal getSaldoDinheiro() {
        return saldoDinheiro;
    }

    public void setSaldoDinheiro(BigDecimal saldoDinheiro) {
        this.saldoDinheiro = saldoDinheiro;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Pessoa getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Pessoa idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<CaixaItens> getCaixaItensList() {
        return caixaItensList;
    }

    public void setCaixaItensList(List<CaixaItens> caixaItensList) {
        this.caixaItensList = caixaItensList;
    }

    public BigDecimal getTotalSaida() {
        return totalSaida;
    }

    public void setTotalSaida(BigDecimal totalSaida) {
        this.totalSaida = totalSaida;
    }

    public BigDecimal getCartaoCreditoSaida() {
        return cartaoCreditoSaida;
    }

    public void setCartaoCreditoSaida(BigDecimal cartaoCreditoSaida) {
        this.cartaoCreditoSaida = cartaoCreditoSaida;
    }

    public BigDecimal getCartaoDebitoSaida() {
        return cartaoDebitoSaida;
    }

    public void setCartaoDebitoSaida(BigDecimal cartaoDebitoSaida) {
        this.cartaoDebitoSaida = cartaoDebitoSaida;
    }

    public BigDecimal getValeAlimentacaoSaida() {
        return valeAlimentacaoSaida;
    }

    public void setValeAlimentacaoSaida(BigDecimal valeAlimentacaoSaida) {
        this.valeAlimentacaoSaida = valeAlimentacaoSaida;
    }

    public BigDecimal getSaldoCartaoDebito() {
        return saldoCartaoDebito;
    }

    public void setSaldoCartaoDebito(BigDecimal saldoCartaoDebito) {
        this.saldoCartaoDebito = saldoCartaoDebito;
    }

    public BigDecimal getSaldoCartaoCredito() {
        return saldoCartaoCredito;
    }

    public void setSaldoCartaoCredito(BigDecimal saldoCartaoCredito) {
        this.saldoCartaoCredito = saldoCartaoCredito;
    }

    public BigDecimal getSaldoCheque() {
        return saldoCheque;
    }

    public void setSaldoCheque(BigDecimal saldoCheque) {
        this.saldoCheque = saldoCheque;
    }

    public BigDecimal getSaldoValeAliment() {
        return saldoValeAliment;
    }

    public void setSaldoValeAliment(BigDecimal saldoValeAliment) {
        this.saldoValeAliment = saldoValeAliment;
    }

    public Date getDt_cad() {
        return dt_cad;
    }

    public void setDt_cad(Date dt_cad) {
        this.dt_cad = dt_cad;
    }

    
       
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Caixa[ id=" + id + " ]";
    }

  
}
