import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ18352 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		HashMap<Integer, ArrayList<Integer>> map = new HashMap();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map.putIfAbsent(A, new ArrayList<Integer>());
			map.get(A).add(B);
		}
		int[] d = new int[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(X, 0));
		d[X] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (!map.containsKey(cur.next))
				continue;
			for (int next : map.get(cur.next)) {
				if (d[next] > cur.dist + 1) {
					d[next] = cur.dist + 1;
					pq.offer(new Node(next, cur.dist + 1));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (d[i] == K)
				sb.append(i).append("\n");
		}
		if (sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb);
	}

	private static class Node implements Comparable<Node> {
		int next;
		int dist;

		public Node(int n, int d) {
			next = n;
			dist = d;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
}
