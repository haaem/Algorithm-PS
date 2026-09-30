import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int total = 0;

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total += arr[i];
			}

			int[] score = new int[total + 1];
			score[0] = 1;
			for (int p : arr) {
				int[] temp = score.clone();
				for (int i = 1; i + p <= total; i++) {
					if (score[i] == 1)
						temp[i + p] = 1;
				}
				score = temp;
				score[p] = 1;
			}

			int ans = 0;
			for (int s : score) {
				if (s == 1)
					ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}