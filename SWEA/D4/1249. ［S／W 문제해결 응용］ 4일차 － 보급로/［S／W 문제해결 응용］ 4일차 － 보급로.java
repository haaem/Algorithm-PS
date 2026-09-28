import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++)
					map[i][j] = s.charAt(j) - '0';
			}

			int[][] dist = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);

			Queue<int[]> q = new ArrayDeque();
			q.offer(new int[] { 0, 0, 0 });
			dist[0][0] = 0;

			while (!q.isEmpty()) {
				int[] now = q.poll();

				for (int a = 0; a < 4; a++) {
					int ny = now[0] + dy[a];
					int nx = now[1] + dx[a];

					if (ny < 0 || nx < 0 || ny >= n || nx >= n)
						continue;

					if (dist[ny][nx] <= now[2] + map[ny][nx])
						continue;

					q.offer(new int[] { ny, nx, now[2] + map[ny][nx] });
					dist[ny][nx] = now[2] + map[ny][nx];
				}
			}

			System.out.println("#" + tc + " " + dist[n - 1][n - 1]);
		}
	}
}