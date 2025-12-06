import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ32184 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int count = 0;
		if (A % 2 == 0) {
			count++;
			A++;
		}
		if (B % 2 == 1) {
			count++;
			B--;
		}
		if (B - A > 0) {
			count += (B - A + 1) / 2;
		}
		System.out.println(count);
	}
}
