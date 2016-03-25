public class DLinkedList{
  
  private int _size;
  private DNode _header, _trailer; // refer to Dummy Nodes
  
  // constructor
  //O(1)
  public DLinkedList(){
    _size = 0;
    _header = new DNode(null, null, null);
    _trailer = new DNode(null, _header, null);
    _header.setNext(_trailer);
  }
  
  //O(1)
  // postcondition : returns the size of the list
  public int size(){
    return _size;
  }
  
  //O(1)
  // postcondition: return true if the list is empty false otherwise
  public boolean isEmpty(){
    return size() == 0;
  }
  //O(1)
  public boolean hasPrevious(DNode v){
    return v != _header;
  }
  //O(1)
  public boolean hasNext(DNode v){
    return v != _trailer;
  }
  //O(1)
  // postcondition: returns the first node in the list
  // throws an IllegalStateException if the list is empty.
  public DNode getFirst(){
    if (isEmpty()) throw new IllegalStateException();
    return _header.getNext(); 
  }
  
  //O(1)
  // postcondition: returns the last node in the list
  // throws an IllegalStateException if the list is empty
  public DNode getLast(){
    if (isEmpty()) throw new IllegalStateException();
    return _trailer.getPrevious();
  }
  
  //O(1)
  // returns the node before current
  // throws Illegal Argument Exception if current == _header
  public DNode getPrevious(DNode current){
    if (current == _header) 
      throw new IllegalArgumentException("cannot move back of header");
    return current.getPrevious();
  }
  
  //O(1)
  // returns the node after current
  // throws Illegal Arguement Exception if current == _trailer
  public DNode getNext(DNode current){
    if (current == _trailer)
      throw new IllegalArgumentException("cannot move forward of trailer");
    return current.getNext();
  }
  
  //O(1)
  // precondition : b refers to a node in the list
  //                Throws an exception if b refers to the _header
  // postcondtion: inserts node a before node b
  public void addBefore(DNode b, DNode a){
    if (b == _header) throw new IllegalArgumentException("cannot insert before header");
    a.setNext(b);
    a.setPrevious(getPrevious(b));
    b.setPrevious(a);
    a.getPrevious().setNext(a);
    _size++;
  }
  
  //O(1)
  public void addLast(DNode x){
    addBefore(_trailer,x);
  }
  
  //O(1)
  public void addLast(String value){
    addLast(new DNode(value,null,null));
  }
  
  
  //O(n)
  public String toString(){
    String ans = "[ ";
    DNode current = _header.getNext();
    while (current != _trailer){
      ans += current + ", ";
      current = current.getNext();
    }
    int len = ans.length();
    ans = ans.substring(0,len - 2);
    ans += "]";
    return ans;
  }
  //*******************************************************************
  //O(1)
  // inserts node b after node a
  // throw exception if a is the trailer node
  public void addAfter(DNode a, DNode b){
    if ( a == _trailer)
      throw new IllegalArgumentException();
    b.setNext(a.getNext());
    b.setPrevious(a);
    a.setNext(b);
    b.getNext().setPrevious(b);
    _size++;
  }
  
  //O(1)
  public void addFirst(DNode current){
    addAfter(_header,current);
  }
  
  //O(1)
  public void addFirst(String value){
    addFirst(new DNode(value,null,null));
  }
  // O(n)
  //*******************************************************************
  // postcondition: returns the ith String in the list.
  //                get(0) is the first string
  //                get(size() - 1) is the last string
  //                Throw an exception if index < 0 || index >= size()
  public String get(int i){
    if (i < 0 || i >= size())
      throw new IndexOutOfBoundsException();
    DNode t;
    if (i < size() / 2){
      t = getFirst();
      for (int a = 0 ; a < i; a++)
        t =  t.getNext();
    }
    else{
      t = getLast();
      for (int a = size() - 1; a > i; a--)
        t = t.getPrevious();
    }
    return t.getValue();
  }
  //O(1)
  public void remove(DNode v){
    DNode before=getPrevious(v);
    DNode after=getNext(v);
    before.setNext(after);
    after.setPrevious(before);
    v.setNext(null);
    v.setPrevious(null);
    _size--;
  }
  //O(1)
  public String removeFirst(){
    DNode first=getFirst();
    remove(first);
    return first.getValue();
  }
  
  //O(n)
  public DNode removeMiddle(){
    if (isEmpty()) throw new IllegalArgumentException();
    return middleNode(getNext(_header), getPrevious(_trailer));
  }
  
  //O(n)
  public DNode middleNode(DNode front, DNode back){
    if (front==back || getNext(front)==back)
      return back;
    return middleNode(getNext(front), getPrevious(back));
  }
  
  //O(1)
  public void swap(DNode x, DNode y){
    DNode prevX=getPrevious(x);
    DNode afterX=getNext(x);
    DNode prevY=getPrevious(y);
    DNode afterY=getNext(y);
    x.setPrevious(prevY);
    x.setNext(afterY);
    prevY.setNext(x);
    y.setPrevious(prevX);
    y.setNext(afterX);
    prevX.setNext(y);
    afterX.setPrevious(y);
    
  }
  
  public static void main(String [] args){
    DLinkedList L = new DLinkedList();
    System.out.println(L);   // []
    L.addLast("Jane");
    System.out.println(L); // [Jane ]
    L.addLast("Mark");
    System.out.println(L); // [Jane, Mark]
    L.addFirst("Carol");
    System.out.println(L); // [Carol, Jane, Mark]
    L.addFirst("Abe");
    System.out.println(L); // [Abe, Carol, Jane, Mark]
    
    // O(n*n)
    for(int i = 0; i < L.size(); i++){
      System.out.println(L.get(i));
    }
    System.out.println(L.removeMiddle());
    System.out.println();
    
    for(int i = 0; i < L.size(); i++){
      System.out.println(L.get(i));
    }
    
  }
  
}
