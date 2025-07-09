import java.util.Scanner;

public class BJ2606 {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < L; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (find(i) == 1)
				count++;
		}
		System.out.println(count);
	}

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A < B) {
			parent[B] = A;
		} else {
			parent[A] = B;
		}
	}
}
