class  coneAp{
    public static void main(String[] args) {
        cone novo=new cone(150,150,50,50,50, 60);
        novo.print();
    }
}
    class cone{
        int x;
        int y; 
        int weigth; int height; int length ;float raio;
        cone(int x, int y, int w, int h, int l,float r){ /*consrutor*/
            this.x=x;
            this.y=y;
            this.weigth=w; 
            this.height=h;
            this.length=l;
            this.raio=r;

        }
        public void print(){
            System.out.format("Cone de tamanho(%d,%d)\nNa posição (%d,%d,%d)\nCom Raio: %f",this.x,this.y, this.weigth,
            this.height,
            this.length,
            this.raio);
        }

    }
