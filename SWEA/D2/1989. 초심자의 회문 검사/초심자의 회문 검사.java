import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			int len = s.length();
			boolean pal = true;

			for (int i = 0; i < len; i++) {
				if (s.charAt(i) != s.charAt(len - 1 - i)) {
					pal = false;
					break;
				}
			}

			if (pal)
				System.out.println("#" + tc + " 1");
			else
				System.out.println("#" + tc + " 0");
		}
	}
}