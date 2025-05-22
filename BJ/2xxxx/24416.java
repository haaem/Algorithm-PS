import java.util.Arrays;
import java.util.Scanner;

public class BJ24416 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] f = new int[n+1];
		Arrays.fill(f, 0);
		f[1] = 1; f[2] = 1;
		for (int i = 3; i <= n; i++) {
			f[i] = f[i-2] + f[i-1];
		}
		int rec = f[n];
		int dp = n-2;
		System.out.println(rec+" "+dp);
	}
}