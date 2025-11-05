import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ10845 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			if (func.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				queue.offer(X);
			} else if (func.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.pop()).append("\n");
				}
			} else if (func.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (func.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if (func.equals("front")) {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peekFirst()).append("\n");
				}
			} else if (func.equals("back")) {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peekLast()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
