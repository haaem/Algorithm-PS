import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11725 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] lst = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			lst[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lst[a].add(b);
			lst[b].add(a);
		}

		int[] parent = new int[N + 1];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		queue.offer(1);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int a : lst[cur]) {
				if (!visited[a]) {
					visited[a] = true;
					parent[a] = cur;
					queue.offer(a);
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
}
