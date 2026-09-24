import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] sum = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					sum[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];

			int max = 0;
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					max = Math.max(max, sum[i][j] - sum[i][j - M] - sum[i - M][j] + sum[i - M][j - M]);
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}