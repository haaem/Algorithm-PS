import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ17626 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = 1; j * j <= i; j++) {
				int s = j * j;
				dp[i] = Math.min(dp[i], dp[i - s] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}
