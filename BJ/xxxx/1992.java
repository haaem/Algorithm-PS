import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1992 {
	static int[][] board;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		recursion(N, 0, 0);
		System.out.println(sb);
	}

	public static void recursion(int N, int r, int c) {
		if (N == 1) {
			sb.append(board[r][c]);
			return;
		}
		int first = board[r][c];
		boolean same = true;
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (board[i][j] != first) {
					same = false;
					break;
				}
			}
			if (!same)
				break;
		}
		if (same) {
			sb.append(first);
			return;
		}
		int half = N / 2;
		sb.append("(");
		recursion(half, r, c);
		recursion(half, r, c + half);
		recursion(half, r + half, c);
		recursion(half, r + half, c + half);
		sb.append(")");
	}
}
