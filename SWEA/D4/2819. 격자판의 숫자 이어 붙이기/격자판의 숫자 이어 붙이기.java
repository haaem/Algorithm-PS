import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] board;
	static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			board = new int[4][4];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			set = new HashSet<>();
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					dfs(i, j, 0, 0);

			System.out.println("#" + tc + " " + set.size());
		}
	}

	static void dfs(int y, int x, int count, int value) {
		if (count == 7) {
			set.add(value);
			return;
		}
		for (int a = 0; a < 4; a++) {
			int ny = y + dy[a];
			int nx = x + dx[a];

			if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4)
				continue;

			dfs(ny, nx, count + 1, value * 10 + board[ny][nx]);
		}
	}
}