import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ30804 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;
		int right = 1; // 뒤 포인터
		int left = 0; // 앞 포인터
		int[] check = new int[10]; // 개수
		check[arr[0]] = 1;
		int count = 1;

		while (right < N) {
			int target = arr[right];
			if (check[target] == 0) {
				check[target]++;
				count++;
				if (count > 2) {
					while (left < right) {
						int t = arr[left];
						check[t]--;
						left++;

						if (check[t] == 0) {
							count--;
							break;
						}
					}
				}
			} else {
				check[target]++;
			}
			max = Math.max(max, right - left + 1);
			right++;
		}

		System.out.println(max);
	}
}
