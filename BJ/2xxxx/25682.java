import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25682 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] board = new char[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				board[i][j] = s.charAt(j - 1);
			}
		}
		// first color B
		int[][] cB = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if ((i + j) % 2 == 0) {
					if (board[i][j] == 'B') {
						cB[i][j] = cB[i - 1][j] + cB[i][j - 1] - cB[i - 1][j - 1];
					} else {
						cB[i][j] = cB[i - 1][j] + cB[i][j - 1] + 1 - cB[i - 1][j - 1];
					}
				} else {
					if (board[i][j] == 'W') {
						cB[i][j] = cB[i - 1][j] + cB[i][j - 1] - cB[i - 1][j - 1];
					} else {
						cB[i][j] = cB[i - 1][j] + cB[i][j - 1] + 1 - cB[i - 1][j - 1];
					}
				}
			}
		}
		// first color W
		int[][] cW = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if ((i + j) % 2 == 0) {
					if (board[i][j] == 'W') {
						cW[i][j] = cW[i - 1][j] + cW[i][j - 1] - cW[i - 1][j - 1];
					} else {
						cW[i][j] = cW[i - 1][j] + cW[i][j - 1] + 1 - cW[i - 1][j - 1];
					}
				} else {
					if (board[i][j] == 'B') {
						cW[i][j] = cW[i - 1][j] + cW[i][j - 1] - cW[i - 1][j - 1];
					} else {
						cW[i][j] = cW[i - 1][j] + cW[i][j - 1] + 1 - cW[i - 1][j - 1];
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N - K + 1; i++) {
			for (int j = 1; j <= M - K + 1; j++) {
				int ie = i + K - 1;
				int je = j + K - 1;

				if (min > cB[ie][je] - cB[i - 1][je] - cB[ie][j - 1] + cB[i - 1][j - 1]) {
					min = cB[ie][je] - cB[i - 1][je] - cB[ie][j - 1] + cB[i - 1][j - 1];
				}
				if (min > cW[ie][je] - cW[i - 1][je] - cW[ie][j - 1] + cW[i - 1][j - 1]) {
					min = cW[ie][je] - cW[i - 1][je] - cW[ie][j - 1] + cW[i - 1][j - 1];
				}
			}
		}
		System.out.println(min);
	}
}
