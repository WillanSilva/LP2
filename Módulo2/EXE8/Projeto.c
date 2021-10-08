#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////
typedef struct {
    Figure super;
    int xPoint[3];
    int yPoint[3];
    int nPoint;
} Polygon;

void Polygon_print (Polygon* this) {
    Figure* sup = (Figure*) this;
    printf("Polygon com as coordenadas x(%d,%d,%d,%d) e y(%d,%d,%d,%d) com %d vértices.\n",
           sup->x, this->xPoint[1],this->xPoint[2],this->xPoint[3],sup->y,this->yPoint[1],this->yPoint[2],this->yPoint[3],this->nPoint);
    printf("E com as cores de fundo:  rg(%d,%d,%d) Contorno: rg2(%d,%d,%d)\n",sup->bg.r,sup->bg.g,sup->bg.b,sup->fg.r,sup->fg.g,sup->fg.b);
}
void polygon_perimetro(Polygon* this) {
    Figure* sup = (Figure*) this;
    int peri=0;
    for (int i=0; i<4; i++) {
        peri+=(this->xPoint[i])-(this->yPoint[i]);
        
    }
    if (peri<0){
        peri=peri*(-1);
    }
    printf("Perimetro: %d",peri);
}

Polygon* Polygon_new (int xPoint[4],int yPoint[4], int nPoints,int r, int g, int b,int r2, int g2, int b2) {
    Polygon* this = malloc(sizeof(Polygon));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Polygon_print;
    sup->x= xPoint[0];
    sup->y = yPoint[0];
    Color rb={r,g,b};
    Color rb2={r2,g2,b2};
    sup->bg=rb;
    sup->fg=rb2;
    for (int i = 0; i < 4; i++){
        this->xPoint[i]=xPoint[i];
        this->yPoint[i]= yPoint[i];
    }
    
    this->nPoint=nPoints;
}
///////////////////////////////////////////////////////////////////////////////
void main (void) {
    int xPoint[4]={4,5,92,3};
    int yPoint[4]={50,30,65,77};
    Figure* figs[5] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) Polygon_new(xPoint,yPoint,4,1,6,300,4,305,130)
    };

    ///

    for (int i=0; i<5; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<5; i++) {
        free(figs[i]);
    }
}
