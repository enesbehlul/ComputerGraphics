/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author behlul
 */
public class Drawing extends JPanel implements MouseListener {

    GeneralPath p = new GeneralPath();
    JTextField xField = new JTextField(5);
    JTextField yField = new JTextField(5);
    JTextField widthField = new JTextField(5);
    JTextField heightField = new JTextField(5);
    JPanel optionPanePanel = new JPanel();
    JFrame frame = new JFrame("Ahmet");
    JButton btnLine = new JButton("Line");
    JButton btnCircle = new JButton("Circle");
    JButton btnRectangle = new JButton("Rectange");
    int whichButton, x, x2, y, y2, counter, radius, width, height;

    public Drawing() {
        whichButton = 0;
        counter = 0;
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.add(this);
        frame.setVisible(true);
        this.setBorder(new EmptyBorder(400, 10, 10, 10));
        this.add(btnLine);
        this.add(btnCircle);
        this.add(btnRectangle);
        //to show multiple input box in jOptionPane
        optionPanePanel.add(new JLabel("x:"));
        optionPanePanel.add(xField);
        optionPanePanel.add(new JLabel("y:"));
        optionPanePanel.add(yField);
        optionPanePanel.add(new JLabel("Width:"));
        optionPanePanel.add(widthField);
        optionPanePanel.add(new JLabel("Height:"));
        optionPanePanel.add(heightField);

        btnLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                whichButton = 1;
                repaint();
            }
        });

        btnCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                whichButton = 2;
                radius = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter radius"));
                repaint();
            }
        });

        btnRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                whichButton = 3;
                int result = JOptionPane.showConfirmDialog(null, optionPanePanel,
                        "Please Enter The Values", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    x = Integer.parseInt(xField.getText());
                    y = Integer.parseInt(yField.getText());
                    height = Integer.parseInt(heightField.getText());
                    width = Integer.parseInt(widthField.getText());
                    
                }
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                System.out.println("x:" + me.getX() + "y:" + me.getY());
                counter++;
                if (counter == 0) {
                    x = me.getX();
                    y = me.getY();
                    x2 = 0;
                    y2 = 0;
                } else {
                    if (counter % 2 != 0) {
                        x = me.getX();
                        y = me.getY();
                    } else {
                        x2 = me.getX();
                        y2 = me.getY();
                    }
                }
                repaint();
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        switch (whichButton) {
            case 1:
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x2, y2);
                break;
            case 2:
                g.drawOval(25, 25, radius, radius);
                break;
            case 3:

                g.drawRect(x, y, width, height);
                break;
            default:
                break;
        } 

    }

    public static void main(String[] args) {
        Drawing d = new Drawing();
        d.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
