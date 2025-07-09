import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ24445 {

	static int[] visited;
	static int order;
	static HashMap<Integer, ArrayList<Integer>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.computeIfAbsent(a, k -> new ArrayList<Integer>()).add(b);
			map.computeIfAbsent(b, k -> new ArrayList<Integer>()).add(a);
		}
		for (int i = 1; i <= N; i++) {
			if (map.containsKey(i)) {
				Collections.sort(map.get(i), Collections.reverseOrder());
			}
		}
		visited = new int[N + 1];
		order = 1;
		bfs(R);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			bw.append(visited[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void bfs(int s) {
		visited[s] = order++;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		while (!queue.isEmpty()) {
			int a = queue.poll();
			if (!map.containsKey(a))
				continue;
			for (int t : map.get(a)) {
				if (visited[t] == 0) {
					visited[t] = order++;
					queue.add(t);
				}
			}
		}
	}
}
