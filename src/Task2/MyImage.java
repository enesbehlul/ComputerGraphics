/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author behlul
 */
public class MyImage {
    
    public static void main(String[] args) throws IOException {
        int height = 103;
        int width = 640;
        
        BufferedImage image = null;
        File f = null;
        
        f = new File("/home/behlul/Masaüstü/Projeler/ComputerGraphics/aaa.jpeg");
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        image = ImageIO.read(f);
        
        f = new File("/home/behlul/Masaüstü/Projeler/ComputerGraphics/aaa5.jpg");  //output file path
        ImageIO.write(image, "jpg", f);


    }
}
