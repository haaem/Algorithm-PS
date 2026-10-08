import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		loop: for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				map.putIfAbsent(from, new ArrayList());
				map.get(from).add(to);
			}

			Queue<Integer> q = new ArrayDeque();
			boolean[] visited = new boolean[100];

			q.offer(0);
			visited[0] = true;

			while (!q.isEmpty()) {
				int now = q.poll();

				if (map.containsKey(now)) {
					for (int a = 0; a < map.get(now).size(); a++) {
						int next = map.get(now).get(a);

						if (next == 99) {
							System.out.println("#" + tc + " 1");
							continue loop;
						}

						if (!visited[next]) {
							visited[next] = true;
							q.offer(next);
						}
					}
				}
			}

			System.out.println("#" + tc + " 0");
		}
	}
}