import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		// 1. test case
		int t = sc.nextInt();

		for (int T = 1; T < t + 1; T++) {
			int emp = 0;// 고용할 사람
			int curr = 0;// 현재 박수 치는 사람
			char[] clap_info = sc.next().toCharArray();// 11111
			for (int i = 0; i < clap_info.length; i++) {
				if (clap_info[i] != '0') {
					if (curr >= i)
						curr += clap_info[i] - '0';

					else {
						// 사람이 필요하다.
						emp += i - curr;
						curr += (i - curr) + (clap_info[i] - '0');// 현재 고용 필요수 + 고용하면 박수치는 사람 수 
					}
				}
			}
			System.out.println("#" + T + " " + emp);
		} // test case end
	}
}