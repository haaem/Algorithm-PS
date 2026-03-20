import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25304 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			X -= a * b;
		}
		if (X == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}