import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[][] maze;
	static int[][] count;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}
		bfs();
		System.out.println(count[N - 1][M - 1]);
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { 0, 0 });
		count = new int[N][M];
		count[0][0] = 1;
		maze[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int i = cur[0];
			int j = cur[1];
			if (i == N - 1 && j == M - 1)
				return;
			for (int a = 0; a < 4; a++) {
				int ni = di[a] + i;
				int nj = dj[a] + j;
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && maze[ni][nj] == 1) {
					maze[ni][nj] = 0;
					queue.add(new int[] { ni, nj });
					count[ni][nj] = count[i][j] + 1;
				}
			}
		}
	}
}
