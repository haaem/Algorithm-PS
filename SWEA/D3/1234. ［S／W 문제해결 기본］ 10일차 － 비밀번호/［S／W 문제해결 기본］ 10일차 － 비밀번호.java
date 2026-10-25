import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			ArrayDeque<Integer> s = new ArrayDeque<>();
			String pass = st.nextToken();

			for (int i = 0; i < n; i++) {
				int a = pass.charAt(i) - '0';

				if (s.isEmpty() || s.peekLast() != a)
					s.offer(a);
				else
					s.pollLast();
			}

			while (!s.isEmpty())
				sb.append(s.poll());
            sb.append("\n");
		}
		System.out.println(sb);
	}
}