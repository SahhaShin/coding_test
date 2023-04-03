import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<Student>[] stList;
	static int[] result;
	static int N;
	static int[] in;//내가 일을 처리하기 위해 거쳐야할 학생 수
	
	static class Student{
		int StudentNo;
		public Student(int StudentNo) {
			super();
			this.StudentNo = StudentNo;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //학생의 수
		int M = sc.nextInt(); //키 비교 횟수
		
		in = new int[N+1];
		
		//학생들의 키정보를 저장할 list
		stList = new ArrayList[N+1];//1번 학생부터 시작
		for(int i=0;i<N+1;i++) {
			stList[i]=new ArrayList<>();
		}
		
		//학생들 키 비교 입력받기
		for(int i=0;i<M;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			//A학생 뒤에 서는 B를 추가
			stList[A].add(new Student(B));
			
			in[B]++;//내 앞에 한 명 추가
		}
		
		//구현
		result = new int[N];
		StudentOrder();
		
		//결과출력
		for(int i=0;i<N;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * 1) 나보다 큰 사람이 없으면 즉, in이 0인 곳을 큐에 추가해준다.
	 * 2) 하나를 꺼내서 그 사람 뒤에오는 사람들 -1을 해준다.
	 * 3) 왜냐하면 지금 꺼낸 애 결과로 반영되었기 때문이다.
	 * */
	public static void StudentOrder() {
		Queue<Integer> q = new LinkedList<>();
		int idx=0;//결과 인덱스
		for(int i=1;i<=N;i++) {
			if(in[i]==0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			result[idx++]=curr;
			for(int i=0;i<stList[curr].size();i++) {
				int next = stList[curr].get(i).StudentNo;
				in[next]--;
				if(in[next]==0)q.add(next);
			}
		}
	}
}