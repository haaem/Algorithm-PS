import java.io.FileInputStream;
import java.util.Scanner;

class SWEA22795 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int max = 0;
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				int temp = sc.nextInt();
				if (temp > max)
					max = temp;
				sum += temp;
			}
			int t = (sum + max) / 7 + 1;
			System.out.println(t * 7 - sum);
		}
	}
}