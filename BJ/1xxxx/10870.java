import java.util.Scanner;

public class BJ10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n==0) System.out.println(0);
		else System.out.println(pibonacci(n)[0]);
	}
	
	public static int[] pibonacci(int n) {
		if (n<=1) return new int[] {1,0};
		int[] res = pibonacci(n-1);
		int a = res[0];
		int b = res[1];
		return new int[] {a+b, a};
	}
}