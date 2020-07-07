/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import AbstractFactory.IPersonaje;

/**
 *
 * @author Fernando Alvarez
 */
public class Juego {
    
    IPersonaje personajes[];
    WaldosFactory factory;

    public Juego() {
        this.factory = new WaldosFactory();
    }
    
    public void initJuego(int cantidadDePersonajes){
        setPersonajes(cantidadDePersonajes);
        cargarEscenario();
    }
    
    private void cargarPersonajes(){
        cargarWaldos();
        cargarDummies();
    }
    
    private void cargarWaldos(){
        int cont = 0;
        EnumPersonajes[] tipos = EnumPersonajes.values();
        for (EnumPersonajes tipo : tipos) {
            if (tipo != EnumPersonajes.DUMMY) {
                personajes[cont++] = factory.getInstance(tipo);
            }
        }
        
    }
    
    private void cargarDummies(){
        for (int i = 5; i < personajes.length; i++) {
            personajes[i] = factory.getInstance(EnumPersonajes.DUMMY);
        }
    }
    
    private void cargarEscenario(){
        //Escoger un escenario
        //Para el mapa asignar las pos de los jugadores
        setPosAleatoria();
    }
    
    private void setPersonajes(int cantidad){
        this.personajes = new IPersonaje[cantidad];
        cargarPersonajes();
    }
    
    private void setPosAleatoria(){
        //Buscar dar pos a todos los personajes qu eno se repitan
    }
}
