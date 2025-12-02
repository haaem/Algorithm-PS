import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21736 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] campus = new char[N][M];
		int y = -1, x = -1;
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < M; j++) {
				campus[i][j] = S.charAt(j);
				if (campus[i][j] == 'I') {
					campus[i][j] = 'O';
					y = i;
					x = j;
				}
			}
		}

		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		visited[y][x] = true;
		queue.offer(new int[] { y, x });

		int count = 0;
		while (!queue.isEmpty()) {
			int[] t = queue.poll();
			int cy = t[0];
			int cx = t[1];

			for (int a = 0; a < 4; a++) {
				int ny = cy + dy[a];
				int nx = cx + dx[a];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || campus[ny][nx] == 'X')
					continue;
				if (campus[ny][nx] == 'P')
					count++;
				visited[ny][nx] = true;
				queue.offer(new int[] { ny, nx });
			}
		}
		if (count > 0) {
			System.out.println(count);
		} else {
			System.out.println("TT");
		}
	}
}
