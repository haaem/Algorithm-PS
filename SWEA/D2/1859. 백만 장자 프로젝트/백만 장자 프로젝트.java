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
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] price = new int[n];
			for (int i = 0; i < n; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			int[] left = new int[n];
			left[n - 1] = price[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				left[i] = Math.max(price[i], left[i + 1]);
			}

			long profit = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (left[i] > price[i]) {
					count++;
					profit -= price[i];
				} else if (left[i] == price[i]) {
					profit += price[i] * count;
					count = 0;
				}
			}

			System.out.println("#" + test_case + " " + profit);
		}
	}
}