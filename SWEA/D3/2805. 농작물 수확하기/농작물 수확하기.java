import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int a = n / 2;

			int sum = 0;
			for (int i = 0; i <= a; i++) {
				String s = br.readLine();
				sum += s.charAt(a) - '0';
				for (int j = 1; j <= i; j++)
					sum += (s.charAt(a - j) - '0') + (s.charAt(a + j) - '0');
			}

			for (int i = a + 1; i < n; i++) {
				String s = br.readLine();
				sum += s.charAt(a) - '0';
				for (int j = 1; j <= n - 1 - i; j++)
					sum += (s.charAt(a - j) - '0') + (s.charAt(a + j) - '0');
			}

			System.out.println("#" + tc + " " + sum);
		}
	}
}