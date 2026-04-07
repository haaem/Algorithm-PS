import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int i = 0;
		boolean tag = false;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				tag = true;
				sb.append(c);
				i++;
				continue;
			} else if (c == '>') {
				tag = false;
				sb.append(c);
				i++;
				continue;
			}
			if (tag) {
				sb.append(c);
			} else {
				if (c == ' ') {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				} else {
					stack.add(c);
				}
			}
			i++;
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
