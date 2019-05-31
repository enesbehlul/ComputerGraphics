/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author behlul
 */
public class Mirroring {

    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("/media/behlul/Dosyalarim/aaa.jpeg");
        img = ImageIO.read(f);
        verticalMirror(img);
        horizontalMirror(img);
        rotateImage(img);
        String path = "/media/behlul/Dosyalarim/";
    }

    public static void verticalMirror(BufferedImage image) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        File f = null;
        System.out.println(width + " " + height);
        int x0 = width / 2;
        int x1 = width / 2 - 1;
        int pixel, symPixel, tempPixel;
        if (width % 2 == 0) {

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width / 2; j++) {
                    pixel = image.getRGB(x0 + j, i);
                    symPixel = image.getRGB(x1 - j, i);
                    tempPixel = pixel;
                    pixel = symPixel;
                    symPixel = tempPixel;
                    image.setRGB(x0 + j, i, pixel);
                    image.setRGB(x1 - j, i, symPixel);
                }
            }
        }
        f = new File("/media/behlul/Dosyalarim/vertical.jpg");
        ImageIO.write(image, "jpg", f);

    }

    public static void horizontalMirror(BufferedImage image) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        File f = null;
        System.out.println(width + " " + height);

        int y0 = height / 2;
        int y1 = y0 - 1;
        int pixel, symPixel, tempPixel;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height / 2; j++) {
                pixel = image.getRGB(i, j);
                symPixel = image.getRGB(width - 1 - i, height - 1 - j);
                tempPixel = pixel;
                pixel = symPixel;
                symPixel = tempPixel;
                image.setRGB(i, j, pixel);
                image.setRGB(width - 1 - i, height - 1 - j, symPixel);
            }
        }
        f = new File("/media/behlul/Dosyalarim/horizontal.jpg");
        ImageIO.write(image, "jpg", f);
    }

    private static void rotateImage(BufferedImage pic1) throws IOException {
        int width = pic1.getWidth(null);
        int height = pic1.getHeight(null);

        // point to rotate about center of image
        double x0 = 0.5 * (width - 1);
        double y0 = 0.5 * (height - 1);

        int sum = (int) (y0 + x0);
        int difference = (int) (y0 - x0);

        WritableRaster inRaster = pic1.getRaster();
        BufferedImage pic2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster outRaster = pic2.getRaster();
        int[] pixel = new int[3];

        // rotation
        int right = Math.min(width, height - difference);
        int bottom = Math.min(height, sum + 1);
        for (int x = Math.max(0, -difference); x < right; x++) {
            for (int y = Math.max(0, sum - width + 1); y < bottom; y++) {
                int xx = sum - y;
                int yy = difference + x;

                outRaster.setPixel(x, y, inRaster.getPixel(xx, yy, pixel));
            }
        }

        ImageIO.write(pic2, "jpg", new File("/media/behlul/Dosyalarim/aaaa.jpg"));
    }
}
