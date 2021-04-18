import java.util.*;
public class Main
{
    
    public static int convert(char[] temp){
        int number1=temp[0]-'0';
        int number2=temp[1]-'0';
        
        return number1*10+number2;
    }
  public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      System.out.println("Lift Positions");
      String x=scan.nextLine();
      int n=x.length();
      
      int arr[]=new int[6];
      int arr_track=0;
      char temp[]=new char[2];
      int  temp_i=0;
      boolean flag=false;
      int number;
      for(int i=0;i<n;i++){
          if(x.charAt(i)==','){
              if(temp_i==2){
                  flag=true;
                  number=convert(temp);
                  arr[arr_track++]=number;
              }
              if(temp_i==1){
                  arr[arr_track++]=temp[0]-'0';
              }
              temp_i=0;
              continue;
          }
          if(x.charAt(i)=='G'){
              temp[temp_i++]='0';
              continue;
          }
          temp[temp_i]=x.charAt(i);
          temp_i++;
      }
      System.out.println("Enter your floor number:");
      int floor=scan.nextInt();
      int MIN=13;
      int i=0;
      int store=0;
      for(int y:arr){
          int diff=Math.abs(floor-y);
          if(diff<MIN){
              MIN=diff;
              store=i+1;
          }
          i++;
      }
      System.out.println("Nearest Lift number:"+store);
  }
}
