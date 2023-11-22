import java.util.Scanner;
import java.util.PriorityQueue;

//(1 ≤ N ≤ 500,000, 2 ≤ P ≤ 300,000)
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//5
		int P = sc.nextInt();//15
		
		PriorityQueue<Node>[] touchList = new PriorityQueue[N];
		
		for(int i=0;i<N;i++){
			touchList[i] = new PriorityQueue<>();
		}
		
		//test case
		int result = 0; 

		for(int T=0;T<N;T++){
			int curLine = sc.nextInt();
			int curFlat = sc.nextInt();
			
			if(touchList[curLine].isEmpty()){//해당 라인의 터치가 없다면
				touchList[curLine].add(new Node(curLine, curFlat));
				result++;
			}else{//터치가 있다면

				Node peek = touchList[curLine].peek();

				
				//라인에 현재 터치보다 큰 플랫이 있다면
				while (peek!=null && peek.flat>curFlat) {
					//손떼기
					touchList[curLine].poll();
					result++;
					peek = touchList[curLine].peek();
				}

				//손 댈 수 있는 상황 만들고,

				//내가 누르려고 하는 터치와 플랫이 같다면 그냥 넘기기
				if(peek!=null && peek.flat==curFlat) continue;

				//작거나 아예 없다면 그냥 넣어도 됨
				//손대기
				touchList[curLine].add(new Node(curLine, curFlat));
				result++;

			}			
			
		}//for end

		System.out.println(result);
		
	}
	
	public static class Node implements Comparable<Node>{
		int line;
		int flat;
		
		public Node(int line, int flat){
			this.line = line;
			this.flat = flat;
		}
		
		@Override
		public int compareTo(Node o){
			return this.flat<o.flat?1:-1;
		}
	}
	

}