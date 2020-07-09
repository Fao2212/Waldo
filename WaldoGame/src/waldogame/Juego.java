/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import AbstractFactory.IPersonaje;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Alvarez
 */
public class Juego {
    
    private IPersonaje personajes[];
    private WaldosFactory factory;
    private Stage mapa;
    private ImageIcon[] images;

    public Juego() {
        this.factory = new WaldosFactory();
    }
    
    public void initJuego(){
        setPersonajes();//Esto depende del escenario
    }
    
    private void cargarPersonajes(){
        cargarWaldos();
        cargarDummies();
        setPosAleatoria();
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
            randomImage(personajes[i]);
        }
    }
    
    public void setMapa(Stage mapa){
        this.mapa = mapa;
    }
    
    private void setPersonajes(){
        int cantidad = numeroDePersonajes();
        this.personajes = new IPersonaje[cantidad];
        cargarPersonajes();
    }
    
    private void setPosAleatoria(){
        List<IPersonaje> list = Arrays.asList(personajes);
        Collections.shuffle(list);
        for (IPersonaje personaje : list) {
            //Poner en orden respetando las dimensiones
        }
    }

    public Stage getMapa() {
        return this.mapa;
    }

    private void randomImage(IPersonaje personaje) {
        int rand = new Random().nextInt(images.length);
        personaje.setImage(images[rand]);
    }
    
    private int numeroDePersonajes(){
        //Usando el tamano de las imagenes y el tamano disponible calcular la cantidad minima de imagenes que entra 
        return numeroDePersonajes;
    }
    
    public void setImages(ImageIcon[] images){
        this.images = images;
    }
}
