import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			HashMap<Integer, HashSet<Integer>> map = new HashMap();
			HashSet<Integer> visited = new HashSet();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				map.putIfAbsent(from, new HashSet<>());
				map.get(from).add(to);
			}

			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { start, 0 });
			visited.add(start);
			int max = 0;
			int ans = 0;

			while (!q.isEmpty()) {
				int[] now = q.poll();

				if (map.containsKey(now[0])) {
					for (int a : map.get(now[0])) {
						if (!visited.contains(a)) {
							visited.add(a);
							if (now[1] + 1 > max || (now[1] + 1 == max && ans < a)) {
								max = now[1] + 1;
								ans = a;
							}

							q.offer(new int[] { a, now[1] + 1 });
						}
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}