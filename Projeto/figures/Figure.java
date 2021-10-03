package figures;  

import java.awt.Graphics;

public abstract class Figure{
    protected int x, y;
    protected int w, h;
    protected int r,g,b; /*cor de fundo*/
    protected int r2, g2, b2;/*cor da linha*/
    public Figure(int x, int y, int w, int h,int r, int g, int b,int r2, int g2, int b2){
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
   /*para o Polygon*/ 
    public Figure(int r, int g, int b,int r2, int g2, int b2){
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;

    }
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    public abstract void paint(Graphics g);
}
