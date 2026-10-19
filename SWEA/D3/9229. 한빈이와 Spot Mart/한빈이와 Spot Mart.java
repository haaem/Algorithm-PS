import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr);

			int left = 0;
			int right = n - 1;
			int max = -1;

			while (left < right) {
				int sum = arr[left] + arr[right];

				if (sum == m) {
					max = sum;
					break;
				} else if (sum < m) {
					max = Math.max(max, sum);
					left++;
				} else {
					right--;
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}