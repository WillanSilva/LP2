import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1; Rect r2; Rect r3;
    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,0,255,0,0,1,0);
        this.r2 = new Rect(50,150, 150,30,0,1,0,0,255,0);
        this.r3 = new Rect(50,250, 200,30,0,80,0,255,255,0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int r; int g; int b; /*cor de fundo*/
    int r2; int g2; int b2;/*cor da linha*/
    Rect (int x, int y, int w, int h,int r, int g, int b,int r2, int g2, int b2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(new Color(r,this.g,b));
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(r2,g2,b2));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
