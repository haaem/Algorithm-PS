import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BJ2108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] count = new int[8001];
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			count[input + 4000]++;
			sum += input;
			max = Math.max(max, input);
			min = Math.min(min, input);
		}
		// 1. 산술 평균
		System.out.println(Math.round((double) sum / N));
		// 2. 중앙값
		int target = N / 2 + 1;
		int s = 0;
		for (int i = 0; i < 8001; i++) {
			if (s + count[i] < target) {
				s += count[i];
			} else {
				System.out.println(i - 4000);
				break;
			}
		}
		// 3. 최빈값
		int temp = 0;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < 8001; i++) {
			if (count[i] > temp) {
				temp = count[i];
				set = new TreeSet<>();
				set.add(i - 4000);
			} else if (count[i] == temp) {
				set.add(i - 4000);
			}
		}
		if (set.size() > 1) {
			int first = set.pollFirst();
			int second = set.pollFirst();
			System.out.println(second);
		} else {
			System.out.println(set.pollFirst());
		}
		// 4. 범위
		System.out.println(max - min);
	}
}