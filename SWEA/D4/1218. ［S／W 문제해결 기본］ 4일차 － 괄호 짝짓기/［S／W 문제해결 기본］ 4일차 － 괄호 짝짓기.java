import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Character> start = new HashSet<Character>();
		start.add('(');
		start.add('[');
		start.add('{');
		start.add('<');

		loop: for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> s = new Stack<>();

			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				if (start.contains(c))
					s.push(c);
				else {
					if (s.isEmpty()) {
						System.out.println("#" + tc + " 0");
						continue loop;
					}

					char in = s.pop();

					switch (c) {
					case ')':
						if (in == '(')
							continue;
						break;
					case ']':
						if (in == '[')
							continue;
						break;
					case '}':
						if (in == '{')
							continue;
						break;
					case '>':
						if (in == '<')
							continue;
						break;
					}

					System.out.println("#" + tc + " 0");
					continue loop;
				}
			}

			System.out.println("#" + tc + " 1");
		}
	}
}