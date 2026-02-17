import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int temp = N;
		int left = temp / 10;
		int right = temp % 10;
		temp = right * 10 + (left + right) % 10;
		while (temp != N) {
			left = temp / 10;
			right = temp % 10;
			temp = right * 10 + (left + right) % 10;
			count++;
		}
		System.out.println(count);
	}
}
