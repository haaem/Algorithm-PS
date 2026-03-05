import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1213 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 'A']++;
		}
		int odd = 0;
		int index = -1;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 == 1) {
				odd++;
				index = i;
			}
			if (odd > 1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}
		String res = "";
		if (index != -1) {
			res += (char) (index + 'A');
		}
		for (int i = 25; i >= 0; i--) {
			int half = alpha[i] / 2;
			char c = (char) (i + 'A');
			for (int j = 0; j < half; j++) {
				res = c + res + c;
			}
		}
		System.out.println(res);
	}
}
