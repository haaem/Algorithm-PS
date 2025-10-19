import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1735 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A1 = Integer.parseInt(st.nextToken());
		int B1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int A2 = Integer.parseInt(st.nextToken());
		int B2 = Integer.parseInt(st.nextToken());
		int lcm = (B1 / gcd(B1, B2)) * B2;
		int A = A1 * (lcm / B1) + A2 * (lcm / B2);
		int t = gcd(A, lcm);
		System.out.println(A / t + " " + lcm / t);
	}

	static int gcd(int A, int B) {
		while (B != 0) {
			int temp = A % B;
			A = B;
			B = temp;
		}
		return A;
	}
}
