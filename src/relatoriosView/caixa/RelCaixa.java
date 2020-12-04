/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.caixa;

import java.util.Objects;

/**
 *
 * @author daniel
 */
public class RelCaixa {
    
    
    private String aberto;
    private String fechado;
    private String totalEntrada;
    private String totalSaida;
    private String saldoFinal;
    private String colaborador;
    private String status;
    private String obs;

    public RelCaixa() {
    }

    public RelCaixa(String aberto, String fechado, String totalEntrada, String totalSaida, String saldoFinal, String colaborador) {
        this.aberto = aberto;
        this.fechado = fechado;
        this.totalEntrada = totalEntrada;
        this.totalSaida = totalSaida;
        this.saldoFinal = saldoFinal;
        this.colaborador = colaborador;
    }

   
    
    
    
    
    
    

    public String getAberto() {
        return aberto;
    }

    public void setAberto(String aberto) {
        this.aberto = aberto;
    }

    public String getFechado() {
        return fechado;
    }

    public void setFechado(String fechado) {
        this.fechado = fechado;
    }

    public String getTotalEntrada() {
        return totalEntrada;
    }

    public void setTotalEntrada(String totalEntrada) {
        this.totalEntrada = totalEntrada;
    }

    public String getTotalSaida() {
        return totalSaida;
    }

    public void setTotalSaida(String totalSaida) {
        this.totalSaida = totalSaida;
    }

    public String getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(String saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.aberto);
        hash = 11 * hash + Objects.hashCode(this.fechado);
        hash = 11 * hash + Objects.hashCode(this.totalEntrada);
        hash = 11 * hash + Objects.hashCode(this.totalSaida);
        hash = 11 * hash + Objects.hashCode(this.saldoFinal);
        hash = 11 * hash + Objects.hashCode(this.colaborador);
        hash = 11 * hash + Objects.hashCode(this.status);
        hash = 11 * hash + Objects.hashCode(this.obs);
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
        final RelCaixa other = (RelCaixa) obj;
        if (!Objects.equals(this.aberto, other.aberto)) {
            return false;
        }
        if (!Objects.equals(this.fechado, other.fechado)) {
            return false;
        }
        if (!Objects.equals(this.totalEntrada, other.totalEntrada)) {
            return false;
        }
        if (!Objects.equals(this.totalSaida, other.totalSaida)) {
            return false;
        }
        if (!Objects.equals(this.saldoFinal, other.saldoFinal)) {
            return false;
        }
        if (!Objects.equals(this.colaborador, other.colaborador)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.obs, other.obs)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RelCaixa{" + "aberto=" + aberto + ", fechado=" + fechado + ", totalEntrada=" + totalEntrada + ", totalSaida=" + totalSaida + ", saldoFinal=" + saldoFinal + ", colaborador=" + colaborador + ", status=" + status + ", obs=" + obs + '}';
    }
   
    
    
    
    
    
}
