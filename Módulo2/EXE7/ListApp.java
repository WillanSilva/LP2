import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.*;
import java.util.ArrayList;
import java.util.Random;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rec = new ArrayList<Rect>();
    ArrayList<Ellipse> Eli = new ArrayList<Ellipse>();
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
                    if (evt.getKeyChar() == 'r') {
                        Rect retangulo = new Rect(x,y,w,h,r,g,b,r2,g2,b2);
                        rec.add(retangulo);
                    } else if (evt.getKeyChar() == 'e') {
                        Eli.add(new Ellipse(x,y,w,h,r,g,b,r2,g2,b2));
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
        for (Rect rec: this.rec) {
            rec.paint(g);
        }
        for (Ellipse Eli: this.Eli) {
            Eli.paint(g);
        }
    }
}
