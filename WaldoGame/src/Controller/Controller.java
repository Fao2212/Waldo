/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import waldogame.Juego;
import WaldoConfig.WaldoConfig;
import java.awt.Rectangle;

/**
 *
 * @author Fernando Alvarez
 */
public class Controller {//Los labels tienen que tenr un action listener
    
    Juego juego;
    //Pantalla pantalla;
    
    public void setearImagenes(){
        //Toma los personajes y por nombre les asignara una imagen, los dummy van aleatoriamente
    }
    
    public void pintarPantalla(){
        //Se colocan los personajes, sus imagenes, en las posiciones que les corresponde en la pantalla
    }
    
    public void cargarImagenes(){
        juego.setImages(WaldoConfig.personajesDisponibles());
    }
    
    public Rectangle getMapCoordinates(){//Using configs
        return juego.getMapa().getBounds();
    }
    
    public void selectMap(){
        juego.setMapa(WaldoConfig.loadMap());
    }
    
    public void initGame(){
        
    }
    
    //Carga imagenes
    //Carga mapa
    //Carga personajes
    //Empieza el jeugo(Pantalla)
}
