import java.util.*;
import java.util.List;
class ArrayStack implements IStackable {
  List<Integer> l;
  public ArrayStack() {
    this.l = new ArrayList<Integer>();
  }

  public int size() {
    return l.size();
  } // quantos elementos

  public void push(int v) {
    l.add(v);
  } // empilha inteiro

  public int pop(){
    int a=l.get(l.size()-1);
    if (a!=0){
      l.remove(l.size()-1);
    }
    return a;
  } // quantos elementos

}
