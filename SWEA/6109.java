import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6109 {
	static int N;
	static int[][] board;
	static int[][] ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();

			board = new int[N][N];
			ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (direction.equals("up")) {
				up();
			} else if (direction.equals("left")) {
				left();
			} else if (direction.equals("right")) {
				right();
			} else {
				down();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(ans[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void up() {
		for (int j = 0; j < N; ++j) {
			for (int i = 0; i < N - 1; ++i) {
				if (board[i][j] == 0) {
					continue;
				}
				int idx = i + 1;

				while (idx < N - 1 && board[idx][j] == 0) {
					idx++;
				}

				if (board[idx][j] == 0) {
					continue;
				}

				if (board[i][j] == board[idx][j]) {
					board[i][j] *= 2;
					board[idx][j] = 0;
					i = idx;
				}
			}

			int cur = 0;
			for (int i = 0; i < N; ++i) {
				if (board[i][j] != 0) {
					ans[cur++][j] = board[i][j];
				}
			}
		}
	}

	static void down() {
		for (int j = 0; j < N; ++j) {
			for (int i = N - 1; i > 0; --i) {
				if (board[i][j] == 0) {
					continue;
				}
				int idx = i - 1;

				while (idx > 0 && board[idx][j] == 0) {
					idx--;
				}

				if (board[idx][j] == 0) {
					continue;
				}

				if (board[i][j] == board[idx][j]) {
					board[i][j] *= 2;
					board[idx][j] = 0;
					i = idx;
				}
			}

			int cur = N - 1;
			for (int i = N - 1; i >= 0; --i) {
				if (board[i][j] != 0) {
					ans[cur--][j] = board[i][j];
				}
			}
		}
	}

	static void left() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - 1; ++j) {
				if (board[i][j] == 0) {
					continue;
				}
				int idx = j + 1;

				while (idx < N - 1 && board[i][idx] == 0) {
					idx++;
				}

				if (board[i][idx] == 0) {
					continue;
				}

				if (board[i][j] == board[i][idx]) {
					board[i][j] *= 2;
					board[i][idx] = 0;
					j = idx;
				}
			}

			int cur = 0;
			for (int j = 0; j < N; ++j) {
				if (board[i][j] != 0) {
					ans[i][cur++] = board[i][j];
				}
			}
		}
	}

	static void right() {
		for (int i = 0; i < N; ++i) {
			for (int j = N - 1; j > 0; --j) {
				if (board[i][j] == 0) {
					continue;
				}
				int idx = j - 1;

				while (idx > 0 && board[i][idx] == 0) {
					idx--;
				}

				if (board[i][idx] == 0) {
					continue;
				}

				if (board[i][j] == board[i][idx]) {
					board[i][j] *= 2;
					board[i][idx] = 0;
					j = idx;
				}
			}

			int cur = N - 1;
			for (int j = N - 1; j >= 0; --j) {
				if (board[i][j] != 0) {
					ans[i][cur--] = board[i][j];
				}
			}
		}
	}
}
