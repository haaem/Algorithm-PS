import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1961 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringBuilder[] ans = new StringBuilder[N];
			for (int i = 0; i < N; i++) {
				ans[i] = new StringBuilder();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans[i].append(arr[N - 1 - j][i]);
					if (j == N - 1) {
						ans[i].append(" ");
					}
				}
				for (int j = 0; j < N; j++) {
					ans[i].append(arr[N - 1 - i][N - 1 - j]);
					if (j == N - 1) {
						ans[i].append(" ");
					}
				}
				for (int j = 0; j < N; j++) {
					ans[i].append(arr[j][N - 1 - i]);
					if (j == N - 1) {
						ans[i].append(" ");
					}
				}
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				System.out.println(ans[i]);
			}
		}
	}
}