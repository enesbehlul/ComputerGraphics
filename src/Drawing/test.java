/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import javax.swing.JFrame;

/**
 *
 * @author behlul
 */
public class test {

    public static void main(String[] args) {
        MyPanel grafik = new MyPanel();

        JFrame ekran = new JFrame("Grafik Kullanımı");
        
        
        ekran.setVisible(true);
        ekran.setResizable(true);
        ekran.setSize(800, 600);
        ekran.setLocation(150,150);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X'e basılınca kapanması için.

        ekran.add(grafik);
        
    }
}
