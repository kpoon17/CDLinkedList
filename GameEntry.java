public class GameEntry implements Comparable<GameEntry>{



    private String _name;
    private int _score;

    public GameEntry(){
 _name = "AAA";
 _score = 0;
    }


    public GameEntry(String name, int score){
 _name = name;
 _score = score;
    }


    public int getScore(){
 return _score;
    }

    public String getName(){
 return _name;
    }


    public int compareTo(GameEntry rhs){
 int ans = getScore() - rhs.getScore();
 if (ans == 0)
     ans = getName().compareTo(rhs.getName());
 return ans;
    }

    public String toString(){
 return _name + ".........." + _score;
    }


    public static int randomScore(int max){
 return (int)(Math.random() * max);
    }
    
    public static String randomInitials(int len){
 String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String ans = "";
 for (int i = 0; i < len; i++){
     int r = randomScore(letters.length());
     ans += letters.substring(r,r+1);
 }
 return ans;
    }

    public static GameEntry randomEntry(int len, int max){
 return new GameEntry(randomInitials(len), randomScore(max));
    }


    public static void main(String [] args){
 GameEntry a = new GameEntry("Abe" ,0);
 GameEntry b = new GameEntry();
 System.out.println("a = " + a);
 System.out.println("b = " + b);
 System.out.println("a compared to b: " + a.compareTo(b));
    }



}
