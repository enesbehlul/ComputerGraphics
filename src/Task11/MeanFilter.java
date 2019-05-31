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
        int p = img.getRGB(0, 0);
        int sump = 0;
        int p1;
        int p2;
        int p3;
        int p4;
        int p5;
        int p6;
        int p7;
        int p8;
        int p9;
        System.out.println(height);
        for (int x = 1; x < width - 1; x++) {
            for (int y = 1; y < height - 1; y++) {
                pixels.clear();
                p1 = img.getRGB(x - 1, y - 1);
                p2 = img.getRGB(x - 1, y);
                p3 = img.getRGB(x - 1, y + 1);
                p4 = img.getRGB(x, y - 1);
                p5 = img.getRGB(x, y);
                p6 = img.getRGB(x, y + 1);
                p7 = img.getRGB(x + 1, y - 1);
                p8 = img.getRGB(x + 1, y);
                p9 = img.getRGB(x + 1, y + 1);
                pixels.add(p1);
                pixels.add(p2);
                pixels.add(p3);
                pixels.add(p4);
                pixels.add(p5);
                pixels.add(p6);
                pixels.add(p7);
                pixels.add(p8);
                pixels.add(p9);
                p = ret(pixels);
                img.setRGB(x, y, p);
            }
        }
        f = new File("/media/behlul/Dosyalarim/MeanFilter/meanFiltered.jpeg");  //output file path
        ImageIO.write(img, "jpeg", f);

    }

    public static int ret(ArrayList<Integer> pixels) {
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
