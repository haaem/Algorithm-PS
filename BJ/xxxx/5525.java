import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ5525 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] count = new int[M + 1];
		String s = br.readLine();
		int index = 0;
		while (index < M) {
			int temp = 0;
			while (index + 2 < M && s.substring(index, index + 3).equals("IOI")) {
				temp++;
				index += 2;
			}
			count[temp]++;
			index++;
		}
		int sum = 0;
		for (int i = N; i <= M; i++) {
			sum += (i - N + 1) * count[i];
		}
		System.out.println(sum);
	}
}
