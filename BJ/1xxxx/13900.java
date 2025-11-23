import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13900 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[] sum = new long[N];
		sum[N - 1] = arr[N - 1];
		for (int i = N - 2; i > 0; i--) {
			sum[i] = arr[i] + sum[i + 1];
		}
		long res = 0;
		for (int i = 0; i < N - 1; i++) {
			res += arr[i] * sum[i + 1];
		}
		System.out.println(res);
	}
}
