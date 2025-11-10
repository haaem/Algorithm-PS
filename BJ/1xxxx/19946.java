import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ19946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());

		int K = 64;
		while (N.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			N = N.divide(BigInteger.valueOf(2));
			K--;
		}
		System.out.println(K);
	}
}