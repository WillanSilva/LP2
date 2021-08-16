#include <stdio.h>
typedef struct 
{
    int x;
    int y;
    int w; 
    int h; /*width height and length*/
    int l;
    float raio; /*para a circurferencia*/
    int r,g,b; /*Adicional para a a cor */
}cilindro;
int print(cilindro*s){
    printf("Cilíndro de tamanho(%d,%d,%d)\nNa posição (%d,%d)\nCom Raio: %f\nE com as cores: r=%d, g=%d ,b=%d \n",
    s->x,s->y,s->w,s->h,s->l,s->raio,s->r,s->g,s->b);
}
 int main(void){
    cilindro eae={150,150,150,50,50,3.4,4,5,8};
    print(&eae);
 }

