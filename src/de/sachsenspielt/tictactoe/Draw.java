package de.sachsenspielt.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class Draw extends JLabel {

    int[] f = Main.Fields;

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        ImageIcon pg = new ImageIcon("playground.png");

        g.drawImage(pg.getImage(), 0, 0, null);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 647, 649);

        g.setColor(Color.CYAN);
        g.fillRect(0, 650, 650, 250);

        repaint();

        //for(int i1 = 0; i1 <= 8; i1++) {
          //  if(f[i1] == 1) {
            //    g.setColor(Color.CYAN);
              //  g.fillRect(250, 0, 650, 250);
                //repaint();
            //}

            //System.out.println(i1);

            //if(i1 == 8) {
              //  i1 = -1;
            //}
        //}
    }



}
