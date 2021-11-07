#include "rect.h"
typedef struct  Rect{
int x;
int y;
}Rect;
Rect* rect_new (void){
Rect* this = malloc(sizeof(Rect));
}
void rect_drag (Rect* this, int dx, int dy){
this->x+=dx;
this->y+=dy;
}
void rect_print( Rect* this){
  printf("(%d,%d).\n",this->x,this->y);
}
