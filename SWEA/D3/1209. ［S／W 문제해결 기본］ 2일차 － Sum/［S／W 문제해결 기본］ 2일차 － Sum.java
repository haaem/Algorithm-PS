import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int max = 0;

			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				int sum = 0;

				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum += arr[i][j];
				}

				max = Math.max(max, sum);
			}

			for (int j = 0; j < 100; j++) {
				int sum = 0;
				for (int i = 0; i < 100; i++)
					sum += arr[i][j];
				max = Math.max(max, sum);
			}

			int s1 = 0, s2 = 0;
			for (int i = 0; i < 100; i++) {
				s1 += arr[i][i];
				s2 += arr[i][99 - i];
			}

			max = Math.max(max, Math.max(s1, s2));
			System.out.println("#" + tc + " " + max);
		}
	}
}