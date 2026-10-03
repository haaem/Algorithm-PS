import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n + 1];

			for (int i = 1; i <= n; i++)
				parent[i] = i;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				switch (Integer.parseInt(st.nextToken())) {
				case 0: {
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				}
				case 1: {
					if (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())))
						sb.append(1);
					else
						sb.append(0);
					break;
				}
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
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