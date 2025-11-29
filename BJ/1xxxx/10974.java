import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10974 {
	static int[] res;
	static int N;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		res = new int[N];
		visited = new boolean[N + 1];
		backtracking(0);
		System.out.println(sb);
	}

	static void backtracking(int depth) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				res[depth] = i;
				visited[i] = true;
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}
}
