/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;

/**
 *
 * @author daniel
 */
public class ImpressaoTeste {
    
    public static void main (String[] args){
         PrinterMatrix printer=new PrinterMatrix();

//Define o tamanho do papel/tela para impressão, aqui 25
//linhas e 80 colunas
printer .setOutSize( 25, 80 );

//imprimir * da 2a linha a 25 na coluna 1
printer.printCharAtLin(2, 25, 1, "*" );

//imprimir
//* na 1a linha da coluna 1 a 80
printer.printCharAtCol( 1, 1, 80, "*" );

//imprimir * da 2a linha a 25 na coluna 1
printer.printCharAtLin( 2, 25, 80, "*" );

//imprimir O na linha 3 coluna 39
printer.printTextLinCol( 3, 39, "OK" );

//imprimir Teste na linha 14 e coluna 40
printer.printTextLinCol( 14, 40, "Teste" );

//imprimir * na linha 25 da coluna 1 a 80
printer.printCharAtCol( 25, 1, 80, "*" );

//imprimir Imprimindo em modo texto na linha 14 e coluna 10
printer.printTextLinCol( 14, 10, "Imprimindo em modo texto" );

//imprimir – na linha 13 da coluna 2 a 79
printer.printCharAtCol( 13, 2, 79, "-" );

//imprimir – na linha 15 da coluna 2 a 79
printer.printCharAtCol( 15, 2, 79, "-" );

//imprimir + da linha 17 a linha 24 da coluna 50 a 79
printer.printCharAtLinCol( 17, 24, 50, 79, "+" );

//imprimir + da linha 17 a linha 24 da coluna 2 a 40
printer .printCharAtLinCol( 17, 24, 2, 40, "+");

//imprimir + da linha 17 a linha 20 da coluna 41 a 49
printer.printCharAtLinCol( 17, 20, 41, 49, "+" );

//printer.toImageFile( "/home/daniel/Imagens/printermatrix.jpg" );
//printer.show();
printer.toFile( "/home/daniel/testePrint.txt" );
//printer.toPrinterServer(“192.168.9.12”,9100);
//printer.toPrinter(“LPT1”);
// printer.mapearDocumentoImageFile(25,80,"/home/daniel/Imagens/cadeado.png" );
        
}
    
    
}
