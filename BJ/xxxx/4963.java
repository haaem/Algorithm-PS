import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963 {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (true) {
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			visited = new boolean[h][w];

			// 지도 입력 받기
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 섬 개수 count
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");

			st = new StringTokenizer(br.readLine());
		}
		// 출력
		System.out.println(sb);
	}

	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		visited[i][j] = true;
		queue.offer(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0];
			int x = cur[1];
			for (int a = 0; a < 8; a++) {
				int ny = y + dy[a];
				int nx = x + dx[a];
				if (ny < 0 || nx < 0 || ny >= h || nx >= w || map[ny][nx] == 0 || visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				queue.offer(new int[] { ny, nx });
			}
		}
	}
}
