/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 *
 * @author Fernando Alvarez
 */
public abstract class AbstractFactory {
    
    public abstract IPersonaje getInstance(Enum value);
    
}
