import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> lst = new LinkedList<Integer>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				lst.add(Integer.parseInt(st.nextToken()));

			int c = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < c; i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				for (int j = 0; j < y; j++)
					lst.add(x + j, Integer.parseInt(st.nextToken()));
			}

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++)
				sb.append(lst.poll()).append(" ");
			sb.append("\n");
		}

		System.out.println(sb);
	}
}