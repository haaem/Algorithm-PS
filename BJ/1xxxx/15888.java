import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15888 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		double in = Math.pow((double) B * B - 4 * A * C, 0.5);
		double n = (-B + in) / (2 * A);
		double m = (-B - in) / (2 * A);
		if (n % 1 != 0.0 || m % 1 != 0.0 || n == m) {
			System.out.println("둘다틀렸근");
		} else {
			if (n > 1 && m > 1 && ((int) n & ((int) n - 1)) == 0 && ((int) m & ((int) m - 1)) == 0) {
				System.out.println("이수근");
			} else {
				System.out.println("정수근");
			}
		}
	}
}
