import java.util.Scanner;

public class BJ3449 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1;test_case<=T;test_case++) {
			String A = sc.next();
			String B = sc.next();
			int count = 0;
			for (int i=0; i<A.length();i++) {
				if(A.charAt(i)!=B.charAt(i)) {
					count++;
				}
			}
			System.out.printf("Hamming distance is %d.%n",count);
		}
	}
}