/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author daniel
 */
public class Localizacao {
    
    
    private static double latitud=0.0;
    private static double longitud=0.0;
    private static String direccion;
    

    public static double getLatitud() {
        return latitud;
    }

    public static void setLatitud(double latitud) {
        Localizacao.latitud = latitud;
    }

    public static double getLongitud() {
        return longitud;
    }

    public static void setLongitud(double longitud) {
        Localizacao.longitud = longitud;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static void setDireccion(String direccion) {
        Localizacao.direccion = direccion;
    }
    
    
    
    
}
