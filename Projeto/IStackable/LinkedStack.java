import java.util.*;  
class LinkedStack implements IStackable{
    LinkedList<Integer> l;
    public LinkedStack(){
      this.l=new LinkedList<>();
    }
    public int  size (){
      return l.size();
    }       // quantos elementos
    public void push (int v){
      l.addFirst(v);
    }  // empilha inteiro
    public int  pop (){
      return  l.removeFirst(); 
    }       // quantos elementos
    
}
