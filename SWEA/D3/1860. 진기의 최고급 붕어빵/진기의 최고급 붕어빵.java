import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arrive = new int[11112];
			for (int i = 0; i < n; i++)
				arrive[Integer.parseInt(st.nextToken())]++;

			int sec = 0, total = 0;
			boolean isPossible = true;

			while (n > 0) {
				if (sec != 0 && sec % m == 0)
					total += k;

				if (arrive[sec] != 0) {
					if (total < arrive[sec]) {
						isPossible = false;
						break;
					} else {
						total -= arrive[sec];
						n -= arrive[sec];
					}
				}

				sec++;
			}

			if (isPossible)
				System.out.println("#" + tc + " Possible");
			else
				System.out.println("#" + tc + " Impossible");
		}
	}
}