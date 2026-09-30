import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] cor = new int[200];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = (Integer.parseInt(st.nextToken()) - 1) / 2;
				int to = (Integer.parseInt(st.nextToken()) - 1) / 2;

				if (from > to) {
					int temp = from;
					from = to;
					to = temp;
				}
				for (int j = from; j <= to; j++)
					cor[j]++;
			}
			int max = 0;
			for (int i = 0; i < 200; i++)
				max = Math.max(max, cor[i]);
			System.out.println("#" + tc + " " + max);
		}
	}
}