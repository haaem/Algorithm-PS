import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21921 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] sum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int count = 0;
		for (int i = 0; i <= N - X; i++) {
			int s = sum[i + X] - sum[i];
			if (s > max) {
				max = s;
				count = 1;
			} else if (s == max) {
				count++;
			}
		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}
	}
}
