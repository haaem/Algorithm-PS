import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ5585 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 1000 - Integer.parseInt(br.readLine());
		int count = 0;
		int[] balance = { 500, 100, 50, 10, 5, 1 };
		for (int i = 0; i < balance.length; i++) {
			if (N == 0)
				break;
			count += N / balance[i];
			N %= balance[i];
		}
		System.out.println(count);
	}
}
