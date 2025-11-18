import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1874 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();
		int a = 1;

		for (int i = 0; i < n; i++) {
			int target = Integer.parseInt(br.readLine());

			if (target >= a) {
				while (target >= a) {
					stack.push(a++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				if (stack.peek() == target) {
					stack.pop();
					sb.append("-\n");
				} else {
					System.out.println("NO");
					return;
				}
			}
		}

		System.out.println(sb);
	}
}
