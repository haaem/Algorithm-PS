import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ12789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> line = new LinkedList<Integer>();
		Stack<Integer> standBy = new Stack<Integer>();
		String result = "Sad";
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			line.add(Integer.parseInt(st.nextToken()));
		}
		int i=1;
		while (!line.isEmpty() || !standBy.isEmpty()) {
			if (!standBy.isEmpty() && standBy.peek() == i) {
				standBy.pop();
				i++;
				continue;
			}
			if (!line.isEmpty()) {
				int value = line.poll();
				if (value != i) {
					standBy.push(value);
				} else {
					i++;
				}
				continue;
			}
			break;
		}
		if (line.isEmpty() && standBy.isEmpty()) {
			result = "Nice";
		}
		System.out.println(result);
	}
	
}