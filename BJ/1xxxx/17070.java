import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17070 {
	static int N;
	static int[][] house;
	static int count;
	static final int HORIZONTAL = 0;
	static final int VERTICAL = 1;
	static final int DIAGONAL = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		house = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 2, HORIZONTAL);
		System.out.println(count);
	}

	static void dfs(int r, int c, int dir) {
		if (r > N || c > N || house[r][c] == 1) {
			return;
		}
		if (dir == DIAGONAL) {
			if (house[r - 1][c] == 1 || house[r][c - 1] == 1)
				return;
		}
		if (r == N && c == N) {
			count++;
			return;
		}
		if (dir == HORIZONTAL) {
			dfs(r, c + 1, HORIZONTAL);
			dfs(r + 1, c + 1, DIAGONAL);
		} else if (dir == VERTICAL) {
			dfs(r + 1, c, VERTICAL);
			dfs(r + 1, c + 1, DIAGONAL);
		} else if (dir == DIAGONAL) {
			dfs(r, c + 1, HORIZONTAL);
			dfs(r + 1, c, VERTICAL);
			dfs(r + 1, c + 1, DIAGONAL);
		}
	}
}
