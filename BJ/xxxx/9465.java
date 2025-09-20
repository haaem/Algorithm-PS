import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[2][n];
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if (n == 1) {
				System.out.println(Math.max(dp[0][0], dp[1][0]));
				continue;
			}
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			if (n == 2) {
				System.out.println(Math.max(dp[0][1], dp[1][1]));
				continue;
			}
			for (int i = 2; i < n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1] + arr[0][i], dp[1][i - 2] + arr[0][i]);
				dp[1][i] = Math.max(dp[0][i - 1] + arr[1][i], dp[0][i - 2] + arr[1][i]);
			}
			System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
		}
	}
}
