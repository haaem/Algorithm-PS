import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int total = 0;
			for (int i = 0; i < 10; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp % 2 == 1)
					total += temp;
			}
			System.out.println("#" + tc + " " + total);
		}
	}
}