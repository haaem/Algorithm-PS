import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2721 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int k = 1; k <= n; k++) {
				int t = (k + 1) * (k + 2) / 2;
				sum += k * t;
			}
			System.out.println(sum);
		}
	}
}
