import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] coor;
	static double e;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int x, y;
		long dist;

		Edge(int x, int y, long dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.dist < o.dist)
				return -1;
			else if (this.dist > o.dist)
				return 1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			coor = new int[n][2];
			parent = new int[n];
			double ans = 0;

			for (int i = 0; i < n; i++)
				parent[i] = i;

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					coor[j][i] = Integer.parseInt(st.nextToken());
			}

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
					pq.offer(new Edge(i, j, dist(i, j)));

			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				if (find(now.x) != find(now.y)) {
					union(now.x, now.y);
					ans += now.dist;
				}
			}

			e = Double.parseDouble(br.readLine());
			System.out.println("#" + tc + " " + Math.round(ans * e));
		}
	}

	static long dist(int a, int b) {
		long nx = coor[a][0] - coor[b][0];
		long ny = coor[a][1] - coor[b][1];

		return nx * nx + ny * ny;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);

		if (A < B)
			parent[B] = A;
		else
			parent[A] = B;
	}
}