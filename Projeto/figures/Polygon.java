package figures;
import java.awt.*;
public class Polygon {
    private int x[];
    private int y[];
    private int p;
    private int r,g,b; /*cor de fundo*/
    private int r2, g2, b2;/*cor da linha*/
    public Polygon(int[] x,int[] yPoints, int nPoints,int r, int g, int b,int r2, int g2, int b2){
        this.x=x;
        this.y=yPoints;
        this.p=nPoints;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }
    public void print () {
        System.out.format("na posicao (%d,%d) com %d pontos (vértices).\n",this.x, this.y,this.p);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(new Color(r,this.g,b));
        g2d.fillPolygon(this.x, this.y, this.p);
        g2d.setColor(new Color(r2,g2,b2));
        g2d.drawPolyline(this.x,this.y, this.p);
    }
}
