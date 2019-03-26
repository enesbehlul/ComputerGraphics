/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author behlul
 */
public class jframeTest extends JFrame {
    
    
    
    public static void main(String[] args) {
        JFrame ekran = new JFrame("anan");

        ekran.setVisible(true);
        //ekran.setResizable(true);
        ekran.setSize(800, 600);
        ekran.setLocation(150, 150);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        //textField.setBounds(50, 100, 200, 30);
        
        textField.setVisible(true);
        ekran.add(textField);
        ekran.setVisible(true);
        
    }
}
