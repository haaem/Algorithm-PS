import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] res = new int[N];
		Arrays.fill(res, -1);
		for (int i = 0; i < N; i++) {
			int left = Integer.parseInt(st.nextToken());
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (res[j] == -1) {
					if (count == left) {
						res[j] = i + 1;
						break;
					}
					count++;
				}
			}
		}
		for (int a : res) {
			System.out.print(a + " ");
		}
	}
}
