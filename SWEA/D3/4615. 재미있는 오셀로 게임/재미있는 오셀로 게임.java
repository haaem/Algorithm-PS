import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] board;
	static int n;
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			board = new int[n][n];
			int half = n / 2;
			board[half - 1][half - 1] = board[half][half] = 2;
			board[half - 1][half] = board[half][half - 1] = 1;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int color = Integer.parseInt(st.nextToken());
				board[y][x] = color;
				change(y, x, color);
			}

			int[] color = new int[2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1)
						color[0]++;
					else if (board[i][j] == 2)
						color[1]++;
				}
			}

			System.out.println("#" + tc + " " + color[0] + " " + color[1]);
		}
	}

	static void change(int y, int x, int color) {
		for (int a = 0; a < 8; a++) {
			int ny = y + dy[a];
			int nx = x + dx[a];

			boolean check = false;

			while (ny >= 0 && nx >= 0 && ny < n && nx < n && board[ny][nx] != 0) {
				if (board[ny][nx] == color) {
					check = true;
					break;
				}
				ny += dy[a];
				nx += dx[a];
			}

			while (check) {
				if (ny == y && nx == x)
					break;

				board[ny][nx] = color;
				ny -= dy[a];
				nx -= dx[a];
			}
		}
	}
}