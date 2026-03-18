import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2525 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		int h = C / 60;
		int m = C % 60;
		B += m;
		if (B > 59) {
			B -= 60;
			A++;
		}
		A += h;
		if (A > 23) {
			A -= 24;
		}
		System.out.println(A + " " + B);
	}
}
