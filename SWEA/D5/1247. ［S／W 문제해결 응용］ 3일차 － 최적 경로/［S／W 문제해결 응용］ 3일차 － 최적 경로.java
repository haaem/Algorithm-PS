import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static int[] company, home;
	static int[][] coor;
	static int min, n;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			visited = new boolean[n];
			st = new StringTokenizer(br.readLine());

			company = new int[2];
			home = new int[2];
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			coor = new int[n][2];
			for (int i = 0; i < n; i++) {
				coor[i][0] = Integer.parseInt(st.nextToken());
				coor[i][1] = Integer.parseInt(st.nextToken());
			}

			backtracking(0, company, 0);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void backtracking(int depth, int[] now, int sum) {
		if (sum >= min)
			return;

		if (depth == n) {
			min = Math.min(min, sum + Math.abs(now[0] - home[0]) + Math.abs(now[1] - home[1]));
			return;
		}

		for (int a = 0; a < n; a++) {
			if (!visited[a]) {
				visited[a] = true;
				int[] next = coor[a];
				backtracking(depth + 1, next, sum + Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]));
				visited[a] = false;
			}
		}
	}
}