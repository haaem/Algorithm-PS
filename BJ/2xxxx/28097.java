import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ28097 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
			if (i != N - 1) {
				sum += 8;
			}
		}
		System.out.println(sum / 24 + " " + sum % 24);
	}
}
