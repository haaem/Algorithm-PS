import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2588 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int last = a * b;
		for (int i = 0; i < 3; i++) {
			System.out.println(a * (b % 10));
			b /= 10;
		}
		System.out.println(last);
	}
}
