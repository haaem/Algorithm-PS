import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[] A = new int[n];
			int[] B = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}

			int[] sum = new int[5002];

			for (int i = 0; i < n; i++) {
				sum[A[i]]++;
				sum[B[i] + 1]--;
			}

			for (int i = 1; i <= 5000; i++)
				sum[i] += sum[i - 1];

			int p = Integer.parseInt(br.readLine());
			for (int i = 0; i < p; i++)
				sb.append(sum[Integer.parseInt(br.readLine())]).append(" ");
			sb.append("\n");
		}

		System.out.println(sb);
	}
}