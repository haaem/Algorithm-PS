import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16953 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 0;
		boolean possible = true;
		while (true) {
			if (B == A) {
				break;
			} else if (B < A) {
				possible = false;
				break;
			}
			if (B % 2 != 0 && B % 10 != 1) {
				possible = false;
				break;
			} else if (B % 2 == 0) {
				count++;
				B /= 2;
			} else {
				count++;
				B /= 10;
			}
		}
		if (possible) {
			System.out.println(count + 1);
		} else {
			System.out.println(-1);
		}
	}
}
