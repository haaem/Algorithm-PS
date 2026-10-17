import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			if (s.contains("3") || s.contains("6") || s.contains("9")) {
				int count = 0;
				for (int j = 0; j < s.length(); j++) {
					char c = s.charAt(j);
					if (c == '3' || c == '6' || c == '9')
						count++;
				}

				for (int j = 0; j < count; j++)
					sb.append('-');
			} else {
				sb.append(i);
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}