import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20551 {
	static int N;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(A);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(binarySearch(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb);
	}

	static int binarySearch(int x) {
		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == x) {
				while (true) {
					if (mid == 0)
						return 0;
					if (A[mid - 1] == x)
						mid--;
					else
						return mid;
				}
			} else if (A[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
