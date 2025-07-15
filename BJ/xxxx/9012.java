import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			boolean check = true;
			LinkedList<Character> lst = new LinkedList<Character>();
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == ')') {
					if (lst.size() != 0 && lst.peekLast() == '(') {
						lst.pollLast();
					} else {
						System.out.println("NO");
						check = false;
						break;
					}
				} else {
					lst.addLast('(');
				}
			}
			if (check) {
				if (lst.size() == 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
