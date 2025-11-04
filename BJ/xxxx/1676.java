import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ1676 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= N; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		int count = 0;
		String s = String.valueOf(fact);
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				count++;
			} else {
				break;
			}
		}
		System.out.println(count);
	}
}
