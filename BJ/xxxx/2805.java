import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {
	static int N, M;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(search(0, arr[N - 1]));
	}

	public static long search(long start, long end) {
		long max = Long.MIN_VALUE;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] < mid)
					break;
				sum += arr[i] - mid;
			}
//			System.out.println(mid + " " + sum);
			if (sum >= M) {
				max = Math.max(max, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return max;
	}
}
