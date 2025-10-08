import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11444 {
	static long n;
	static int[][] mat = new int[2][2];
	static final int mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		mat[0][0] = mat[0][1] = mat[1][0] = 1;
		mat[1][1] = 0;
		System.out.println(power(n)[1][0]);
	}

	static int[][] power(long n) {
		if (n == 1) {
			return mat;
		}
		int[][] half = power(n / 2);
		if (n % 2 == 0) {
			return calculate(half, half);
		} else {
			return calculate(calculate(half, half), mat);
		}
	}

	static int[][] calculate(int[][] A, int[][] B) {
		int[][] res = new int[2][2];
		res[0][0] = (int) (((long) A[0][0] * B[0][0] + (long) A[0][1] * B[1][0]) % mod);
		res[0][1] = (int) (((long) A[0][0] * B[0][1] + (long) A[0][1] * B[1][1]) % mod);
		res[1][0] = (int) (((long) A[1][0] * B[0][0] + (long) A[1][1] * B[1][0]) % mod);
		res[1][1] = (int) (((long) A[1][0] * B[0][1] + (long) A[1][1] * B[1][1]) % mod);
		return res;
	}
}
