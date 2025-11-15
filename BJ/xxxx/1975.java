import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1975 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			for (int i = 2; i <= N; i++) {
				int temp = N;
				while (true) {
					if (temp % i != 0)
						break;
					count++;
					temp /= i;
				}
			}
			System.out.println(count);
		}
	}
}
