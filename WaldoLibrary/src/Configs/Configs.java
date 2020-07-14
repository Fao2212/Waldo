/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Fernando Alvarez
 */
public class Configs extends Properties{
    
    public static Properties prop = new Properties();
    
    public static void saveProp(String nombre,String valor,String fileName){
        try{
            try{
                InputStream inputStream = new FileInputStream(fileName);
                prop.load(inputStream);
            }
            catch(IOException e){
                System.out.println("Archivo no encontrado");
            }
            prop.setProperty(nombre,valor);
            prop.store(new FileOutputStream(fileName), null);
        }
        catch(IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
    
    public static String loadProp(String nombre,String fileName){
        String valor = "";
        try{
            InputStream inputStream = new FileInputStream(fileName);
            prop.load(inputStream);
            valor = prop.getProperty(nombre);
        }
        catch(IOException e){
            
        }
        return valor;
    }
    
    public static int valuesSize(String fileName){
        int size = 0;
        try{
            prop.load(new FileInputStream(fileName));
            size = prop.size();
        }
        catch(IOException e){
            
        }
        return size;
    }
    
    public static String getKey(String fileName,int index){
        String value = "";
        try{
            prop.load(new FileInputStream(fileName));
            value = (String)prop.stringPropertyNames().toArray()[index];
        }
        catch(IOException e){
            
        }
        return value;
    }
}
