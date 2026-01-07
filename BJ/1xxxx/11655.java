import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				int val = c + 13;
				if (val > 'z')
					sb.append((char) (val - 26));
				else
					sb.append((char) val);
			} else if (c >= 'A' && c <= 'Z') {
				int val = c + 13;
				if (val > 'Z')
					sb.append((char) (val - 26));
				else
					sb.append((char) val);
			} else
				sb.append(c);
		}
		System.out.println(sb);
	}
}
