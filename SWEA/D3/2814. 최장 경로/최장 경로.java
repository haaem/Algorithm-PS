import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static boolean[] visited;
	static int count;
	static List<Integer>[] lst;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			visited = new boolean[N + 1];
			count = 1;
			lst = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				lst[i] = new ArrayList<Integer>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				lst[a].add(b);
				lst[b].add(a);
			}

			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}

			System.out.println("#" + tc + " " + count);
		}
	}

	static void dfs(int start, int len) {
		count = Math.max(count, len);
		for (int next : lst[start]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, len + 1);
				visited[next] = false;
			}
		}
	}
}