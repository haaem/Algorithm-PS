import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2583 {
	static boolean[][] paper;
	static boolean[][] visited;
	static int N, M;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		paper = new boolean[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int a = y1; a < y2; a++) {
				for (int b = x1; b < x2; b++) {
					paper[a][b] = true;
				}
			}
		}

		int count = 0;
		ArrayList<Integer> area = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && !paper[i][j]) {
					int temp = bfs(i, j);
					count++;
					area.add(temp);
				}
			}
		}
		System.out.println(count);
		Collections.sort(area);
		for (int a : area) {
			System.out.print(a + " ");
		}
	}

	private static int bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;
		int area = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0];
			int x = cur[1];
			for (int a = 0; a < 4; a++) {
				int ny = y + dy[a];
				int nx = x + dx[a];
				if (ny < 0 || nx < 0 || ny >= M || nx >= N || visited[ny][nx] || paper[ny][nx])
					continue;
				visited[ny][nx] = true;
				area++;
				queue.offer(new int[] { ny, nx });
			}
		}
		return area;
	}
}
