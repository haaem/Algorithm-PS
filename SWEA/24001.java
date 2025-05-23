import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class SWEA24001
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String inst = br.readLine();
			int L = 0; int R = 0;
			char[] arr = inst.toCharArray();
			int position = 0;
			int maxL = 0;
			for (int i=0; i<inst.length(); i++) {
				if (arr[i] == 'R') {
					position++;
				} else {
					position--;
				}
				int dis = Math.abs(position);
				if (dis > maxL) maxL = dis;
			}
			int maxR = 0; position = 0;
			for (int i=0; i<inst.length(); i++) {
				if (arr[i] == 'L') {
					position--;
				} else {
					position++;
				}
				int dis = Math.abs(position);
				if (dis > maxR) maxR = dis;
			}
			System.out.println(Math.max(maxL, maxR));
		}
	}
}