import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.*;
import figures.Polygon;

import java.util.ArrayList;
import java.util.Random;

class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> fig = new ArrayList<Figure>();
    Random rand = new Random();
    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int r=rand.nextInt(255);
                    int g=rand.nextInt(255);
                    int b=rand.nextInt(255);
                    int r2=rand.nextInt(255);
                    int g2=rand.nextInt(255);
                    int b2=rand.nextInt(255);
                    int [] xPoint=new int[3];
                    int [] yPoint=new int[3];
                    int p=3;
                    for (int i=0;i<3;++i){
                        xPoint[i]=rand.nextInt(350);
                        yPoint[i]=rand.nextInt(350);
                    }
                    if (evt.getKeyChar() == 'r'  || evt.getKeyChar() == 'R' ) {
                        Rect retangulo = new Rect(x,y,w,h,r,g,b,r2,g2,b2);
                        fig.add(retangulo);
                    } else if (evt.getKeyChar() == 'e'  || evt.getKeyChar() == 'E' ) {
                        fig.add(new Ellipse(x,y,w,h,r,g,b,r2,g2,b2));
                    }
                    else if (evt.getKeyChar() == 'P'  || evt.getKeyChar() == 'p' ) {
                        fig.add(new Polygon(xPoint,yPoint,p,r,g,b,r2,g2,b2));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.fig) {
            fig.paint(g);
        }
    }
}
