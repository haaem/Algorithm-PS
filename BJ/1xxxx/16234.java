import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16234 {
	static int N, L, R;
	static boolean moved;
	static int[][] pop;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		pop = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pop[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		while (true) {
			visited = new boolean[N][N];
			moved = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j])
						bfs(i, j);
				}
			}
			if (moved)
				day++;
			else
				break;
		}
		System.out.println(day);
	}

	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		visited[i][j] = true;
		queue.offer(new int[] { i, j });
		ArrayList<int[]> save = new ArrayList<int[]>();
		save.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0];
			int x = cur[1];
			for (int a = 0; a < 4; a++) {
				int ny = y + dy[a];
				int nx = x + dx[a];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])
					continue;
				int diff = Math.abs(pop[ny][nx] - pop[y][x]);
				if (L <= diff && diff <= R) {
					queue.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
					save.add(new int[] { ny, nx });
				}
			}
		}

		if (save.size() > 1)
			fed(save);
	}

	static void fed(ArrayList<int[]> list) {
		moved = true;
		int c = list.size();
		int sum = 0;
		for (int[] a : list) {
			sum += pop[a[0]][a[1]];
		}
		int aver = sum / c;
		for (int[] a : list) {
			pop[a[0]][a[1]] = aver;
		}
	}
}
