import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ13706 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger b = new BigInteger(br.readLine());
		System.out.println(b.sqrt()); // JAVA 9 버전 이상에서
	}
}
