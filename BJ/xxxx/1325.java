import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1325 {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		count = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[B].add(A);
		}
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			count[i] = bfs(i);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < count[i]) {
				max = count[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (count[i] == max)
				sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	static int bfs(int i) {
		visited[i] = true;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(i);
		int c = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int a : arr[now]) {
				if (!visited[a]) {
					c++;
					queue.offer(a);
				}
			}
		}
		return c;
	}
}
