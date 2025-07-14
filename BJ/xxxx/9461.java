import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		for (int i = 5; i <= 100; i++) {
			arr[i] = arr[i - 5] + arr[i - 1];
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(arr[N] + "\n");
		}
		System.out.println(sb);
	}
}
