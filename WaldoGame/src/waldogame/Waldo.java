/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import ImageLoader.ImageLoader;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Alvarez
 */
public class Waldo extends Personaje{
    
    public Waldo(String name) {
        this.name = name;
        imageSet();
    }
    
    @Override
    public void charAction() {
        System.out.println("Im waldo");
    }
    
    private void imageSet(){
        setImage(new ImageIcon(ImageLoader.getImage("C:/Users/ACER/Documents/GitHub/Waldo/WaldoGame/src/Waldo Cahracter/"+name+".png")));
    }
    
}
