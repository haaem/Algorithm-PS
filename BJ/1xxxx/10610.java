import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10610 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if (!s.contains("0")) {
			System.out.println(-1);
			return;
		}
		int sum = 0;
		int[] count = new int[10];
		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i) - '0';
			count[temp]++;
			sum += temp;
		}
		if (sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < count[i]; j++) {
				sb.append(i);
			}
		}
		System.out.println(sb);
	}
}
