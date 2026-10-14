import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String to = br.readLine();
			int ans = 0;

			int prev = 0;
			for (int i = 0; i < to.length(); i++) {
				int now = to.charAt(i) - '0';

				if (prev != now) {
					prev = now;
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}