import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
	this.getContentPane().setBackground(Color.black); /*alteração 3: backgroud para black, get contentPane() é uma método de Jframe para "pegar" a janela para após, colocar a cor black*/
        this.setVisible(true);
	
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.green); /*alteração 1: g2d.setPaint(Color.blue) --> g2d.setPaint(Color.green), coloquei para verde todos os desenhos*/
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
	String nome="Antonio Willan";
	g2d.drawString(nome,140,150);/*alteração 4: coloquei meu nome no meio para diferenciar*/
        g2d.draw3DRect(150,150,50,60,false); /*alteração 2 -- adicionei retangulo, draw3drect é um método de Graphics2D*/
    }
}
