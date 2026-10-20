import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] A;
	static int n, k, ans;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			A = new int[n];
			for (int i = 0; i < n; i++)
				A[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(A);
			ans = 0;
			dfs(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int sum, int depth) {
		if (sum > k)
			return;

		if (sum == k) {
			ans++;
			return;
		}

		if (depth >= n)
			return;

		dfs(sum + A[depth], depth + 1);
		dfs(sum, depth + 1);
	}
}