import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3273 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		int i = 1, j = n;
		int count = 0;
		while (i < j) {
			if (a[i] + a[j] == x) {
				count++;
				i++;
			} else if (a[i] + a[j] < x) {
				i++;
			} else {
				j--;
			}
		}
		System.out.println(count);
	}
}
