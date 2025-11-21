import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ32290 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int n = r - l + 1;
		int[] arr = new int[n];
		for (int i = l; i <= r; i++) {
			arr[i - l] = i | x;
		}
		int a = 0;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (arr[i] > a) {
				break;
			} else {
				a++;
			}
		}
		System.out.println(a);
	}
}
