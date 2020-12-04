/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


/**
 *
 * @author daniel
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String descricao;    
    @Column(name = "cod_barras", length = 25, unique = true)
    private String codBarras;
    @Column(name = "vl_venda")
    private float vlVenda;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private CategoriaProduto categoria;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_marca", referencedColumnName = "id")
    private MarcaProduto marca;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_unidade", referencedColumnName = "id")
    private UnidadeProduto unidade;
    
    private float estoque;
    private float estoque_minimo;
    
    private String prateleira;
    
    @Column(unique = true)
    private String cod_interno;
    
    private int status;
    private String peso;
    private float porcento_comissao;
    private float vl_compra;
    private float ultimo_vl_compra;
    private boolean estoque_controlado;
    private String tamanho;
    
    @Column(name = "porcentagem_atacado")
    private float porcentagemAtacado;
    
    @Column(name = "vl_venda_atacado")
    private float vlVendaAtacado;

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        String oldCodBarras = this.codBarras;
        this.codBarras = codBarras;
        changeSupport.firePropertyChange("codBarras", oldCodBarras, codBarras);
    }

    public float getVlVenda() {
        return vlVenda;
    }

    public void setVlVenda(float vlVenda) {
        float oldVlVenda = this.vlVenda;
        this.vlVenda = vlVenda;
        changeSupport.firePropertyChange("vlVenda", oldVlVenda, vlVenda);
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        CategoriaProduto oldCategoria = this.categoria;
        this.categoria = categoria;
        changeSupport.firePropertyChange("categoria", oldCategoria, categoria);
    }

    public MarcaProduto getMarca() {
        return marca;
    }

    public void setMarca(MarcaProduto marca) {
        MarcaProduto oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    public UnidadeProduto getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeProduto unidade) {
        UnidadeProduto oldUnidade = this.unidade;
        this.unidade = unidade;
        changeSupport.firePropertyChange("unidade", oldUnidade, unidade);
    }

    public float getEstoque() {
        return estoque;
    }

    public void setEstoque(float estoque) {
        float oldEstoque = this.estoque;
        this.estoque = estoque;
        changeSupport.firePropertyChange("estoque", oldEstoque, estoque);
    }

    public float getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(float estoque_minimo) {
        float oldEstoque_minimo = this.estoque_minimo;
        this.estoque_minimo = estoque_minimo;
        changeSupport.firePropertyChange("estoque_minimo", oldEstoque_minimo, estoque_minimo);
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getCod_interno() {
        return cod_interno;
    }

    public void setCod_interno(String cod_interno) {
        this.cod_interno = cod_interno;
    }

   

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public float getPorcento_comissao() {
        return porcento_comissao;
    }

    public void setPorcento_comissao(float porcento_comissao) {
        this.porcento_comissao = porcento_comissao;
    }

    

    public float getVl_compra() {
        return vl_compra;
    }

    public void setVl_compra(float vl_compra) {
        this.vl_compra = vl_compra;
    }

    public float getUltimo_vl_compra() {
        return ultimo_vl_compra;
    }

    public void setUltimo_vl_compra(float ultimo_vl_compra) {
        this.ultimo_vl_compra = ultimo_vl_compra;
    }

    public boolean isEstoque_controlado() {
        return estoque_controlado;
    }

    public void setEstoque_controlado(boolean estoque_controlado) {
        this.estoque_controlado = estoque_controlado;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPorcentagemAtacado() {
        return porcentagemAtacado;
    }

    public void setPorcentagemAtacado(float porcentagemAtacado) {
        this.porcentagemAtacado = porcentagemAtacado;
    }

    public float getVlVendaAtacado() {
        return vlVendaAtacado;
    }

    public void setVlVendaAtacado(float vlVendaAtacado) {
        this.vlVendaAtacado = vlVendaAtacado;
    }

   

        
    

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", codBarras=" + codBarras + ", vlVenda=" + vlVenda + ", categoria=" + categoria + ", marca=" + marca + ", unidade=" + unidade + ", estoque=" + estoque + ", estoque_minimo=" + estoque_minimo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 59 * hash + (this.codBarras != null ? this.codBarras.hashCode() : 0);
        hash = 59 * hash + Float.floatToIntBits(this.vlVenda);
        hash = 59 * hash + (this.categoria != null ? this.categoria.hashCode() : 0);
        hash = 59 * hash + (this.marca != null ? this.marca.hashCode() : 0);
        hash = 59 * hash + (this.unidade != null ? this.unidade.hashCode() : 0);
        hash = 59 * hash + Float.floatToIntBits(this.estoque);
        hash = 59 * hash + Float.floatToIntBits(this.estoque_minimo);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if ((this.codBarras == null) ? (other.codBarras != null) : !this.codBarras.equals(other.codBarras)) {
            return false;
        }
        if (Float.floatToIntBits(this.vlVenda) != Float.floatToIntBits(other.vlVenda)) {
            return false;
        }
        if (this.categoria != other.categoria && (this.categoria == null || !this.categoria.equals(other.categoria))) {
            return false;
        }
        if (this.marca != other.marca && (this.marca == null || !this.marca.equals(other.marca))) {
            return false;
        }
        if (this.unidade != other.unidade && (this.unidade == null || !this.unidade.equals(other.unidade))) {
            return false;
        }
        if (Float.floatToIntBits(this.estoque) != Float.floatToIntBits(other.estoque)) {
            return false;
        }
        if (Float.floatToIntBits(this.estoque_minimo) != Float.floatToIntBits(other.estoque_minimo)) {
            return false;
        }
        return true;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
    
    
    
    
    
    
}
