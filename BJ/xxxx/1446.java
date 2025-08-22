import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1446 {
	static int[] dist;
	static HashMap<Integer, ArrayList<Road>> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		dist = new int[D + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		map = new HashMap<Integer, ArrayList<Road>>();
		for (int i = 0; i < D; i++) {
			map.putIfAbsent(i, new ArrayList<Road>());
			map.get(i).add(new Road(i + 1, 1));
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (start > D || end > D || d >= end - start)
				continue;
			map.get(start).add(new Road(end, d));
		}
		dijstra(0);
		System.out.println(dist[D]);
	}

	static void dijstra(int start) {
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		pq.offer(new Road(start, 0));
		while (!pq.isEmpty()) {
			Road cur = pq.poll();
			int end = cur.end;
			int d = cur.dist;

			if (dist[end] < d)
				continue;

			if (!map.containsKey(cur.end))
				continue;

			for (Road next : map.get(cur.end)) {
				if (d + next.dist < dist[next.end]) {
					dist[next.end] = d + next.dist;
					pq.offer(new Road(next.end, dist[next.end]));
				}
			}
		}
	}
}

class Road implements Comparable<Road> {
	int end, dist;

	public Road(int end, int dist) {

		this.end = end;
		this.dist = dist;
	}

	@Override
	public int compareTo(Road o) {
		return this.dist - o.dist;
	}
}
