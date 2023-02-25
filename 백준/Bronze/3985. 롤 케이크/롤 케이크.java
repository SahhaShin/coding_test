import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.케잌 수 / 방청객 수
		int cake = sc.nextInt();
		int cust = sc.nextInt();
		
		int[] count=new int[cake+1];
		int[] people=new int[cust+1];
		int max=0;
		int max_index=0;
		for(int i=1;i<cust+1;i++) {
			//2. 몇번부터 몇번까지 먹고싶니
			int start= sc.nextInt();
			int end = sc.nextInt();
			
			//3. 가장 많이 요청한 사람 
			if(max<(end-start+1)) {
				max=end-start+1;
				max_index=i;
			}
			
			//4. 실제로 많이 받은 사람 연산을 위한 저장 
			for(int j=start;j<=end;j++) {
				if(count[j]==0) {
					count[j]=i;
					people[i]++;
				}
			}
		
		}
		
		//5. 인원 수 중 누가 실제로 많이받았는가 
		int max_p = people[0];
		int max_idx_p=0;
		for(int i=1;i<=cust;i++) {
			if(people[i]>max_p) {
				max_p=people[i];
				max_idx_p=i;
			}
		}
		
		System.out.println(max_index);
		System.out.println(max_idx_p);

	}

}
