import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		if (N == 1 || N == 2) {
			count = 1;
		} else {
			int start = 1;
			int end = 1;
			int sum = 1;
			while (end <= N) {
				if (sum == N) {
					count++;
					end++;
					sum += end;
				} else if (sum < N) {
					end++;
					sum += end;
				} else { // sum > N
					sum -= start;
					start++;
				}
			}
		}
		System.out.println(count);
	}
}
