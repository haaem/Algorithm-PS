import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1740 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long num = 1, sum = 0;
		while (N > 0) {
			if ((N & 1) == 1) {
				sum += num;
			}
			num *= 3;
			N >>= 1;
		}
		System.out.println(sum);
	}
}
