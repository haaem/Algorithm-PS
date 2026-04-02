import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10808 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(alpha[i]).append(" ");
		}
		System.out.println(sb);
	}
}
