import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ17135 {
	static int[][] board;
	static int N;
	static int M;
	static int D;
	static int max;
	static ArrayList<int[]> enemy;
	static int[] archer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		max = 0;
		board = new int[N][M];
		archer = new int[3];
		enemy = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					enemy.add(new int[] { i, j });
				}
			}
		}
		combi(0, 0);
		System.out.println(max);
	}

	public static void combi(int depth, int start) {
		if (depth == 3) {
			attack();
			return;
		}
		for (int i = start; i < M; i++) {
			archer[depth] = i;
			combi(depth + 1, i + 1);
		}
	}

	public static void attack() {
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(board[i], M);
		}
		int count = 0;
		for (int h = N; h > 0; h--) {
			boolean[][] visited = new boolean[N][M];
			ArrayList<int[]> tar = new ArrayList<int[]>();
			for (int i = 0; i < 3; i++) {
				PriorityQueue<Enemy> pq = new PriorityQueue<Enemy>();
				int ac = archer[i];
				for (int r = 0; r < h; r++) {
					for (int c = 0; c < M; c++) {
						if (map[r][c] == 1) {
							int d = Math.abs(h - r) + Math.abs(ac - c);
							if (d <= D)
								pq.offer(new Enemy(r, c, d));
						}
					}
				}
				if (!pq.isEmpty()) {
					Enemy cur = pq.poll();
					if (!visited[cur.i][cur.j]) {
						visited[cur.i][cur.j] = true;
						tar.add(new int[] { cur.i, cur.j });
					}
				}
			}
			for (int[] t : tar) {
				if (map[t[0]][t[1]] == 1) {
					map[t[0]][t[1]] = 0;
					count++;
				}
			}
		}
		max = Math.max(max, count);
	}
}

class Enemy implements Comparable<Enemy> {
	int i, j;
	int dist;

	public Enemy(int i, int j, int dist) {
		this.i = i;
		this.j = j;
		this.dist = dist;
	}

	@Override
	public int compareTo(Enemy o) {
		if (this.dist == o.dist) {
			return this.j - o.j;
		}
		return this.dist - o.dist;
	}
}
