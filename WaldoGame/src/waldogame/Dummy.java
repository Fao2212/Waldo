/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Alvarez
 */
public class Dummy extends Personaje{

    public Dummy(){
        this.name = EnumPersonajes.DUMMY.name();
    }
    
    @Override
    public void charAction() {
        System.out.println("Im Dummy");
    }
    
}
