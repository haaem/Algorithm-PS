import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1238 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
		HashMap<Integer, HashMap<Integer, Integer>> reverse = new HashMap<Integer, HashMap<Integer, Integer>>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map.putIfAbsent(s, new HashMap<Integer, Integer>());
			map.get(s).put(e, t);
			reverse.putIfAbsent(e, new HashMap<Integer, Integer>());
			reverse.get(e).put(s, t);
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		dist[X] = 0;
		pq.offer(new Road(X, 0));
		while (!pq.isEmpty()) {
			Road cur = pq.poll();

			for (int next : map.get(cur.end).keySet()) {
				int d = cur.dist + map.get(cur.end).get(next);
				if (d >= dist[next])
					continue;
				dist[next] = d;
				pq.offer(new Road(next, d));
			}
		}

		int[] reverseDist = new int[N + 1];
		Arrays.fill(reverseDist, Integer.MAX_VALUE);
		reverseDist[X] = 0;
		pq = new PriorityQueue<Road>();
		pq.offer(new Road(X, 0));
		while (!pq.isEmpty()) {
			Road cur = pq.poll();

			for (int next : reverse.get(cur.end).keySet()) {
				int d = cur.dist + reverse.get(cur.end).get(next);
				if (d >= reverseDist[next])
					continue;
				reverseDist[next] = d;
				pq.offer(new Road(next, d));
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < dist[i] + reverseDist[i])
				max = dist[i] + reverseDist[i];
		}
		System.out.println(max);
	}
}

class Road implements Comparable<Road> {
	int end, dist;

	Road(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}

	@Override
	public int compareTo(Road o) {
		return this.dist - o.dist;
	}

}
