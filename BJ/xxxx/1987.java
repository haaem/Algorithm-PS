import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1987 {
	static int R, C;
	static char[][] board;
	static int max;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String S = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = S.charAt(j);
			}
		}
		max = 0;
		HashSet<Character> set = new HashSet<Character>();
		set.add(board[0][0]);
		dfs(0, 0, 1, 1 << (board[0][0] - 'A'));
		System.out.println(max);
	}

	static void dfs(int y, int x, int count, int visited) {
		max = Math.max(max, count);

		for (int a = 0; a < 4; a++) {
			int ny = y + dy[a];
			int nx = x + dx[a];
			if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
				int nextVisited = 1 << (board[ny][nx] - 'A');
				if ((visited & nextVisited) == 0)
					dfs(ny, nx, count + 1, visited | nextVisited);
			}
		}
	}
}