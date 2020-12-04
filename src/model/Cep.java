/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author daniel
 */
@Entity
@Table(name="cep")
public class Cep implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70)
    private String logadouro;
    @Column(length = 20)
    private String cep;
    @Column(length = 50)
    private String bairro;
    @Column(length = 70)
    private String cidade;
    @Column(length = 2)
    private String uf;

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;       
    }
    
    
           
    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        String oldLogadouro = this.logadouro;
        this.logadouro = logadouro;
     
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        String oldCep = this.cep;
        this.cep = cep;
       
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
     
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
     
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        String oldUf = this.uf;
        this.uf = uf;
     
    }

    @Override
    public String toString() {
        return "Cep{" + "id=" + id + ", logadouro=" + logadouro + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.logadouro);
        hash = 61 * hash + Objects.hashCode(this.cep);
        hash = 61 * hash + Objects.hashCode(this.bairro);
        hash = 61 * hash + Objects.hashCode(this.cidade);
        hash = 61 * hash + Objects.hashCode(this.uf);
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
        final Cep other = (Cep) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.logadouro, other.logadouro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    
    
}
