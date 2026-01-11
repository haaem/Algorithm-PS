import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pq.offer(new Node(A, B, C));
		}
		long sum = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (find(node.A) == find(node.B))
				continue;
			union(node.A, node.B);
			sum += node.w;
		}
		System.out.println(sum);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rootA < rootB)
				parent[rootB] = rootA;
			else
				parent[rootA] = rootB;
		}
	}

	private static class Node implements Comparable<Node> {
		int A, B, w;

		Node(int A, int B, int w) {
			this.A = A;
			this.B = B;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}
