import java.util.Scanner;

public class BJ1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int title = 666;
		int num = 0;
		String str;
		
		while (true) {
			str = Integer.toString(title);
			if (str.contains("666")) {
				num++;
				if (N == num) {
					System.out.println(title);
					break;
				}
			}
			title++;
		}
	}
}
