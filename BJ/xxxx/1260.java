import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ1260 {
	static HashMap<Integer, TreeSet<Integer>> graph;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new HashMap<Integer, TreeSet<Integer>>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.putIfAbsent(a, new TreeSet<Integer>());
			graph.get(a).add(b);
			graph.putIfAbsent(b, new TreeSet<Integer>());
			graph.get(b).add(a);
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		sb.append(v).append(" ");
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (graph.get(cur) == null) {
				return;
			}
			for (int a : graph.get(cur)) {
				if (!visited[a]) {
					visited[a] = true;
					sb.append(a).append(" ");
					queue.add(a);
				}
			}
		}
	}

	private static void dfs(int v) {
		if (visited[v])
			return;
		visited[v] = true;
		sb.append(v).append(" ");
		if (graph.get(v) == null)
			return;
		for (int a : graph.get(v)) {
			if (!visited[a]) {
				dfs(a);
			}
		}
	}
}
