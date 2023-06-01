import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		char[] numbers = new char[count+1];
		
		numbers=sc.next().toCharArray();
		
		int result = 0;
		
		for(int i=0;i<count;i++) {
			result += numbers[i]-'0';
		}
		
		System.out.println(result);

	}

}