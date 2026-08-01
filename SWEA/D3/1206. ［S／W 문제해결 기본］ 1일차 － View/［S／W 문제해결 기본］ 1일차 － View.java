import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] building = new int[N];
			for (int i = 0; i < N; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int i = 2; i < N - 2; i++) {
				int min = 255;
				int now = building[i];
				min = Math.min(Math.min(now - building[i - 2], now - building[i - 1]),
						Math.min(now - building[i + 1], now - building[i + 2]));
				count += Math.max(min, 0);
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}