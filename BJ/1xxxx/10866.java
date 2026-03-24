import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ10866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (deque.size() > 0)
					System.out.println(deque.pollFirst());
				else
					System.out.println(-1);
				break;
			case "pop_back":
				if (deque.size() > 0)
					System.out.println(deque.pollLast());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if (deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if (deque.size() > 0)
					System.out.println(deque.peekFirst());
				else
					System.out.println(-1);
				break;
			case "back":
				if (deque.size() > 0)
					System.out.println(deque.peekLast());
				else
					System.out.println(-1);
				break;
			}
		}
	}
}
