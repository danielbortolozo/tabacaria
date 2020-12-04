/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author del
 */
@Entity
@Table(name = "sub_categoria_conta")
public class SubCategoriaConta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    
    @OneToMany(mappedBy = "idSubCategoriaConta")
    private List<CategoriaConta> categoriaContaList;
    
    

    public SubCategoriaConta() {
    }

    public SubCategoriaConta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof SubCategoriaConta)) {
            return false;
        }
        SubCategoriaConta other = (SubCategoriaConta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SubCategoriaConta[ id=" + id + " ]";
    }

    public List<CategoriaConta> getCategoriaContaList() {
        return categoriaContaList;
    }

    public void setCategoriaContaList(List<CategoriaConta> categoriaContaList) {
        this.categoriaContaList = categoriaContaList;
    }
    
}
