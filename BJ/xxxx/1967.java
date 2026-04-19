import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1967 {
	static ArrayList<int[]>[] map;
	static int max, n, node;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(0);
			return;
		}

		StringTokenizer st;
		map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[p].add(new int[] { c, w });
			map[c].add(new int[] { p, w });
		}
		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0);

		visited = new boolean[n + 1];
		visited[node] = true;
		max = 0;
		dfs(node, 0);

		System.out.println(max);
	}

	static void dfs(int i, int w) {
		if (w > max) {
			max = w;
			node = i;
		}
		for (int[] arr : map[i]) {
			int a = arr[0];
			int weight = arr[1];
			if (!visited[a]) {
				visited[a] = true;
				dfs(a, w + weight);
			}
		}
	}
}
