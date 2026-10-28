import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dy = { 1, 0 };
		int[] dx = { 0, 1 };

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] puzzle = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					puzzle[i][j] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (puzzle[i][j] == 0)
						continue;

					loop: for (int a = 0; a < 2; a++) {
						if (i + (k - 1) * dy[a] >= n || j + (k - 1) * dx[a] >= n)
							continue;

						int py = i - dy[a], px = j - dx[a];
						if (py >= 0 && px >= 0 && puzzle[py][px] == 1)
							continue;

						for (int b = 0; b < k; b++) {
							if (puzzle[i + b * dy[a]][j + b * dx[a]] == 0)
								continue loop;
						}

						int ey = i + k * dy[a], ex = j + k * dx[a];
						if (ey >= n || ex >= n || puzzle[ey][ex] == 0)
							count++;
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}