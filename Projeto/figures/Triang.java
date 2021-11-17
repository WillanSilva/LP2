package figures;
import java.awt.*;
public class Triang extends Figure{
    public Triang (int x, int y, int w, int h,int r, int g, int b,int r2, int g2, int b2) {
        super(x,y,w,h,r,g,b,r2,g2,b2);
    }
    public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g, boolean focused) {
        int [] xPoint= {this.w/2 + this.x, this.x,this.w + this.x};
        int [] yPoint= {this.y, this.y + this.h,this.y + this.h};
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(new Color(r,this.g,b));
        g2d.fillPolygon(xPoint, yPoint,3);
        g2d.setColor(new Color(r2,g2,b2));
        g2d.drawPolyline(xPoint,yPoint,3);
    }
}
