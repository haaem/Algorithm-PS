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
			int[][] data = new int[100][100];
			int[] target = new int[2];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
					if (data[i][j] == 2) {
						target[0] = i;
						target[1] = j;
					}
				}
			}

			int y = 99;
			int x = target[1];

			while (y > 0) {
				if (x >= 1 && data[y][x - 1] == 1)
					while (x >= 1 && data[y][x - 1] == 1)
						x--;
				else if (x < 99 && data[y][x + 1] == 1)
					while (x < 99 && data[y][x + 1] == 1)
						x++;
				y--;
			}

			System.out.println("#" + tc + " " + x);
		}
	}
}