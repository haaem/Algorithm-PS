import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2417 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long sq = (long) Math.sqrt(n);
		if (sq * sq < n)
			System.out.println(sq + 1);
		else
			System.out.println(sq);
	}
}
