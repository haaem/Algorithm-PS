import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14916 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int c = n / 5; c >= 0; c--) {
			int t = n - 5 * c;
			if (t % 2 == 0) {
				System.out.println(t / 2 + c);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
}
