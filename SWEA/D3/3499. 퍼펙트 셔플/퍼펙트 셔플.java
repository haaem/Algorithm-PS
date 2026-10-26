import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String[] s = new String[n];

			for (int i = 0; i < n; i++)
				s[i] = st.nextToken();

			int half;
			if (n % 2 == 1) {
				half = n / 2 + 1;
				for (int i = 0; i < half - 1; i++) {
					sb.append(s[i]).append(" ").append(s[half + i]).append(" ");
				}
				sb.append(s[half - 1]).append("\n");
			} else {
				half = n / 2;
				for (int i = 0; i < half; i++) {
					sb.append(s[i]).append(" ").append(s[half + i]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}