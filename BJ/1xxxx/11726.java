import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11726 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 1)
			System.out.println(1);
		else {
			int[] dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
			}
			System.out.println(dp[n]);
		}
	}
}
