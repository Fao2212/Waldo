/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import AbstractFactory.IPersonaje;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Alvarez
 */
public class Personaje implements IPersonaje{

    String name;
    Rectangle bounds;
    ImageIcon image;
    
    
    @Override//Implementada por los hijos
    public void charAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setImage(ImageIcon icon) {
        this.image = icon;
    }

    @Override
    public ImageIcon getImage() {
        return this.image;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Rectangle getBounds() {
        return this.bounds;
    }

    @Override
    public void setBounds(Rectangle pos) {
        this.bounds = bounds;
    }
    
}
