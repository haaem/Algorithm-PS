import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1300 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		long k = Integer.parseInt(br.readLine());
		long left = 1;
		long right = k;
		while (left < right) {
			long mid = (left + right) / 2;
			long count = 0;

			for (int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}

			if (k <= count)
				right = mid;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}
}
