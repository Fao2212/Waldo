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
public class WaldosFactory extends AbstractFactory.AbstractFactory{

    @Override
    public IPersonaje getInstance(Enum value) {
        String name = value.name();
        if(!name.equals(EnumPersonajes.DUMMY.name()))
            return new Waldo(name);
        else
            return new Dummy();
    }

    
    
}
