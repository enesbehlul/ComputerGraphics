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
public class GetSetPixels {

    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("/media/behlul/Dosyalarim/aaa.jpeg");
        img = ImageIO.read(f);

        int width = img.getWidth();
        int height = img.getHeight();

        int p = img.getRGB(0, 0);

        int a;
        int r;
        int g;
        int b;
        System.out.println(height);
        Double rgb;
        int rgb2;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                p = img.getRGB(i, j);
                a = (p >> 24) & 0xff;
                r = (p >> 16) & 0xff;
                g = (p >> 8) & 0xff;
                b = p & 0xff;
                rgb = 0.2989 * r + 0.587 * g + 0.114 * b;
                rgb2 = rgb.intValue();
                p = (a << 24) | (rgb2 << 16) | (rgb2 << 8) | rgb2;
                img.setRGB(i, j, p);
            }
        }
        f = new File("/media/behlul/Dosyalarim/aaaGrey.jpeg");  //output file path
        ImageIO.write(img, "jpg", f);

    }
}
