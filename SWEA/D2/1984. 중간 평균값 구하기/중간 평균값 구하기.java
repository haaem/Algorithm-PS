import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];

			int sum = 0;
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}

			Arrays.sort(arr);
			System.out.println("#" + tc + " " + Math.round(((double) sum - arr[0] - arr[9]) / 8));
		}
	}
}