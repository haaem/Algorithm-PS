import java.io.FileInputStream;
import java.util.Scanner;

class SWEA22574 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int P = sc.nextInt();
			long floor = 0;
			for (int i = 1; i <= N; i++) {
				floor += i;
				if (floor == P)
					floor--;
			}
			System.out.println(floor);
		}
	}
}