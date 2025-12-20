import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15663 {
	static int[] arr;
	static boolean[] visited;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		visited = new boolean[N];
		backtracking(0);
		System.out.println(sb);
	}

	static void backtracking(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before = 0;
		for (int i = 0; i < N; i++) {
			if (before == arr[i])
				continue;
			if (!visited[i]) {
				visited[i] = true;
				before = arr[i];
				res[depth] = arr[i];
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}
}
