public class DNode{
  
  private String _value;
  private DNode _previous, _next;
  
  //constructor
  public DNode(String value, DNode previous, DNode next){
    _value=value;
    _previous=previous;
    _next=next;
  }
  
  //accessor methods
  public String getValue(){
    return _value;
  }
  
  public DNode getPrevious(){
    return _previous;
  }
  
  public DNode getNext(){
    return _next;
  }
  ///////////////////////////
  
  //modifer methods
  
  public String setValue(String newValue){
    String ans=_value;
    _value=newValue;
    return ans;
  }
  
  public DNode setPrevious(DNode newPrev){
    DNode ans=_previous;
    _previous=newPrev;
    return ans;
  }
  
  public DNode setNext(DNode newNext){
    DNode ans=_next;
    _next=newNext;
    return ans;
  }
  
  public String toString(){
    return _value;
  }
  
  public static void main(String [] args){
    DNode a= new DNode("Amy", null, null);
    DNode b= new DNode("Bill",a,null);
    DNode c= new DNode("Carol", b, null);
    a.setNext(b);
    b.setNext(c);
    DNode _current=a;
    while (_current!=null){
      System.out.println(_current);
      _current=_current.getNext();
    }
    
    a.setValue(c.setValue(a.getValue()));
    
    _current=a;
    while (_current!=null){
      System.out.println(_current);
      _current=_current.getNext();
    }
  }
  
}
