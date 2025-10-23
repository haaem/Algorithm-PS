import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sol = new int[N];
		for (int i = 0; i < N; i++) {
			sol[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sol);
		int left = 0, right = N - 1;
		int sum = Integer.MAX_VALUE;
		int current;
		int[] save = new int[2];
		while (left < right) {
			current = sol[left] + sol[right];
			if (Math.abs(current) < Math.abs(sum)) {
				save[0] = sol[left];
				save[1] = sol[right];
				sum = current;
			}
			if (current == 0)
				break;
			else if (current < 0)
				left++;
			else
				right--;
		}
		System.out.println(save[0] + " " + save[1]);
	}
}
