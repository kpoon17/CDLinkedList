public class GNode{
  
  private GameEntry _entry;
  private GNode _previous,_next;
  
  //constructors
  public GNode(){
    _entry=new GameEntry("AAA",0);
    _previous=_next=null;
  }
  
  public GNode(GameEntry entry, GNode previous, GNode next){
    _entry=entry;
    _previous=previous;
    _next=next;
  }
  
    //accessor methods
  public GameEntry getEntry(){
    return _entry;
  }
  
  public GNode getPrevious(){
    return _previous;
  }
  
  public GNode getNext(){
    return _next;
  }  
  //modifer methods
  public GNode setPrevious(GNode newPrev){
    GNode ans=_previous;
    _previous=newPrev;
    return ans;
  }
  
  public GNode setNext(GNode newNext){
    GNode ans=_next;
    _next=newNext;
    return ans;
  }
  
  public String toString(){
    return _entry.toString();
  }
  
  /*public static void main(String [] args){
    GNode a=new GNode();
    GNode b= new GNode(GameEntry.randomEntry(3,100),a,null);
    GNode c= new GNode(GameEntry.randomEntry(3,100), b, null);
    a.setNext(b);
    b.setNext(c);
    GNode _current=a;
    while (_current!=null){
      System.out.println(_current);
      _current=_current.getNext();
    }
  }*/
  
  
}