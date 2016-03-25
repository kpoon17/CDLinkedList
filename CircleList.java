public class CircleList{
  
  private Node _cursor;
  private int _size;
  
  //constructor
  public CircleList(){
    _cursor= null;
    _size=0;
  }
  
  public int size(){
    return _size;
  }
  
  public boolean isEmpty(){
    return _size==0;
  }
  
  public Node getCursor(){
    return _cursor;
  }
  
  public void add(Node newNode){
    if (size()==0){
      _cursor=newNode;
      newNode.setNext(_cursor);
    }
    else{
      newNode.setNext(_cursor.setNext(newNode)); 
      //^^reports back what cursor used to point to after setting the next to newNode
      //newNode next is then set to what used to be there so that newNode is inserted inbetween the two nodes
    }
    _size++;
  }
  
  public void advance(){
    _cursor=_cursor.getNext();
  }
  
  //removes node after cursor
  public Node remove(){
    Node ans=_cursor.getNext();
    if (size()==1)
      _cursor=null;
    else{
      _cursor.setNext(ans.getNext());
      ans.setNext(null);
    }
    _size--;    
    return ans;
  }
  
  public String toString(){
    String ans = "";
    Node t = _cursor;
    for (int i = 0; i < size(); i++){
      ans += t + ", ";
      t = t.getNext();
    } 
    int len = ans.length();
    if (len > 0) ans = ans.substring(0,len - 2);
    return "[" + ans + "]";
  }
  
  public static void main(String [] args){
    CircleList L= new CircleList();
    System.out.println(L.size());
    System.out.println(L.getCursor());
    System.out.println(L.isEmpty());
    L.add(new Node("Abe",null));
    System.out.println(L);
    L.add(new Node("Betty",null));
    System.out.println(L);
    L.advance();
    L.add(new Node("Ada",null));
    System.out.println(L);
    System.out.println(L.remove());
    System.out.println(L);
  }
  
}
