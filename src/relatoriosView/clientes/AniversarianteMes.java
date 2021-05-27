/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.clientes;


public class AniversarianteMes implements Comparable<AniversarianteMes> {

  private String id;
  private String nome;
  private Integer diaAniversario;

    public AniversarianteMes(String id, String nome, int diaAniversario) {
        this.id = id;
        this.nome = nome;
        this.diaAniversario = diaAniversario;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(Integer diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    @Override
    public int compareTo(AniversarianteMes another) {
       return Integer.compare(another.getDiaAniversario(), getDiaAniversario());
     
    }
    

   
    

    
}
