import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2485 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int gcd = 0;
		for (int i = 0; i < N - 1; i++) {
			gcd = gcd(arr[i + 1] - arr[i], gcd);
		}
		System.out.println((arr[N - 1] - arr[0]) / gcd + 1 - N);
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
