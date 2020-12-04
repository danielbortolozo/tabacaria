/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author daniel
 */
public class DefinirJTextField {
    
    public JTextField DefinirTiposCaracteresETamanho(int tamanho,String caracteres)
{
	try
	{
		//defino a variável que vai guardar a quantidade de caracteres
		String quantidade="";

		//defino um método de repetição para repetir o numero de
 		//vezes  do tamanho
		for(int i=0 ; i < tamanho; i++)
		{
			// defino asterisco para aceitar qualquer coisa e crio a máscara
			quantidade=quantidade+"*";
		}        
		//  **********...   de acordo com o tamanho informado
		// defino que a mascara possui essa
		//quantidade de elementos que foi informado em tamanho e
		// foi colocada com * dentro de quantidade
		javax.swing.text.MaskFormatter nome=new javax.swing.text.MaskFormatter(quantidade);

		//defino que o parâmetro caracter recebido pelo
		//método contém os caracteres válidos 
		nome.setValidCharacters(caracteres);

		//retorno a mascara que foi criada  
		return new javax.swing.JFormattedTextField(nome);
	}// fim do try
	catch (Exception e)
	{      
		//mensagem se acontecer erro
		JOptionPane.showMessageDialog(null,"Ocorreu um erro");
		//retorno um campo de texto comum  
		return new JTextField();
	}//fim do catch
}//fim do método




    
    
    
}
