import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ9370 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
			int[] dis = new int[2001];
			Arrays.fill(dis, Integer.MAX_VALUE);

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				d *= 2;
				if ((a == g && b == h) || a == h && b == g)
					d--;
				map.putIfAbsent(a, new HashMap<Integer, Integer>());
				map.putIfAbsent(b, new HashMap<Integer, Integer>());
				map.get(a).put(b, d);
				map.get(b).put(a, d);
			}

			int[] candidate = new int[t];
			for (int i = 0; i < t; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(candidate);
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(s, 0));
			dis[s] = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				for (int next : map.get(cur.end).keySet()) {
					if (dis[next] <= cur.dist + map.get(cur.end).get(next))
						continue;
					dis[next] = cur.dist + map.get(cur.end).get(next);
					pq.add(new Node(next, dis[next]));
				}
			}

			for (int c : candidate) {
				if (dis[c] != Integer.MAX_VALUE && dis[c] % 2 == 1) {
					sb.append(c).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

class Node implements Comparable<Node> {
	int end, dist;

	Node(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		return this.dist - o.dist;
	}
}
