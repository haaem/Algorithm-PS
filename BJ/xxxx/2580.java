import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2580 {
	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
	}

	public static void dfs(int row, int col) {
		if (col == 9) {
			dfs(row + 1, 0);
			return;
		}
		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if (board[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isPossible(row, col, i)) {
					board[row][col] = i;
					dfs(row, col + 1);
				}
			}
			board[row][col] = 0;
			return;
		}
		dfs(row, col + 1);
	}

	public static boolean isPossible(int row, int col, int val) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == val) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == val) {
				return false;
			}
		}

		int r = (row / 3) * 3;
		int c = (col / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[r + i][c + j] == val) {
					return false;
				}
			}
		}
		return true;
	}
}
