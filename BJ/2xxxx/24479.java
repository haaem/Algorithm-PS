import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ24479 {
	static HashMap<Integer, TreeSet<Integer>> map;
	static int[] visited;
	static int order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new int[N + 1];
		map = new HashMap<Integer, TreeSet<Integer>>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.computeIfAbsent(a, k -> new TreeSet<Integer>()).add(b);
			map.computeIfAbsent(b, k -> new TreeSet<Integer>()).add(a);
		}
		order = 1;
		dfs(R);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			bw.append(visited[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void dfs(int k) {
		if (visited[k] != 0)
			return;
		visited[k] = order++;
		if (!map.containsKey(k))
			return;
		for (Object v : map.get(k).toArray()) {
			int t = (int) v;
			dfs(t);
		}
	}
}
