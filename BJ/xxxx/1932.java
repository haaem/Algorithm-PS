import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Integer>[] lst = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			lst[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				lst[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		ArrayList<Integer>[] dp = new ArrayList[n];
		dp[0] = new ArrayList<Integer>();
		dp[0].add(lst[0].get(0));
		for (int i = 1; i < n; i++) {
			dp[i] = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i].add(dp[i - 1].get(j) + lst[i].get(j));
				} else if (j == i) {
					dp[i].add(dp[i - 1].get(j - 1) + lst[i].get(j));
				} else {
					dp[i].add(Math.max(dp[i - 1].get(j - 1) + lst[i].get(j), dp[i - 1].get(j) + lst[i].get(j)));
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (dp[n - 1].get(i) > max)
				max = dp[n - 1].get(i);
		}
		System.out.println(max);
	}
}
