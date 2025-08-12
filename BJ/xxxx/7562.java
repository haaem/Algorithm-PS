
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {
	static int I;
	static int[][] board;
	static int[] end;
	static int[] di = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dj = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			I = Integer.parseInt(br.readLine());
			board = new int[I][I];
			st = new StringTokenizer(br.readLine());
			int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			st = new StringTokenizer(br.readLine());
			end = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			bfs(start[0], start[1]);
			System.out.println(board[end[0]][end[1]]);
		}
	}

	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		board[i][j] = 0;
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			if (temp[0] == end[0] && temp[1] == end[1])
				break;
			for (int a = 0; a < 8; a++) {
				int ni = temp[0] + di[a];
				int nj = temp[1] + dj[a];
				if (ni >= 0 && nj >= 0 && ni < I && nj < I && board[ni][nj] == 0) {
					board[ni][nj] = board[temp[0]][temp[1]] + 1;
					queue.add(new int[] { ni, nj });
				}
			}
		}
	}
}