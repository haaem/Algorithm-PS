import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if (i == 1) {
				sb.append(arr[j - 1]).append("\n");
			} else {
				sb.append(arr[j - 1] - arr[i - 2]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
