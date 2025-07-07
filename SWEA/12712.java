import java.io.FileInputStream;
import java.util.Scanner;

class SWEA12712 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			int sum;
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum = arr[i][j];
					for (int k = 1; k < M; k++) {
						for (int l = 0; l < 4; l++) {
							int x = i + k * dx[l];
							int y = j + k * dy[l];
							if (x >= 0 && x < N && y >= 0 && y < N) {
								sum += arr[x][y];
							}
						}
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			dx = new int[] { -1, -1, 1, 1 };
			dy = new int[] { 1, -1, 1, -1 };
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum = arr[i][j];
					for (int k = 1; k < M; k++) {
						for (int l = 0; l < 4; l++) {
							int x = i + k * dx[l];
							int y = j + k * dy[l];
							if (x >= 0 && x < N && y >= 0 && y < N) {
								sum += arr[x][y];
							}
						}
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}