import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10811 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] bucket = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			bucket[i] = i;
		}
		for (int a = 0; a < M; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			for (int b = 0; b < (j - i + 1) / 2; b++) {
				int temp = bucket[i + b];
				bucket[i + b] = bucket[j - b];
				bucket[j - b] = temp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(bucket[i]).append(" ");
		}
		System.out.println(sb);
	}
}
