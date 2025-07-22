import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int[] count;
		if (X < 3) {
			count = new int[4];
		} else {
			count = new int[X + 1];
		}
		count[1] = 0;
		count[2] = 1;
		count[3] = 1;
		for (int i = 4; i < X + 1; i++) {
			count[i] = count[i - 1] + 1;
			if (i % 2 == 0) {
				count[i] = Math.min(count[i], count[i / 2] + 1);
			}
			if (i % 3 == 0) {
				count[i] = Math.min(count[i], count[i / 3] + 1);
			}
		}
		System.out.println(count[X]);
	}
}
