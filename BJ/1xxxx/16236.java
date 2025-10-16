import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16236 {
	static int N;
	static int[][] map;
	static int babySize = 2;
	static PriorityQueue<Fish> pq;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int start_y = -1;
		int start_x = -1;
		Queue<Fish> queue = new ArrayDeque<Fish>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					start_y = i;
					start_x = j;
					map[i][j] = 0;
				}
			}
		}
		queue.offer(new Fish(start_y, start_x, 0));
		bfs(queue);

		int move = 0, count = 0;
		while (!pq.isEmpty()) {
			Fish now = pq.poll();
			map[now.y][now.x] = 0;
			if (++count == babySize) {
				count = 0;
				babySize++;
			}
			move += now.dist;
			queue = new ArrayDeque<>();
			queue.offer(new Fish(now.y, now.x, 0));
			bfs(queue);
		}
		System.out.println(move);
	}

	static void bfs(Queue<Fish> queue) {
		pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];

		while (!queue.isEmpty()) {
			Fish now = queue.poll();
			for (int a = 0; a < 4; a++) {
				int ny = now.y + dy[a];
				int nx = now.x + dx[a];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] > babySize || visited[ny][nx])
					continue;

				visited[ny][nx] = true;
				queue.offer(new Fish(ny, nx, now.dist + 1));
				if (map[ny][nx] != 0 && map[ny][nx] < babySize) {
					pq.offer(new Fish(ny, nx, now.dist + 1));
				}
			}
		}
	}
}

class Fish implements Comparable<Fish> {
	int y, x, dist;

	public Fish(int y, int x, int dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.dist != o.dist)
			return this.dist - o.dist;
		if (this.y != o.y)
			return this.y - o.y;
		return this.x - o.x;
	}
}