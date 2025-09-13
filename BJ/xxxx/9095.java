import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ9095 {
	public static void main(String[] args) throws Exception {
		int[] dp = new int[12];
		dp[1] = 1; // 1
		dp[2] = 2; // 1+1, 2
		dp[3] = 4; // 1+2, 1+1+1, 2+1, 3
		for (int i = 4; i <= 11; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
}
