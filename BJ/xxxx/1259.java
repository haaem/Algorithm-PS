import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1259 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = br.readLine();
		while (!num.equals("0")) {
			boolean isPalindrome = true;
			for (int i = 0; i < num.length() / 2; i++) {
				if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
					isPalindrome = false;
					break;
				}
			}
			if (isPalindrome)
				sb.append("yes\n");
			else
				sb.append("no\n");
			num = br.readLine();
		}
		System.out.println(sb);
	}
}
