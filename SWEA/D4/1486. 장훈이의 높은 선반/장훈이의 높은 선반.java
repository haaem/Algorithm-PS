import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B, ans;
	static int[] height;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			height = new int[N];
			for (int i = 0; i < N; i++)
				height[i] = Integer.parseInt(st.nextToken());

			ans = Integer.MAX_VALUE;
			subset(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void subset(int index, int sum) {
		if (sum >= B) {
			ans = Math.min(ans, sum - B);
			return;
		}

		if (index == N)
			return;

		subset(index + 1, sum);
		subset(index + 1, sum + height[index]);
	}
}