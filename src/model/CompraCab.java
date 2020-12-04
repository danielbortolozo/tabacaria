/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "compra_cab")
public class CompraCab implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50)
    private String num_doc;
    @Temporal(TemporalType.DATE)
    private Date emissao;
    
       
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id")
    private Pessoa fornecedor;
   
    
          
    @Column(name = "vl_total")
    private float vltotal;
    @Column(name = "qtd_parcela")
    private int qtdparcela;
    
    private String descricao;
    
    private String obs;
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Column(length = 20)
    private String status;

    
    @OneToMany(mappedBy = "compra_cab", cascade = {CascadeType.REMOVE})
    private List<CompraDet> listaCompraDet;
    
       
    private float subtotal;
    private float desconto;
    private float frete;
    private int gerar_conta_pagar;
    
    //Campo criado para pegar o nome do fornecedor nos relatórios
    @Transient
    private String nomeFonecedor;
    
   // private CategoriaConta idCategoriaConta;
    
         
    public CompraCab() {
    }
    
    public CompraCab(Long id, String num_doc, Date emissao,  Pessoa fornecedor, float vltotal, int qtdparcela, String descricao, String obs, Date vencimento, String status) {
        this.id = id;
        this.num_doc = num_doc;
        this.emissao = emissao;       
        this.fornecedor = fornecedor;       
        this.vltotal = vltotal;
        this.qtdparcela = qtdparcela;
        this.descricao = descricao;
        this.obs = obs;
        this.vencimento = vencimento;
        this.status = status;
    }

    public CompraCab(String num_doc, String descricao, String nomeFornecedor, Date emissao, float subtotal, float desconto, float vltotal) {
        this.num_doc = num_doc;
        this.descricao = descricao;
        this.nomeFonecedor = nomeFornecedor;        
        this.emissao = emissao;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.vltotal = vltotal;       
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Pessoa fornecedor) {
        this.fornecedor = fornecedor;
    }    

    public float getVltotal() {
        return vltotal;
    }

    public void setVltotal(float vltotal) {
        this.vltotal = vltotal;
    }

    public int getQtdparcela() {
        return qtdparcela;
    }

    public void setQtdparcela(int qtdparcela) {
        this.qtdparcela = qtdparcela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CompraDet> getListaCompraDet() {
        return listaCompraDet;
    }

    public void setListaCompraDet(List<CompraDet> listaCompraDet) {
        this.listaCompraDet = listaCompraDet;
    }    

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public int getGerar_conta_pagar() {
        return gerar_conta_pagar;
    }

    public void setGerar_conta_pagar(int gerar_conta_pagar) {
        this.gerar_conta_pagar = gerar_conta_pagar;
    }

    public String getNomeFonecedor() {
        return nomeFonecedor;
    }

    public void setNomeFonecedor(String nomeFoneceddor) {
        this.nomeFonecedor = nomeFoneceddor;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    
    
    
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.num_doc);
        hash = 31 * hash + Objects.hashCode(this.emissao);
        hash = 31 * hash + Objects.hashCode(this.fornecedor);
        hash = 31 * hash + Float.floatToIntBits(this.vltotal);
        hash = 31 * hash + this.qtdparcela;
        hash = 31 * hash + Objects.hashCode(this.descricao);
        hash = 31 * hash + Objects.hashCode(this.obs);
        hash = 31 * hash + Objects.hashCode(this.vencimento);
        hash = 31 * hash + Objects.hashCode(this.status);
        hash = 31 * hash + Objects.hashCode(this.listaCompraDet);
        hash = 31 * hash + Float.floatToIntBits(this.subtotal);
        hash = 31 * hash + Float.floatToIntBits(this.desconto);
        hash = 31 * hash + this.gerar_conta_pagar;
        hash = 31 * hash + Objects.hashCode(this.nomeFonecedor);       
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompraCab other = (CompraCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.num_doc, other.num_doc)) {
            return false;
        }
        if (!Objects.equals(this.emissao, other.emissao)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (Float.floatToIntBits(this.vltotal) != Float.floatToIntBits(other.vltotal)) {
            return false;
        }
        if (this.qtdparcela != other.qtdparcela) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.obs, other.obs)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.listaCompraDet, other.listaCompraDet)) {
            return false;
        }
        if (Float.floatToIntBits(this.subtotal) != Float.floatToIntBits(other.subtotal)) {
            return false;
        }
        if (Float.floatToIntBits(this.desconto) != Float.floatToIntBits(other.desconto)) {
            return false;
        }
        if (this.gerar_conta_pagar != other.gerar_conta_pagar) {
            return false;
        }
        if (!Objects.equals(this.nomeFonecedor, other.nomeFonecedor)) {
            return false;
        }
        
        return true;
    }

  
    
    
    
    
    
    
    
    
}
