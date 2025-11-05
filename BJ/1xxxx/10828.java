import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = (Integer.parseInt(br.readLine()));
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			if (func.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				stack.push(X);
			} else if (func.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} else if (func.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (func.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if (func.equals("top")) {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
