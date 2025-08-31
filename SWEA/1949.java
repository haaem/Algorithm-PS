import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1949 {
	static int N, K;
	static int[][] map;
	static int len;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			ArrayList<int[]> top = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max == map[i][j])
						top.add(new int[] { i, j });
				}
			}
			len = Integer.MIN_VALUE;
			visited = new boolean[N][N];

			for (int[] a : top) {
				visited[a[0]][a[1]] = true;
				dfs(a, 1, max, false);
				visited[a[0]][a[1]] = false;
			}
			sb.append(len).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int[] coor, int l, int h, boolean cut) {
		len = Math.max(len, l);

		for (int a = 0; a < 4; a++) {
			int ni = coor[0] + di[a];
			int nj = coor[1] + dj[a];

			if (ni < 0 || nj < 0 || ni >= N || nj >= N || visited[ni][nj])
				continue;
			if (cut) {
				if (map[ni][nj] < h) {
					visited[ni][nj] = true;
					dfs(new int[] { ni, nj }, l + 1, map[ni][nj], cut);
					visited[ni][nj] = false;
				}
			} else {
				if (map[ni][nj] < h) {
					visited[ni][nj] = true;
					dfs(new int[] { ni, nj }, l + 1, map[ni][nj], cut);
					visited[ni][nj] = false;
				} else if (map[ni][nj] - K < h) {
					visited[ni][nj] = true;
					dfs(new int[] { ni, nj }, l + 1, h - 1, true);
					visited[ni][nj] = false;
				}
			}
		}
	}
}
