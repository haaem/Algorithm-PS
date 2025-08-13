import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569 {
	static int N;
	static int M;
	static int H;
	static int[][][] box;
	static int[] di = { -1, 1, 0, 0, 0, 0 };
	static int[] dj = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H];
		queue = new ArrayDeque<int[]>();
		boolean isAlready = true;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[i][j][h] = Integer.parseInt(st.nextToken());
					if (box[i][j][h] == 1) {
						queue.add(new int[] { i, j, h });
					} else if (box[i][j][h] == 0) {
						isAlready = false;
					}
				}
			}
		}
		if (isAlready)
			System.out.println(0);
		else {
			bfs();
			int c = 0;
			boolean cant = false;
			loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int h = 0; h < H; h++) {
						if (box[i][j][h] == 0) {
							cant = true;
							break loop;
						}
						if (box[i][j][h] > c) {
							c = box[i][j][h];
						}
					}
				}
			}
			if (cant)
				System.out.println(-1);
			else
				System.out.println(c - 1);
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int[] coor = queue.poll();

			int i = coor[0];
			int j = coor[1];
			int h = coor[2];

			for (int a = 0; a < 6; a++) {
				int ni = i + di[a];
				int nj = j + dj[a];
				int nh = h + dh[a];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && nh >= 0 && nh < H) {
					if (box[ni][nj][nh] == 0) {
						box[ni][nj][nh] = box[i][j][h] + 1;
						queue.add(new int[] { ni, nj, nh });
					}
				}
			}
		}
	}
}
