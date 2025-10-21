import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2776 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int target = Integer.parseInt(st.nextToken());
				int l = 0;
				int r = N - 1;
				boolean found = false;
				while (l <= r) {
					int mid = (l + r) / 2;
					if (A[mid] == target) {
						found = true;
						break;
					}
					if (A[mid] < target) {
						l = mid + 1;
					} else {
						r = mid - 1;
					}
				}
				if (found)
					sb.append("1\n");
				else
					sb.append("0\n");
			}
		}
		System.out.println(sb);
	}
}
