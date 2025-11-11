import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ30088 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j < c; j++) {
				sum[i] += Integer.parseInt(st.nextToken());
			}
		}
		long total = 0;
		Arrays.sort(sum);
		for (int i = 0; i < N; i++) {
			total += sum[i] * (N - i);
		}
		System.out.println(total);
	}
}
