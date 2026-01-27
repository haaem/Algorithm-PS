import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ20040 {
	static int[] parent;
	static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			set.add(i);
		}
		int res = 0;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) == find(b)) {
				res = i;
				break;
			}
			union(a, b);
		}
		System.out.println(res);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A < B)
			parent[B] = A;
		else
			parent[A] = B;
	}
}
