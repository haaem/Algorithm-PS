import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		String[] s = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
		HashMap<String, Integer> map;

		for (int tc = 1; tc <= T; tc++) {
			map = new HashMap<String, Integer>();
			for (int i = 0; i < 10; i++)
				map.put(s[i], 0);

			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append("\n");

			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String now = st.nextToken();
				map.replace(now, map.get(now) + 1);
			}

			for (int i = 0; i < 10; i++)
				for (int j = 0; j < map.get(s[i]); j++)
					sb.append(s[i]).append(" ");

			sb.append("\n");
		}

		System.out.println(sb);
	}
}