import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static int n;
	static boolean[][] board;
	static int[] dy = { 1, 0, 1, 1 };
	static int[] dx = { 0, 1, 1, -1 };

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++)
					if (s.charAt(j) == 'o')
						board[i][j] = true;
			}

			boolean possible = false;
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] && check(i, j)) {
						possible = true;
						break loop;
					}
				}
			}

			if (possible)
				System.out.println("#" + tc + " YES");
			else
				System.out.println("#" + tc + " NO");
		}
	}

	static boolean check(int i, int j) {
		for (int a = 0; a < 4; a++) {
			int b = 0;
			int cnt = 0;
			while (b < 5) {
				int ny = i + dy[a] * b;
				int nx = j + dx[a] * b;

				if (ny < 0 || nx < 0 || ny >= n || nx >= n || !board[ny][nx])
					break;

				cnt++;
				b++;
			}

			if (cnt == 5)
				return true;
		}

		return false;
	}
}