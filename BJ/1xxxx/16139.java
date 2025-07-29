import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16139 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int len = S.length();
		int[][] count = new int[26][len];
		for (int i = 0; i < len; i++) {
			char t = S.charAt(i);
			for (int j = 0; j < 26; j++) {
				if (j == t - 'a') {
					if (i == 0) {
						count[j][i]++;
					} else {
						count[j][i] = count[j][i - 1] + 1;
					}
				} else {
					if (i == 0) {
						continue;
					} else {
						count[j][i] = count[j][i - 1];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start == 0) {
				sb.append(count[a][end]).append("\n");
			} else {
				sb.append(count[a][end] - count[a][start - 1]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
