import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1343 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int cont = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'X') {
				cont++;
				continue;
			}
			if (cont > 0) {
				if (cont % 2 != 0) {
					System.out.println(-1);
					return;
				}
				for (int j = 0; j < cont / 4; j++)
					sb.append("AAAA");
				cont %= 4;
				for (int j = 0; j < cont / 2; j++)
					sb.append("BB");
				cont = 0;
			}
			sb.append(".");
		}
		if (cont > 0) {
			if (cont % 2 != 0) {
				System.out.println(-1);
				return;
			}
			for (int j = 0; j < cont / 4; j++)
				sb.append("AAAA");
			cont %= 4;
			for (int j = 0; j < cont / 2; j++)
				sb.append("BB");
			cont = 0;
		}
		System.out.println(sb);
	}
}
