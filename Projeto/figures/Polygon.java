package figures;
import java.awt.*;
public class Polygon extends Figure{
    protected int[] xPoint,yPoint; /* a classe Polygon é diferente da demais portanto criei 2 construtor */
    protected int p;
    public Polygon(int[] xPoint,int[] yPoint, int nPoints,int r, int g, int b,int r2, int g2, int b2){
        super(r,g,b,r2,g2,b2);
        this.xPoint=xPoint;
        this.yPoint=yPoint;
        this.p=nPoints;
    }
    public void print () {
        System.out.format("na posicao (%d,%d) com %d pontos (vértices).\n",this.x, this.y,this.p);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(new Color(r,this.g,b));
        g2d.fillPolygon(this.xPoint, this.yPoint,this.p);
        g2d.setColor(new Color(r2,g2,b2));
        g2d.drawPolyline(this.xPoint,this.yPoint, this.p);
    }
}
