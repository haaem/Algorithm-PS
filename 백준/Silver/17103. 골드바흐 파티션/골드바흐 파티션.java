import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int MAX = 1_000_000;
		boolean[] prime = new boolean[1_000_001];
		Arrays.fill(prime, true);

		prime[0] = prime[1] = false;

		for (int i = 2; i * i <= MAX; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= MAX; j += i)
					prime[j] = false;
			}
		}

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;

			for (int j = 2; j <= n / 2; j++) {
				if (prime[j] && prime[n - j])
					count++;
			}
			System.out.println(count);
		}
	}
}
