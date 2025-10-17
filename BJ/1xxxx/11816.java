import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();
		int res;
		if (X.startsWith("0x")) {
			res = Integer.parseInt(X.substring(2), 16);
		} else if (X.startsWith("0")) {
			res = Integer.parseInt(X.substring(1), 8);
		} else {
			res = Integer.parseInt(X, 10);
		}
		System.out.println(res);
	}
}
