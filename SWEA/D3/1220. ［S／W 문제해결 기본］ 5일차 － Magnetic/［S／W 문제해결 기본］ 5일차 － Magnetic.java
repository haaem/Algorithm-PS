import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			int[][] table = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++)
					table[i][j] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int j = 0; j < 100; j++) {
				boolean check = false;
				for (int i = 0; i < 100; i++) {
					if (table[i][j] == 1)
						check = true;
					else if (table[i][j] == 2 && check) {
						check = false;
						count++;
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}