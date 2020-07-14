/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.LabelPersonaje;
import GUI.Pantalla;
import waldogame.Juego;
import WaldoConfig.WaldoConfig;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Alvarez
 */
public class Controller implements MouseListener{//Los labels tienen que tenr un action listener
    
    Juego juego;
    Pantalla pantalla;

    public Controller() {
        this.juego = new Juego();
        this.pantalla = new Pantalla();
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }
    
    public void setearImagenes(){//Para la pantalla
        //Meter todas las imagenes del directiorio character
        ImageIcon[] test = new ImageIcon[1];
        test[0] = new ImageIcon(ImageLoader.ImageLoader.getImage("C:/Users/ACER/Documents/GitHub/Waldo/WaldoGame/src/Waldo Cahracter/WALDO.png"));
       juego.setImages(test);
    }
    
    public void pintarPantalla(){
        pantalla.setCharacters(this);
    }
    
    public void cargarImagenes(){
        juego.setImages(WaldoConfig.personajesDisponibles());
    }
    
    public Rectangle getMapCoordinates(){//Para la pantalla creo que no se usara
        return juego.getMapa().getBounds();
    }
    
    public void selectMap(){
        juego.setMapa(WaldoConfig.loadMap());
    }
    
    public void initGame(){
        cargarImagenes();
        selectMap();
        juego.initJuego();
        setearImagenes();
        pintarPantalla();
        pantalla.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        LabelPersonaje p = (LabelPersonaje)e.getSource();
        p.personaje.charAction();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
}
