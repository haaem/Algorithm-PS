import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ23306 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println("? 1");
		System.out.flush();
		int start = Integer.parseInt(br.readLine());
		System.out.printf("? %d\n", N);
		System.out.flush();
		int end = Integer.parseInt(br.readLine());
		if (start == end) {
			System.out.println("! 0");
		} else if (start == 1 && end == 0) {
			System.out.println("! -1");
		} else {
			System.out.println("! 1");
		}
	}
}
