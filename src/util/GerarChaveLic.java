/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import dao.LicencaDAO;
import java.text.SimpleDateFormat;
import model.Licenca;
import org.jasypt.util.text.BasicTextEncryptor;
/**
 *
 * @author del
 */
public class GerarChaveLic {
 static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    static LicencaDAO lDao = new LicencaDAO();
    static Licenca l = new Licenca();
 public static void main(String[] args) {
       // String crpb = lDao.pwd();
        //criptografia("meu texto");
        //System.out.println("Criptografia ="+criptografia("meu texto"));
        //GERADO PARA CAIO RUIZ DIA 01/08/2018. CHAVE = 20190115
        String crp = criptografia("20211230");
        System.out.println("Criptografia : "+crp);
     //   System.out.println("Descriptografa ="+descriptografa(crpb));
 //       int descr = (Integer.parseInt(descriptografa(crpb)));
//       Date y = new Date();
//        
//        String x = sdf.format(y);
//        int ix = (Integer.parseInt(x));
//        
//        System.out.println("integer do sistema "+x);
//        if (descr > ix){
//            JOptionPane.showMessageDialog(null, "tela dee login");
//            
//        }else
//            if(descr == ix)
//                JOptionPane.showMessageDialog(null, "Seu Sistema será cancelado amanhã");
//            else
//                if (descr < ix)
//                    JOptionPane.showMessageDialog(null, "tela de codigo");
//        String seuTexto = "10/10/2016";
//        System.out.println("Texto sem criptografia: " + seuTexto);
//
////instanciamos a classe BasicTextEncryptor
//        BasicTextEncryptor bte = new BasicTextEncryptor();
//
////inserimos uma senha qualquer
//        bte.setPassword("123456");
//
////criamos uma String que recebe a senha criptografada
//        String seuTextoCriptografado = bte.encrypt(seuTexto);
//        System.out.println("Seu texto criptografado = " + seuTextoCriptografado);
//
////criamos uma String que recebe a senha descriptografada
//        String seuTextoNovamenteDescriptografado = bte.decrypt(seuTextoCriptografado);
//        System.out.println("Texto descriptografado = " + seuTextoNovamenteDescriptografado);

    }
    public static String criptografia(String txt){
        
        BasicTextEncryptor bte = new BasicTextEncryptor();
        bte.setPassword("123456");
        txt = bte.encrypt(txt);
        
        return txt ;
    }
    public static String descriptografa(String txt){
         BasicTextEncryptor bte = new BasicTextEncryptor();
        bte.setPassword("123456");
        txt = bte.decrypt(txt);
        
         
        
        return txt;
    }

}
    
