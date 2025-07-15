import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] s = new int[1000000];
		int n = Integer.parseInt(br.readLine());
		int index = 0;
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				s[index--] = 0;
			} else {
				s[index++] = input;
			}
		}
		long ans = 0;
		for (int i = 0; i < index; i++) {
			ans += s[i];
		}
		System.out.println(ans);
	}
}
