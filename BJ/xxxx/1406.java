import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ1406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 커서 위치를 저장하고 arraylist로 했을 때 시간초과가 남
		// Deque에서 맨 앞과 뒤만 접근하는 방법을 통해 시간 단축
		ArrayDeque<Character> left = new ArrayDeque<Character>();
		ArrayDeque<Character> right = new ArrayDeque<Character>();

		String S = br.readLine();
		for (int i = 0; i < S.length(); i++) {
			left.offerLast(S.charAt(i));
		}

		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			char func = st.nextToken().charAt(0);
			switch (func) {
			case 'L': {
				if (!left.isEmpty())
					right.offerFirst(left.pollLast());
				break;
			}
			case 'D': {
				if (!right.isEmpty())
					left.offerLast(right.pollFirst());
				break;
			}
			case 'B': {
				if (!left.isEmpty()) {
					left.pollLast();
				}
				break;
			}
			case 'P': {
				char c = st.nextToken().charAt(0);
				left.offerLast(c);
				break;
			}
			}
		}

		StringBuilder sb = new StringBuilder();
		int size = left.size();
		for (int i = 0; i < size; i++) {
			sb.append(left.pollFirst());
		}
		size = right.size();
		for (int i = 0; i < size; i++) {
			sb.append(right.pollFirst());
		}
		System.out.println(sb);
	}
}
