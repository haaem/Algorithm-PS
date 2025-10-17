import java.util.Scanner;

public class BJ15873 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int A, B;
		if (input.length() == 4) {
			A = 10;
			B = 10;
		} else if (input.length() == 3) {
			if (Integer.parseInt(input.substring(1, 2)) == 0) {
				A = 10;
				B = Integer.parseInt(input.substring(2));
			} else {
				A = Integer.parseInt(input.substring(0, 1));
				B = 10;
			}
		} else {
			A = Integer.parseInt(input.substring(0, 1));
			B = Integer.parseInt(input.substring(1));
		}
		System.out.println(A + B);
	}
}
