package komgraf;

import javax.swing.*;
import java.awt.*;

public class KomGraf extends JFrame {
    
    Container container;
    Graphics gg;
    LaunchGraf launchGraf;
    
    
    public KomGraf()
    {
        container = getContentPane();
        launchGraf = new LaunchGraf();
        container.add(launchGraf);
    }

    private static void FrameBaru() {
        final int RES_WIDTH = 1300;
        final int RES_HEIGHT = 750;
        KomGraf kg = new KomGraf();
        kg.setVisible(true);
        kg.setResizable(false);
        kg.setSize(RES_WIDTH, RES_HEIGHT);
        kg.setDefaultCloseOperation(EXIT_ON_CLOSE);
        kg.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {FrameBaru();}
    
}
