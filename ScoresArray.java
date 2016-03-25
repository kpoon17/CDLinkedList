public class ScoresArray{
  
  private GameEntry [] _scores;
  
  //pre: N>0, n represents size of array
  //n game entries stored
  public ScoresArray(int n){
    _scores=new GameEntry[n];
    for (int i=0;i<n;i++){
      _scores[i]=new GameEntry();
    }
  }
  
  //uses above constructor
  //size of array is 10
  public ScoresArray(){
    this(10);
  }
  
  public int numScores(){
    return _scores.length;
  }
  
  public void initialize(int len,int maxScore){
    for (int i=0;i<_scores.length;i++){
      GameEntry entry=GameEntry.randomEntry(len,maxScore);
      if (addV2(entry))
        System.out.println("Adding..."+entry);
      else
        System.out.println(entry+" not added");
    }
  }
  

    //all cases O(n)
  public boolean addV1(GameEntry entry){
	boolean ans = false;
	for (int i = 0; i < _scores.length; i++){
	    if (entry.compareTo(_scores[i]) > 0){
		GameEntry t = _scores[i];
		_scores[i] = entry;
		ans = true;
		entry = t;
	    }
	}
	return ans;
    }

    //all cases O(n)
    public boolean addV2(GameEntry entry){
	for (int i = 0; i < _scores.length; i++){
	    if (entry.compareTo(_scores[i]) > 0){
		GameEntry t = _scores[i];
		_scores[i] = entry;
		while ( ++i < _scores.length){
		    entry = t;
		    t = _scores[i];
		    _scores[i] = entry;
		}
		return true;
	    }
	}
	return false;
    }

    //best case O(1) when entry too small else O(N)
    public boolean addV3(GameEntry entry){
	int N = _scores.length;
	if (entry.compareTo(_scores[N-1]) <= 0)
	    return false;
	for(int i = N-1; i > 0; i--){
	    _scores[i] = _scores[i-1];
	    if (entry.compareTo(_scores[i]) < 0){
		_scores[i] = entry;
		return true;
	    }
	}
	_scores[0] = entry;
	return true;
    }
  
  //modified binary search
  public boolean addBS(GameEntry entry){
    if (entry.compareTo(_scores[_scores.length-1])<=0)
      return false;
    int top=0;
    int bottom=_scores.length-1;
    int mid=_scores.length/2;
    while (top<bottom){
      if (entry.compareTo(_scores[mid])>0)
        bottom=mid-1;
      else
        top=mid+1;
      mid=(top+bottom)/2;
    }
    if(entry.compareTo(_scores[mid])<0)
      mid+=1; //so that mid is insertion point

    GameEntry temp=_scores[mid];
    _scores[mid]=entry;
    while ( ++mid < _scores.length){
	entry = temp;
	temp = _scores[mid];
	_scores[mid] = entry;
    }
    return true;
  }
  
  public String toString(){
    String ans="Rank\tInitials\tScore\n";
    for (int i=0;i<numScores();i++)
      ans+=(i+1)+".\t"+_scores[i]+"\n";
    return ans;
  }
  
  public static void main(String [] args){
    ScoresArray a=new ScoresArray();
    /*System.out.println(randomEntry(3,1000));
     System.out.println(a.add(new GameEntry("aaa",100)));
     System.out.println(a.add(new GameEntry("yyy",0)));
     System.out.println(a.add(new GameEntry("yyy",4)));
     
     System.out.println(a);*/
    a.initialize(3,1000);
    System.out.println(a);
    System.out.println(a.addBS(new GameEntry("AAA",1)));
    System.out.println(a);
  }
  
}
