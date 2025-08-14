import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16928 {
	static HashMap<Integer, Integer> move;
	static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[101];
		Arrays.fill(map, Integer.MAX_VALUE);
		move = new HashMap<>();
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			move.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		bfs();
		System.out.println(map[100]);
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(1);
		map[1] = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (move.containsKey(cur)) {
				int next = move.get(cur);
				if (map[next] > map[cur])
					map[next] = map[cur];
				queue.add(next);
				continue;
			}
			for (int i = 1; i <= 6; i++) {
				if (cur + i <= 100) {
					if (map[cur + i] > map[cur] + 1) {
						map[cur + i] = map[cur] + 1;
						queue.add(cur + i);
					}
				}
			}
		}
	}
}
