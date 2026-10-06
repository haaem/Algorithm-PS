import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] in = br.readLine().split(" ");
			int N = Integer.parseInt(in[0]);
			int M = Integer.parseInt(in[1]);

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;

			for (int i = 0; i < M; i++) {
				in = br.readLine().split(" ");
				union(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
			}

			int count = 0;
			for (int i = 1; i <= N; i++)
				if (find(i) == i)
					count++;

			System.out.println("#" + tc + " " + count);
		}
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