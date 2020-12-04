/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "colaborador")
public class Colaborador {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private Pessoa pessoa;
    
    @Temporal(TemporalType.DATE)
    private Date dt_demissao;
    @Temporal(TemporalType.DATE)
    private Date dt_admissao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimo_acesso;
    private String tipo_usuario;
    @Temporal(TemporalType.DATE)
    private Date dt_cadastro;
    //@Column(name = "login", nullable=false, unique=true)
     @Column(name = "login")
    private String login;
    private String senha;
    
    @OneToMany(mappedBy = "idColaborador")
   // @OrderBy(value="id")
    private List<NivelAcesso> ListaAcesso;
    
    
    

    public Colaborador() {
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDt_demissao() {
        return dt_demissao;
    }

    public void setDt_demissao(Date dt_demissao) {
        Date oldDt_demissao = this.dt_demissao;
        this.dt_demissao = dt_demissao;
        changeSupport.firePropertyChange("dt_demissao", oldDt_demissao, dt_demissao);
    }

    public Date getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(Date dt_admissao) {
        Date oldDt_admissao = this.dt_admissao;
        this.dt_admissao = dt_admissao;
        changeSupport.firePropertyChange("dt_admissao", oldDt_admissao, dt_admissao);
    }

    public Date getUltimo_acesso() {
        return ultimo_acesso;
    }

    public void setUltimo_acesso(Date ultimo_acesso) {
        Date oldUltimo_acesso = this.ultimo_acesso;
        this.ultimo_acesso = ultimo_acesso;
        changeSupport.firePropertyChange("ultimo_acesso", oldUltimo_acesso, ultimo_acesso);
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        String oldTipo_usuario = this.tipo_usuario;
        this.tipo_usuario = tipo_usuario;
        changeSupport.firePropertyChange("tipo_usuario", oldTipo_usuario, tipo_usuario);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        String oldLogin = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldLogin, login);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        Date oldDt_cadastro = this.dt_cadastro;
        this.dt_cadastro = dt_cadastro;
        changeSupport.firePropertyChange("dt_cadastro", oldDt_cadastro, dt_cadastro);
    }

    public List<NivelAcesso> getListaAcesso() {
        return ListaAcesso;
    }

    public void setListaAcesso(List<NivelAcesso> ListaAcesso) {
        this.ListaAcesso = ListaAcesso;
    }
    
    
    
    
    
    

    @Override
    public String toString() {
        return "Colaborador{" + "id=" + id + ", pessoa=" + pessoa + ", dt_demissao=" + dt_demissao + ", dt_admissao=" + dt_admissao + ", ultimo_acesso=" + ultimo_acesso + ", tipo_usuario=" + tipo_usuario + ", dt_cadastro=" + dt_cadastro + ", login=" + login + ", senha=" + senha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.pessoa);
        hash = 47 * hash + Objects.hashCode(this.dt_demissao);
        hash = 47 * hash + Objects.hashCode(this.dt_admissao);
        hash = 47 * hash + Objects.hashCode(this.ultimo_acesso);
        hash = 47 * hash + Objects.hashCode(this.tipo_usuario);
        hash = 47 * hash + Objects.hashCode(this.dt_cadastro);
        hash = 47 * hash + Objects.hashCode(this.login);
        hash = 47 * hash + Objects.hashCode(this.senha);
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
        final Colaborador other = (Colaborador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.dt_demissao, other.dt_demissao)) {
            return false;
        }
        if (!Objects.equals(this.dt_admissao, other.dt_admissao)) {
            return false;
        }
        if (!Objects.equals(this.ultimo_acesso, other.ultimo_acesso)) {
            return false;
        }
        if (!Objects.equals(this.tipo_usuario, other.tipo_usuario)) {
            return false;
        }
        if (!Objects.equals(this.dt_cadastro, other.dt_cadastro)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
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
