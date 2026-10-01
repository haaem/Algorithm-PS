import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] map = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			int[] start = new int[2];
			int[] end = new int[2];

			for (int i = 0; i < 16; i++) {
				String s = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = s.charAt(j) - '0';
					if (map[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					} else if (map[i][j] == 3) {
						end[0] = i;
						end[1] = j;
					}
				}
			}

			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { start[0], start[1] });
			visited[start[0]][start[1]] = true;
			boolean possible = false;

			loop: while (!q.isEmpty()) {
				int[] now = q.poll();

				for (int a = 0; a < 4; a++) {
					int ny = now[0] + dy[a];
					int nx = now[1] + dx[a];

					if (ny == end[0] && nx == end[1]) {
						possible = true;
						break loop;
					}

					if (ny < 0 || nx < 0 || ny >= 16 || nx >= 16 || visited[ny][nx] || map[ny][nx] == 1)
						continue;

					visited[ny][nx] = true;
					q.offer(new int[] { ny, nx });
				}
			}

			if (possible)
				System.out.println("#" + tc + " 1");
			else
				System.out.println("#" + tc + " 0");
		}
	}
}