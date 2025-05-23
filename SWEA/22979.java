import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

class SWEA22979 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			LinkedList<Character> list = new LinkedList<Character>();
			for (int i = 0; i < s.length(); i++) {
				list.add(s.charAt(i));
			}
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int X = sc.nextInt();
				if (X > 0) {
					int t = X % s.length();
					for (int j = 0; j < t; j++) {
						char temp = list.pollFirst();
						list.add(temp);
					}
				} else if (X < 0) {
					int t = (-X) % s.length();
					for (int j = 0; j < t; j++) {
						char temp = list.pollLast();
						list.addFirst(temp);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				sb.append(list.poll());
			}
			System.out.println(sb);
		}
	}
}