import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			double[] score = new double[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Double.parseDouble(st.nextToken()) * 0.35 + Double.parseDouble(st.nextToken()) * 0.45
						+ Double.parseDouble(st.nextToken()) * 0.2;
			}

			double target = score[k - 1];
			Arrays.sort(score);

			for (int i = 0; i < n; i++) {
				if (score[i] == target) {
					System.out.println("#" + tc + " " + grade[i / (n / 10)]);
					break;
				}
			}
		}
	}
}