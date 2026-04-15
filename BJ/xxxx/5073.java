import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5073 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while (a != 0 && b != 0 && c != 0) {
			if (a + b > c && b + c > a && c + a > b) {
				if (a == b && b == c)
					System.out.println("Equilateral");
				else if (a == b || b == c || c == a)
					System.out.println("Isosceles");
				else
					System.out.println("Scalene");
			} else {
				System.out.println("Invalid");
			}
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
	}
}
