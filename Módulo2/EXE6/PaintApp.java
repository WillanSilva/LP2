import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.Ellipse;
import figures.Rect;
import figures.Polygon;
class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Ellipse E1; Rect R2; Polygon P;
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
        this.E1 = new Ellipse(50,50, 50,30,0,255,0,0,1,0);
        this.R2 = new Rect(50,150, 80,30,0,1,0,0,255,0);
        int x[] = {150,300,275};/*um poligono qualquer*/
        int y[] = {230,250,275};
        this.P = new Polygon(x,y,3,0,80,0,255,255,0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.E1.paint(g);
        this.R2.paint(g);
        this.P.paint(g);
    }
}
