import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1504 {
	static HashMap<Integer, ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map.putIfAbsent(a, new ArrayList<Node>());
			map.get(a).add(new Node(b, c));
			map.putIfAbsent(b, new ArrayList<Node>());
			map.get(b).add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		long path1 = Integer.MAX_VALUE;
		long path2 = Integer.MAX_VALUE;

		int dist_1_v1 = dijstra(1, v1);
		int dist_1_v2 = dijstra(1, v2);
		int dist_v1_v2 = dijstra(v1, v2);
		int dist_v1_N = dijstra(v1, N);
		int dist_v2_N = dijstra(v2, N);

		if (dist_1_v1 != Integer.MAX_VALUE && dist_v1_v2 != Integer.MAX_VALUE && dist_v2_N != Integer.MAX_VALUE) {
			path1 = (long) dist_1_v1 + dist_v1_v2 + dist_v2_N;
		}
		if (dist_1_v2 != Integer.MAX_VALUE && dist_v1_v2 != Integer.MAX_VALUE && dist_v1_N != Integer.MAX_VALUE) {
			path2 = (long) dist_1_v2 + dist_v1_v2 + dist_v1_N;
		}

		long min = Math.min(path1, path2);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static int dijstra(int start, int end) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		Queue<Node> pq = new PriorityQueue<Node>();
		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int next = cur.next;

			if (distance[next] < cur.dist)
				continue;

			if (map.get(next) != null) {
				for (Node a : map.get(next)) {
					if (distance[a.next] > a.dist + distance[next]) {
						distance[a.next] = a.dist + distance[next];
						pq.offer(new Node(a.next, distance[a.next]));
					}
				}
			}
		}
		return distance[end];
	}
}

class Node implements Comparable<Node> {
	int next, dist;

	public Node(int next, int dist) {
		this.next = next;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		return this.dist - o.dist;
	}
}