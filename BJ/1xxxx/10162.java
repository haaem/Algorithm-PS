import java.util.Scanner;

public class BJ10162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A = 300;
		int B = 60;
		int C = 10;
		if (T % 10 != 0) {
			System.out.println(-1);
		} else {
			int count = T / A;
			T -= count * A;
			System.out.print(count + " ");
			count = T / B;
			T -= count * B;
			System.out.print(count + " " + (T / C));
		}
	}
}
