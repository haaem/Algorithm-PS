import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;

	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			parent = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()) });
			}

			long sum = 0;
			while (!pq.isEmpty()) {
				int[] now = pq.poll();

				if (find(now[0]) != find(now[1])) {
					sum += now[2];
					union(find(now[0]), find(now[1]));
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}

	static int find(int x) {
		if (x == parent[x])
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