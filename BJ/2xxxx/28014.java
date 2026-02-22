import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ28014 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			int H = Integer.parseInt(st.nextToken());
			if (H >= max) {
				count++;
			}
			max = H;
		}
		System.out.println(count);
	}
}
