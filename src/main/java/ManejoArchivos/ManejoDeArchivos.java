/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nicolas Correa
 */
public class ManejoDeArchivos {
     public static void crearArchivo(String nombre){
         File archivo = new File(nombre);
            try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            }catch(FileNotFoundException ex){
               ex.printStackTrace(System.out);
            }
         
    }
    
    public static void escribirArchivo(String nombre, String contenido){
        PrintWriter salida = null;
          File archivo = new File (nombre);
        try {//Se que el fichero existe
            salida = new PrintWriter(archivo);
            salida.println(contenido);
            System.out.println("====================SE HA CREADO EL ARCHIVO=================================");        
        } catch (FileNotFoundException ex){//El fichero no existe
            ex.printStackTrace(System.out);            
        } finally {
            salida.close();
        }
        
    }
    public static void agregarArchivo(String nombre, String contenido){
        PrintWriter salida = null;
         File archivo = new File (nombre);
        try {
           
            salida = new PrintWriter(new FileWriter(nombre,true));
            salida.println(contenido);
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
                
    }
    public static void leerArchivo(String nombre){
        BufferedReader entrada;
        File archivo = new File (nombre);
           
        try {
             entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null){
                System.out.println(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
                
    }
    public static void leerArchivoporPalabra(String nombre){
        File archivo = new File (nombre);
        try {   
            Scanner entrada = new Scanner(archivo);
            int cont = 0;
            while(entrada.hasNext()){
                String palabra = entrada.next();
                System.out.println(palabra);
                cont++;
            }
            System.out.println("Número de palabras: " + cont);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        
                
    }
}
