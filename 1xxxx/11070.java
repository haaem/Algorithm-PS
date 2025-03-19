import java.util.Scanner;

public class BJ11070 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int res = 1;
		for (int i=0; i<K; i++) {
			res *= N-i;
		}
		for (int i=1; i<=K; i++) {
			res /= i;
		}
		System.out.println(res);
	}
}
