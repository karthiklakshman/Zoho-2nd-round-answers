import java.util.*;
public class Main
{
    public static void lift(Scanner scan,int a[])
    {
        System.out.println("Enter your floor number:");
        int floor=scan.nextInt();
        int flr=0,lift=1;
        flr=Math.abs(a[0]-floor);
        for(int i=1;i<6;i++)
        {
            int temp=Math.abs(a[i]-floor);
            if(temp<flr)
            {
                flr=temp;
                lift=i+1;
            }
        }
        a[lift-1]=floor;
        System.out.println("Current Lift Positions:");
        for(int i:a)
        {
            System.out.print(i+" ");
        }
        System.out.println("\nNearest Lift number:"+lift);
    }
    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Lift Positions");
        String s=scan.nextLine();
        s=s+",";
        int a[]=new int[6];
        int b=0;
        for(int i=0;i<s.length();)
        {
            int num=0,j=0;
            if(s.charAt(i)=='G')
            {
                a[b++]=0;
                i=i+2;
                continue;
            }
            for(j=i;s.charAt(j)!=',';j++)
            {
                num=num*10+(s.charAt(j)-'0');
            }
            a[b++]=num;
            i=j+1;
        }
        while(true)
        {
            System.out.println("1 - Start");
            System.out.println("2 - Exit");
            System.out.println("****Enter your choice:-****");
            int ch=scan.nextInt();
            switch(ch)
            {
                case 1:
                    lift(scan,a);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
  }
}
