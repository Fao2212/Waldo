/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

/**
 *
 * @author Fernando Alvarez
 */
public class WaldoGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO cargar Waldo
        //Crear pantalla y correr el uego
        WaldosFactory wf = new WaldosFactory();
        wf.getInstance(EnumPersonajes.WOOF);
    }
    
}
