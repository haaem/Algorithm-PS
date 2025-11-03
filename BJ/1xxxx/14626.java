import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14626 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String isbn = br.readLine();
		int index = -1;
		int sum = 0;
		for (int i = 0; i < 13; i++) {
			if (isbn.charAt(i) == '*')
				index = i;
			else {
				int t = i % 2 == 0 ? 1 : 3;
				sum += Integer.parseInt(isbn.substring(i, i + 1)) * t;
			}
		}
		int res = -1;
		int t = index % 2 == 0 ? 1 : 3;
		for (int i = 0; i < 10; i++) {
			if ((sum + t * i) % 10 == 0) {
				res = i;
				break;
			}
		}
		System.out.println(res);
	}
}
