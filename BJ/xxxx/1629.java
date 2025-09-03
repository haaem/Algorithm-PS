import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1629 {
	static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(pow(A, B));
	}

	static long pow(int A, int B) {
		if (B == 1)
			return A % C;
		long half = pow(A % C, B / 2);
		if (B % 2 == 1) {
			return (half * half % C) * A % C;
		}
		return half * half % C;
	}
}
