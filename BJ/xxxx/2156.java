import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2156 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[n];
		dp[0] = arr[0];
		if (n == 1) {
			System.out.println(dp[0]);
			System.exit(0);
		}
		dp[1] = arr[0] + arr[1];
		if (n == 2) {
			System.out.println(dp[1]);
			System.exit(0);
		}
		dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
		if (n == 3) {
			System.out.println(dp[2]);
			System.exit(0);
		}
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]));

		}
		System.out.println(dp[n - 1]);
	}
}