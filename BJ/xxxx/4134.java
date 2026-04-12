import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ4134 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			long n = Long.parseLong(br.readLine());
			if (n <= 1)
				n = 2;
			while (true) {
				boolean isPrime = true;
				for (int j = 2; j < Math.sqrt(n); j++) {
					if (n % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					System.out.println(n);
					break;
				}
				n++;
			}
		}
	}
}
