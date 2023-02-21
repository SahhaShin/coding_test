

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] cro= {"c=","c-","d-","lj","nj","s=","z=","dz="};
		char[] arr = sc.next().toCharArray();
		
		//크로아티아 1개당 몇 개 매치되는 게 있는지 확인 
		//매치되면 길이 저장 
		//크로아티아 모두 돌아가고 arr 총길이 - 매치길이 = 남은길이 를 result에 추가 
		int result=0;//크로아티아 갯수 
		int len=0;
		for(int i=0;i<cro.length;i++) {
			//매칭몇번?
			for(int j=0;j<arr.length-cro[i].length()+1;j++) {
				//매칭할 텍스트 정의
				String sb = new String();
				for(int k=0;k<cro[i].length();k++) {
					sb+=arr[k+j]; //ljes=njak 중 li -> je
				}
				if(cro[i].equals(sb)) {
					if(sb.equals("dz=")) {
						//z=도 맞아서 들어왔을 확률이 높다.
						//result로 추가해주진 않지만 글자수 +1을 해줘야 함
						len++;
					}
					else {
						result++;
						len+=sb.length();
					}
					
				}
			}
		}
		
		//크로아티아를 글자수를 제외한 남은 글자 더해줌 
		result+=arr.length-len;
		
		System.out.println(result);

	}//main end

}
