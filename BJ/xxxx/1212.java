import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1212 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String base8 = br.readLine();
		if (base8.equals("0")) {
			System.out.println(0);
			return;
		}
		StringBuilder sb = new StringBuilder();
		String[] s = { "000", "001", "010", "011", "100", "101", "110", "111" };
		for (int i = 0; i < base8.length(); i++) {
			sb.append(s[base8.charAt(i) - '0']);
		}
		while (sb.charAt(0) == '0') {
			sb = new StringBuilder(sb.substring(1));
		}
		System.out.println(sb);
	}
}
