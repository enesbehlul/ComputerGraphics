/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task11;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

/**
 *
 * @author behlul
 */
public class MedianFilter {

    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("/media/behlul/Dosyalarim/MedianFilter/original.gif");
        img = ImageIO.read(f);

        int width = img.getWidth();
        int height = img.getHeight();
        ArrayList<Integer> pixels = new ArrayList();
        int pixel;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                if (y + 3 <= height && x + 3 <= width) {
                    pixels.clear();
                    for (int i = y; i < y + 3; i++) {
                        for (int j = x; j < x + 3; j++) {
                            pixels.add(img.getRGB(j, i));
                        }
                    }
                    pixel = returnMedianPixel(pixels);
                    img.setRGB(x + 1, y + 1, pixel);
                }

            }
        }
        System.out.println("Median filter applied.");
        f = new File("/media/behlul/Dosyalarim/MedianFilter/medianFiltered.jpeg");  //output file path
        ImageIO.write(img, "jpeg", f);

    }

    public static int returnMedianPixel(ArrayList<Integer> pixels) {

        Collections.sort(pixels);
        int p = pixels.get(4);
        return p;
    }
}
