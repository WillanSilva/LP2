import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.*;
import figures.Polygon;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Random;

public class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> fig = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus;
    int[] rgb = new int[3];
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
                    int [] x2Point=new int[5];
                    int [] y2Point=new int[5];
                    for (int i=0;i<3;++i){
                        xPoint[i]=rand.nextInt(350);
                        yPoint[i]=rand.nextInt(350);
                    }
                    for (int i=0;i<5;++i){
                        x2Point[i]=rand.nextInt(350);
                        y2Point[i]=rand.nextInt(350);
                    }
                    if (evt.getKeyChar() == 'r'  || evt.getKeyChar() == 'R' ) {
                        Rect retangulo = new Rect(x,y,w,h,r,g,b,r2,g2,b2);
                        fig.add(retangulo);
                    } else if (evt.getKeyChar() == 'e'  || evt.getKeyChar() == 'E' ) {
                        fig.add(new Ellipse(x,y,w,h,r,g,b,r2,g2,b2));
                    }
                    else if (evt.getKeyChar() == 't'  || evt.getKeyChar() == 'T' ) {
                        fig.add(new Triang(x,y,w,h,r,g,b,r2,g2,b2));
                    }
                    /*else if (evt.getKeyChar() == 'P'  || evt.getKeyChar() == 'p' ) {
                        fig.add(new Polygon(x2Point,y2Point,5,r,g,b,r2,g2,b2));
                    }*/
                    else if ((evt.getKeyChar() == 'd'  || evt.getKeyChar() == 'D' ) && focus!=null) {
                        fig.remove(focus);
                    }
                    else if ((evt.getKeyChar() == 'C'  || evt.getKeyChar() == 'c') &&focus!=null ) {
                        Scanner sc = new Scanner(System.in);
                          System.out.println("Digite os números(RGB):");
                          for(int i=0;i<3;i++){
                            rgb[i] = sc.nextInt();
                          }
                          focus.set_fundo(rgb);
                    }
                    repaint();
                }
            }
        );
        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    int x = evt.getX();
                    int y = evt.getY();
                    for (Figure cores1: fig) {
                        if (cores1.clicked(x,y)) {
                           focus=cores1;
                           rgb[0]=255; 
                           rgb[1]=0;
                           rgb[2]=0;
                           cores1.set_contorno(rgb);
                           repaint();
                        }
                        else{
                            rgb[0]=0;
                            rgb[1]=0;
                            rgb[2]=0;
                            cores1.set_contorno(rgb);
                        }
                    }
                }
            }
        );
        this.addMouseMotionListener(
            new MouseMotionAdapter(){
                public void mouseDragged(MouseEvent evt){
                    for(Figure cores: fig){
                        int dx = evt.getX();
                        int dy = evt.getY();
                        if(focus == cores){
                            cores.drag(dx,dy);
                            repaint();
                        }
                    }
                }
                public void mouseMoved(MouseEvent evt){
                    focus=null;
                }
            }

        );
        this.setTitle("Iterface IVisible");
        this.setSize(350, 350);
    }
    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.fig) {
            fig.paint(g);
        }
    }
}
