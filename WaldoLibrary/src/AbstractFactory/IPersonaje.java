/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Alvarez
 */
public interface IPersonaje {
    
    public void charAction();
    public String getName();
    public void setName(String string);
    public Rectangle getBounds();
    public void setBounds(Rectangle pos);
    public void setImage(ImageIcon icon);
    public ImageIcon getImage();
    
}
