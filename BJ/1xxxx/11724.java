import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ11724 {
	static int[] parent;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		init();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= N; i++) {
			set.add(find(i));
		}
		System.out.println(set.size());
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);

		if (A == B)
			return;
		if (A < B) {
			parent[B] = A;
		} else {
			parent[A] = B;
		}
	}
}
