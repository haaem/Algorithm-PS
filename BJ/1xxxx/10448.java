import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10448 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[45];
		for (int i = 1; i <= 44; i++) {
			arr[i] = i * (i + 1) / 2;
		}
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			boolean possible = false;
			loop: for (int i = 1; i <= 44; i++) {
				for (int j = 1; j <= 44; j++) {
					for (int k = 1; k <= 44; k++) {
						int sum = arr[i] + arr[j] + arr[k];
						if (sum == K) {
//							sb.append(arr[i] + " " + arr[j] + " " + arr[k]).append("\n");
							possible = true;
							break loop;
						}
					}
				}
			}
			if (possible)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
	}
}
