import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.*;
import figures.Polygon;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}
class ListFrame extends JFrame {
    ArrayList<Figure> fig = new ArrayList<Figure>();
    ArrayList<Button> buton = new ArrayList<Button>();
    Random rand = new Random();
    Figure focus=null;
    Button focus_b=null;
    int xmouse;
    int ymouse;
    int x;int y;
    int w;int h; int r,g,b; int r2,g2,b2;
    int[] rgb = new int[3];
    ListFrame () {
          try{
                FileInputStream f= new FileInputStream ("proj.bin");
                ObjectInputStream o = new ObjectInputStream(f);
                this.fig=(ArrayList<Figure>) o.readObject();
                o.close();
                } catch(Exception x){
                System.out.println("ERRO");
              }
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                  try{
                    FileOutputStream f= new FileOutputStream ("proj.bin");
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(fig);
                    o.flush();
                    o.close();
                  } catch(Exception x ){
                  }
                    System.exit(0);
                }
            }
        );
        buton.add(new Button(0,new Rect(0,0,0,0,0,0,0,0,0,0)));
        buton.add(new Button(1,new Ellipse(0, 0, 0, 0,0,0,0,0,0,0)));
        buton.add(new Button(2,new Triang(0, 0, 00, 0,0,0,0,0,0,0)));
        buton.add(new Button(3,new Losang(0, 0, 00, 0,0,0,0,0,0,0)));
        buton.add(new Button(4,new Rect(0, 0, 00, 0,0,0,0,0,0,0)));
        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    w = rand.nextInt(50);
                    h = rand.nextInt(50);
                    r=rand.nextInt(255);
                    g=rand.nextInt(255);
                    b=rand.nextInt(255);
                    r2=rand.nextInt(255);
                    g2=rand.nextInt(255);
                    b2=rand.nextInt(255);
                    focus=null;
                    xmouse = evt.getX();
                    ymouse = evt.getY();
                    int indx=0;
                    for (Figure cores1: fig) {
                        if (cores1.clicked(xmouse,ymouse)) {
                           indx=fig.indexOf(cores1);
                           //System.out.println(indx);
                           focus=cores1;
                           rgb[0]=0;
                          rgb[1]=0;
                          rgb[2]=0;
                          focus.set_contorno(rgb);
                        }
                        else{
                            rgb[0]=0;
                            rgb[1]=0;
                            rgb[2]=0;
                            cores1.set_contorno(rgb);
                        }
                  }
                  if(focus!=null){
                    rgb[0]=255; 
                    rgb[1]=0;
                    rgb[2]=0;
                    focus.set_contorno(rgb);
                  }
                  repaint();
                  for (Button but: buton) {
                    if(but.clicked(xmouse,ymouse)){
                      if(focus_b==null){focus_b=but;}
                      else{focus_b=null;}
                    }
                  }
                    if(focus_b!=null && focus_b.clicked(xmouse,ymouse)!=true){
                      if(focus_b.idx==0){
                      Rect retangulo = new Rect(xmouse,ymouse,w,h,r,g,b,r2,g2,b2);
                      fig.add(retangulo);
                      focus=fig.get(fig.size()-1);
                    }
                    else if(focus_b.idx==1){
                      fig.add(new Ellipse(xmouse,ymouse,w,h,r,g,b,r2,g2,b2));
                      focus=fig.get(fig.size()-1);
                    }
                    else if (focus_b.idx==2){
                      fig.add(new Triang(xmouse,ymouse,w,h,r,g,b,r2,g2,b2));
                      focus=fig.get(fig.size()-1);
                    }
                    else if (focus_b.idx==3){
                      fig.add(new Losang(xmouse,ymouse,w,h,r,g,b,r2,g2,b2));
                      focus=fig.get(fig.size()-1);
                    }
                    else if (focus_b.idx==4 && focus!=null){
                      fig.remove(focus);
                    }
                  }
                
                repaint();
            }
          }
        );
        this.addMouseMotionListener(
            new MouseMotionAdapter(){
                public void mouseDragged(MouseEvent evt){
                  int dx = evt.getX();
                  int dy = evt.getY();
                  if(focus != null){
                    focus.drag(dx-xmouse,dy-ymouse);
                    xmouse=dx;
                    ymouse=dy;
                    repaint();
                  }
                }
              public void mouseMoved(MouseEvent e){
                x=e.getX();
                y=e.getY();
              }
            }

        );
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
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
                     else if ((evt.getKeyChar() == 'L'  || evt.getKeyChar() == 'l' ) && focus!=null) {
                        fig.add(new Losang(x,y,w,h,r,g,b,r2,g2,b2));
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
        this.setTitle("Iterface IVisible");
        this.setSize(350, 350);
    }
    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.fig) {
            fig.paint(g,false);
        }
        for (Button but: this.buton) {
            but.paint(g,but==focus_b);
        }
    }
}
