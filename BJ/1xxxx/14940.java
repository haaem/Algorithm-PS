import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14940 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n, m;
	static int[][] map, dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		int sy = -1, sx = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					sy = i;
					sx = j;
					map[i][j] = 1;
				}
			}
		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { sy, sx });
		dist[sy][sx] = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0];
			int x = cur[1];

			for (int a = 0; a < 4; a++) {
				int ny = y + dy[a];
				int nx = x + dx[a];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0) {
					continue;
				}
				if (dist[ny][nx] > dist[y][x] + 1) {
					dist[ny][nx] = dist[y][x] + 1;
					queue.offer(new int[] { ny, nx });
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dist[i][j] == Integer.MAX_VALUE) {
					if (map[i][j] == 0) {
						sb.append("0 ");
					} else if (map[i][j] == 1) {
						sb.append("-1 ");
					}
				} else {
					sb.append(dist[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
