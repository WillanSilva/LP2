#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
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

void ellipse_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
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
    printf("Polygon com as coordenadas x(%d,%d,%d) e y(%d,%d,%d) com %d vértices.\n",
           this->xPoint[0], this->xPoint[1],this->xPoint[2],this->yPoint[0],this->yPoint[1],this->yPoint[2],this->nPoint);
    printf("E com as cores: rg(%d,%d,%d) rg2(%d,%d,%d)",sup->bg.r,sup->bg.g,sup->bg.b,sup->fg.r,sup->fg.g,sup->fg.b);
}
int Polygon_area(Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}
Figure_vtable Polygon_vtable = {
    (Figure_Print) Polygon_print,
    (Figure_Area)  Polygon_area
};
Polygon* Polygon_new (int xPoint[3],int yPoint[3], int nPoints,int r, int g, int b,int r2, int g2, int b2) {
    Polygon* this = malloc(sizeof(Polygon));
    Figure* sup = (Figure*) this;
    sup->vtable = &Polygon_vtable;
    sup->x= xPoint[0];
    sup->y = yPoint[0];
    Color rb={r,g,b};
    Color rb2={r2,g2,b2};
    sup->bg=rb;
    sup->fg=rb2;
    for (int i = 0; i < 3; i++){
        this->xPoint[i]=xPoint[i];
        this->yPoint[i]= yPoint[i];
    }
    
    this->nPoint=nPoints;
}
///////////////////////////////////////////////////////////////////////////////
void main (void) {
    int xPoint[3]={89,54,77};
    int yPoint[3]={45,80,90};
    Figure* figs[5] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) Polygon_new(xPoint,yPoint,3,5,3,7,8,9,80)
    };

    ///

    for (int i=0; i<5; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (int i=0; i<5; i++) {
        free(figs[i]);
    }
}
