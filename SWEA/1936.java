import java.io.FileInputStream;
import java.util.Scanner;

class SWEA1936 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if ((A == 1 && B == 2) || (A == 2 && B == 3) || (B == 3 && A == 1)) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}
}