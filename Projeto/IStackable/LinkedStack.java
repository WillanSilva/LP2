class LinkedStack  extend LinkedList implements IStackable{
    l=new LinkedList();
    public int  size (void){
      return size.l;
    }       // quantos elementos
    public void push (int v){
      this.l.addFist();
    }  // empilha inteiro
    public int  pop  (void ){
      return l.removeFist();
    }
}
