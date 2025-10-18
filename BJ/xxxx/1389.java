import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1389 {
	static int N, M;
	static HashSet<Integer>[] set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new HashSet[N + 1];
		for (int i = 1; i <= N; i++) {
			set[i] = new HashSet<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			set[A].add(B);
			set[B].add(A);
		}
		int index = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int temp = bfs(i);
			if (temp < min) {
				min = temp;
				index = i;
			}
		}
		System.out.println(index);
	}

	static int bfs(int start) {
		int[] count = new int[N + 1];
		Arrays.fill(count, 0);
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { start, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int who = cur[0];
			int depth = cur[1];
			for (int i : set[who]) {
				if (count[i] == 0 && i != start) {
					count[i] = depth + 1;
					queue.offer(new int[] { i, depth + 1 });
				}
			}
		}
		int res = 0;
		for (int i : count) {
			res += i;
		}
		return res;
	}
}
