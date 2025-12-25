import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ25709 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int count = 0;
		while (!s.equals("") && !(Long.parseLong(s) == 0)) {
			boolean hasOne = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					hasOne = true;
					s = s.substring(0, i) + s.substring(i + 1);
					break;
				}
			}
			if (!hasOne) {
				long temp = Long.parseLong(s);
				s = String.valueOf(temp - 1);
			}
			count++;
		}
		System.out.println(count);
	}
}
