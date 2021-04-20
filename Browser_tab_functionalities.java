import java.util.regex.*;
import java.io.Serializable;
import java.io.*;
import java.util.*;
class ArrayList<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private T arr[];
    private Integer initial=0;

    public ArrayList(Class<T> d){
        this.arr = (T[]) java.lang.reflect.Array.newInstance(d,10);
    }
    public void add(T s){
        arr[initial++]=s;
        if(initial==arr.length){
            T tempArr[]=(T[]) java.lang.reflect.Array.newInstance(String.class,initial*2);
            for(int i=0;i<arr.length;i++){
                tempArr[i]=arr[i];
            }
            arr=tempArr;
        }
        System.gc();
    }
    public boolean displayAll(){
        if(initial==0)
        {
            return false;
        }
        for(T x:arr){
            if(x!=null)
            System.out.println(x);
        }
        return true;
    }
    public void remove(Integer x1){
        for(int i=x1;i<initial-1;i++){
            arr[i]=arr[i+1];
        }
        initial--;
    }
    public int length(){
        return initial;
    }
    public T get(Integer index){

          if(arr[index]!=null)
          {
              return arr[index];

          }
          return (T)"";
      }
    
      public boolean contains(T x){
          for(T temp :arr){
              if(x==temp){
                  return true;
              }
          }
          return false;
      }
      public void clearAll(){
        this.arr = (T[]) java.lang.reflect.Array.newInstance(String.class,10);
      }
}
public class Main   
{
  ArrayList<String> x =new ArrayList<>(String.class);
  ArrayList<String> y =new ArrayList<>(String.class);
  int curr=0;
  static String url;
  
  public static void visiturl(Main m) throws IOException
    {
        InputStreamReader temp0 =new InputStreamReader(System.in);
        BufferedReader b =new BufferedReader(temp0);
        System.out.println("Enter URL");
        m.url=b.readLine();
        
        
        if (!m.x.contains(m.url)) 
        {
            m.x.add(m.url);
            m.curr++;
        }
        
        System.out.println(m.url+" -->Your url is being visited!");
    }
    public static void isValidURL(String url)
    {
      if (url == null) {
            return;
      }
    String currurl = "((http|https)://)(www.)?"
      + "[a-zA-Z0-9@:%._\\+~#?&//=]"
      + "{2,256}\\.[a-z]"
      + "{2,6}\\b([-a-zA-Z0-9@:%"
      + "._\\+~#?&//=]*)";
    Pattern a = Pattern.compile(currurl);
    Matcher b = a.matcher(url);
    if(b.matches()){
        System.out.println("valid");
    }
    else{
        System.out.println("Not valid");
    }
  }
  public static void bookmarkurl(String url,Main m){
    m.y.add(url);
    System.out.println("Your url is bookmarked!!");
  }
  public static void goback(Main m){
      if(m.curr>=0){
          m.curr--;
          System.out.println(m.x.get(m.curr));
      }
  }
  public static void goforward(Main m){
      if(m.curr<m.x.length()-1){
          m.curr++;
          System.out.println(m.x.get(m.curr));
      }
  }
  public static void listhistory(Main m)
  {
      if(m.x.displayAll()==false){
          System.out.println("Your history is empty!");
      }
  }
  public static void clearhistory(Main m)
  {
      m.x.clearAll();
      System.out.println("Your browser history is cleared!!");
  }
  public static void bookmarkedhistory(Main m){
      System.out.println("Bookmarked Urls are:\n");
      if(m.y.displayAll()==false){
          System.out.println("Your history is empty!");
      }
  }
  public static void main(String[] args) {
    
    Main x=new Main();
    InputStreamReader temp0 =new InputStreamReader(System.in);
    BufferedReader b =new BufferedReader(temp0);
    // Scanner scan=new Scanner(System.in);
       
    try{ 
      while(true)
      {
        String url;
        System.out.println("1 - visitURL()");
        System.out.println("2 - validateURL()");
        System.out.println("3 - bookmarkURL()");
        System.out.println("4 - goBack()");
        System.out.println("5 - goForward()");
        System.out.println("6 - listHistory()");
        System.out.println("7 - clear History()");
        System.out.println("8 - listBookmarkedUrls()");
        System.out.println("9 - exit()");

        System.out.println("\n****Enter your choice****");
        int ch=Integer.parseInt(b.readLine());
        // int ch=scan.nextInt();
        switch(ch)
        {
            case 1:
                visiturl(x);
                break;
            case 2:
                isValidURL(x.url);
                break;
            case 3:
                bookmarkurl(x.url,x);
                break;
            case 4:
                goback(x);
                break;
            case 5:
                goforward(x);
                break;
            case 6:
                listhistory(x);
                break;
            case 7:
                clearhistory(x);
                break;
            case 8:
                bookmarkedhistory(x);
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        }
  }
  catch(IOException ex){
      System.out.println("Input Error");
  }
}
}
