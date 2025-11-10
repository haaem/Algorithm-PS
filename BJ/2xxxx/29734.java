import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ29734 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		long a = N % 8 == 0 ? (N / 8 - 1) * S + N : N / 8 * S + N;
		long b = M % 8 == 0 ? T + (M / 8 - 1) * (S + 2 * T) + M : T + M / 8 * (S + 2 * T) + M;
		if (a > b) {
			System.out.println("Dok");
			System.out.println(b);
		} else {
			System.out.println("Zip");
			System.out.println(a);
		}
	}
}
