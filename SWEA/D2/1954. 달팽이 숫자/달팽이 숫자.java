import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			int n = Integer.parseInt(br.readLine());
			int t = 1;
			int dir = 0;
			int[][] ans = new int[n][n];
			int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			int i = 0, j = 0;

			while (t <= n * n) {
				ans[i][j] = t++;
				int ni = i + move[dir % 4][0];
				int nj = j + move[dir % 4][1];
				if (ni < 0 || nj < 0 || ni >= n || nj >= n || ans[ni][nj] != 0)
					dir++;
				i += move[dir % 4][0];
				j += move[dir % 4][1];
			}

			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					System.out.print(ans[a][b] + " ");
				}
				System.out.println();
			}
		}
	}
}