/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageLoader;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Fernando Alvarez
 */
public class ImageLoader {
    
    public static ImageLoader imageLoader = new ImageLoader();
    
    public static BufferedImage getImage(String absolutePath){
        try {
            System.out.println(absolutePath);
            InputStream inputStream = new FileInputStream(absolutePath);
            return ImageIO.read(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
