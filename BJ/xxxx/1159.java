import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1159 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			char c = name.charAt(0);
			alpha[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (alpha[i] >= 5) {
				sb.append((char) (i + 'a'));
			}
		}
		if (sb.length() == 0) {
			System.out.println("PREDAJA");
		} else {
			System.out.println(sb);
		}
	}
}
