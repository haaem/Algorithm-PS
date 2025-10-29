import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15829 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int r = 31;
		int M = 1234567891;
		long hash = 0;
		for (int i = 0; i < L; i++) {
			long pow = 1;
			for (int j = 0; j < i; j++) {
				pow *= r;
				pow %= M;
			}
			hash += (s.charAt(i) - 'a' + 1) * pow;
			hash %= M;
		}
		System.out.println(hash);
	}
}
