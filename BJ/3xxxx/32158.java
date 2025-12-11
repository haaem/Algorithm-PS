import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ32158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String S = br.readLine();
		int p = 0;
		int c = 0;
		char[] ans = new char[len];
		for (int i = 0; i < len; i++) {
			char ch = S.charAt(i);
			if (ch == 'P')
				p++;
			else if (ch == 'C')
				c++;
			ans[i] = ch;
		}
		int swap = Math.min(p, c);
		p = swap;
		c = swap;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (ans[i] == 'P' && p > 0) {
				ans[i] = 'C';
				p--;
			} else if (ans[i] == 'C' && c > 0) {
				ans[i] = 'P';
				c--;
			}
			sb.append(ans[i]);
		}
		System.out.println(sb);
	}
}
