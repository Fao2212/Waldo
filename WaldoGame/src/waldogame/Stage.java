/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Alvarez
 */
public class Stage {
    
    ImageIcon image;
    Rectangle bounds;

    public Stage(ImageIcon image, Rectangle bounds) {
        this.image = image;
        this.bounds = bounds;
    }
    
}
