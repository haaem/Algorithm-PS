import java.util.Scanner;

public class BJ15652 {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		sb = new StringBuilder();
		dfs(1, 0);
		System.out.println(sb);
	}

	public static void dfs(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			if (depth == 0 || arr[depth - 1] <= i) {
				arr[depth] = i;
				dfs(start, depth + 1);
			}
		}
	}
}
