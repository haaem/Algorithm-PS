import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1075 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		N = N / 100 * 100;
		while (N % F != 0) {
			N++;
		}
		System.out.printf("%02d\n", N % 100);
	}
}
