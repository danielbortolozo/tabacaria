/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficosView.venda;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author daniel
 */
public class GraficoVendasMes {
    
    
    private Date data;
    
    private BigDecimal total;
    
    private String dias;
    
  //  private String label;

    public GraficoVendasMes() {
    }

    public GraficoVendasMes(Date data, BigDecimal total, String dias) {
        this.data = data;
        this.total = total;
        this.dias = dias;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
    
    
    
    
    
    
}
