import java.io.FileInputStream;
import java.util.Scanner;

class SWEA22759 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int L = sc.nextInt();
			int R = sc.nextInt();
			if (R + 1 > 2 * L)
				System.out.println("no");
			else
				System.out.println("yes");
		}
	}
}