import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10830 {
	static int N;
	static int[][] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken()); // B 범위가 매우 크므로 입력 받을 때 주의
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] res = pow(A, B);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] pow(int[][] arr, long n) {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			res[i][i] = 1;
		}
		while (n > 0) {
			if (n % 2 == 1) {
				res = calculate(arr, res);
			}
			arr = calculate(arr, arr);
			n /= 2;
		}
		return res;
	}

//	static int[][] pow(int[][] arr, long n) {
//		if (n == 1) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					arr[i][j] %= 1000;
//				}
//			}
//			return arr;
//		}
//		int[][] half = pow(arr, n / 2);
//		if (n % 2 == 0) {
//			return calculate(half, half);
//		} else {
//			int[][] temp = calculate(half, half);
//			return calculate(temp, A);
//		}
//	}

	static int[][] calculate(int[][] a, int[][] b) {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				long sum = 0;
				for (int j = 0; j < N; j++) {
					sum += a[i][j] * b[j][k];
				}
				res[i][k] = (int) (sum % 1000);
			}
		}
		return res;
	}
}
