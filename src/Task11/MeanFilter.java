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
import javax.imageio.ImageIO;

/**
 *
 * @author behlul
 */
public class MeanFilter {

    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("/media/behlul/Dosyalarim/MeanFilter/original.gif");
        img = ImageIO.read(f);

        int width = img.getWidth();
        int height = img.getHeight();
        ArrayList<Integer> pixels = new ArrayList<>();
        int p;
        for (int x = 1; x < width - 1; x++) {
            for (int y = 1; y < height - 1; y++) {
                pixels.clear();
                pixels.add(img.getRGB(x - 1, y - 1));
                pixels.add(img.getRGB(x - 1, y));
                pixels.add(img.getRGB(x - 1, y + 1));
                pixels.add(img.getRGB(x, y - 1));
                pixels.add(img.getRGB(x, y));
                pixels.add(img.getRGB(x, y + 1));
                pixels.add(img.getRGB(x + 1, y - 1));
                pixels.add(img.getRGB(x + 1, y));
                pixels.add(img.getRGB(x + 1, y + 1));
                
                p = returnAvaregePixel(pixels);
                img.setRGB(x, y, p);
            }
        }
        System.out.println("Mean filter applied.");
        f = new File("/media/behlul/Dosyalarim/MeanFilter/meanFiltered.jpeg");  //output file path
        ImageIO.write(img, "jpeg", f);

    }

    public static int returnAvaregePixel(ArrayList<Integer> pixels) {
        int sumA = 0, sumR = 0, sumG = 0, sumB = 0;
        int p;
        for (int i = 0; i < pixels.size(); i++) {
            sumA += (pixels.get(i) >> 24) & 0xff;
            sumR += (pixels.get(i) >> 16) & 0xff;
            sumG += (pixels.get(i) >> 8) & 0xff;
            sumB += pixels.get(i) & 0xff;
        }
        p = (sumA/9 << 24) | (sumR/9 << 16) | (sumG/9 << 8) | sumB/9;
        return p;
    }
}
