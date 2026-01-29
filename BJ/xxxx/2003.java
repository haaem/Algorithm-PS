import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		int[] sum = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				sum[i] = A[0];
			} else {
				sum[i] = A[i] + sum[i - 1];
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (M == sum[i])
				count++;
		}
		for (int i = 1; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (M == sum[j] - sum[i - 1])
					count++;
			}
		}
		System.out.println(count);
	}
}
