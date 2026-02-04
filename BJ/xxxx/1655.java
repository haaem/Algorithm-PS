import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ1655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> leftPq = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> rightPq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (leftPq.size() == rightPq.size())
				leftPq.add(num);
			else
				rightPq.add(num);
			if (!leftPq.isEmpty() && !rightPq.isEmpty()) {
				if (leftPq.peek() > rightPq.peek()) {
					int temp = leftPq.poll();
					leftPq.add(rightPq.poll());
					rightPq.add(temp);
				}
			}
			sb.append(leftPq.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
