/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author behlul
 */
class MyPanel extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        Point2D center = new Point2D.Float(0.0f, 0.0f);
        Line2D line = new Line2D.Float(center, center);
        GeneralPath p = new GeneralPath();
        p.moveTo(-100.0f, -25.0f);
        p.lineTo(100.0f, -25.0f);
        p.lineTo(-50.0f, 100.0f);
        p.lineTo(0.0f, -100.0f);
        p.lineTo(50.0f, 100.0f);
        p.closePath();
        g2.translate(200.0f, 200.0f);
        g2.rotate(3.14159f / 6.0f);
        g2.scale(2.0f, 2.0f);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(6.0f));
        g2.draw(line);
        g2.draw(p);
    }
}
