import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		long[] dp = new long[N + 1];
		dp[1] = P[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = P[i];
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
			}
		}
		System.out.println(dp[N]);
	}
}
