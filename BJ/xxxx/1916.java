import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			map.put(i, new HashMap<>());
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if (!map.get(s).containsKey(e) || map.get(s).get(e) > p) {
				map.get(s).put(e, p);
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.offer(new Bus(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Bus cur = pq.poll();

			for (int city : map.get(cur.next).keySet()) {
				if (dist[city] > map.get(cur.next).get(city) + dist[cur.next]) {
					dist[city] = map.get(cur.next).get(city) + dist[cur.next];
					pq.offer(new Bus(city, dist[city]));
				}
			}
		}
		System.out.println(dist[end]);
	}
}

class Bus implements Comparable<Bus> {
	int next, price;

	public Bus(int next, int price) {
		this.next = next;
		this.price = price;
	}

	@Override
	public int compareTo(Bus o) {
		return this.price - o.price;
	}
}