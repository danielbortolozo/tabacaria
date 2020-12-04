/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@Table(name="pessoa_fisica")
@PrimaryKeyJoinColumn(name="pessoa_id")
public class PessoaFisica extends Pessoa{
    
    
    
    private String cpf;
    private String rg;
    private String orgao_rg;
    
    @Temporal(TemporalType.DATE)
    private Date data_emissao;
    
    @Temporal(TemporalType.DATE)
    private Date data_nascimento;
    
    
    private String sexo;
    private String naturalidade;
    private String nacionalidade;
    
    @Enumerated(EnumType.STRING)
    private EstadoCivil estado_civil;

    public PessoaFisica() {
    }

       
    
    
    
    
     
    public String getCpf() {
        return cpf;
    }

    public EstadoCivil getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(EstadoCivil estado_civil) {
        this.estado_civil = estado_civil;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgao_rg() {
        return orgao_rg;
    }

    public void setOrgao_rg(String orgao_rg) {
        this.orgao_rg = orgao_rg;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 89 * hash + (this.rg != null ? this.rg.hashCode() : 0);
        hash = 89 * hash + (this.orgao_rg != null ? this.orgao_rg.hashCode() : 0);
        hash = 89 * hash + (this.data_emissao != null ? this.data_emissao.hashCode() : 0);
        hash = 89 * hash + (this.data_nascimento != null ? this.data_nascimento.hashCode() : 0);
        hash = 89 * hash + (this.sexo != null ? this.sexo.hashCode() : 0);
        hash = 89 * hash + (this.naturalidade != null ? this.naturalidade.hashCode() : 0);
        hash = 89 * hash + (this.nacionalidade != null ? this.nacionalidade.hashCode() : 0);
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
        final PessoaFisica other = (PessoaFisica) obj;
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if ((this.rg == null) ? (other.rg != null) : !this.rg.equals(other.rg)) {
            return false;
        }
        if ((this.orgao_rg == null) ? (other.orgao_rg != null) : !this.orgao_rg.equals(other.orgao_rg)) {
            return false;
        }
        if (this.data_emissao != other.data_emissao && (this.data_emissao == null || !this.data_emissao.equals(other.data_emissao))) {
            return false;
        }
        if (this.data_nascimento != other.data_nascimento && (this.data_nascimento == null || !this.data_nascimento.equals(other.data_nascimento))) {
            return false;
        }
        if ((this.sexo == null) ? (other.sexo != null) : !this.sexo.equals(other.sexo)) {
            return false;
        }
        if ((this.naturalidade == null) ? (other.naturalidade != null) : !this.naturalidade.equals(other.naturalidade)) {
            return false;
        }
        if ((this.nacionalidade == null) ? (other.nacionalidade != null) : !this.nacionalidade.equals(other.nacionalidade)) {
            return false;
        }
        return true;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    
    
    
    
    
    
    
}
