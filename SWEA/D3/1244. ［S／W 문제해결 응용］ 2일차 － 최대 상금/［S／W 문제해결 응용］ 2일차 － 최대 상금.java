import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int change, answer;
	static char[] num;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			answer = 0;
			change = Integer.parseInt(st.nextToken());
			num = s.toCharArray();
			backtracking(0, 0);
			System.out.println("#" + test_case + " " + answer);
		}
	}

	static void backtracking(int depth, int count) {
		if (change == count) {
			answer = Math.max(answer, Integer.parseInt(new String(num)));
			return;
		}

		for (int i = depth; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				swap(i, j);
				backtracking(i, count + 1);
				swap(i, j);
			}
		}
	}

	static void swap(int i, int j) {
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}