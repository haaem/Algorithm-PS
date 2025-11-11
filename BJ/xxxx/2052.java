import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class BJ2052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigDecimal half = new BigDecimal("0.5");
		BigDecimal bd = half.pow(N);
		System.out.println(bd.toPlainString());
	}
}
