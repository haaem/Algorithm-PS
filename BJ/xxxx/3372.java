import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ3372 {
	static int N;
	static int[][] board;
	static BigInteger[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dp = new BigInteger[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = BigInteger.ZERO;
			}
		}

		dp[0][0] = BigInteger.ONE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == N - 1 && j == N - 1)
					continue;
				if (dp[i][j].equals(BigInteger.ZERO) || board[i][j] == 0)
					continue;
				int jump = board[i][j];

				if (j + jump < N) {
					dp[i][j + jump] = dp[i][j + jump].add(dp[i][j]);
				}
				if (i + jump < N) {
					dp[i + jump][j] = dp[i + jump][j].add(dp[i][j]);
				}
			}
		}

		System.out.println(dp[N - 1][N - 1]);
	}
}
