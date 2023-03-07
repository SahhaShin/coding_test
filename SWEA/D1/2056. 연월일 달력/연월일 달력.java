import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int T=1;T<t+1;T++){
        	String num = sc.next();
            int year = ((num.charAt(0)-'0')*1000+(num.charAt(1)-'0')*100+(num.charAt(2)-'0')*10+num.charAt(3)-'0');
            int month = ((num.charAt(4)-'0')*10+num.charAt(5)-'0');
            int day = ((num.charAt(6)-'0')*10+num.charAt(7))-'0';
            int flag=1;//가능 
            if(month<1 || month>12){
            	flag=0;
            }
            if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                if(day>31 || day<1){
                	flag=0;
                }
            }
            else if(month==2){
            	if(day>28 || day<1){
                	flag=0;
                }
            }
            
            else if(month==4 || month==6 || month==9 || month==11){
                if(day>30 || day<1){
                	flag=0;
                }
            }
            
            if(flag==0) System.out.println("#"+T+" -1");
            else System.out.printf("#%d %04d/%02d/%02d\n",T,year,month,day);
        }
    }
}