import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10451 {
	static int[] to;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			to = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				to[i] = Integer.parseInt(st.nextToken());
			}
			int cycle = 0;
			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					dfs(i);
					cycle++;
				}
			}
			System.out.println(cycle);
		}
	}

	static void dfs(int i) {
		visited[i] = true;

		int next = to[i];
		if (!visited[next])
			dfs(next);
	}
}
