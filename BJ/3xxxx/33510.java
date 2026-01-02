import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ33510 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String X = br.readLine();
		int count = 0;
		boolean carry = false;
		for (int i = N - 1; i > 0; i--) {
			if (X.charAt(i) == '0' && !carry) {
				carry = false;
			} else if ((X.charAt(i) == '0' && carry) || (X.charAt(i) == '1' && !carry)) {
				count++;
				carry = true;
			} else if (X.charAt(i) == '1' && carry) {
				carry = true;
			}
		}
		System.out.println(count);
	}
}