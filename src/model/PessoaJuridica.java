/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author root
 */

@Entity
@Table(name="pessoa_juridica")
@PrimaryKeyJoinColumn(name="pessoa_id")
public class PessoaJuridica extends Pessoa{
    
    private String cnpj;
    private String razao_social;
    private String inscrecao_estadual;
    private String inscrecao_municipal;

    
    
    
    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscrecao_estadual() {
        return inscrecao_estadual;
    }

    public void setInscrecao_estadual(String inscrecao_estadual) {
        this.inscrecao_estadual = inscrecao_estadual;
    }

    public String getInscrecao_municipal() {
        return inscrecao_municipal;
    }

    public void setInscrecao_municipal(String inscrecao_municipal) {
        this.inscrecao_municipal = inscrecao_municipal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.cnpj != null ? this.cnpj.hashCode() : 0);
        hash = 71 * hash + (this.razao_social != null ? this.razao_social.hashCode() : 0);
        hash = 71 * hash + (this.inscrecao_estadual != null ? this.inscrecao_estadual.hashCode() : 0);
        hash = 71 * hash + (this.inscrecao_municipal != null ? this.inscrecao_municipal.hashCode() : 0);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if ((this.cnpj == null) ? (other.cnpj != null) : !this.cnpj.equals(other.cnpj)) {
            return false;
        }
        if ((this.razao_social == null) ? (other.razao_social != null) : !this.razao_social.equals(other.razao_social)) {
            return false;
        }
        if ((this.inscrecao_estadual == null) ? (other.inscrecao_estadual != null) : !this.inscrecao_estadual.equals(other.inscrecao_estadual)) {
            return false;
        }
        if ((this.inscrecao_municipal == null) ? (other.inscrecao_municipal != null) : !this.inscrecao_municipal.equals(other.inscrecao_municipal)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
