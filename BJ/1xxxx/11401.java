import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11401 {
	static long[] dp;
	static final int mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new long[N + 1];
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1] * i % mod;
		}
		long temp = power(dp[N - K] * dp[K] % mod, mod - 2);
		System.out.println(dp[N] * temp % mod);
	}

	static long power(long a, int n) {
		long res = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				res = res * a % mod;
			}
			a = a * a % mod;
			n /= 2;
		}
		return res;
	}
}
