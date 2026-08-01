import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int[] count = new int[101];
			for (int i = 0; i < 1000; i++) {
				count[Integer.parseInt(st.nextToken())]++;
			}

			int max = 0;
			int answer = 0;
			for (int i = 0; i <= 100; i++) {
				if (count[i] >= max) {
					answer = i;
					max = count[i];
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}
}