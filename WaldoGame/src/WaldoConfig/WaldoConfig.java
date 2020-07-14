/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WaldoConfig;

import Configs.Configs;
import ImageLoader.ImageLoader;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import waldogame.Stage;

/**
 *
 * @author Fernando Alvarez
 */
public class WaldoConfig {
    
    final static String STAGESPATH = "stagesConfig.txt";//Guarda el path de la imagen como key t el value son sus coordenadas
    final static String CHARPATH = "src/character";//Caambiar esto por un folder donde esten todas las imagenes de los personajes
    public static WaldoConfig wc = new WaldoConfig();
    
    public static void saveMap(String [] values){//Toma valores de pantalla y el path
        String path = values[0];
        String coordenadas = packMapConfig(values);
        File file = new File(STAGESPATH);
        Configs.saveProp(path, coordenadas,file.getAbsolutePath());
    }
    
    public static Stage loadMap(){//Crea un mapa
        String[] values = unpackMapConfig();
        ImageIcon image = new ImageIcon(ImageLoader.getImage(values[0]));//Carga la imagen con la pos 0 del array
        Rectangle bounds = new Rectangle(Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));//Con el resto de las posiciones del array
        return new Stage(image, bounds);
    }
    
    private static String[] unpackMapConfig(){//Con el key aleatorio toma el path y sus coordenadas y lo convierte en un array
        String path = mapSelection();
        File file = new File(STAGESPATH);
        String value = Configs.loadProp(path, file.getAbsolutePath());
        String[] values = new String[5];
        values[0] = path;
        String[] cord = value.split(",");
        for (int i = 1; i < 5; i++) {
            values[i] = cord[i-1];
        }
        return values;
    } 
    
    private static String mapSelection(){//Retorna un key aleatorio del archivo de config
        int size = stagesSize();
        int rand = new Random().nextInt(size);
        return Configs.getKey(STAGESPATH,rand);
    }
    
    private static String packMapConfig(String[] values){//Devuelve las coordenadas en el formato con comas que se establecio para el archivo de configuracion
        String coordenadas = "";
        for (int i = 1;i<values.length;i++) {
            coordenadas += values[i];
            if(i != values.length-1)
                coordenadas +=  ",";
        }
        return coordenadas;
    }
    
    public static int stagesSize(){
        return Configs.valuesSize(STAGESPATH);
    }
    
    public static ImageIcon[] personajesDisponibles(){
        File dir = new File(CHARPATH);
        File [] files = dir.listFiles();
        ImageIcon [] images = new ImageIcon[files.length];  
        int cont = 0;
        for (File file : files) {
            images[cont++] = new ImageIcon(ImageLoader.getImage(file.getAbsolutePath()));
        }
        return images;
    }
}
