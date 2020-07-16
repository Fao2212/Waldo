/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AbstractFactory.IPersonaje;
import GUI.LabelPersonaje;
import GUI.Pantalla;
import waldogame.Juego;
import WaldoConfig.WaldoConfig;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import waldogame.Temporizador;
import waldogame.Waldo;

/**
 *
 * @author Fernando Alvarez
 */
public class Controller implements MouseListener,ActionListener{//Los labels tienen que tenr un action listener
    
    Juego juego;
    Pantalla pantalla;
    Temporizador temporizador;

    public Controller() {
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
        ImageIcon[] test = WaldoConfig.personajesDisponibles();
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
        this.juego = new Juego();
        this.pantalla = new Pantalla();
        cargarImagenes();
        selectMap();
        juego.initJuego();
        setearImagenes();
        pintarPantalla();
        pantalla.agregarListeners(this);
        pantalla.setVisible(true);
        initTemporizador();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        LabelPersonaje p = (LabelPersonaje)e.getSource();
        p.personaje.charAction();
        if(isWaldo(p.personaje)){
            pintarWaldo(p);
            juego.sumarEncontrado();
        }
        condicionDeVictoria();
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
    
    private boolean isWaldo(IPersonaje personaje){
        return personaje.getClass().equals(Waldo.class);
    }
    
    private void pintarWaldo(LabelPersonaje p){
            p.setBackground(Color.red);
            p.setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(pantalla.jButton2)){
            for (LabelPersonaje label : pantalla.labels) {
                if(isWaldo(label.personaje)){
                    pintarWaldo(label);
                }
            }
            JOptionPane.showMessageDialog(pantalla, "Perdiste");
        }
        if (source.equals(pantalla.jButton3)) {
            pantalla.dispose();
            initGame();
        }
    }
    
    public void condicionDeVictoria(){
        if(this.juego.condicionDeVictoria()){
            JOptionPane.showMessageDialog(pantalla, "Ganaste");
        }
    }
   
    
    public void initTemporizador(){
        this.temporizador = new Temporizador(this);
        this.temporizador.start();
    }

    public void updateTime() {
        pantalla.setTime(temporizador.getTiempo());
    }
}
 