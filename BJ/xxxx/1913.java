import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1913 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int ans_i = -1;
		int ans_j = -1;

		int[][] arr = new int[N][N];
		int value = N * N;
		int i = 0;
		int j = 0;
		int start = 0;
		int end = N - 1;
		while (value > 0) {
			j = start;
			for (int a = i; a <= end; a++) {
				if (value == target) {
					ans_i = a;
					ans_j = j;
				}
				arr[a][j] = value--;
			}
			i = end;
			for (int b = j + 1; b <= end; b++) {
				if (value == target) {
					ans_i = i;
					ans_j = b;
				}
				arr[i][b] = value--;
			}
			j = end;
			for (int a = i - 1; a >= start; a--) {
				if (value == target) {
					ans_i = a;
					ans_j = j;
				}
				arr[a][j] = value--;
			}
			i = start;
			for (int b = j - 1; b > start; b--) {
				if (value == target) {
					ans_i = i;
					ans_j = b;
				}
				arr[i][b] = value--;
			}
			start++;
			end--;
			i = start;
		}

		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				sb.append(arr[a][b]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(ans_i + 1).append(" ").append(ans_j + 1);
		System.out.println(sb);
	}
}
