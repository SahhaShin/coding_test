import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][16];

		//가장 긴 길이를 알아라 
		int max=0;
		for(int i=0;i<5;i++) {
			arr[i]=sc.next().toCharArray();
			if(max<arr[i].length) max=arr[i].length;
			
		}
		
		for(int i=0;i<max;i++) {
			for(int j=0;j<5;j++) {
				if(arr[j].length<(i+1)) continue;
				if(arr[j][i]!='\u0000') {
					System.out.print(arr[j][i]);
				}
			}
		}
	}

}
