import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2644 {
	static int n, res;
	static ArrayList<Integer>[] relation;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		relation = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			relation[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x].add(y);
			relation[y].add(x);
		}
		res = -1;
		visited = new boolean[n + 1];
		dfs(a, b, 0);
		System.out.println(res);
	}

	static void dfs(int s, int e, int c) {
		if (s == e) {
			res = c;
			return;
		}
		visited[s] = true;
		for (int next : relation[s]) {
			if (!visited[next])
				dfs(next, e, c + 1);
		}
	}
}
