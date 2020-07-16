/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waldogame;

import AbstractFactory.IPersonaje;
import java.awt.Rectangle;
import java.util.ArrayList;
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
    private ArrayList<Rectangle> positions;
    private int SIZEY = 78;
    private int SIZEX = 40;
    private int encontrados;
    private final int AENCONTRAR = 5;

    public Juego() {
        this.factory = new WaldosFactory();
        this.positions = new ArrayList<>();
        this.encontrados = 0;
    }
    
    public int getEncontrados(){
        return this.encontrados;
    }
    
    public boolean condicionDeVictoria(){
        return this.encontrados == AENCONTRAR;
    }
    
    public void sumarEncontrado(){
        this.encontrados++;
    }
    
    public ImageIcon[] getImages(){
        return this.images;
    }
    
    public IPersonaje[] getPersonajes(){
        return this.personajes;
    }
    
    public void initJuego(){
        setPositions();
        setPersonajes();
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
        int cantidad = this.positions.size();
        this.personajes = new IPersonaje[cantidad];
        cargarPersonajes();
    }
    
    private void setPosAleatoria(){
        List<IPersonaje> list = Arrays.asList(personajes);
        Collections.shuffle(list);
        for (IPersonaje personaje : list) {
            personaje.setBounds(this.positions.get(list.indexOf(personaje)));
        }
    }

    public Stage getMapa() {
        return this.mapa;
    }

    private void randomImage(IPersonaje personaje) {
        int rand = new Random().nextInt(images.length);
        personaje.setImage(images[rand]);
    }
    
    private void setPositions(){//Usar la cantidad de pos
        int x,y;
         x = y = 0;
        while (isInYAxis(SIZEY*y)) {  
            if(!isInXAxis(SIZEX*x)){
                x = 0;
                y++;
            }
            //Se pasa una de mas la del final
            if(!isInYAxis(SIZEY*y))
                break;
            positions.add(new Rectangle(SIZEX*x, SIZEY*y, SIZEX, SIZEY));
            x++;
        }
    }
    
    public void setImages(ImageIcon[] images){
        this.images = images;
    }
    
    private boolean isInXAxis(int x){
       Rectangle mapBounds = this.mapa.getBounds();
        System.out.println(x < mapBounds.width);
       return x < mapBounds.width;
    }
    
    private boolean isInYAxis(int y){
       Rectangle mapBounds = this.mapa.getBounds();
        System.out.println(y < mapBounds.height);
       return y < mapBounds.height;
    }
    
}
