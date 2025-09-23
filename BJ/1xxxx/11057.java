import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11057 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < 10; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
			}
		}
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum % 10007);
	}
}
