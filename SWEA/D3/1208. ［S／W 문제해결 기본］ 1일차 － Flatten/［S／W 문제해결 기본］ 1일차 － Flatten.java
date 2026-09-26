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
			int[] height = new int[101];
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int min = 100, max = 0;

			for (int j = 0; j < 100; j++) {
				int t = Integer.parseInt(st.nextToken());
				height[t]++;
				min = Math.min(min, t);
				max = Math.max(max, t);
			}

			while (dump > 0 && max - min > 1) {
				height[max]--;
				height[max - 1]++;
				height[min]--;
				height[min + 1]++;
				dump--;

				while (height[min] == 0)
					min++;
				while (height[max] == 0)
					max--;
			}

			System.out.println("#" + tc + " " + (max - min));
		}
	}
}