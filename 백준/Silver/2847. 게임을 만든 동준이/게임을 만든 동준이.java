import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int sum = 0;
		int before = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (before <= arr[i]) {
				sum += arr[i] - (before - 1);
				arr[i] = before - 1;
			}
			before = arr[i];
		}

		System.out.println(sum);
	}
}
