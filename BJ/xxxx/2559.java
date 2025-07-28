import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] count = new int[N - K + 1];
		int index = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			queue.add(t);
			if (i < K) {
				count[0] += t;
			} else {
				count[index] = count[index - 1] - queue.poll() + t;
				index++;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N - K + 1; i++) {
			if (count[i] > max)
				max = count[i];
		}
		System.out.println(max);
	}
}
