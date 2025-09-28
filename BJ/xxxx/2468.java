import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468 {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[][] arr;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		int maxArea = 0;
		for (int height = 0; height <= max; height++) {
			int count = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && arr[i][j] > height) {
						bfs(i, j, height);
						count++;
					}
				}
			}
			maxArea = Math.max(maxArea, count);
		}
		System.out.println(maxArea);
	}

	public static void bfs(int i, int j, int h) {
		visited[i][j] = true;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int a = 0; a < 4; a++) {
				int ni = cur[0] + di[a];
				int nj = cur[1] + dj[a];

				if (ni < 0 || nj < 0 || ni >= N || nj >= N || visited[ni][nj] || arr[ni][nj] <= h)
					continue;
				visited[ni][nj] = true;
				queue.offer(new int[] { ni, nj });
			}
		}
	}
}
