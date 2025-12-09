import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ26170 {
	static int[][] board;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		res = 100;

		board[r][c] = -1;
		backtracking(r, c, 0, 0);

		if (res == 100)
			System.out.println(-1);
		else
			System.out.println(res);
	}

	static void backtracking(int y, int x, int count, int move) {
		if (count == 3) {
			res = Math.min(res, move);
			return;
		}
		for (int a = 0; a < 4; a++) {
			int ny = y + dy[a];
			int nx = x + dx[a];

			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5 || board[ny][nx] == -1)
				continue;

			if (board[ny][nx] == 1) {
				board[ny][nx] = -1;
				backtracking(ny, nx, count + 1, move + 1);
				board[ny][nx] = 1;
			} else { // board[ny][nx] == 0
				board[ny][nx] = -1;
				backtracking(ny, nx, count, move + 1);
				board[ny][nx] = 0;
			}
		}
	}
}
