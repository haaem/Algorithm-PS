import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int n, max, room;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			max = 0;
			room = n * n;

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					bfs(i, j);

			System.out.println("#" + tc + " " + room + " " + max);
		}
	}

	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		q.offer(new int[] { i, j, map[i][j] });
		visited[i][j] = true;
		int sum = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int a = 0; a < 4; a++) {
				int ny = now[0] + dy[a];
				int nx = now[1] + dx[a];

				if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || map[ny][nx] - now[2] != 1)
					continue;

				q.offer(new int[] { ny, nx, map[ny][nx] });
				visited[ny][nx] = true;
				sum++;
			}
		}

		if (sum > max || (sum == max && map[i][j] < room)) {
			max = sum;
			room = map[i][j];
		}
	}
}