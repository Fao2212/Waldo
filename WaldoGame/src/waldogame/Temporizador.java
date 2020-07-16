/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import Controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Alvarez
 */
public class Temporizador extends Thread {
    
    private int tiempo = 0;
    private boolean running = true;
    private Controller controlador;

    public Temporizador(Controller controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void run(){
        while(running){
            controlador.updateTime();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
            }
            tiempo++;
        }
    }
    
    public void detener(){
        this.running = false;
    }
    
    public int getTiempo(){
        return this.tiempo;
    }
}
