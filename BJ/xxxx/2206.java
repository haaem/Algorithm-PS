import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map;
	static int[][][] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String S = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(S.substring(j - 1, j));
			}
		}

		distance = new int[N + 1][M + 1][2];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < M + 1; j++) {
				Arrays.fill(distance[i][j], 0);
			}
		}

		System.out.println(bfs(1, 1, 0));
	}

	static int bfs(int x, int y, int z) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(new Node(x, y, z));
		distance[1][1][0] = 1;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;
			int curZ = cur.z;

			if (curX == N && curY == M) {
				return distance[curX][curY][curZ];
			}

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (nx <= 0 || ny <= 0 || nx > N || ny > M) {
					continue;
				}

				if (map[nx][ny] == 1 && curZ == 0) {
					distance[nx][ny][1] = distance[curX][curY][0] + 1;
					queue.offer(new Node(nx, ny, 1));
				} else if (map[nx][ny] == 0 && distance[nx][ny][curZ] == 0) {
					distance[nx][ny][curZ] = distance[curX][curY][curZ] + 1;
					queue.offer(new Node(nx, ny, curZ));
				}
			}
		}

		return -1;
	}
}

class Node {
	int x, y, z;

	public Node(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}