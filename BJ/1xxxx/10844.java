import java.util.Scanner;

public class BJ10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] arr = new long[N][10];
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				arr[0][i] = 0;
			} else {
				arr[0][i] = 1;
			}
		}
		long mod = 1000000000L;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					arr[i][j] = arr[i - 1][1] % mod;
				} else if (j == 9) {
					arr[i][j] = arr[i - 1][8] % mod;
				} else {
					arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % mod;
				}
			}
		}
		long count = 0;
		for (int i = 0; i < 10; i++) {
			count += arr[N - 1][i];
		}
		System.out.println(count % mod);
	}
}
