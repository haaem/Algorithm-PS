import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2293 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] value = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(value);
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = value[i]; j <= k; j++) {
				dp[j] += dp[j - value[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
