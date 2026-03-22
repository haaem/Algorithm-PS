import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1926 {
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int max = 0;
		int count = 0;
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					count++;
					max = Math.max(bfs(i, j), max);
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

	static int bfs(int y, int x) {
		int size = 1;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { y, x });
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int a = 0; a < 4; a++) {
				int i = now[0] + dy[a];
				int j = now[1] + dx[a];
				if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j])
					continue;
				if (arr[i][j] == 1) {
					visited[i][j] = true;
					size++;
					queue.offer(new int[] { i, j });
				}
			}
		}
		return size;
	}
}
