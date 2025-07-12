import java.io.FileInputStream;
import java.util.Scanner;

class SWEA1959 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			int[] big;
			int[] small;
			if (N >= M) {
				big = A;
				small = B;
			} else {
				big = B;
				small = A;
			}
			int total;
			int max = 0;
			for (int i = 0; i <= big.length - small.length; i++) {
				total = 0;
				for (int j = 0; j < small.length; j++) {
					total += big[i + j] * small[j];
				}
				if (total > max)
					max = total;
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}