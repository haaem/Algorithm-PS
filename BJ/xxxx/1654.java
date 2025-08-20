import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {
	static int N, K;
	static int[] len;
	static long res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		len = new int[K];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			len[i] = Integer.parseInt(br.readLine());
			if (len[i] > max)
				max = len[i];
		}
		search(1, max); // mid가 0인 상황을 방지하기 위해 1부터 시작
		System.out.println(res);
	}

	static void search(long start, long end) {
		while (start <= end) {
			long mid = (start + end) / 2;
			long count = 0;

			for (int i = 0; i < len.length; i++) { // 따로 함수를 빼는 것 보다는 내부적으로 확인하는 것이 빠름
				count += len[i] / mid;
			}
			if (count >= N) {
				if (res < mid)
					res = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}
}
