import java.util.*;
import java.io.*;

public class Baekjoon1244 {
	
	//스위치 교체 메소드 
	public static int swiching(int switch_status) {
		if (switch_status == 0){
			switch_status=1;
		}
		else {
			switch_status=0;
		}
		
		return switch_status;
	}
	
	//대칭 유무 판별 
	public static int butterfly(int left, int right) {
		if(left==right) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
//		8 -> 스위치 개수 
//		0 1 0 1 0 0 0 1 -> 스위치상태 
//		2 -> 학생
//		1 3 -> 학생 성별 / 학생이 받은 스위치ㅣ 
//		2 3
		
		//전역변수
		int sex;
		int getSwitch;
		
		
		//입력받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int switch_count = Integer.parseInt(br.readLine());
		int[] switch_status=new int[switch_count+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<switch_count+1;i++) {
			switch_status[i]=Integer.parseInt(st.nextToken());
		}
		
		
		int student_number = Integer.parseInt(br.readLine());	
		
	
		
		//처리
		//학생수만큼 돌아가야함.
		for(int stu=1;stu<student_number+1;stu++) {
			StringTokenizer stu_info = new StringTokenizer(br.readLine()," ");
			sex = Integer.parseInt(stu_info.nextToken());
			getSwitch=Integer.parseInt(stu_info.nextToken());
			
			//남학생일 경우 == 1
			if(sex==1) {
				
				//자기받은 수와 그 수의  배수의 스위치 상태 변경
				for(int x=getSwitch;x<switch_count+1;x=x+getSwitch) {
					switch_status[x]=swiching(switch_status[x]);
				}
				
			}

			
			//여학생일 경우 
			else if(sex==2) {
				//자기자신은 무조건 변함.
				switch_status[getSwitch]=swiching(switch_status[getSwitch]);
				
				//자기받은 수의 좌우가 대칭이면 스위치 상태 변경
				
				for(int y=1;y<switch_count+1;y++) {
					
					//범위 제어해줘야함.
					if((getSwitch-y)<=0 || (getSwitch+y)>switch_count) {
						break;
					}
					else {
						int left=switch_status[getSwitch-y];
						int right=switch_status[getSwitch+y];
						//좌우 대칭이 맞지 않으면, 멈추기
						if(butterfly(left, right)==0) {
							break;
						}
						else {
							//좌우 대칭이 맞으면, 대칭인 곳은 변화시켜주기 
							switch_status[getSwitch-(y)]=swiching(left);
							switch_status[getSwitch+(y)]=swiching(right);
							continue;
						}
					}
				}

			}
			
			
		}

		br.close();
	
		
		//출력 
		
		for(int i=1;i<switch_count+1;i++) {
			
			System.out.print(switch_status[i]+" ");
//			40번 까지밖에 없을 때 이 코드가 프린트 위에 있으면 엔터찍힘.
			if(i%20==0) {
				System.out.println();
			}
			
			
		}
		
	

	}

}
