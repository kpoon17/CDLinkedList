public class GLinkedList{
  
  private GNode _cursor;
  private GNode _trailer;
  private int _size;
  
  //constructor
  public GLinkedList(){
    _cursor= new GNode(new GameEntry(), null,null);
    _trailer=new GNode(new GameEntry(), _cursor,_cursor);
    _cursor.setPrevious(_trailer);
    _cursor.setNext(_trailer);
    _size=0;
  }
  
  public int size(){
    return _size;
  }
  
  public boolean isEmpty(){
    return _size==0;
  }
  
  public GNode getFirst(){
    if (isEmpty()) throw new IllegalStateException();
    return _cursor.getNext();
  }
  
  public GNode getLast(){
    if (isEmpty()) throw new IllegalStateException();
    return _trailer.getPrevious();
  }
  
  public boolean hasNext(GNode v){
    return v != _trailer;
  }
  
  public void add(GNode newNode){
    if (size()==0){
      _cursor.setNext(newNode).setPrevious(newNode);
      newNode.setPrevious(_cursor);
      newNode.setNext(_trailer);
    }
    else{
      newNode.setNext(_cursor.setNext(newNode)); 
      newNode.setPrevious(_cursor);
    }
    _size++;
  }
  
  public void advance(){ //removes last node and inserts it in the front
    GNode curr=getLast();
    GNode newLast=getLast().getPrevious();
    GNode oldFirst=getFirst();
    
    newLast.setNext(_trailer).setNext(oldFirst);
    oldFirst.setPrevious(curr);
    curr.setPrevious(_cursor);
    _trailer.setPrevious(newLast);
  }
  
  //removes node after cursor
  public GNode remove(){
    GNode ans=_cursor.getNext();
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
    GNode t = _cursor;
    for (int i = 0; i < size(); i++){
      ans += t + ", ";
      t = t.getNext();
    } 
    int len = ans.length();
    if (len > 0) ans = ans.substring(0,len - 2);
    return "[" + ans + "]";
  }
  
  public static void main(String [] args){
    GLinkedList L= new GLinkedList();
    System.out.println(L.size());
   // System.out.println(L.getFirst());
    System.out.println(L.isEmpty());
    L.add(new GNode());
    System.out.println(L);
    L.add(new GNode(GameEntry.randomEntry(3,100),null,null));
    System.out.println(L);
    L.add(new GNode(GameEntry.randomEntry(3,100),null,null));
    System.out.println(L);
     L.advance();
    System.out.println(L);
     L.add(new GNode(GameEntry.randomEntry(3,100),null,null));
    System.out.println(L);
    //System.out.println(L.remove());
    //System.out.println(L);
  }
}
