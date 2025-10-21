import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12015 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] lis = new int[N];
		lis[0] = A[0];
		int nextIndex = 1;
		for (int i = 1; i < N; i++) {
			int k = A[i];
			if (lis[nextIndex - 1] < k) {
				lis[nextIndex++] = k;
			} else {
				int left = 0;
				int right = nextIndex;
				while (left < right) {
					int mid = (left + right) / 2;
					if (lis[mid] < k)
						left = mid + 1;
					else
						right = mid;
				}
				lis[left] = k;
			}
		}
		System.out.println(nextIndex);
	}
}
