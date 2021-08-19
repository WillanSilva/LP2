public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10); 
        r1.print();
        System.out.println("area: "+r1.area());/*coloquei na tela para verificar*/
        r1.drag(20, 70); /*alterei a posição*/
        r1.print();
    }
} 
class Rect {
     int x, y;
     int w, h;
     Rect (int x, int y, int w, int h) {
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
     }
    int area(){
        int area=w*h;
        return area;
    }
    void drag (int dx, int dy){
        x=x+dx; /*poderia colocar o this.x mas o java já reconhece pois é um variável "global" na classe Rect*/
        y=dy+y; /*poderia colocar o this.y mas o java já reconhece pois é um variável "global" na classe Rect*/
    }
     void print () {
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this.w, this.h, this.x, this.y);
       }
}
