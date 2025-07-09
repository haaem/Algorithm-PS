import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ24480 {
	static ArrayList<Integer>[] E;
	static int[] visited;
	static int order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		E = new ArrayList[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (E[a] == null) {
				E[a] = new ArrayList<Integer>();
			}
			E[a].add(b);
			if (E[b] == null) {
				E[b] = new ArrayList<Integer>();
			}
			E[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			if (E[i] != null) {
				Collections.sort(E[i], Collections.reverseOrder());
			}
		}
		order = 1;
		visited = new int[N + 1];
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
		if (E[k] == null)
			return;
		for (Object a : E[k]) {
			int t = (int) a;
			dfs(t);
		}
	}
}