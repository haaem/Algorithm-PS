import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1707 {
	static int[] visited;
	static ArrayList<Integer>[] adj;
	static boolean possible;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		testcase: for (int tc = 0; tc < K; tc++) {
			HashSet<Integer> A = new HashSet<Integer>();
			HashSet<Integer> B = new HashSet<Integer>();
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			adj = new ArrayList[V + 1];
			possible = true;
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			visited = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				if (!possible)
					break;
				if (visited[i] == 0)
					bfs(i);
			}
			if (possible)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);
		visited[start] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : adj[cur]) {
				if (visited[next] == 0) {
					visited[next] = visited[cur] * -1; // HashSet보다 빠름
					queue.offer(next);
				} else if (visited[next] == visited[cur]) {
					possible = false;
					return;
				}
			}
		}
	}
}
