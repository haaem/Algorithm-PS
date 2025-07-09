import java.util.Arrays;
import java.util.Scanner;

public class BJ15649 {
	static int N;
	static int M;
	static int[] check;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		check = new int[N + 1];
		arr = new int[M];
		Arrays.fill(check, 0);
		dfs(0);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (check[i] == 0) {
				check[i] = 1;
				arr[depth] = i;
				dfs(depth + 1);
				check[i] = 0;
			}
		}
	}
}
