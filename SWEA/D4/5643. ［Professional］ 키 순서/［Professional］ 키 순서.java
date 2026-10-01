import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			int[][] rank = new int[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				rank[a][b] = 1;
				rank[b][a] = -1;
			}

			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (rank[i][k] == 0 || rank[k][j] == 0)
							continue;

						if (rank[i][k] == 1 && rank[k][j] == 1) {
							rank[i][j] = 1;
							rank[j][i] = -1;
						} else if (rank[i][k] == -1 && rank[k][j] == -1) {
							rank[i][j] = -1;
							rank[j][i] = 1;
						}
					}
				}
			}

			int count = 0;
			loop: for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (rank[i][j] == 0)
						continue loop;
				}
				count++;
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}