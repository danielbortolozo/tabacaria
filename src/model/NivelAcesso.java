/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author daniel
 */
@Entity

   

public class NivelAcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    
   @JoinColumn(name = "id_colaborador", referencedColumnName = "id")
   @ManyToOne
   private Colaborador idColaborador;
   
   private String nomeModulo;
   
      

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.idColaborador);
        hash = 79 * hash + Objects.hashCode(this.nomeModulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NivelAcesso other = (NivelAcesso) obj;
        if (!Objects.equals(this.nomeModulo, other.nomeModulo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idColaborador, other.idColaborador)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
   
    
}
