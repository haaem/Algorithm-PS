import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1043 {
	static int N, M;
	static int[] parent;
	static ArrayList<int[]> parties;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		for (int i = 0; i < count; i++) {
			parent[Integer.parseInt(st.nextToken())] = -1;
		}
		parties = new ArrayList<int[]>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			count = Integer.parseInt(st.nextToken());
			int[] mem = new int[count];
			for (int j = 0; j < count; j++) {
				mem[j] = Integer.parseInt(st.nextToken());
			}
			parties.add(mem);

			if (count > 1) {
				for (int j = 0; j < count - 1; j++) {
					union(mem[j], mem[j + 1]);
				}
			}
		}
		int res = 0;

		for (int[] party : parties) {
			if (party.length > 0) {
				int root = find(party[0]);
				if (root != -1)
					res++;
			}
		}

		System.out.println(res);
	}

	static int find(int a) {
		if (parent[a] == -1 || parent[a] == a) {
			return parent[a];
		}
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return;

		if (rootA == -1) {
			parent[rootB] = -1;
		} else if (rootB == -1) {
			parent[rootA] = -1;
		} else {
			parent[rootB] = rootA;
		}
	}
}
