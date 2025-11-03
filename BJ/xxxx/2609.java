import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int mul = a * b;
		while (b > 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		System.out.println(a);
		System.out.println(mul / a);
	}
}
