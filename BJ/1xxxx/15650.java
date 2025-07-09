import java.util.Scanner;

public class BJ15650 {
	public static int N;
	public static int M;
	public static int[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		check = new int[N + 1];
		dfs(1, 0);
	}

	public static void dfs(int start, int depth) {
		if (depth == M) {
			for (int i = 1; i <= N; i++) {
				if (check[i] == 1)
					System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			if (check[i] == 0) {
				check[i] = 1;
				dfs(i + 1, depth + 1);
				check[i] = 0;
			}
		}
	}
}
