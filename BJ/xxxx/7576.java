import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	static int N;
	static int M;
	static int[][] box;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		queue = new ArrayDeque<int[]>();
		boolean already = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0)
					already = false;
				if (box[i][j] == 1)
					queue.add(new int[] { i, j });
			}
		}
		if (already) {
			System.out.println(0);
		} else {
			bfs();
			int max = 0;
			boolean cant = false;
			loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j] == 0) {
						cant = true;
						break loop;
					} else {
						max = Math.max(max, box[i][j]);
					}
				}
			}
			if (cant)
				System.out.println(-1);
			else
				System.out.println(max - 1);
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int a = 0; a < 4; a++) {
				int ni = temp[0] + di[a];
				int nj = temp[1] + dj[a];
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && box[ni][nj] == 0) {
					box[ni][nj] = box[temp[0]][temp[1]] + 1;
					queue.add(new int[] { ni, nj });
				}
			}
		}
	}
}
