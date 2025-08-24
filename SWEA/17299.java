import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA17299 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String S = br.readLine();
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < S.length() - 1; i++) {
				int a = Integer.parseInt(S.substring(0, i + 1));
				int b = Integer.parseInt(S.substring(i + 1, S.length()));
				min = Math.min(min, a + b);
			}
			System.out.println("#" + test_case + " " + min);
		}
	}
}
