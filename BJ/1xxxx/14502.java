import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {
	static int N, M;
	static int max;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] search;
	static int[] save;
	static ArrayList<int[]> zero;
	static ArrayList<int[]> virus;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		search = new int[N][M];
		zero = new ArrayList<int[]>();
		virus = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = search[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zero.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}

		save = new int[3];
		max = Integer.MIN_VALUE;
		combi(0, 0);
		System.out.println(max);
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i));
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int a = 0; a < 4; a++) {
				int ni = cur[0] + di[a];
				int nj = cur[1] + dj[a];
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && search[ni][nj] == 0) {
					search[ni][nj] = 2;
					queue.offer(new int[] { ni, nj });
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (search[i][j] == 0) {
					sum++;
				}
			}
		}
		max = Math.max(sum, max);
	}

	static void combi(int depth, int start) {
		if (depth == 3) {
			for (int i = 0; i < N; i++) {
				search[i] = Arrays.copyOf(map[i], M);
			}
			for (int i = 0; i < 3; i++) {
				int[] temp = zero.get(save[i]);
				search[temp[0]][temp[1]] = 1;
			}
			bfs();
			return;
		}
		for (int i = start; i < zero.size(); i++) {
			save[depth] = i;
			combi(depth + 1, i + 1);
		}
	}
}
