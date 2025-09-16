import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[k + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				dp[0][i] = dp[0][i - 1] + i;
			}
			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			System.out.println(dp[k][n] - dp[k][n - 1]);
		}
	}
}
