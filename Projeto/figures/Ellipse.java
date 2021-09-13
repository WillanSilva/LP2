package figures;
import java.awt.*;
public class Ellipse extends Figure{
    public Ellipse(int x, int y, int w, int h,int r, int g, int b,int r2, int g2, int b2) {
        super(x,y,w,h,r,g,b,r2,g2,b2);
    }

    public void print () {
        System.out.format("Elipse de tamanho(%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(new Color(r,this.g,b));
        g2d.fillOval(this.x,this.y,this.w,this.h);
        g2d.setColor(new Color(r2,g2,b2));
        g2d.drawOval(this.x,this.y,this.w,this.h);
        
    }

}
