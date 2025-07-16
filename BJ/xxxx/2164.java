import java.util.LinkedList;
import java.util.Scanner;

public class BJ2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Integer> lst = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			lst.add(N - i);
		}
		int turn = 0;
		while (lst.size() > 1) {
			if (turn % 2 == 0) {
				lst.pollLast();
			} else {
				int temp = lst.pollLast();
				lst.addFirst(temp);
			}
			turn++;
		}
		System.out.println(lst.poll());
	}
}
