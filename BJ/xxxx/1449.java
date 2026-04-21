import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1449 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if (L == 1) {
			System.out.println(N);
			return;
		}
		int count = 1;
		double now = arr[0] + L - 0.5;
		for (int i = 1; i < N; i++) {
			if (arr[i] >= now) {
				count++;
				now = arr[i] + L - 0.5;
			}
		}
		System.out.println(count);
	}
}
