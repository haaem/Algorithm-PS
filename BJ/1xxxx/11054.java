import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {
	static int[] arr, reversedArr;
	static int[] dp, reversedDp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		reversedArr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			reversedArr[N - i - 1] = arr[i];
		}
		dp = new int[N];
		reversedDp = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				if (reversedArr[i] > reversedArr[j])
					reversedDp[i] = Math.max(reversedDp[j] + 1, reversedDp[i]);
			}
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i] + reversedDp[N - i - 1]);
		}
		System.out.println(max + 1);
	}
}
