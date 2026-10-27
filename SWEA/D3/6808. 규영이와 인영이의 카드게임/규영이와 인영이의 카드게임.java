import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] first, second;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			first = new int[9];
			boolean[] used = new boolean[19];
			for (int i = 0; i < 9; i++) {
				first[i] = Integer.parseInt(st.nextToken());
				used[first[i]] = true;
			}

			second = new int[9];
			int idx = 0;
			for (int n = 1; n <= 18; n++)
				if (!used[n])
					second[idx++] = n;

			answer = new int[2];
			visited = new boolean[9];

			dfs(0, 0, 0);

			System.out.println("#" + tc + " " + answer[0] + " " + answer[1]);
		}
	}

	static void dfs(int depth, int a, int b) {
		if (depth == 9) {
			if (a > b)
				answer[0]++;
			else if (a < b)
				answer[1]++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int point = first[depth] + second[i];

				if (first[depth] > second[i])
					dfs(depth + 1, a + point, b);
				else
					dfs(depth + 1, a, b + point);
				visited[i] = false;
			}
		}
	}
}