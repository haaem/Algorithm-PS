import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] A = new int[n];

			for (int i = 0; i < n; i++)
				A[i] = Integer.parseInt(st.nextToken());
			int max = -1;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					String s = String.valueOf(A[i] * A[j]);
					char prev = s.charAt(0);
					boolean possible = true;
					for (int k = 1; k < s.length(); k++) {
						if (prev > s.charAt(k)) {
							possible = false;
							break;
						}
						prev = s.charAt(k);
					}

					if (possible)
						max = Math.max(max, Integer.parseInt(s));
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}