import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ1247 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 3; t++) {
			int N = Integer.parseInt(br.readLine());
			BigInteger S = BigInteger.ZERO;
			for (int i = 0; i < N; i++) {
				S = S.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
			}
			int c = S.compareTo(BigInteger.ZERO);
			if (c > 0)
				System.out.println('+');
			else if (c == 0)
				System.out.println(0);
			else
				System.out.println('-');
		}
	}
}
