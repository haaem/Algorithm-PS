import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10775 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}
		int count = 0;
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			if (find(g) == 0)
				break;
			count++;
			union(find(g), find(g) - 1);
		}
		System.out.println(count);
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parent[pa] = pb;
	}
}
