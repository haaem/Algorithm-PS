import java.io.FileInputStream;
import java.util.Scanner;

class SWEA2058 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;

		while (N > 0) {
			ans += N % 10;
			N /= 10;
		}
		System.out.println(ans);
	}
}