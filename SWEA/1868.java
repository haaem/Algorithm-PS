import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class SWEA1868 {
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static boolean[][] board;
	static int[][] count;
	static int N;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			board = new boolean[N][N];
			count = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					if (line.charAt(j) == '*')
						board[i][j] = true;
				}
			}
			count();
			int ans = 0;

			// 주변 지뢰 0개 누르기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (count[i][j] == 0 && !board[i][j]) {
						click(i, j);
						ans++;
					}
				}
			}

			// 눌리지 않은 곳 누르기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (count[i][j] > 0 && !board[i][j]) {
						ans++;
					}
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}

	// 주변 지뢰 찾기
	public static void count() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!board[i][j]) {
					int c = 0;
					for (int k = 0; k < 8; k++) {
						if (i + dx[k] < 0 || i + dx[k] >= N || j + dy[k] < 0 || j + dy[k] >= N
								|| !board[i + dx[k]][j + dy[k]]) {
							continue;
						}
						c++;
					}
					count[i][j] = c;
				}
			}
		}
	}

	public static void click(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		count[x][y] = -1;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 8; d++) {
				if (p.x + dx[d] < 0 || p.x + dx[d] >= N || p.y + dy[d] < 0 || p.y + dy[d] >= N
						|| count[p.x + dx[d]][p.y + dy[d]] == -1)
					continue;
				if (count[p.x + dx[d]][p.y + dy[d]] == 0)
					queue.add(new Point(p.x + dx[d], p.y + dy[d]));
				count[p.x + dx[d]][p.y + dy[d]] = -1;
			}
		}
	}
}