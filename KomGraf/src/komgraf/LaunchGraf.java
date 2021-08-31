package komgraf;

import java.awt.*;
import java.applet.*;
import java.awt.geom.*;


public class LaunchGraf extends Applet{
    //Custom Color
    Color Maroon = new Color(189, 53, 53);
    Color Abu    = new Color(204, 204, 204);
    Color Cream  = new Color(255, 214, 163);
    Color GreeN = new Color(0,139,51);
//pembesaran
    int f = 25;
    
     public void paint(Graphics gg)
    {
        Graphics2D g = (Graphics2D) gg;
          
        //Background
        GradientPaint v3 = new GradientPaint(350,350, Color.DARK_GRAY,450, 650, Color.LIGHT_GRAY);
        g.setPaint(v3);
        g.fillRect(0,0,1300,750);
        
      
        //Percobaan Gradient Warna
        GradientPaint v2 = new GradientPaint(12*f, 10*f, Color.BLACK,16*f,26*f, Color.GRAY);
        GradientPaint v1 = new GradientPaint(12*f, 26*f, Color.LIGHT_GRAY,13*f,26*f, Color.GRAY);
        
        //background
        
        
        //membuat garis lebih tebal
        g.setStroke(new BasicStroke(2));
        
        // Pembuatan Character
        int x[] = {6*f,8*f,7*f};
        int y[] = {4*f,8*f,10*f};
        int p   = x.length;
        g.setPaint(v1);
        g.fillPolygon(x, y, p);
        g.setColor(Color.black);
        g.drawPolygon(x, y, p);
        
        int x1[] = {18*f,16*f,17*f};
        int y1[] = {4*f,8*f,10*f};
        int p1   = x1.length;
        g.setPaint(v1);
        g.fillPolygon(x1, y1, p1);
        g.setColor(Color.black);
        g.drawPolygon(x1, y1, p1);
        
        int x2[] = {9*f,12*f,15*f,16*f,12*f,8*f};
        int y2[] = {7*f,6*f,7*f,8*f,7*f,8*f};
        int p2   = x2.length;
        g.setPaint(v2);
        g.fillPolygon(x2, y2, p2);
        g.setColor(Color.black);
        g.drawPolygon(x2, y2, p2);
        
        int x3[] = {16*f,12*f,8*f,7*f,12*f,17*f};
        int y3[] = {8*f,7*f,8*f,10*f,12*f,10*f};
        int p3   = x3.length;
        g.setPaint(v1);
        g.fillPolygon(x3, y3, p3);
        g.setColor(Color.black);
        g.drawPolygon(x3, y3, p3);
        
        int x4[] = {17*f,12*f,7*f,8*f,12*f,16*f};
        int y4[] = {10*f,12*f,10*f,11*f,13*f,11*f};
        int p4   = x4.length;
        g.setColor(Color.GREEN);
        g.fillPolygon(x4, y4, p4);
        g.setColor(Color.black);
        g.drawPolygon(x4, y4, p4);
        
        int x5[] = {17*f,16*f,12*f,8*f,7*f,8*f,12*f,16*f};
        int y5[] = {10*f,11*f,13*f,11*f,10*f,330,15*f,13*f};
        int p5   = x5.length;
        g.setPaint(v1);
        g.fillPolygon(x5, y5, p5);
        g.setColor(Color.black);
        g.drawPolygon(x5, y5, p5);
        
        int x6[] = {8*f,12*f,16*f,15*f,12*f,9*f};
        int y6[] = {13*f,15*f,13*f,15*f,410,15*f};
        int p6   = x6.length;
        g.setPaint(v2);
        g.fillPolygon(x6, y6, p6);
        g.setColor(Color.black);
        g.drawPolygon(x6, y6, p6);
        
        int x7[] = {9*f,12*f,15*f,390,12*f,210,9*f};
        int y7[] = {15*f,410,15*f,16*f,18*f,16*f,15*f};
        int p7   = x7.length;
        g.setPaint(v1);
        g.fillPolygon(x7, y7, p7);
        g.setColor(Color.black);
        g.drawPolygon(x7, y7, p7);

        int x8[] = {7*f,210,8*f};
        int y8[] = {10*f,16*f,13*f};
        int p8   = x8.length;
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(x8, y8, p8);
        g.setColor(Color.black);
        g.drawPolygon(x8, y8, p8);
        
        int x9[] = {17*f,390,16*f};
        int y9[] = {10*f,16*f,13*f};
        int p9   = x9.length;
        g.setPaint(v1);
        g.fillPolygon(x9, y9, p9);
        g.setColor(Color.black);
        g.drawPolygon(x9, y9, p9);
        
        int x10[] = {390,16*f,15*f};
        int y10[] = {16*f,13*f,15*f};
        int p10   = x10.length;
        g.setPaint(v1);
        g.fillPolygon(x10, y10, p10);
        g.setColor(Color.black);
        g.drawPolygon(x10, y10, p10);
        
        int x11[] = {210,8*f,9*f};
        int y11[] = {16*f,13*f,15*f};
        int p11   = x11.length;
        g.setPaint(v1);
        g.fillPolygon(x11, y11, p11);
        g.setColor(Color.black);
        g.drawPolygon(x11, y11, p11);
        
        int x12[] = {10*f,12*f,14*f,14*f,12*f,10*f};
        int y12[] = {17*f,18*f,17*f,21*f,24*f,21*f};
        int p12   = x12.length;
        g.setPaint(Cream);
        g.fillPolygon(x12, y12, p12);
        g.setColor(Color.black);
        g.drawPolygon(x12, y12, p12);

        int x13[] = {10*f,8*f,12*f,10*f,10*f};
        int y13[] = {17*f,21*f,24*f,21*f,17*f};
        int p13   = x13.length;
        g.setPaint(Maroon);
        g.fillPolygon(x13, y13, p13);
        g.setColor(Color.black);
        g.drawPolygon(x13, y13, p13);
        
        int x14[] = {14*f,16*f,12*f,14*f,14*f};
        int y14[] = {17*f,21*f,24*f,21*f,17*f};
        int p14   = x14.length;
        g.setPaint(Maroon);
        g.fillPolygon(x14, y14, p14);
        g.setColor(Color.black);
        g.drawPolygon(x14, y14, p14);
        
        int x15[] = {7*f,12*f,8*f};
        int y15[] = {22*f,24*f,21*f};
        int p15   = x15.length;
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(x15, y15, p15);
        g.setColor(Color.black);
        g.drawPolygon(x15, y15, p15);
        
        int x16[] = {17*f,12*f,16*f};
        int y16[] = {22*f,24*f,21*f};
        int p16   = x16.length;
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(x16, y16, p16);
        g.setColor(Color.black);
        g.drawPolygon(x16, y16, p16);
        
        int x17[] = {4*f,7*f,12*f,17*f,20*f,12*f};
        int y17[] = {23*f,22*f,24*f,22*f,23*f,26*f};
        int p17   = x17.length;
        g.setColor(Color.GRAY);
        g.fillPolygon(x17, y17, p17);
        g.setColor(Color.black);
        g.drawPolygon(x17, y17, p17);
        
        // logo overwatch
        int posX = 650; //ubah koordinat x untuk semua Shape
        int posY = 100; //ubah koordinat y untuk semua Shape
        
        g.setColor(Color.white);
        g.fillOval(posX, posY, 500, 500);
        
        g.setColor(Color.black);
        g.fillArc(posX, posY, 500, 500, 30, -120);

        g.setColor(Color.black);
        g.fillArc(posX, posY, 500, 500, 150, 120);
        
        g.setColor(Color.orange);
        g.fillArc(posX, posY, 500, 500, 37, 105);

        g.setColor(Color.white);
        g.fillOval(70 + posX, 70 + posY, 360, 360);

        
        //properti untuk Polygon Logo
        final int offsetX = 42;//ubah offset x
        final int offsetY = 25;//ubah offset y
        final int s = 45;//ubah skala, hati-hati

        int logoX1[] = {3*s-offsetX +posX, 3*s-offsetX +posX, 6*s-offsetX +10 +posX, 6*s-offsetX +10 +posX, 5*s-offsetX +posX};
        int logoY1[] = {8*s-offsetY +posY, 10*s-offsetY +posY, 8*s-offsetY +posY, 4*s-offsetY +posY, 7*s-offsetY +posY};
        int logoP1 = logoX1.length;
        g.setColor(Color.black);
        g.fillPolygon(logoX1, logoY1, logoP1);

        int logoX2[] = {10*s-offsetX +posX, 10*s-offsetX +posX, 7*s-offsetX -10 +posX, 7*s-offsetX -10 +posX, 8*s-offsetX +posX};
        int logoY2[] = {8*s-offsetY +posY, 10*s-offsetY +posY, 8*s-offsetY +posY, 4*s-offsetY +posY, 7*s-offsetY +posY};
        int logoP2 = logoX2.length;
        g.setColor(Color.black);
        g.fillPolygon(logoX2, logoY2, logoP2);
        
          //Nama Character
        Font font = new Font("Franklin Gothic Medium Cond", Font.BOLD + Font.ITALIC, 72);
        FontMetrics fm = g.getFontMetrics(font);
        g.setColor(Color.WHITE);
        String str = " G E N J I ";
        g.setFont(font);
        g.drawString(str, 7*f, 3*f);
    }
}
