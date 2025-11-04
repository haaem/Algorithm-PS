import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ28702 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		int res = -1;
		if (isNum(a)) {
			res = Integer.parseInt(a) + 3;
		} else if (isNum(b)) {
			res = Integer.parseInt(b) + 2;
		} else if (isNum(c)) {
			res = Integer.parseInt(c) + 1;
		}
		if (res % 15 == 0) {
			System.out.println("FizzBuzz");
		} else if (res % 3 == 0) {
			System.out.println("Fizz");
		} else if (res % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(res);
		}
	}

	static boolean isNum(String S) {
		return !S.equals("Fizz") && !S.equals("Buzz") && !S.equals("FizzBuzz");
	}
}
