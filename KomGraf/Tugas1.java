import java.awt.Graphics;
import java.applet.Applet;
import java.awt.Color;

public class Tugas1 extends java.applet.Applet{
    public void paint (Graphics g) {
        g.setColor(Color.red);
        g.fillArc (100, 100, 300,300, 30, 150);
        g.setColor(Color.yellow);
        g.fillArc (270, 65, 220,220,181,30);
        
        
        g.setColor(Color.yellow);
        g.fillArc (100, 100, 300,300,210,180);
        g.setColor(Color.green);
        g.fillArc (140, 290, 220,220,60,30);
        
        g.setColor(Color.green);
        g.fillArc (100, 100, 300,300,135,136);
        g.setColor(Color.red);
        g.fillArc (33, 33, 220,220,287,30);
        
        g.setColor(Color.white);
        g.fillOval (175, 175, 150,150);
        g.setColor(Color.blue);
        g.fillOval (190, 190, 120,120);
    }
}