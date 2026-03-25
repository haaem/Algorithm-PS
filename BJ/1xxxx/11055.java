import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		int res = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i])
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
			}
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}
}
