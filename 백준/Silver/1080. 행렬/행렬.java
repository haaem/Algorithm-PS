import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] before, after;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		before = new int[n][m];
		after = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				before[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				after[i][j] = s.charAt(j) - '0';
			}
		}

		if (n < 3 || m < 3) {
			if (!isSame())
				System.out.println(-1);
			else
				System.out.println(0);
			return;
		}

		int count = 0;
		for (int i = 0; i <= n - 3; i++) {
			for (int j = 0; j <= m - 3; j++) {
				if (before[i][j] != after[i][j]) {
					change(i, j);
					count++;
				}
			}
		}

		if (isSame())
			System.out.println(count);
		else
			System.out.println(-1);
	}

	static boolean isSame() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (before[i][j] != after[i][j])
					return false;
			}
		}
		return true;
	}

	static void change(int i, int j) {
		for (int a = i; a < i + 3; a++) {
			for (int b = j; b < j + 3; b++) {
				before[a][b] = (before[a][b] + 1) % 2;
			}
		}
	}
}