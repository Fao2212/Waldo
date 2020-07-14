/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import AbstractFactory.IPersonaje;
import javax.swing.JLabel;

/**
 *
 * @author Fernando Alvarez
 */
public class LabelPersonaje extends JLabel{
    
    public IPersonaje personaje;

    public LabelPersonaje(IPersonaje personaje) {
        this.personaje = personaje;
    }
    
}
