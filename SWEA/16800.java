import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA16800 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			// N이 10^12이기 때문에 O(N^2)인 이차원 배열 bfs같은 건 절대 불가능
			long N = Long.parseLong(br.readLine());
			if (isPrime(N))
				System.out.println("#" + test_case + " " + (N - 1));
			else {
				// 최악의 경우라고 가정해도 41*10^6이므로 2초 내에 가능
				long a = 1;
				long b = N;
				for (long i = (long) Math.sqrt(N); i > 0; i--) {
					if (N % i == 0) {
						a = i;
						b = N / i;
						break;
					}
				}
				System.out.println("#" + test_case + " " + (a + b - 2));
			}
		}
	}

	static boolean isPrime(long N) {
		// 소수 판별 시 제곱근을 포함해야
		for (long i = 2; i <= Math.sqrt(N); i++) {
			if (N % i == 0)
				return false;
		}
		return true;
	}
}
