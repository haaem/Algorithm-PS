import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new ArrayDeque();
			for (int i = 0; i < 8; i++)
				q.offer(Integer.parseInt(st.nextToken()));
			int count = 0;

			while (true) {
				int now = q.poll();
				if (now - (count % 5 + 1) <= 0) {
					q.offer(0);
					break;
				}
				q.offer(now - (count % 5 + 1));
				count++;
			}

			for (int a : q)
				sb.append(a).append(" ");

			sb.append("\n");
		}

		System.out.println(sb);
	}
}