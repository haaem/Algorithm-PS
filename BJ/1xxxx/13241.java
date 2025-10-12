import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13241 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long gcd = gcd(A, B);
		System.out.println(A / gcd * B);
	}

	static long gcd(long a, long b) {
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}