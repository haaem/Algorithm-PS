import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ34511 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 1; j++) {
				char now = board[i][j];
				if (now == '.')
					continue;
				if (i != N - 1) {
					if (board[i + 1][j] != '.' && board[i + 1][j] != now) {
						sum++;
					}
				}
				if (board[i][j + 1] != '.' && board[i][j + 1] != now)
					sum++;
			}
		}
		for (int i = 0; i < N - 1; i++) {
			char now = board[i][M - 1];
			if (now == '.')
				continue;
			if (board[i + 1][M - 1] != '.' && board[i + 1][M - 1] != now)
				sum++;
		}
		System.out.println(sum);
	}
}
