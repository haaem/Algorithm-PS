import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ18110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int r = (int) Math.round(n * 0.15);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int sum = 0;
		for (int i = r; i < n - r; i++) {
			sum += arr[i];
		}
		System.out.println(Math.round(((double) sum) / (n - 2 * r)));
	}
}
