import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1789 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		int count = 1;
		long sum = 1;
		while (true) {
			if (S - sum > count) {
				count++;
				sum += count;
			} else {
				break;
			}
		}
		System.out.println(count);
	}
}
