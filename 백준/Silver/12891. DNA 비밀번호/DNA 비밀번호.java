import java.util.Scanner;

public class Main {

	static char[] dna;
	static int[] count;
	static int[] ok;
	static int S,P;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		S = sc.nextInt();
		P = sc.nextInt();
		
		dna = new char[S];
		
		dna = sc.next().toCharArray();
		
		count = new int[4];
		ok = new int[4];
		for(int i=0;i<4;i++) {
			count[i]=sc.nextInt();
		}
		
		int result = 0;
		for(int i=0;i<S-P+1;i++) {
			if(isok(i,i+P)) result++;
		}
		
		System.out.println(result);

	}
	
	public static boolean isok(int start, int end) {
		
		if(start==0) {
			for(int i=start;i<end;i++) {
				if(dna[i]=='A') ok[0]++;
				else if(dna[i]=='C')ok[1]++;
				else if(dna[i]=='G')ok[2]++;
				else if(dna[i]=='T')ok[3]++;
			}			
		}
		
		else {
			if(dna[start-1]=='A')ok[0]--;
			else if(dna[start-1]=='C')ok[1]--;
			else if(dna[start-1]=='G')ok[2]--;
			else if(dna[start-1]=='T')ok[3]--;
			
			if(dna[end-1]=='A')ok[0]++;
			else if(dna[end-1]=='C')ok[1]++;
			else if(dna[end-1]=='G')ok[2]++;
			else if(dna[end-1]=='T')ok[3]++;
		}
		if(ok[0]>=count[0] && ok[1]>=count[1] && ok[2]>=count[2] && ok[3]>=count[3]) {
			return true;
		}
		else return false;
	}

}