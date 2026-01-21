import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N <= 2) {
			System.out.println(0);
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int count = 0;

		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			int num = A[i];
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				} else if (right == i) {
					right--;
					continue;
				}
				if (A[left] + A[right] == num) {
					count++;
					break;
				} else if (A[left] + A[right] < num) {
					left++;
				} else {
					right--;
				}
			}
		}
		System.out.println(count);
	}
}
