import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, ans, total;
	static int[] input, fact;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			input = new int[n];
			total = 0;
			fact = new int[n];
			fact[0] = 1;
			for (int i = 1; i < n; i++)
				fact[i] = fact[i - 1] * i;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				total += input[i];
			}

			visited = new boolean[n];
			ans = 0;

			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int depth, int left, int right) {
		if (depth == n) {
			ans++;
			return;
		}

		int remain = total - left - right;
		if (left >= remain + right) {
			int t = n - depth;
			ans += fact[t] * Math.pow(2, t);
			return;
		}

		for (int a = 0; a < n; a++) {
			if (!visited[a]) {
				visited[a] = true;
				dfs(depth + 1, left + input[a], right);
				if (right + input[a] <= left)
					dfs(depth + 1, left, right + input[a]);
				visited[a] = false;
			}
		}
	}
}