import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			String tar = br.readLine();
			String sentence = br.readLine();
			int count = 0;
			int len = tar.length();

			for (int i = 0; i <= sentence.length() - len; i++) {
				if (sentence.substring(i, i + len).equals(tar)) {
					count++;
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}