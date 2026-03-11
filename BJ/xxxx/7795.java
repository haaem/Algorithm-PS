import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ7795 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int[] b = new int[M];
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			Arrays.sort(b);
			int count = 0;
			for (int i = N - 1; i >= 0; i--) {
				int left = 0;
				int right = M - 1;
				int now = 0;
				while (left <= right) {
					int mid = (left + right) / 2;
					if (a[i] > b[mid]) {
						now = mid + 1;
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				count += now;
			}
			System.out.println(count);
		}
	}
}
