import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int w=Integer.parseInt(st1.nextToken());
		int h=Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st2.nextToken());
		int y= Integer.parseInt(st2.nextToken());
		
		int count = Integer.parseInt(br.readLine());
		
		if(((x+count)/w)%2==1) x = w-((x+count)%w);
		else x = (x+count)%w;
		if(((y+count)/h)%2==1) y = h-((y+count)%h);
		else y = (y+count)%h;
		
		bw.write(x+" "+y);
		bw.flush();
		bw.close();
		br.close();
	}
}