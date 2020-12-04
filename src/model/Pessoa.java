/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author root
 **/
@Entity
@Table(name="pessoa")
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "colaborador")
    private String colaborador;
    @Column(name = "email")
    private String email;
    @Column(name = "fornecedor")
    private String fornecedor;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "site")
    private String site;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "usuarios")
    private String usuarios;
   
    
       
    @OneToOne(mappedBy = "pessoa")
    private Cliente cli;
    
    @OneToOne(mappedBy = "pessoa")
    private Fornecedor forn;
    
    @OneToOne(mappedBy = "pessoa")
    private Colaborador colaborad;
    
    
    @OneToMany(mappedBy = "pessoa")
    private List<PessoaEndereco> listaEndereco;
    
    @OneToMany(mappedBy = "pessoa")
    private List<PessoaContato> listaContato;

    
    //Gets e Sets

    public List<PessoaContato> getListaContato() {
        return listaContato;
    }

    public void setListaContato(List<PessoaContato> listaContato) {
        this.listaContato = listaContato;
    }
         
    public List<PessoaEndereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<PessoaEndereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }
    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Fornecedor getForn() {
        return forn;
    }

    public void setForn(Fornecedor forn) {
        this.forn = forn;
    }

    public Colaborador getColaborad() {
        return colaborad;
    }

    public void setColaborad(Colaborador colaborad) {
        this.colaborad = colaborad;
    }
       
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public Pessoa() {
    }

    public Pessoa(Long id) {
        this.id = id;
    }

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pessoa[ id=" + id + " ]";
    }

   

    

 
}
