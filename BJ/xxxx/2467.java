import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2467 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = N - 1;
		int ans1 = arr[left];
		int ans2 = arr[right];
		long sum = Math.abs(arr[left] + arr[right]);
		while (left < right) {
			long temp = arr[left] + arr[right];
			if (Math.abs(temp) < Math.abs(sum)) {
				sum = Math.abs(temp);
				ans1 = arr[left];
				ans2 = arr[right];
			}
			if (temp >= 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(ans1 + " " + ans2);
	}
}